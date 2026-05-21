# SymboleoAC Text Editor

The SymboleoAC IDE is an Integrated Development Environment designed for the formal specification of legal contracts using the \Symboleo/ language. It is built using the Xtext DSL framework, enabling the creation of domain-specific languages with advanced editor support such as syntax highlighting, validation, and code generation.

The IDE extends Symboleo to SymboleoAC, supporting the specification of access-controlled, and event-driven smart contracts for cyber-physical systems.

## Installation and Setup

To install and use the SymboleoAC IDE, please follow the official installation guide:

[Installation Guide](https://github.com/Smart-Contract-Modelling-uOttawa/Symboleo-IDE/blob/master/INSTALL.md)

## Headless CLI Validator

For batch experiments and automated pipelines (e.g. LLM transform-and-fix
loops), a headless command-line validator is available that runs the Xtext
parser and every `@Check` rule in [`SymboleoValidator`](ca.uottawa.csmlab.symboleo/src/ca/uottawa/csmlab/symboleo/validation/SymboleoValidator.java)
without launching Eclipse.

### Download

Grab the latest fat jar from the **Releases** page:

[symboleo-cli-1.0.0-all.jar](https://github.com/Smart-Contract-Modelling-uOttawa/SymboleoAC-IDE/releases/latest)

Requires **Java 17+** on PATH. No other dependencies.

### Usage

```bash
java -jar symboleo-cli-1.0.0-all.jar <input.symboleo> [options]
```

| Option | Description |
|---|---|
| `-o`, `--out <file>` | Write diagnostics to a file instead of stdout |
| `-f`, `--format <fmt>` | `text` (default) or `json` |
| `-q`, `--quiet` | Suppress the human-readable summary on stdout |
| `-h`, `--help` | Show usage |

### Exit codes

| Code | Meaning |
|---|---|
| `0` | File parses, no `ERROR`-severity issues (warnings allowed) |
| `1` | One or more `ERROR`-severity issues (grammar or `@Check`) |
| `2` | Usage error or I/O failure (input missing, etc.) |

### JSON output shape

Ideal as input to an automated fixer (e.g. LLM):

```json
{
  "summary": {
    "total": 2,
    "warnings": 0,
    "errors": 2
  },
  "file": "C:\\Users\\SomeUser\\Models\\Test.symboleo",
  "issues": [
    {
      "severity": "ERROR",
      "code": null,
      "offset": 3088,
      "line": 41,
      "column": 34,
      "length": 5,
      "message": "Type of 'name' in myAsset is Number, it does not match String"
    },
    {
      "severity": "ERROR",
      "code": null,
      "offset": 9590,
      "line": 137,
      "column": 2,
      "length": 17,
      "message": "Duplicate identifier oSomeObligation"
    }
  ]
}
```

### Examples

Validate a single file and dump errors as JSON:

```bash
java -jar symboleo-cli-1.0.0-all.jar samples/MeatSale.symboleo \
     --format json --out errors.json
```

Batch-validate a directory, stopping on the first error (bash):

```bash
for f in contracts/*.symboleo; do
  java -jar symboleo-cli-1.0.0-all.jar "$f" --quiet || exit 1
done
```

PowerShell equivalent:

```powershell
Get-ChildItem contracts\*.symboleo | ForEach-Object {
  java -jar symboleo-cli-1.0.0-all.jar $_.FullName --quiet
  if ($LASTEXITCODE -ne 0) { throw "validation failed on $($_.Name)" }
}
```

### Building from source

See [`cli/README.md`](cli/README.md) for the developer build instructions.

## How to Use the IDE?

Once the IDE is set up and operational:

1. Open the **runtime-Eclipse workspace** using the steps provided in the installation guide.

2. Create a new general project:  
   `File → New → Project… → General → Project`

3. Explore the **Sample** folder, which contains several example contracts.  
   You can either:
   - Generate smart contracts from the provided examples, or  
   - Start writing a \Symboleo/ specification from scratch.

4. Inside your project, create a new file with the `.symboleo` extension.

5. You can copy and paste an example from the **Sample** folder into your new file as a starting point.


## How to Specify AC in SymboleoAC?

Access control in SymboleoAC is specified within the **Contract Body** section of Symboleo contract specification.  

This section defines who is authorized to perform specific actions on particular resources.

The following table summarizes the main access control concepts:

| Access Control Concept | Description |
|----------------------|------------|
| **ACPolicy** | Indicates the beginning of the access control section. This section governs who has permission to perform specific actions on resources within the contract. |
| **ACPolicy Controller** | Defines the controller of the access control policy. Controller of contract policy is responsible for managing the policy and specifying constraints over rules. |
| **rule** | Each rule defines a decision (e.g., grant or revoke) for specific roles to access resources. These rules determine how entities interact with contract resources. |
| **accessedRole** | The role for which access is being granted or revoked. |
| **accessedResource** | The resource on which access is being controlled. |
| **Resources Controller** | The entity responsible for managing and enforcing access control to a specifc resource. |

The sample contracts available in `SymboleoAC-IDE/samples/` demonstrate how access control is specified in Symboleo.

## Examples

Examples of three contracts with their Symboleo specifications and generated smart contracts with access control are available in another repository:

[SymboleoAC2SC Repository](https://github.com/Smart-Contract-Modelling-uOttawa/SymboleoAC2SC)


