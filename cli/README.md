# SymboleoAC headless CLI

Standalone command-line validator for `.symboleo` files. Runs the Xtext parser
and all `@Check` validations from `ca.uottawa.csmlab.symboleo` without starting
Eclipse, so it is suitable for batch experiments and LLM transform-and-fix
pipelines.

## Build

Requires JDK 17+, Maven 3.8+, and a one-time bootstrap of the Xtext-generated
sources (see below).

### One-time bootstrap (run MWE2 in Eclipse)

The Xtext language generator (MWE2) cannot reliably be run headlessly from
Maven on Java 17+/Windows — the JvmType proxy-resolver isn't wired up the
way it is inside Eclipse, and works around for that aren't worth the
maintenance burden. Instead, regenerate the parser + EMF model once from
inside Eclipse (which you already have, since this is an Xtext project):

1. Open Eclipse with the **Xtext SDK** installed.
2. `File → Import → General → Existing Projects into Workspace`, point at
   `SymboleoAC-Xtext/` and import all five projects
   (`ca.uottawa.csmlab.symboleo`, `.ide`, `.tests`, `.ui`, `.ui.tests`).
3. In the Project Explorer, expand
   `ca.uottawa.csmlab.symboleo/src/ca/uottawa/csmlab/symboleo/`,
   right-click `GenerateSymboleo.mwe2` → **Run As → MWE2 Workflow**.
4. Wait for the console to print `Done.` This populates
   `ca.uottawa.csmlab.symboleo/src-gen/` and `xtend-gen/` (and the same
   under the four sibling projects).

You only need to repeat this when the grammar (`Symboleo.xtext`) or any
`@Check` validation changes.

### Build the CLI

```powershell
cd cli
mvn -B clean package
```

If you hit SSL cert errors against Maven Central (corporate Java truststore
doesn't recognize the CA), tell Maven to use the Windows truststore:

```powershell
$env:MAVEN_OPTS = "-Djavax.net.ssl.trustStoreType=Windows-ROOT"
mvn -B clean package
```

Output: `cli/target/symboleo-cli-1.0.0-all.jar` (fat / executable jar).

## Run

```powershell
java -jar target/symboleo-cli-1.0.0-all.jar ../samples/MeatSale.symboleo `
     --format json --out errors.json
```

### Exit codes

| Code | Meaning                                                  |
|------|----------------------------------------------------------|
| `0`  | File parses, no `ERROR`-severity issues (warnings ok)    |
| `1`  | One or more `ERROR`-severity issues (grammar or `@Check`)|
| `2`  | Usage error or I/O failure (input missing, etc.)         |

### Output formats

- `text` (default) — one issue per line, prefixed with severity and `[line:col]`.
- `json` — a single object: `{ file, issues: [...], summary: { errors, warnings, total } }`.
  If the resource fails to load at all (e.g. binary file), a `fatal` key is added.

The JSON format is the recommended input for an LLM fixer step: parse `issues`,
group by severity, feed each error's `line`/`column`/`message`/`code` back into
the model alongside the original source.

## Layout

```
cli/
├── pom.xml                                # build (no MWE2, no xtend plugin)
├── README.md
└── src/main/
    ├── java/ca/uottawa/csmlab/symboleo/cli/
    │   └── Cli.java                       # main(); validates and writes diagnostics
    └── resources/
        └── log4j.properties               # silences a harmless EMF i18n warning
```

## Notes on the bootstrap step

- Eclipse must have a **Xtext SDK** matching whatever the CLI's Maven build expects. The current pom pins Xtext **2.36.0** because that's the newest version on Maven Central. If your Eclipse installs a newer Xtext (e.g. 2.42), the generated `.xtextbin` won't be loadable by the 2.36 runtime — but a workaround is in place: the build also picks up `.xtextbin` files and a duplicate is created as `Symboleo.xmi` (which 2.36 looks up). If a future Xtext version changes the format incompatibly, regenerate after installing Xtext SDK 2.36 in Eclipse via `Help → Install New Software → https://download.eclipse.org/modeling/tmf/xtext/updates/releases/2.36.0/`.
- The Eclipse projects need real `.project` / `.classpath` files. The cloned repo has these in `.gitignore`, so on a fresh checkout copy them from an existing Eclipse workspace, or create them via Eclipse's `File → New → Plug-in Project` wizard pointing at the existing folders.

The CLI module does not duplicate any grammar or validator code — it adds the
runtime project's `src/`, `src-gen/`, and `xtend-gen/` (all post-bootstrap)
to its own compile path via `build-helper-maven-plugin`, so any change to
`SymboleoValidator.java` or `Helpers.xtend` is picked up by the next
`mvn package` (no re-bootstrap needed unless the grammar itself changed).

## Why not auto-regenerate from Maven?

Short version: MWE2 (the Xtext language generator) requires a
`IJvmTypeProvider.Factory` binding that is set up by Eclipse's runtime
environment, not by `Mwe2StandaloneSetup.createInjectorAndDoEMFRegistration()`.
Running MWE2 outside Eclipse on Java 17+ fails at
`JavaReflectAccess.getRawType` with `Cannot resolve proxy: java:/Objects/java.lang.String`.
Working around it cleanly requires Guice module overrides plus a hand-rolled
Mwe2 runner, which is more code than the one-time Eclipse step it replaces.
