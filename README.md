# SymboleoAC Text Editor

The SymboleoAC IDE is an Integrated Development Environment designed for the formal specification of legal contracts using the \Symboleo/ language. It is built using the Xtext DSL framework, enabling the creation of domain-specific languages with advanced editor support such as syntax highlighting, validation, and code generation.

The IDE extends Symboleo to SymboleoAC, supporting the specification of access-controlled, and event-driven smart contracts for cyber-physical systems.

## Installation and Setup

To install and use the SymboleoAC IDE, please follow the official installation guide:

[Installation Guide](https://github.com/Smart-Contract-Modelling-uOttawa/Symboleo-IDE/blob/master/INSTALL.md)

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
| ** ACPolicy Controller** | Defines the controller of the access control policy. Controller of contract policy is responsible for managing the policy and specifying constraints over rules. |
| **rule** | Each rule defines a decision (e.g., grant or revoke) for specific roles to access resources. These rules determine how entities interact with contract resources. |
| **accessedRole** | The role for which access is being granted or revoked. |
| **accessedResource** | The resource on which access is being controlled. |
| ** Resources Controller** | The entity or entities responsible for managing and enforcing access control to a specifc resource. |

The sample contracts available in `Symboleo-IDE/samples/` demonstrate how access control is specified in Symboleo.

## Examples

Examples of three contracts with their Symboleo specifications and generated smart contracts with access control are available in another repository:

[SymboleoAC2SC Repository](https://github.com/Smart-Contract-Modelling-uOttawa/SymboleoAC2SC)


