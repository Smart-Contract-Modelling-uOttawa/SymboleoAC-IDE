package ca.uottawa.csmlab.symboleo.cli;

import ca.uottawa.csmlab.symboleo.SymboleoStandaloneSetup;
import ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage;
import ca.uottawa.csmlab.symboleo.validation.SymboleoValidator;
import com.google.inject.Injector;
import com.google.inject.Provider;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Headless validator for *.symboleo files.
 *
 * Exit codes:
 *   0 - file parses and validates with no ERROR-severity issues (warnings allowed)
 *   1 - file has ERROR-severity issues (grammar errors and/or @Check failures)
 *   2 - usage error or I/O failure (file not found, cannot write output, etc.)
 */
public final class Cli {

    public static void main(String[] args) {
        try {
            System.exit(run(args));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(2);
        }
    }

    private static int run(String[] args) throws Exception {
        Path input = null;
        Path out = null;
        String format = "text";
        boolean quiet = false;

        for (int i = 0; i < args.length; i++) {
            String a = args[i];
            switch (a) {
                case "-o":
                case "--out":
                    out = Paths.get(args[++i]);
                    break;
                case "-f":
                case "--format":
                    format = args[++i];
                    break;
                case "-q":
                case "--quiet":
                    quiet = true;
                    break;
                case "-h":
                case "--help":
                    printUsage(System.out);
                    return 0;
                default:
                    if (a.startsWith("-")) {
                        System.err.println("Unknown option: " + a);
                        printUsage(System.err);
                        return 2;
                    }
                    if (input != null) {
                        System.err.println("Only one input file is supported.");
                        return 2;
                    }
                    input = Paths.get(a);
            }
        }
        if (input == null) {
            printUsage(System.err);
            return 2;
        }
        if (!Files.isRegularFile(input)) {
            System.err.println("Input file not found: " + input.toAbsolutePath());
            return 2;
        }
        if (!format.equals("text") && !format.equals("json")) {
            System.err.println("--format must be 'text' or 'json' (got: " + format + ")");
            return 2;
        }

        Injector injector = new SymboleoStandaloneSetup().createInjectorAndDoEMFRegistration();

        // In Eclipse, plugin.xml's org.eclipse.emf.ecore.eValidator extension
        // registers SymboleoValidator with the EValidator registry that
        // Xtext's Diagnostician (CancelableDiagnostician) actually consults.
        // That registry is the INJECTED one held by EValidatorRegistrar, NOT
        // the global EValidator.Registry.INSTANCE — putting on INSTANCE
        // silently does nothing for the IResourceValidator dispatch path.
        // Headlessly we register through the injected registrar so all
        // @Check methods in SymboleoValidator (e.g. checkIdentifiersAreUnique2)
        // are actually invoked during validation.
        SymboleoValidator symboleoValidator = injector.getInstance(SymboleoValidator.class);
        EValidatorRegistrar registrar = injector.getInstance(EValidatorRegistrar.class);
        registrar.register(SymboleoPackage.eINSTANCE, symboleoValidator);

        IResourceValidator validator = injector.getInstance(IResourceValidator.class);
        @SuppressWarnings("unchecked")
        Provider<ResourceSet> rsProvider = injector.getInstance(
                com.google.inject.Key.get(new com.google.inject.TypeLiteral<Provider<ResourceSet>>() {}));
        ResourceSet rs = rsProvider.get();

        URI uri = URI.createFileURI(input.toAbsolutePath().toString());

        Resource resource;
        List<Issue> issues;
        try {
            resource = rs.getResource(uri, true);
            // CheckMode.ALL = FAST + NORMAL + EXPENSIVE @Check methods.
            issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
            if (System.getenv("SYMBOLEO_CLI_DEBUG") != null && !resource.getContents().isEmpty()) {
                org.eclipse.emf.common.util.BasicDiagnostic dc =
                        new org.eclipse.emf.common.util.BasicDiagnostic();
                java.util.HashMap<Object, Object> ctx = new java.util.HashMap<>();
                ctx.put(org.eclipse.xtext.validation.AbstractInjectableValidator.CURRENT_LANGUAGE_NAME,
                        "ca.uottawa.csmlab.symboleo.Symboleo");
                symboleoValidator.validate(resource.getContents().get(0).eClass(),
                        resource.getContents().get(0), dc, ctx);
                System.err.println("[debug] direct-invoke diagnostics: " + dc.getChildren().size());
                for (Object d : dc.getChildren()) System.err.println("  - " + d);
            }
        } catch (Exception parseFailure) {
            // Catastrophic load failure (e.g. file is binary garbage). Emit a single
            // synthetic error so downstream tooling sees something machine-readable.
            issues = List.of();
            writeOutput(out, format, input, issues, parseFailure);
            if (!quiet) {
                System.err.println("Fatal error loading resource: " + parseFailure.getMessage());
            }
            return 1;
        }

        writeOutput(out, format, input, issues, null);

        boolean hasErrors = issues.stream().anyMatch(i -> i.getSeverity() == Severity.ERROR);
        if (!quiet) {
            long errorCount = issues.stream().filter(i -> i.getSeverity() == Severity.ERROR).count();
            long warnCount = issues.stream().filter(i -> i.getSeverity() == Severity.WARNING).count();
            System.out.println("Validation: " + errorCount + " error(s), " + warnCount + " warning(s)");
        }
        return hasErrors ? 1 : 0;
    }

    private static void writeOutput(Path out,
                                    String format,
                                    Path input,
                                    List<Issue> issues,
                                    Throwable fatal) throws Exception {
        if (out == null) {
            try (PrintWriter w = new PrintWriter(System.out)) {
                renderTo(w, format, input, issues, fatal);
                w.flush();
            }
        } else {
            try (BufferedWriter bw = Files.newBufferedWriter(out, StandardCharsets.UTF_8);
                 PrintWriter w = new PrintWriter(bw)) {
                renderTo(w, format, input, issues, fatal);
            }
        }
    }

    private static void renderTo(PrintWriter w,
                                 String format,
                                 Path input,
                                 List<Issue> issues,
                                 Throwable fatal) {
        if ("json".equals(format)) {
            renderJson(w, input, issues, fatal);
        } else {
            renderText(w, input, issues, fatal);
        }
    }

    private static void renderText(PrintWriter w, Path input, List<Issue> issues, Throwable fatal) {
        w.println("file: " + input.toAbsolutePath());
        if (fatal != null) {
            w.println("FATAL: " + fatal.getClass().getSimpleName() + ": " + fatal.getMessage());
            return;
        }
        if (issues.isEmpty()) {
            w.println("ok: no issues");
            return;
        }
        for (Issue i : issues) {
            w.println(i.getSeverity()
                    + " [" + i.getLineNumber() + ":" + i.getColumn() + "] "
                    + i.getMessage()
                    + (i.getCode() != null ? "  (" + i.getCode() + ")" : ""));
        }
    }

    private static void renderJson(PrintWriter w, Path input, List<Issue> issues, Throwable fatal) {
        JSONObject root = new JSONObject();
        root.put("file", input.toAbsolutePath().toString());
        if (fatal != null) {
            root.put("fatal", new JSONObject()
                    .put("type", fatal.getClass().getName())
                    .put("message", String.valueOf(fatal.getMessage())));
        }
        JSONArray arr = new JSONArray();
        for (Issue i : issues) {
            JSONObject o = new JSONObject();
            o.put("severity", String.valueOf(i.getSeverity()));
            o.put("line", i.getLineNumber() == null ? JSONObject.NULL : i.getLineNumber());
            o.put("column", i.getColumn() == null ? JSONObject.NULL : i.getColumn());
            o.put("offset", i.getOffset() == null ? JSONObject.NULL : i.getOffset());
            o.put("length", i.getLength() == null ? JSONObject.NULL : i.getLength());
            o.put("message", String.valueOf(i.getMessage()));
            o.put("code", i.getCode() == null ? JSONObject.NULL : i.getCode());
            arr.put(o);
        }
        root.put("issues", arr);
        long errors = issues.stream().filter(i -> i.getSeverity() == Severity.ERROR).count();
        long warnings = issues.stream().filter(i -> i.getSeverity() == Severity.WARNING).count();
        root.put("summary", new JSONObject()
                .put("errors", errors)
                .put("warnings", warnings)
                .put("total", issues.size()));
        w.println(root.toString(2));
    }

    private static void printUsage(java.io.PrintStream s) {
        s.println("Usage: symboleo-cli <input.symboleo> [options]");
        s.println();
        s.println("Validates a SymboleoAC source file headlessly (no Eclipse).");
        s.println();
        s.println("Options:");
        s.println("  -o, --out <file>       Write diagnostics here (default: stdout)");
        s.println("  -f, --format <fmt>     'text' (default) or 'json'");
        s.println("  -q, --quiet            Suppress the human-readable summary on stdout");
        s.println("  -h, --help             Show this help");
        s.println();
        s.println("Exit codes: 0 = no errors, 1 = errors found, 2 = usage / I/O failure");
    }

    private Cli() {}
}
