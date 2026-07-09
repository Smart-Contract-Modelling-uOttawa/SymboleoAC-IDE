package ca.uottawa.csmlab.symboleo.generator;

import ca.uottawa.csmlab.symboleo.Helpers;
import ca.uottawa.csmlab.symboleo.symboleo.And;
import ca.uottawa.csmlab.symboleo.symboleo.AssignExpression;
import ca.uottawa.csmlab.symboleo.symboleo.Assignment;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDate;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDouble;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionEnum;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionFalse;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionInt;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionParameter;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionString;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionTrue;
import ca.uottawa.csmlab.symboleo.symboleo.Attribute;
import ca.uottawa.csmlab.symboleo.symboleo.Comparison;
import ca.uottawa.csmlab.symboleo.symboleo.ContractEvent;
import ca.uottawa.csmlab.symboleo.symboleo.ContractState;
import ca.uottawa.csmlab.symboleo.symboleo.Controller;
import ca.uottawa.csmlab.symboleo.symboleo.Div;
import ca.uottawa.csmlab.symboleo.symboleo.DomainType;
import ca.uottawa.csmlab.symboleo.symboleo.EnumItem;
import ca.uottawa.csmlab.symboleo.symboleo.Enumeration;
import ca.uottawa.csmlab.symboleo.symboleo.Equality;
import ca.uottawa.csmlab.symboleo.symboleo.Eselfvent;
import ca.uottawa.csmlab.symboleo.symboleo.Event;
import ca.uottawa.csmlab.symboleo.symboleo.Expression;
import ca.uottawa.csmlab.symboleo.symboleo.FunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.IntervalExpression;
import ca.uottawa.csmlab.symboleo.symboleo.IntervalFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Minus;
import ca.uottawa.csmlab.symboleo.symboleo.Mod;
import ca.uottawa.csmlab.symboleo.symboleo.Model;
import ca.uottawa.csmlab.symboleo.symboleo.Multi;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPAtom;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPrimaryExpression;
import ca.uottawa.csmlab.symboleo.symboleo.Obligation;
import ca.uottawa.csmlab.symboleo.symboleo.ObligationEvent;
import ca.uottawa.csmlab.symboleo.symboleo.ObligationState;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OntologyType;
import ca.uottawa.csmlab.symboleo.symboleo.Or;
import ca.uottawa.csmlab.symboleo.symboleo.PAnd;
import ca.uottawa.csmlab.symboleo.symboleo.PArithmetic;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomDateLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomDoubleLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomEnum;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomIntLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomPredicate;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomPredicateFalseLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomPredicateTrueLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomRecursive;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomStringLiteral;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomVariable;
import ca.uottawa.csmlab.symboleo.symboleo.PComparison;
import ca.uottawa.csmlab.symboleo.symboleo.PEquality;
import ca.uottawa.csmlab.symboleo.symboleo.PFContractResumed;
import ca.uottawa.csmlab.symboleo.symboleo.PFContractSuspended;
import ca.uottawa.csmlab.symboleo.symboleo.PFContractTerminated;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationDischarged;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationResumed;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationSuspended;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationTerminated;
import ca.uottawa.csmlab.symboleo.symboleo.PFObligationTriggered;
import ca.uottawa.csmlab.symboleo.symboleo.POr;
import ca.uottawa.csmlab.symboleo.symboleo.Parameter;
import ca.uottawa.csmlab.symboleo.symboleo.Permission;
import ca.uottawa.csmlab.symboleo.symboleo.Plus;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomContractEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomObligationEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomParameterDotExpression;
import ca.uottawa.csmlab.symboleo.symboleo.PointAtomPowerEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PointExpression;
import ca.uottawa.csmlab.symboleo.symboleo.PointFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Power;
import ca.uottawa.csmlab.symboleo.symboleo.PowerEvent;
import ca.uottawa.csmlab.symboleo.symboleo.PowerFunction;
import ca.uottawa.csmlab.symboleo.symboleo.PowerState;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunction;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionAssignment;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionAssignmentOnly;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappens;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappensAfter;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionHappensWithin;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionSHappensBefore;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionWHappensBefore;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionFunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionRecursive;
import ca.uottawa.csmlab.symboleo.symboleo.Proposition;
import ca.uottawa.csmlab.symboleo.symboleo.Ref;
import ca.uottawa.csmlab.symboleo.symboleo.RegularType;
import ca.uottawa.csmlab.symboleo.symboleo.ResourceACPolicy;
import ca.uottawa.csmlab.symboleo.symboleo.ResourceDot;
import ca.uottawa.csmlab.symboleo.symboleo.ResourceObligation;
import ca.uottawa.csmlab.symboleo.symboleo.ResourceOntologyType;
import ca.uottawa.csmlab.symboleo.symboleo.ResourcePower;
import ca.uottawa.csmlab.symboleo.symboleo.Rule;
import ca.uottawa.csmlab.symboleo.symboleo.Situation;
import ca.uottawa.csmlab.symboleo.symboleo.SituationExpression;
import ca.uottawa.csmlab.symboleo.symboleo.ThirdParty;
import ca.uottawa.csmlab.symboleo.symboleo.ThreeArgDateFunction;
import ca.uottawa.csmlab.symboleo.symboleo.ThreeArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Variable;
import ca.uottawa.csmlab.symboleo.symboleo.VariableEvent;
import ca.uottawa.csmlab.symboleo.symboleo.VariableRef;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Symboleo2SC extends SymboleoGenerator {
  private final String ASSET_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String EVENT_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String ROLE_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String POWER_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String OBLIGATION_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String CONTRACT_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String EVENTS_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String PREDICATES_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String UTILS_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String ACPolicy_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String ATTRIBUTE_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String Rule_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String Resource_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String Operation_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String LegalSituation_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final ArrayList<RegularType> assets = new ArrayList<RegularType>();

  private final ArrayList<RegularType> events = new ArrayList<RegularType>();

  private final ArrayList<RegularType> roles = new ArrayList<RegularType>();

  private final ArrayList<Enumeration> enumerations = new ArrayList<Enumeration>();

  private final ArrayList<Parameter> parameters = new ArrayList<Parameter>();

  private final ArrayList<Variable> variables = new ArrayList<Variable>();

  private final ArrayList<String> AssignVar = new ArrayList<String>();

  private final ArrayList<Obligation> conditionalObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> conditionalSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> conditionalPowers = new ArrayList<Power>();

  private final ArrayList<Obligation> unconditionalObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> unconditionalSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> unconditionalPowers = new ArrayList<Power>();

  private final ArrayList<Obligation> untriggeredObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> untriggeredSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> untriggeredPowers = new ArrayList<Power>();

  private final ArrayList<Obligation> triggeredObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> triggeredSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> triggeredPowers = new ArrayList<Power>();

  private final ArrayList<Obligation> allObligations = new ArrayList<Obligation>();

  private final ArrayList<Obligation> allSurvivingObligations = new ArrayList<Obligation>();

  private final ArrayList<Power> allPowers = new ArrayList<Power>();

  private final ArrayList<String> arrays = new ArrayList<String>();

  private final ArrayList<Variable> eventVariables = new ArrayList<Variable>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationTriggerEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationTriggerEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Power, List<PAtomPredicate>> powerTriggerEvents = new HashMap<Power, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationAntecedentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationAntecedentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Power, List<PAtomPredicate>> powerAntecedentEvents = new HashMap<Power, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationFullfilmentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationFullfilmentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Resource, List<Controller>> controller = new HashMap<Resource, List<Controller>>();

  public void generateHFSource(final IFileSystemAccess2 fsa, final Model model) {
    this.parse(model);
    this.compileDomainTypes(fsa, model);
    this.compileContract(fsa, model);
    this.compileEventsFile(fsa, model);
    this.compileTransactionFile(fsa, model);
    this.compileSerializerFile(fsa, model);
    this.generateNPMFile(fsa, model);
  }

  public void compileDomainTypes(final IFileSystemAccess2 fsa, final Model model) {
    for (final RegularType asset : this.assets) {
      this.generateAsset(fsa, model, asset);
    }
    for (final RegularType event : this.events) {
      this.generateEvent(fsa, model, event);
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("const { Event } = require(\"symboleoac-js-core\");");
    _builder.newLine();
    _builder.append("class Notified extends Event {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("constructor(_name, message) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("super()");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this._name = _name");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this._type = \'Notified\'");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("this.message = message || []");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("module.exports.Notified = Notified");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName = model.getContractName();
    String _plus = ("./" + _contractName);
    String _plus_1 = (_plus + "/domain/events/Notified.js");
    fsa.generateFile(_plus_1, code);
    for (final RegularType role : this.roles) {
      this.generateRole(fsa, model, role);
    }
    for (final Enumeration enumeration : this.enumerations) {
      this.generateEnumeration(fsa, model, enumeration);
    }
  }

  public void compileContract(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final RegularType asset : this.assets) {
        _builder.append("  ");
        _builder.append("const { ");
        String _name = asset.getName();
        _builder.append(_name, "  ");
        _builder.append(" } = require(\"../assets/");
        String _name_1 = asset.getName();
        _builder.append(_name_1, "  ");
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final RegularType event : this.events) {
        _builder.append("  ");
        _builder.append("const { ");
        String _name_2 = event.getName();
        _builder.append(_name_2, "  ");
        _builder.append(" } = require(\"../events/");
        String _xifexpression = null;
        String _name_3 = event.getOntologyType().getName();
        boolean _equals = Objects.equals(_name_3, "DataTransfer");
        if (_equals) {
          _xifexpression = "datatransfer/";
        } else {
          _xifexpression = "";
        }
        _builder.append(_xifexpression, "  ");
        String _name_4 = event.getName();
        _builder.append(_name_4, "  ");
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final RegularType role : this.roles) {
        _builder.append("  ");
        _builder.append("const { ");
        String _name_5 = role.getName();
        _builder.append(_name_5, "  ");
        _builder.append(" } = require(\"../roles/");
        String _name_6 = role.getName();
        _builder.append(_name_6, "  ");
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      for(final Enumeration enumeration : this.enumerations) {
        _builder.append("  ");
        _builder.append("const { ");
        String _name_7 = enumeration.getName();
        _builder.append(_name_7, "  ");
        _builder.append(" } = require(\"../types/");
        String _name_8 = enumeration.getName();
        _builder.append(_name_8, "  ");
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("  ");
    _builder.append("const { SymboleoContract } = require(");
    _builder.append(this.CONTRACT_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { Obligation } = require(");
    _builder.append(this.OBLIGATION_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { Power } = require(");
    _builder.append(this.POWER_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { Utils } = require(");
    _builder.append(this.UTILS_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { Str } = require(");
    _builder.append(this.UTILS_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { ACPolicy } = require(");
    _builder.append(this.ACPolicy_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { Notified } = require(\"../events/Notified.js\")");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const { Attribute } = require(");
    _builder.append(this.ATTRIBUTE_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { Rule } = require(");
    _builder.append(this.Rule_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { LegalSituation } = require(");
    _builder.append(this.LegalSituation_CLASS_IMPORT_PATH, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("const { contracts } = require(\"../../index.js\")");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("class ");
    String _contractName = model.getContractName();
    _builder.append(_contractName, "  ");
    _builder.append(" extends SymboleoContract {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("constructor(");
    final Function1<Parameter, String> _function = (Parameter p) -> {
      return p.getName();
    };
    String _join = IterableExtensions.join(ListExtensions.<Parameter, String>map(model.getParameters(), _function), ", ");
    _builder.append(_join, "    ");
    _builder.append(") {");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("super(\"");
    String _contractName_1 = model.getContractName();
    _builder.append(_contractName_1, "      ");
    _builder.append("\")");
    _builder.newLineIfNotEmpty();
    _builder.append("      ");
    _builder.append("this._name = \"");
    String _contractName_2 = model.getContractName();
    _builder.append(_contractName_2, "      ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    {
      EList<Parameter> _parameters = model.getParameters();
      for(final Parameter parameter : _parameters) {
        _builder.append("      ");
        _builder.append("this.");
        String _name_9 = parameter.getName();
        _builder.append(_name_9, "      ");
        _builder.append(" = ");
        String _name_10 = parameter.getName();
        _builder.append(_name_10, "      ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("      ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("this.obligations = {};");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("this.survivingObligations = {};");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("this.powers = {};");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("//notification ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("this.notified = new Notified (\'notified\')");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("// assign varaibles of the contract");
    _builder.newLine();
    {
      EList<Variable> _variables = model.getVariables();
      for(final Variable variable : _variables) {
        {
          RegularType _type = variable.getType();
          if ((_type instanceof RegularType)) {
            _builder.append("      ");
            _builder.append("\t\t");
            _builder.append("this.");
            String _name_11 = variable.getName();
            _builder.append(_name_11, "      \t\t");
            _builder.append(" = new ");
            String _name_12 = variable.getType().getName();
            _builder.append(_name_12, "      \t\t");
            _builder.append("(\"");
            String _name_13 = variable.getName();
            _builder.append(_name_13, "      \t\t");
            _builder.append("\")");
            _builder.newLineIfNotEmpty();
            _builder.append("      ");
            _builder.newLine();
            _builder.append("      ");
            int cntt = 0;
            _builder.newLineIfNotEmpty();
            _builder.append("      ");
            _builder.append(" ");
            String cntp = "";
            _builder.newLineIfNotEmpty();
            {
              EList<Assignment> _attributes = variable.getAttributes();
              for(final Assignment assignment : _attributes) {
                {
                  if ((assignment instanceof AssignExpression)) {
                    {
                      if (((!Objects.equals(((AssignExpression)assignment).getName(), "controller")) && (!Objects.equals(((AssignExpression)assignment).getName(), "performer")))) {
                        {
                          String _lowerCase = ((AssignExpression)assignment).getName().toLowerCase();
                          boolean _notEquals = (!Objects.equals(_lowerCase, "owner"));
                          if (_notEquals) {
                            _builder.append("this.");
                            String _name_14 = variable.getName();
                            _builder.append(_name_14);
                            _builder.append(".");
                            String _name_15 = ((AssignExpression)assignment).getName();
                            _builder.append(_name_15);
                            _builder.append("._value = ");
                            String _generateExpressionString = this.generateExpressionString(((AssignExpression)assignment).getValue(), "P");
                            _builder.append(_generateExpressionString);
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("this.");
                            String _name_16 = variable.getName();
                            _builder.append(_name_16);
                            _builder.append(".");
                            String _name_17 = ((AssignExpression)assignment).getName();
                            _builder.append(_name_17);
                            _builder.append(" = ");
                            String _generateExpressionString_1 = this.generateExpressionString(((AssignExpression)assignment).getValue(), "P");
                            _builder.append(_generateExpressionString_1);
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      } else {
                        {
                          String _name_18 = ((AssignExpression)assignment).getName();
                          boolean _equals_1 = Objects.equals(_name_18, "controller");
                          if (_equals_1) {
                            _builder.append("                 ");
                            String _xblockexpression = null;
                            {
                              cntt = 1;
                              _xblockexpression = "";
                            }
                            _builder.append(_xblockexpression, "                 ");
                            _builder.append("  ");
                            _builder.newLineIfNotEmpty();
                            _builder.append("this.");
                            String _name_19 = variable.getName();
                            _builder.append(_name_19);
                            _builder.append(".addController(");
                            String _generateExpressionString_2 = this.generateExpressionString(((AssignExpression)assignment).getValue(), "P");
                            _builder.append(_generateExpressionString_2);
                            _builder.append(")");
                            _builder.newLineIfNotEmpty();
                          } else {
                            _builder.append("      ");
                            String _xifexpression_1 = null;
                            if ((Objects.equals(Helpers.getBaseType(variable.getType()).getOntologyType().getName(), "Event") || Objects.equals(Helpers.getBaseType(variable.getType()).getOntologyType().getName(), "DataTransfer"))) {
                              String _name_20 = variable.getName();
                              String _plus = ("this." + _name_20);
                              String _plus_1 = (_plus + ".addPerformer(");
                              String _generateExpressionString_3 = this.generateExpressionString(((AssignExpression)assignment).getValue(), "this");
                              String _plus_2 = (_plus_1 + _generateExpressionString_3);
                              _xifexpression_1 = (_plus_2 + ")");
                            } else {
                              _xifexpression_1 = "";
                            }
                            _builder.append(_xifexpression_1, "      ");
                            _builder.newLineIfNotEmpty();
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            {
              if ((cntt == 0)) {
                _builder.append("      ");
                _builder.append(" ");
                _builder.append("this.");
                String _name_21 = variable.getName();
                _builder.append(_name_21, "       ");
                _builder.append(".addController(");
                String _defaultController = this.getDefaultController(model, variable);
                _builder.append(_defaultController, "       ");
                _builder.append(")  ");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("      ");
            _builder.append(" \t ");
            String _xifexpression_2 = null;
            String _name_22 = Helpers.getBaseType(variable.getType()).getOntologyType().getName();
            boolean _equals_2 = Objects.equals(_name_22, "Role");
            if (_equals_2) {
              String _name_23 = variable.getName();
              String _plus_3 = ("this.addRole(this." + _name_23);
              _xifexpression_2 = (_plus_3 + ")");
            } else {
              _xifexpression_2 = "";
            }
            _builder.append(_xifexpression_2, "       \t ");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("this.accessPolicy = new ACPolicy(");
    String _defaultControllerACPolicy = this.getDefaultControllerACPolicy(model);
    _builder.append(_defaultControllerACPolicy);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      EList<Variable> _variables_1 = model.getVariables();
      for(final Variable variable_1 : _variables_1) {
        {
          boolean _findRole = this.findRole(variable_1.getType().getName());
          if (_findRole) {
            {
              ThirdParty _thirdParty = variable_1.getType().getThirdParty();
              boolean _tripleEquals = (_thirdParty == null);
              if (_tripleEquals) {
                _builder.append("this.addController(this.");
                String _name_24 = variable_1.getName();
                _builder.append(_name_24);
                _builder.append("); ");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("      ");
    _builder.append("// create instance of triggered obligations");
    _builder.newLine();
    {
      for(final Obligation obligation : this.triggeredObligations) {
        _builder.append("          \t    ");
        _builder.append("this.");
        String _name_25 = obligation.getName();
        _builder.append(_name_25, "          \t    ");
        _builder.append("Situation = new LegalSituation();");
        _builder.newLineIfNotEmpty();
        {
          Proposition _consequent = obligation.getConsequent();
          boolean _not = (!(_consequent instanceof PAtomPredicateTrueLiteral));
          if (_not) {
            _builder.append("          \t  ");
            Proposition _consequent_1 = obligation.getConsequent();
            String _name_26 = obligation.getName();
            String _plus_4 = ("this." + _name_26);
            String _plus_5 = (_plus_4 + "Situation.addConsequentOf(");
            String _generateLegalpositionCondition = this.generateLegalpositionCondition(_consequent_1, _plus_5);
            _builder.append(_generateLegalpositionCondition, "          \t  ");
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          Proposition _antecedent = obligation.getAntecedent();
          boolean _not_1 = (!(_antecedent instanceof PAtomPredicateTrueLiteral));
          if (_not_1) {
            _builder.append("      ");
            Proposition _antecedent_1 = obligation.getAntecedent();
            String _name_27 = obligation.getName();
            String _plus_6 = ("this." + _name_27);
            String _plus_7 = (_plus_6 + "Situation.addAntecedentOf(");
            String _generateLegalpositionCondition_1 = this.generateLegalpositionCondition(_antecedent_1, _plus_7);
            _builder.append(_generateLegalpositionCondition_1, "      ");
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("      ");
        _builder.append("  ");
        _builder.append("this.obligations.");
        String _name_28 = obligation.getName();
        _builder.append(_name_28, "        ");
        _builder.append(" = new Obligation(\'");
        String _name_29 = obligation.getName();
        _builder.append(_name_29, "        ");
        _builder.append("\', ");
        String _generateDotExpressionString = SymboleoGenerator.generateDotExpressionString(obligation.getCreditor(), "this");
        _builder.append(_generateDotExpressionString, "        ");
        _builder.append(", ");
        String _generateDotExpressionString_1 = SymboleoGenerator.generateDotExpressionString(obligation.getDebtor(), "this");
        _builder.append(_generateDotExpressionString_1, "        ");
        _builder.append(", this, this.");
        String _name_30 = obligation.getName();
        _builder.append(_name_30, "        ");
        _builder.append("Situation)");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        _builder.append("  ");
        String _specifiedControllerObligation = this.getSpecifiedControllerObligation(obligation, "this");
        _builder.append(_specifiedControllerObligation, "        ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("      ");
    _builder.newLine();
    {
      for(final Obligation obligation_1 : this.triggeredSurvivingObligations) {
        _builder.append("      ");
        _builder.append("this.survivingObligations.");
        String _name_31 = obligation_1.getName();
        _builder.append(_name_31, "      ");
        _builder.append(" = new Obligation(\'");
        String _name_32 = obligation_1.getName();
        _builder.append(_name_32, "      ");
        _builder.append("\', ");
        String _generateDotExpressionString_2 = SymboleoGenerator.generateDotExpressionString(obligation_1.getCreditor(), "this");
        _builder.append(_generateDotExpressionString_2, "      ");
        _builder.append(", ");
        String _generateDotExpressionString_3 = SymboleoGenerator.generateDotExpressionString(obligation_1.getDebtor(), "this");
        _builder.append(_generateDotExpressionString_3, "      ");
        _builder.append(", this,null, true)");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        String _specifiedControllerObligation_1 = this.getSpecifiedControllerObligation(obligation_1, "this");
        _builder.append(_specifiedControllerObligation_1, "      ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("      ");
    _builder.newLine();
    {
      for(final Power power : this.triggeredPowers) {
        _builder.append("      ");
        _builder.append("this.powers.");
        String _name_33 = power.getName();
        _builder.append(_name_33, "      ");
        _builder.append("Situation = new LegalSituation();            ");
        _builder.newLineIfNotEmpty();
        {
          Proposition _antecedent_2 = power.getAntecedent();
          boolean _not_2 = (!(_antecedent_2 instanceof PAtomPredicateTrueLiteral));
          if (_not_2) {
            _builder.append("           ");
            Proposition _antecedent_3 = power.getAntecedent();
            String _name_34 = power.getName();
            String _plus_8 = ("this." + _name_34);
            String _plus_9 = (_plus_8 + "Situation.addAntecedentOf(");
            String _generateLegalpositionCondition_2 = this.generateLegalpositionCondition(_antecedent_3, _plus_9);
            _builder.append(_generateLegalpositionCondition_2, "           ");
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("      ");
        _builder.append("this.");
        String _name_35 = power.getName();
        _builder.append(_name_35, "      ");
        _builder.append("Situation.addConsequentOf({_type: \'stateCondition\',");
        String _compilePowerCondition = this.compilePowerCondition(power.getConsequent());
        _builder.append(_compilePowerCondition, "      ");
        _builder.append("})");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        _builder.append("this.powers.");
        String _name_36 = power.getName();
        _builder.append(_name_36, "      ");
        _builder.append(" = new Power(\'");
        String _name_37 = power.getName();
        _builder.append(_name_37, "      ");
        _builder.append("\', ");
        String _generateDotExpressionString_4 = SymboleoGenerator.generateDotExpressionString(power.getCreditor(), "this");
        _builder.append(_generateDotExpressionString_4, "      ");
        _builder.append(", ");
        String _generateDotExpressionString_5 = SymboleoGenerator.generateDotExpressionString(power.getDebtor(), "this");
        _builder.append(_generateDotExpressionString_5, "      ");
        _builder.append(", this,this.");
        String _name_38 = power.getName();
        _builder.append(_name_38, "      ");
        _builder.append("Situation)");
        _builder.newLineIfNotEmpty();
        _builder.append("      ");
        String _specifiedControllerPower = this.getSpecifiedControllerPower(power, "this");
        _builder.append(_specifiedControllerPower, "      ");
        _builder.append("  ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.newLine();
    {
      EList<Rule> _rules = model.getRules();
      for(final Rule rule : _rules) {
        String _specifiedRulesUnCond = this.getSpecifiedRulesUnCond(rule);
        _builder.append(_specifiedRulesUnCond);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append(" \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("module.exports.");
    String _contractName_3 = model.getContractName();
    _builder.append(_contractName_3, "  ");
    _builder.append(" = ");
    String _contractName_4 = model.getContractName();
    _builder.append(_contractName_4, "  ");
    _builder.newLineIfNotEmpty();
    final String code = _builder.toString();
    String _contractName_5 = model.getContractName();
    String _plus_10 = ("./" + _contractName_5);
    String _plus_11 = (_plus_10 + "/domain/contract/");
    String _contractName_6 = model.getContractName();
    String _plus_12 = (_plus_11 + _contractName_6);
    String _plus_13 = (_plus_12 + ".js");
    fsa.generateFile(_plus_13, code);
  }

  public void compileTransactionFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("     ");
    _builder.append("const { Contract } = require(\"fabric-contract-api\")");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("const { ");
    String _contractName = model.getContractName();
    _builder.append(_contractName, "     ");
    _builder.append(" } = require(\"./domain/contract/");
    String _contractName_1 = model.getContractName();
    _builder.append(_contractName_1, "     ");
    _builder.append(".js\")");
    _builder.newLineIfNotEmpty();
    _builder.append("     ");
    _builder.append("const { deserialize, serialize } = require(\"./serializer.js\")");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("const { Events } = require(");
    _builder.append(this.EVENT_CLASS_IMPORT_PATH, "     ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("     ");
    _builder.append("const { InternalEvent, InternalEventSource, InternalEventType } = require(");
    _builder.append(this.EVENT_CLASS_IMPORT_PATH, "     ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("     ");
    _builder.append("const { getEventMap, EventListeners } = require(\"./events.js\")");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("const { Rule } = require(");
    _builder.append(this.Rule_CLASS_IMPORT_PATH, "     ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("     ");
    _builder.append("const { error } = require(\"fabric-shim\")");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("const { ClientIdentity, ChaincodeStub }= require(\'fabric-shim\');");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("const crypto = require(\'crypto\');");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("class HFContract extends Contract {");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("constructor() {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("super(\'");
    String _contractName_2 = model.getContractName();
    _builder.append(_contractName_2, "         ");
    _builder.append("\');");
    _builder.newLineIfNotEmpty();
    _builder.append("         ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("initialize(contract) {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("Events.init(getEventMap(contract), EventListeners)");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("       ");
    String _compileInitMethod = this.compileInitMethod(model);
    _builder.append(_compileInitMethod, "       ");
    _builder.newLineIfNotEmpty();
    _builder.append("     ");
    _builder.newLine();
    {
      List<String> _compileEventTriggerMethods = this.compileEventTriggerMethods(model);
      for(final String method : _compileEventTriggerMethods) {
        _builder.append("       ");
        _builder.append(method, "       ");
        _builder.newLineIfNotEmpty();
        _builder.append("       ");
        _builder.newLine();
      }
    }
    {
      List<String> _compilePowerTransactions = this.compilePowerTransactions(model);
      for(final String method_1 : _compilePowerTransactions) {
        _builder.append("       ");
        _builder.append(method_1, "       ");
        _builder.newLineIfNotEmpty();
        _builder.append("       ");
        _builder.newLine();
      }
    }
    {
      List<String> _compileTransferTransactions = this.compileTransferTransactions(model);
      for(final String method_transfer : _compileTransferTransactions) {
        _builder.append("       ");
        _builder.append(method_transfer, "       ");
        _builder.newLineIfNotEmpty();
        _builder.append("       ");
        _builder.newLine();
      }
    }
    {
      List<String> _compileViolationEventsTransactions = this.compileViolationEventsTransactions(model);
      for(final String method_2 : _compileViolationEventsTransactions) {
        _builder.append("       ");
        _builder.append(method_2, "       ");
        _builder.newLineIfNotEmpty();
        _builder.append("       ");
        _builder.newLine();
      }
    }
    {
      List<String> _compileExpirationTransactions = this.compileExpirationTransactions(model);
      for(final String method_3 : _compileExpirationTransactions) {
        _builder.append("       ");
        _builder.append(method_3, "       ");
        _builder.newLineIfNotEmpty();
        _builder.append("       ");
        _builder.newLine();
      }
    }
    {
      List<String> _compilePowerExpirationTransactions = this.compilePowerExpirationTransactions(model);
      for(final String method_4 : _compilePowerExpirationTransactions) {
        _builder.append("       ");
        _builder.append(method_4, "       ");
        _builder.newLineIfNotEmpty();
        _builder.append("       ");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("         ");
    _builder.append("//notification");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("async trigger_notification(ctx, event) {");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("console.log(\"trigger_notification\")");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("console.log(event)");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("await ctx.stub.setEvent(event.name, Buffer.from(JSON.stringify({");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("event: event");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("})));");
    _builder.newLine();
    _builder.append("         ");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("return {successful: true}");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("* Stores the hardcoded rolesList in the ledger as ACPolicyRecord with a signed hash.");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("* Can only be called by Regulator or Admin.");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("* Input is not accepted to prevent tampering.");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("async storeRolesPolicy(ctx, contractId) {");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("console.log(\"I am in storeRolesPolicy\")");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("let roleObj;");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("//");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const userId = cid.getID();");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const role = cid.getAttributeValue(\'HF.role\');");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("console.log(\"Attr name\")");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("console.log(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'))");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("try{");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("if (role !== \'Admin\' && role !== \'Regulator\') {");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("throw new Error(\'Only Admin or Regulator can trigger roles policy storage\');");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if(roleObj === null ){ ");
    _builder.newLine();
    _builder.append("                     ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}//else");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("// Build roles policy from contract spec");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const policy = {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("roles: contract._roles.map(role => ({");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("name: role._name,");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("type: role._type,");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("dept: role.dept._value,");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("org: role.org._value");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("})),");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("metadata: {");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("storedBy: cid.getID(),");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("timestamp: new Date().toISOString()");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const policyStr = JSON.stringify(policy);");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const policyHash = crypto.createHash(\'sha256\').update(policyStr).digest();");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const record = {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("hash: policyHash.toString(\'hex\'),");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("policy,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("verified: true,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("signer: userId");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("await ctx.stub.putState(\'ACPolicyRecord\', Buffer.from(JSON.stringify(record)));");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("// Emit tamper-proof event");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("await ctx.stub.setEvent(\'ACPolicyStored\', Buffer.from(JSON.stringify({");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("accessor: userId,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("role,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("hash: policyHash.toString(\'hex\'),");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("time: new Date().toISOString()");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("})));");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("successful: true,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("hash: policyHash.toString(\'hex\'),");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("message: \'ACPolicy stored successfully with verified signature\'");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("//AC -- get rules for IoT and CEP");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("async getIoTCondition(ctx, contractId) {");
    _builder.newLine();
    _builder.append("                      ");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("let roleObj;");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("let contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("                   ");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("//");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("const userId = cid.getID();");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("const role = cid.getAttributeValue(\'HF.role\');");
    _builder.newLine();
    _builder.append("                       ");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("console.log(\"Attr name in getPolicy\")");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("console.log(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'))");
    _builder.newLine();
    _builder.append("                   ");
    _builder.newLine();
    _builder.append("                       ");
    _builder.append("try{");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("if (role !== \'Admin\' && role !== \'Regulator\') {");
    _builder.newLine();
    _builder.append("                   ");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("throw new Error(\'Only Admin or Regulator can trigger getIoTCondition\');");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
    _builder.newLine();
    _builder.append("                   ");
    _builder.newLine();
    _builder.append("                                ");
    _builder.append("if(roleObj === null ){ ");
    _builder.newLine();
    _builder.append("                                 ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("                   ");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}//else");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("              ");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("contractState = await ctx.stub.getState(contractId) ");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("let rules = { rules: [], roles: [] };");
    _builder.newLine();
    _builder.append("              ");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("const eventList = [");
    _builder.newLine();
    _builder.append("                ");
    final Function1<Variable, Boolean> _function = (Variable e) -> {
      String _name = Helpers.getBaseType(e.getType()).getOntologyType().getName();
      return Boolean.valueOf(Objects.equals(_name, "DataTransfer"));
    };
    final Function1<Variable, String> _function_1 = (Variable v) -> {
      String _name = v.getName();
      String _plus = ("\'" + _name);
      return (_plus + "\'");
    };
    String _join = IterableExtensions.join(IterableExtensions.<Variable, String>map(IterableExtensions.<Variable>filter(this.variables, _function), _function_1), ", ");
    _builder.append(_join, "                ");
    _builder.newLineIfNotEmpty();
    _builder.append("              ");
    _builder.append("];");
    _builder.newLine();
    _builder.append("              ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("for (const key of eventList) {");
    _builder.newLine();
    _builder.append("             ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("// skip undefined contract entries");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("if (contract[key] === undefined) continue;");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("if (!contract.hasOwnProperty(key)) continue;");
    _builder.newLine();
    _builder.append("             ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("const dObj = contract[key];");
    _builder.newLine();
    _builder.append("             ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("rules.rules.push({");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("id: dObj._name + \"Rule\",");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("contractId: contractId,");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("chaincodeName: \"");
    String _lowerCase = model.getContractName().toLowerCase();
    _builder.append(_lowerCase, "                 ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("                 ");
    _builder.append("eventType: \"SensorEvent\",");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("sensorType: dObj._name,");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("sensorId: dObj.sensorId,");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("condition:(dObj.condition._value.trim() === \"\")? \"\": dObj.condition._value,");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("window: (dObj.window._value.trim() === \"\")? \"\": \"time(\"+dObj.window._value+ \" min)\",");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("having: (dObj.count._value.trim() === \"\")? \"\":\"count(*) > \" +dObj.count._value,");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("select: \"sensorId, sensorTimestamp\"+((dObj.count._value.trim() === \"\")? \", value \" : \", count(*) as cnt, avg(value)\")+\" as avgValue\",");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("chaincodeFunction: \"trigger_\" + dObj._name");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("});");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("// -------------------------------");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("// Build roles list from contract");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("// -------------------------------");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("rules.roles = contract._roles.map(role => role.name._value);");
    _builder.newLine();
    _builder.append("              ");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("// metadata block");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("rules.metadata = {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("storedBy: cid.getID(),");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("timestamp: new Date().toISOString()");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("                      ");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("const ruleStr = JSON.stringify(rules);");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("const ruleHash = crypto.createHash(\'sha256\').update(ruleStr).digest();                      ");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("const record = {");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("hash: ruleHash.toString(\'hex\'),");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("rules,");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("verified: true,");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("signer: userId");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("                          ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("successful: true,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("message: \'Retrieved successfully\',");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("record: record");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("};                      ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("* Allows CAAdmin or Regulator to retrieve the stored ACPolicy.");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("async getRolePolicy(ctx, contractId) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("let roleObj;");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("//");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const userId = cid.getID();");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const role = cid.getAttributeValue(\'HF.role\');");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("console.log(\"Attr name in getPolicy\")");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("console.log(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'))");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("try{");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("if (role !== \'Admin\' && role !== \'Regulator\') {");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("throw new Error(\'Only Admin or Regulator can trigger roles policy storage\');");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if(roleObj === null ){ ");
    _builder.newLine();
    _builder.append("                     ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}//else");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const policyBytes = await ctx.stub.getState(\'ACPolicyRecord\');");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("if (!policyBytes || policyBytes.length === 0) {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("return { successful: false, message: \'ACPolicyRecord not found\' };");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const policy = JSON.parse(policyBytes.toString());");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("// Emit access event for auditing");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("await ctx.stub.setEvent(\'ACPolicyAccessed\', Buffer.from(JSON.stringify({");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("accessor: userId,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("role,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("time: new Date().toISOString()");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("})));");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("successful: true,");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("message: \'ACPolicy retrieved successfully\',");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("policyRecord: policy");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("//get Date And Time of any event");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("async getEventDateAndTime(ctx, args) {");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("       \t        \t        \t");
    _builder.append("let roleObj;");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const inputs = JSON.parse(args);");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const contractId = inputs.contractId;");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const requiredResource = inputs.event");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("let output = {}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("try{           \t");
    _builder.newLine();
    _builder.append("                             \t       ");
    _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("                             \t       ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
    _builder.newLine();
    _builder.append("                             \t");
    _builder.newLine();
    _builder.append("                             \t             ");
    _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
    _builder.newLine();
    _builder.append("                             \t              ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("                             \t         ");
    _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
    _builder.newLine();
    _builder.append("                             \t        ");
    _builder.append("// wrong certificate");
    _builder.newLine();
    _builder.append("                             \t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                             \t");
    _builder.newLine();
    _builder.append("                             \t    ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("                             \t        ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("                             \t        ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("                             \t    ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("                             \t    ");
    _builder.append("//seond layer");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("let eventObj = contract.findObject(requiredResource.event, requiredResource._type, contract)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("if (  eventObj != null){");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("let controllers = eventObj._controller");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("if(contract.accessPolicy.hasPermesstion(\'grant\',\'read\', eventObj, roleObj, eventObj.getController(controllers.length - 1)) || contract.accessPolicy.hasPermesstionOnLegalPosition(\'grant\',\'read\', eventObj, roleObj, eventObj.getController(controllers.length - 1), contract)){");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("output = {time: eventObj.getHappenedTime(), state: eventObj.hasHappened()  ? \"Happened\" : \"Not Happened\"}  ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("throw new Error(`access denied...`)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("return output");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}else{ throw new Error(`The event is not exist...`)}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("//AC -- access state, time for legalpositions (obligation and power) by authorized roles ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("async getLegalPositionStateAndTime(ctx, args) {");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("       \t        \t        \t");
    _builder.append("let roleObj;");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("const inputs = JSON.parse(args);");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("const contractId = inputs.contractId;");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("const quiredState = inputs.quiredState.state");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("const requiredResource = inputs.quiredState.resource");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("const requiredResourceType = inputs.quiredState.resourceType");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("let output = {}");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("       \t  ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("     \t\t");
    _builder.append("try{           \t");
    _builder.newLine();
    _builder.append("   \t       ");
    _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("   \t       ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
    _builder.newLine();
    _builder.append("   \t");
    _builder.newLine();
    _builder.append("   \t             ");
    _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
    _builder.newLine();
    _builder.append("   \t              ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("   \t         ");
    _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
    _builder.newLine();
    _builder.append("   \t        ");
    _builder.append("// wrong certificate");
    _builder.newLine();
    _builder.append("   \t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   \t");
    _builder.newLine();
    _builder.append("   \t    ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("   \t        ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("   \t        ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("   \t    ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("   \t    ");
    _builder.append("//seond layer");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("const aResource = contract.findLegalPosition(requiredResource, requiredResourceType, contract)");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("if(aResource !== null){");
    _builder.newLine();
    _builder.append("         \t");
    _builder.append("let controllers = aResource._controller");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("switch(requiredResourceType.toLowerCase()){");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("case \'obligation\':");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("if(contract.accessPolicy.hasPermesstion(\'grant\',\'read\', aResource, roleObj, aResource.getController(controllers.length - 1))) {");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("output= contract.findStateTimeLegalPosition(aResource)");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("throw new Error(`access denied...`)");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("break");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("case \'power\': ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("if(contract.accessPolicy.hasPermesstion(\'grant\',\'read\', aResource, roleObj, aResource.getController(controllers.length - 1))) {");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("output=contract.findStateTimeLegalPosition(aResource)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("throw new Error(`access denied...`)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}// outer switch");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("} else{throw new Error(`Resource is not exist...`)}//if (aResource == null)");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("return output");
    _builder.newLine();
    _builder.append("         ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("// Access the state and time of the parts of the legalpositions");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("async getStateTimeOfParts(ctx, args){");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("       \t        \t");
    _builder.append("let roleObj;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const inputs = JSON.parse(args);");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const contractId = inputs.contractId;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const requiredResource = inputs.condition");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("let output = {}");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("// First security layer");
    _builder.newLine();
    _builder.append("                 \t");
    _builder.append("try{           \t");
    _builder.newLine();
    _builder.append("                 \t       ");
    _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("                 \t       ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
    _builder.newLine();
    _builder.append("                 \t");
    _builder.newLine();
    _builder.append("                 \t             ");
    _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
    _builder.newLine();
    _builder.append("                 \t              ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("                 \t         ");
    _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
    _builder.newLine();
    _builder.append("                 \t        ");
    _builder.append("// wrong certificate");
    _builder.newLine();
    _builder.append("                 \t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                 \t");
    _builder.newLine();
    _builder.append("                 \t    ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("                 \t        ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("                 \t        ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("                 \t    ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("                 \t    ");
    _builder.append("//seond layer");
    _builder.newLine();
    _builder.append("                 \t    ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("const aLegalPositionIncodition = contract.findLegalPosition(requiredResource.resource, requiredResource.resourceType, contract)");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if(aLegalPositionIncodition !==null){");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("let controllers = aLegalPositionIncodition._controller");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("switch(requiredResource._type.toLowerCase()){");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("case \'statecondition\':          ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("if(contract.accessPolicy.hasPermesstionOnLegalPosition(\'grant\',\'read\', requiredResource, roleObj, aLegalPositionIncodition.getController(controllers.length - 1),contract)){");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("output=contract.findStateTimeLegalPosition(aLegalPositionIncodition)");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("if(output.State !== null && output.State !== undefined ){");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if (output.State.toLowerCase() !== requiredResource.state.toLowerCase() ) {");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("output = {state: requiredResource.state.toLowerCase()+\' is Not Happened\', time: null}");
    _builder.newLine();
    _builder.append("                      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("} else{");
    _builder.newLine();
    _builder.append("                   ");
    _builder.append("throw new Error(`access denied...`)");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("break");
    _builder.newLine();
    _builder.append("             ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("case \'condition\': ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("if(contract.accessPolicy.hasPermesstionOnLegalPosition(\'grant\',\'read\', requiredResource, roleObj, aLegalPositionIncodition.getController(controllers.length - 1),contract)){");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("let conditionValue = eval(requiredResource.leftSide + \" \" + requiredResource.op + \" \" + requiredResource.rightSide)");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("output = {state: conditionValue, time: null}");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("                     ");
    _builder.append("throw new Error(`access denied...`)");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("break");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("case \'eventcondition\':");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("if(contract.accessPolicy.hasPermesstionOnLegalPosition(\'grant\',\'read\', requiredResource, roleObj, aLegalPositionIncodition.getController(controllers.length - 1),contract)){");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("let eventObj = contract.findObject(requiredResource.partResource, requiredResource.partResourceType, contract)");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("output = {time: eventObj.getHappenedTime(), state: eventObj.hasHappened()  ? \"Happened\" : \"Not Happened\"}");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("throw new Error(`access denied...`)");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("break");
    _builder.newLine();
    _builder.append("             ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("default: throw new Error(`This is not a valid part of legal situation...`)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}else {throw new Error(`Resource is not exist...`)}");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return output");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("// Return the states of the contract and its parts     ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("async getState(ctx, contractId) {");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("       \t  ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("let output = `Contract state: ${contract.state}-${contract.activeState}\\r\\n`");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("output += \'Obligations:\\r\\n\'");
    _builder.newLine();
    _builder.append("       \t");
    _builder.append("for (const obligationKey of Object.keys(contract.obligations)) {");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("output += `  ${obligationKey}: ${contract.obligations[obligationKey].state}-${contract.obligations[obligationKey].activeState}\\r\\n`");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("output += \'Powers:\\r\\n\'");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("for (const powerKey of Object.keys(contract.powers)) {");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("output += `  ${powerKey}: ${contract.powers[powerKey].state}-${contract.powers[powerKey].activeState}\\r\\n`");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("output += \'Surviving Obligations:\\r\\n\'");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("for (const obligationKey of Object.keys(contract.survivingObligations)) {");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("output += `  ${obligationKey}: ${contract.survivingObligations[obligationKey].state}-${contract.survivingObligations[obligationKey].activeState}\\r\\n`");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("output += \'Events:\\r\\n\'");
    _builder.newLine();
    {
      for(final Variable event : this.eventVariables) {
        _builder.append("         ");
        _builder.append("if (contract.");
        String _name = event.getName();
        _builder.append(_name, "         ");
        _builder.append("._triggered) {");
        _builder.newLineIfNotEmpty();
        _builder.append("         ");
        _builder.append("  ");
        _builder.append("output += `  Event \"");
        String _name_1 = event.getName();
        _builder.append(_name_1, "           ");
        _builder.append("\" happened at ${contract.");
        String _name_2 = event.getName();
        _builder.append(_name_2, "           ");
        _builder.append("._timestamp}\\r\\n`");
        _builder.newLineIfNotEmpty();
        _builder.append("         ");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("         ");
        _builder.append("  ");
        _builder.append("output += `  Event \"");
        String _name_3 = event.getName();
        _builder.append(_name_3, "           ");
        _builder.append("\" has not happened\\r\\n`");
        _builder.newLineIfNotEmpty();
        _builder.append("         ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("         ");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("return output");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("module.exports.contracts = [HFContract];");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName_3 = model.getContractName();
    String _plus = ("./" + _contractName_3);
    String _plus_1 = (_plus + "/");
    String _plus_2 = (_plus_1 + "index.js");
    fsa.generateFile(_plus_2, code);
  }

  public void generateAsset(final IFileSystemAccess2 fsa, final Model model, final RegularType asset) {
    OntologyType _ontologyType = asset.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("const { Asset } = require(");
      _builder.append(this.ASSET_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("const { Attribute } = require(");
      _builder.append(this.ATTRIBUTE_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      String _name = asset.getName();
      _builder.append(_name);
      _builder.append(" extends Asset {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("constructor(_name,");
      final Function1<Attribute, String> _function = (Attribute a) -> {
        return a.getName();
      };
      String _join = IterableExtensions.join(ListExtensions.<Attribute, String>map(asset.getAttributes(), _function), ", ");
      _builder.append(_join, "  ");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("super(owner)");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._name = _name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._type = \"");
      String _name_1 = asset.getName();
      _builder.append(_name_1, "    ");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("this.owner=owner");
      _builder.newLine();
      {
        EList<Attribute> _attributes = asset.getAttributes();
        for(final Attribute attribute : _attributes) {
          {
            if (((!Objects.equals(attribute.getName(), "owner")) && (!Objects.equals(attribute.getName(), "controller")))) {
              _builder.append("    ");
              _builder.append("this.");
              String _name_2 = attribute.getName();
              _builder.append(_name_2, "    ");
              _builder.append(" = new Attribute(\"");
              String _name_3 = attribute.getName();
              _builder.append(_name_3, "    ");
              _builder.append("\",");
              String _name_4 = attribute.getName();
              _builder.append(_name_4, "    ");
              _builder.append(",_name)");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("module.exports.");
      String _name_5 = asset.getName();
      _builder.append(_name_5);
      _builder.append(" = ");
      String _name_6 = asset.getName();
      _builder.append(_name_6);
      _builder.newLineIfNotEmpty();
      final String code = _builder.toString();
      String _contractName = model.getContractName();
      String _plus = ("./" + _contractName);
      String _plus_1 = (_plus + "/domain/assets/");
      String _name_7 = asset.getName();
      String _plus_2 = (_plus_1 + _name_7);
      String _plus_3 = (_plus_2 + ".js");
      fsa.generateFile(_plus_3, code);
    } else {
      RegularType _regularType = asset.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = asset.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(asset);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(asset.getAttributes());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("const { ");
        String _name_8 = parentType.getName();
        _builder_1.append(_name_8);
        _builder_1.append(" } = require(\"./");
        String _name_9 = parentType.getName();
        _builder_1.append(_name_9);
        _builder_1.append(".js\");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("const { Attribute } = require(");
        _builder_1.append(this.ATTRIBUTE_CLASS_IMPORT_PATH);
        _builder_1.append(");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("class ");
        String _name_10 = asset.getName();
        _builder_1.append(_name_10);
        _builder_1.append(" extends ");
        String _name_11 = parentType.getName();
        _builder_1.append(_name_11);
        _builder_1.append(" {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("  ");
        _builder_1.append("constructor(_name,");
        final Function1<Attribute, String> _function_1 = (Attribute a) -> {
          return a.getName();
        };
        String _join_1 = IterableExtensions.join(ListExtensions.<Attribute, String>map(allAttributes, _function_1), ", ");
        _builder_1.append(_join_1, "  ");
        _builder_1.append(") {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("super(_name,");
        final Function1<Attribute, String> _function_2 = (Attribute a) -> {
          return a.getName();
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<Attribute, String>map(parentAttributes, _function_2), ", ");
        _builder_1.append(_join_2, "    ");
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("this._type = \"");
        String _name_12 = asset.getName();
        _builder_1.append(_name_12, "    ");
        _builder_1.append("\"");
        _builder_1.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_1 = asset.getAttributes();
          for(final Attribute attribute_1 : _attributes_1) {
            {
              if (((!Objects.equals(attribute_1.getName(), "owner")) && (!Objects.equals(attribute_1.getName(), "controller")))) {
                _builder_1.append("    ");
                _builder_1.append("this.");
                String _name_13 = attribute_1.getName();
                _builder_1.append(_name_13, "    ");
                _builder_1.append(" = new Attribute(\"");
                String _name_14 = attribute_1.getName();
                _builder_1.append(_name_14, "    ");
                _builder_1.append("\",");
                String _name_15 = attribute_1.getName();
                _builder_1.append(_name_15, "    ");
                _builder_1.append(",_name)");
                _builder_1.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder_1.append("    ");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("module.exports.");
        String _name_16 = asset.getName();
        _builder_1.append(_name_16);
        _builder_1.append(" = ");
        String _name_17 = asset.getName();
        _builder_1.append(_name_17);
        _builder_1.newLineIfNotEmpty();
        final String code_1 = _builder_1.toString();
        String _contractName_1 = model.getContractName();
        String _plus_4 = ("./" + _contractName_1);
        String _plus_5 = (_plus_4 + "/domain/assets/");
        String _name_18 = asset.getName();
        String _plus_6 = (_plus_5 + _name_18);
        String _plus_7 = (_plus_6 + ".js");
        fsa.generateFile(_plus_7, code_1);
      }
    }
  }

  public void generateEvent(final IFileSystemAccess2 fsa, final Model model, final RegularType event) {
    OntologyType _ontologyType = event.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("const { ");
      String _name = event.getOntologyType().getName();
      _builder.append(_name);
      _builder.append(" } = require(");
      _builder.append(this.EVENT_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("const { Attribute } = require(");
      _builder.append(this.ATTRIBUTE_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("class ");
      String _name_1 = event.getName();
      _builder.append(_name_1);
      _builder.append(" extends ");
      String _name_2 = event.getOntologyType().getName();
      _builder.append(_name_2);
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append(" \t");
      _builder.append("constructor(_name,performer,");
      final Function1<Attribute, Boolean> _function = (Attribute a) -> {
        return Boolean.valueOf(((!Objects.equals(a.getName(), "performer")) && (!Objects.equals(a.getName(), "controller"))));
      };
      final Function1<Attribute, String> _function_1 = (Attribute a) -> {
        return a.getName();
      };
      String _join = IterableExtensions.join(IterableExtensions.<Attribute, String>map(IterableExtensions.<Attribute>filter(event.getAttributes(), _function), _function_1), ", ");
      _builder.append(_join, " \t");
      _builder.append(" ) {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("super(performer)");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._name = _name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._type = \"");
      String _name_3 = event.getName();
      _builder.append(_name_3, "    ");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      {
        String _name_4 = event.getOntologyType().getName();
        boolean _equals = Objects.equals(_name_4, "DataTransfer");
        if (_equals) {
          _builder.append("    ");
          _builder.append("this.sensorId=_name+\"_sensor_\"+_name + \"Rule\" ");
          _builder.newLine();
        }
      }
      {
        EList<Attribute> _attributes = event.getAttributes();
        for(final Attribute attribute : _attributes) {
          {
            if (((!Objects.equals(attribute.getName(), "performer")) && (!Objects.equals(attribute.getName(), "controller")))) {
              _builder.append("    ");
              _builder.append("this.");
              String _name_5 = attribute.getName();
              _builder.append(_name_5, "    ");
              _builder.append(" = new Attribute(\"");
              String _name_6 = attribute.getName();
              _builder.append(_name_6, "    ");
              _builder.append("\",");
              String _name_7 = attribute.getName();
              _builder.append(_name_7, "    ");
              _builder.append(",_name)");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("module.exports.");
      String _name_8 = event.getName();
      _builder.append(_name_8);
      _builder.append(" = ");
      String _name_9 = event.getName();
      _builder.append(_name_9);
      _builder.newLineIfNotEmpty();
      final String code = _builder.toString();
      String _contractName = model.getContractName();
      String _plus = ("./" + _contractName);
      String _plus_1 = (_plus + "/domain/events/");
      String _xifexpression = null;
      String _name_10 = event.getOntologyType().getName();
      boolean _equals_1 = Objects.equals(_name_10, "DataTransfer");
      if (_equals_1) {
        _xifexpression = "datatransfer/";
      } else {
        _xifexpression = "";
      }
      String _plus_2 = (_plus_1 + _xifexpression);
      String _name_11 = event.getName();
      String _plus_3 = (_plus_2 + _name_11);
      String _plus_4 = (_plus_3 + ".js");
      fsa.generateFile(_plus_4, code);
    } else {
      RegularType _regularType = event.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = event.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(event);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(event.getAttributes());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("const { ");
        String _name_12 = parentType.getName();
        _builder_1.append(_name_12);
        _builder_1.append(" } = require(\"./");
        String _name_13 = parentType.getName();
        _builder_1.append(_name_13);
        _builder_1.append(".js\");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("const { Attribute } = require(");
        _builder_1.append(this.ATTRIBUTE_CLASS_IMPORT_PATH);
        _builder_1.append(");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("class ");
        String _name_14 = event.getName();
        _builder_1.append(_name_14);
        _builder_1.append(" extends ");
        String _name_15 = parentType.getName();
        _builder_1.append(_name_15);
        _builder_1.append(" {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("  ");
        _builder_1.append("constructor(_name,");
        final Function1<Attribute, String> _function_2 = (Attribute a) -> {
          return a.getName();
        };
        String _join_1 = IterableExtensions.join(ListExtensions.<Attribute, String>map(allAttributes, _function_2), ", ");
        _builder_1.append(_join_1, "  ");
        _builder_1.append(") {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("super(_name,");
        final Function1<Attribute, String> _function_3 = (Attribute a) -> {
          return a.getName();
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<Attribute, String>map(parentAttributes, _function_3), ", ");
        _builder_1.append(_join_2, "    ");
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("this._type = \"");
        String _name_16 = event.getName();
        _builder_1.append(_name_16, "    ");
        _builder_1.append("\"");
        _builder_1.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_1 = event.getAttributes();
          for(final Attribute attribute_1 : _attributes_1) {
            {
              if (((!Objects.equals(attribute_1.getName(), "performer")) && (!Objects.equals(attribute_1.getName(), "controller")))) {
                _builder_1.append("    ");
                _builder_1.append("this.");
                String _name_17 = attribute_1.getName();
                _builder_1.append(_name_17, "    ");
                _builder_1.append(" = new Attribute(\"");
                String _name_18 = attribute_1.getName();
                _builder_1.append(_name_18, "    ");
                _builder_1.append("\",");
                String _name_19 = attribute_1.getName();
                _builder_1.append(_name_19, "    ");
                _builder_1.append(",_name)");
                _builder_1.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("module.exports.");
        String _name_20 = event.getName();
        _builder_1.append(_name_20);
        _builder_1.append(" = ");
        String _name_21 = event.getName();
        _builder_1.append(_name_21);
        _builder_1.newLineIfNotEmpty();
        final String code_1 = _builder_1.toString();
        String _contractName_1 = model.getContractName();
        String _plus_5 = ("./" + _contractName_1);
        String _plus_6 = (_plus_5 + "/domain/events/");
        String _name_22 = event.getName();
        String _plus_7 = (_plus_6 + _name_22);
        String _plus_8 = (_plus_7 + ".js");
        fsa.generateFile(_plus_8, code_1);
      }
    }
  }

  public void generateRole(final IFileSystemAccess2 fsa, final Model model, final RegularType role) {
    OntologyType _ontologyType = role.getOntologyType();
    final boolean isBase = (_ontologyType != null);
    if ((Boolean.valueOf(isBase) == Boolean.valueOf(true))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("const { Role } = require(");
      _builder.append(this.ROLE_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("const { Attribute } = require(");
      _builder.append(this.ATTRIBUTE_CLASS_IMPORT_PATH);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("class ");
      String _name = role.getName();
      _builder.append(_name);
      _builder.append(" extends Role {");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("constructor(_name,");
      final Function1<Attribute, String> _function = (Attribute a) -> {
        return a.getName();
      };
      String _join = IterableExtensions.join(ListExtensions.<Attribute, String>map(role.getAttributes(), _function), ", ");
      _builder.append(_join, "  ");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("super()");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._name = _name");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("this._type = \"");
      String _name_1 = role.getName();
      _builder.append(_name_1, "    ");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      {
        EList<Attribute> _attributes = role.getAttributes();
        for(final Attribute attribute : _attributes) {
          {
            String _name_2 = attribute.getName();
            boolean _notEquals = (!Objects.equals(_name_2, "controller"));
            if (_notEquals) {
              _builder.append("    ");
              _builder.append("this.");
              String _name_3 = attribute.getName();
              _builder.append(_name_3, "    ");
              _builder.append(" = new Attribute(\"");
              String _name_4 = attribute.getName();
              _builder.append(_name_4, "    ");
              _builder.append("\",");
              String _name_5 = attribute.getName();
              _builder.append(_name_5, "    ");
              _builder.append(",_name)");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("module.exports.");
      String _name_6 = role.getName();
      _builder.append(_name_6);
      _builder.append(" = ");
      String _name_7 = role.getName();
      _builder.append(_name_7);
      _builder.newLineIfNotEmpty();
      final String code = _builder.toString();
      String _contractName = model.getContractName();
      String _plus = ("./" + _contractName);
      String _plus_1 = (_plus + "/domain/roles/");
      String _name_8 = role.getName();
      String _plus_2 = (_plus_1 + _name_8);
      String _plus_3 = (_plus_2 + ".js");
      fsa.generateFile(_plus_3, code);
    } else {
      RegularType _regularType = role.getRegularType();
      boolean _tripleNotEquals = (_regularType != null);
      if (_tripleNotEquals) {
        final RegularType parentType = role.getRegularType();
        final List<Attribute> allAttributes = Helpers.getAttributesOfRegularType(role);
        final ArrayList<Attribute> parentAttributes = new ArrayList<Attribute>(allAttributes);
        parentAttributes.removeAll(role.getAttributes());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("const { ");
        String _name_9 = parentType.getName();
        _builder_1.append(_name_9);
        _builder_1.append(" } = require(\"./");
        String _name_10 = parentType.getName();
        _builder_1.append(_name_10);
        _builder_1.append(".js\");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("const { Attribute } = require(");
        _builder_1.append(this.ATTRIBUTE_CLASS_IMPORT_PATH);
        _builder_1.append(");");
        _builder_1.newLineIfNotEmpty();
        _builder_1.newLine();
        _builder_1.append("class ");
        String _name_11 = role.getName();
        _builder_1.append(_name_11);
        _builder_1.append(" extends ");
        String _name_12 = parentType.getName();
        _builder_1.append(_name_12);
        _builder_1.append(" {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("  ");
        _builder_1.append("constructor(_name,");
        final Function1<Attribute, String> _function_1 = (Attribute a) -> {
          return a.getName();
        };
        String _join_1 = IterableExtensions.join(ListExtensions.<Attribute, String>map(allAttributes, _function_1), ", ");
        _builder_1.append(_join_1, "  ");
        _builder_1.append(") {");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("super(_name,");
        final Function1<Attribute, String> _function_2 = (Attribute a) -> {
          return a.getName();
        };
        String _join_2 = IterableExtensions.join(ListExtensions.<Attribute, String>map(parentAttributes, _function_2), ", ");
        _builder_1.append(_join_2, "    ");
        _builder_1.append(")");
        _builder_1.newLineIfNotEmpty();
        _builder_1.append("    ");
        _builder_1.append("this._type = \"");
        String _name_13 = role.getName();
        _builder_1.append(_name_13, "    ");
        _builder_1.append("\"");
        _builder_1.newLineIfNotEmpty();
        {
          EList<Attribute> _attributes_1 = role.getAttributes();
          for(final Attribute attribute_1 : _attributes_1) {
            {
              String _name_14 = attribute_1.getName();
              boolean _notEquals_1 = (!Objects.equals(_name_14, "controller"));
              if (_notEquals_1) {
                _builder_1.append("    ");
                _builder_1.append("this.");
                String _name_15 = attribute_1.getName();
                _builder_1.append(_name_15, "    ");
                _builder_1.append(" = new Attribute(\"");
                String _name_16 = attribute_1.getName();
                _builder_1.append(_name_16, "    ");
                _builder_1.append("\",");
                String _name_17 = attribute_1.getName();
                _builder_1.append(_name_17, "    ");
                _builder_1.append(",_name)");
                _builder_1.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("module.exports.");
        String _name_18 = role.getName();
        _builder_1.append(_name_18);
        _builder_1.append(" = ");
        String _name_19 = role.getName();
        _builder_1.append(_name_19);
        _builder_1.newLineIfNotEmpty();
        final String code_1 = _builder_1.toString();
        String _contractName_1 = model.getContractName();
        String _plus_4 = ("./" + _contractName_1);
        String _plus_5 = (_plus_4 + "/domain/roles/");
        String _name_20 = role.getName();
        String _plus_6 = (_plus_5 + _name_20);
        String _plus_7 = (_plus_6 + ".js");
        fsa.generateFile(_plus_7, code_1);
      }
    }
  }

  public void generateEnumeration(final IFileSystemAccess2 fsa, final Model model, final Enumeration enumeration) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module.exports.");
    String _name = enumeration.getName();
    _builder.append(_name);
    _builder.append(" = {");
    _builder.newLineIfNotEmpty();
    {
      EList<EnumItem> _enumerationItems = enumeration.getEnumerationItems();
      for(final EnumItem item : _enumerationItems) {
        _builder.append("  ");
        String _name_1 = item.getName();
        _builder.append(_name_1, "  ");
        _builder.append(": ");
        int _indexOf = enumeration.getEnumerationItems().indexOf(item);
        _builder.append(_indexOf, "  ");
        _builder.append(",");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName = model.getContractName();
    String _plus = ("./" + _contractName);
    String _plus_1 = (_plus + "/domain/types/");
    String _name_2 = enumeration.getName();
    String _plus_2 = (_plus_1 + _name_2);
    String _plus_3 = (_plus_2 + ".js");
    fsa.generateFile(_plus_3, code);
  }

  public boolean findRole(final String e) {
    for (final RegularType role : this.roles) {
      boolean _equals = role.getName().equals(e);
      if (_equals) {
        return true;
      }
    }
    return false;
  }

  public String getDefaultController(final Model model, final Variable variable) {
    RegularType base = Helpers.getBaseType(variable.getType());
    if ((base != null)) {
      EList<Assignment> _attributes = variable.getAttributes();
      for (final Assignment assignment : _attributes) {
        if ((assignment instanceof AssignExpression)) {
          String _name = base.getOntologyType().getName();
          if (_name != null) {
            switch (_name) {
              case "Asset":
                String _name_1 = ((AssignExpression)assignment).getName();
                boolean _equals = Objects.equals(_name_1, "owner");
                if (_equals) {
                  return this.generateExpressionString(((AssignExpression)assignment).getValue(), "this");
                }
                break;
              case "Event":
                String _name_2 = ((AssignExpression)assignment).getName();
                boolean _equals_1 = Objects.equals(_name_2, "performer");
                if (_equals_1) {
                  return this.generateExpressionString(((AssignExpression)assignment).getValue(), "this");
                }
                break;
              case "DataTransfer":
                String _name_3 = ((AssignExpression)assignment).getName();
                boolean _equals_2 = Objects.equals(_name_3, "performer");
                if (_equals_2) {
                  return this.generateExpressionString(((AssignExpression)assignment).getValue(), "this");
                }
                break;
            }
          }
        }
      }
      String _name_4 = base.getOntologyType().getName();
      if (_name_4 != null) {
        switch (_name_4) {
          case "Role":
            String _name_5 = variable.getName();
            return ("this." + _name_5);
        }
      }
    }
    return null;
  }

  public String getDefaultControllerACPolicy(final Model model) {
    if ((model.getAcpolicys() == null)) {
      return "[]";
    }
    String acC = "[";
    int cnt = 0;
    EList<Controller> _controller = model.getAcpolicys().getController();
    for (final Controller controller : _controller) {
      {
        Ref contr = controller.getControllerType();
        if ((cnt > 0)) {
          acC = (acC + ",");
        }
        String _variable = ((VariableRef) contr).getVariable();
        String _plus = ((acC + "this.") + _variable);
        acC = _plus;
        cnt++;
      }
    }
    acC = (acC + "]");
    return acC;
  }

  public String getSpecifiedControllerObligation(final Obligation obl, final String pre) {
    Ref contr = obl.getController();
    if ((contr != null)) {
      String _name = obl.getName();
      String _plus = ((pre + ".obligations.") + _name);
      String _plus_1 = (_plus + ".addController(this.");
      String _variable = ((VariableRef) contr).getVariable();
      String _plus_2 = (_plus_1 + _variable);
      return (_plus_2 + ")");
    } else {
      return "";
    }
  }

  public String getSpecifiedControllerPower(final Power power, final String pre) {
    Ref contr = power.getController();
    if ((contr != null)) {
      String _name = power.getName();
      String _plus = ((pre + ".powers.") + _name);
      String _plus_1 = (_plus + ".addController(this.");
      String _variable = ((VariableRef) contr).getVariable();
      String _plus_2 = (_plus_1 + _variable);
      return (_plus_2 + ")");
    } else {
      return "";
    }
  }

  public String getSpecifiedRulesUnCond(final Rule rule) {
    String addRule = "";
    Permission contr = rule.getPermission();
    Ref rl = rule.getAccessedRole();
    Ref r2 = rule.getController();
    String rName = "";
    ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource = rule.getAccessedResource();
    if ((_accessedResource instanceof ResourcePower)) {
      ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_1 = rule.getAccessedResource();
      final ResourcePower p = ((ResourcePower) _accessedResource_1);
      Power _resourcePo = p.getResourcePo();
      final Power power = ((Power) _resourcePo);
      String _name = power.getName();
      String _plus = ("this.powers." + _name);
      rName = _plus;
      Proposition _trigger = power.getTrigger();
      boolean _tripleEquals = (_trigger == null);
      if (_tripleEquals) {
        String _lowerCase = rule.getAction().toLowerCase();
        String _plus_1 = ((addRule + "this.accessPolicy.addRulee(\"") + _lowerCase);
        String _plus_2 = (_plus_1 + "\", \"");
        String _lowerCase_1 = contr.getName().toLowerCase();
        String _plus_3 = (_plus_2 + _lowerCase_1);
        String _plus_4 = (_plus_3 + "\", ");
        String _plus_5 = (_plus_4 + rName);
        String _plus_6 = (_plus_5 + ", this.");
        String _variable = ((VariableRef) rl).getVariable();
        String _plus_7 = (_plus_6 + _variable);
        String _plus_8 = (_plus_7 + ", this.");
        String _variable_1 = ((VariableRef) r2).getVariable();
        String _plus_9 = (_plus_8 + _variable_1);
        String _plus_10 = (_plus_9 + ")\n");
        addRule = _plus_10;
      }
    }
    ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_2 = rule.getAccessedResource();
    if ((_accessedResource_2 instanceof ResourceObligation)) {
      ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_3 = rule.getAccessedResource();
      final ResourceObligation obr = ((ResourceObligation) _accessedResource_3);
      Obligation _resourceOp = obr.getResourceOp();
      final Obligation obl = ((Obligation) _resourceOp);
      String _name_1 = obl.getName();
      String _plus_11 = ("this.obligations." + _name_1);
      rName = _plus_11;
      Proposition _trigger_1 = obl.getTrigger();
      boolean _tripleEquals_1 = (_trigger_1 == null);
      if (_tripleEquals_1) {
        String _lowerCase_2 = rule.getAction().toLowerCase();
        String _plus_12 = ((addRule + "this.accessPolicy.addRulee(\"") + _lowerCase_2);
        String _plus_13 = (_plus_12 + "\", \"");
        String _lowerCase_3 = contr.getName().toLowerCase();
        String _plus_14 = (_plus_13 + _lowerCase_3);
        String _plus_15 = (_plus_14 + "\", ");
        String _plus_16 = (_plus_15 + rName);
        String _plus_17 = (_plus_16 + ", this.");
        String _variable_2 = ((VariableRef) rl).getVariable();
        String _plus_18 = (_plus_17 + _variable_2);
        String _plus_19 = (_plus_18 + ", this.");
        String _variable_3 = ((VariableRef) r2).getVariable();
        String _plus_20 = (_plus_19 + _variable_3);
        String _plus_21 = (_plus_20 + ")\n");
        addRule = _plus_21;
      }
    }
    ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_4 = rule.getAccessedResource();
    if ((_accessedResource_4 instanceof ResourceACPolicy)) {
      rName = "accessPolicy";
      String _lowerCase_4 = rule.getAction().toLowerCase();
      String _plus_22 = ((addRule + "this.accessPolicy.addRulee(\"") + _lowerCase_4);
      String _plus_23 = (_plus_22 + "\", \"");
      String _lowerCase_5 = contr.getName().toLowerCase();
      String _plus_24 = (_plus_23 + _lowerCase_5);
      String _plus_25 = (_plus_24 + "\", this.");
      String _plus_26 = (_plus_25 + rName);
      String _plus_27 = (_plus_26 + ", this.");
      String _variable_4 = ((VariableRef) rl).getVariable();
      String _plus_28 = (_plus_27 + _variable_4);
      String _plus_29 = (_plus_28 + ", this.");
      String _variable_5 = ((VariableRef) r2).getVariable();
      String _plus_30 = (_plus_29 + _variable_5);
      String _plus_31 = (_plus_30 + ")\n");
      addRule = _plus_31;
    }
    ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_5 = rule.getAccessedResource();
    if ((_accessedResource_5 instanceof ResourceDot)) {
      ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_6 = rule.getAccessedResource();
      final ResourceDot resourceDot = ((ResourceDot) _accessedResource_6);
      final Ref r = resourceDot.getResourceDot();
      rName = SymboleoGenerator.generateDotExpressionString(r, "P");
      String _lowerCase_6 = rule.getAction().toLowerCase();
      String _plus_32 = ((addRule + "this.accessPolicy.addRulee(\"") + _lowerCase_6);
      String _plus_33 = (_plus_32 + "\", \"");
      String _lowerCase_7 = contr.getName().toLowerCase();
      String _plus_34 = (_plus_33 + _lowerCase_7);
      String _plus_35 = (_plus_34 + "\", ");
      String _plus_36 = (_plus_35 + rName);
      String _plus_37 = (_plus_36 + ", this.");
      String _variable_6 = ((VariableRef) rl).getVariable();
      String _plus_38 = (_plus_37 + _variable_6);
      String _plus_39 = (_plus_38 + ", this.");
      String _variable_7 = ((VariableRef) r2).getVariable();
      String _plus_40 = (_plus_39 + _variable_7);
      String _plus_41 = (_plus_40 + ")\n");
      addRule = _plus_41;
    }
    ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_7 = rule.getAccessedResource();
    if ((_accessedResource_7 instanceof ResourceOntologyType)) {
      ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_8 = rule.getAccessedResource();
      final ResourceOntologyType resourceOntologyType = ((ResourceOntologyType) _accessedResource_8);
      rName = resourceOntologyType.getResourceOn().getName();
      String _lowerCase_8 = rule.getAction().toLowerCase();
      String _plus_42 = ((addRule + "this.accessPolicy.addRulee(\"") + _lowerCase_8);
      String _plus_43 = (_plus_42 + "\", \"");
      String _lowerCase_9 = contr.getName().toLowerCase();
      String _plus_44 = (_plus_43 + _lowerCase_9);
      String _plus_45 = (_plus_44 + "\", this.");
      String _plus_46 = (_plus_45 + rName);
      String _plus_47 = (_plus_46 + ", this.");
      String _variable_8 = ((VariableRef) rl).getVariable();
      String _plus_48 = (_plus_47 + _variable_8);
      String _plus_49 = (_plus_48 + ", this.");
      String _variable_9 = ((VariableRef) r2).getVariable();
      String _plus_50 = (_plus_49 + _variable_9);
      String _plus_51 = (_plus_50 + ")\n");
      addRule = _plus_51;
    }
    return addRule;
  }

  public String getSpecifiedRulesCondPower(final Power powerC, final Model model) {
    String addRule = "";
    EList<Rule> _rules = model.getRules();
    for (final Rule rule : _rules) {
      {
        Permission contr = rule.getPermission();
        Ref rl = rule.getAccessedRole();
        Ref r2 = rule.getController();
        String rName = "";
        ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource = rule.getAccessedResource();
        if ((_accessedResource instanceof ResourcePower)) {
          ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_1 = rule.getAccessedResource();
          final ResourcePower p = ((ResourcePower) _accessedResource_1);
          Power _resourcePo = p.getResourcePo();
          final Power power = ((Power) _resourcePo);
          String _name = power.getName();
          String _plus = ("powers." + _name);
          rName = _plus;
          if (((power.getTrigger() != null) && Objects.equals(powerC.getName(), power.getName()))) {
            String _lowerCase = rule.getAction().toLowerCase();
            String _plus_1 = ((addRule + "contract.accessPolicy.addRulee(\"") + _lowerCase);
            String _plus_2 = (_plus_1 + "\", \"");
            String _lowerCase_1 = contr.getName().toLowerCase();
            String _plus_3 = (_plus_2 + _lowerCase_1);
            String _plus_4 = (_plus_3 + "\", contract.");
            String _plus_5 = (_plus_4 + rName);
            String _plus_6 = (_plus_5 + ", contract.");
            String _variable = ((VariableRef) rl).getVariable();
            String _plus_7 = (_plus_6 + _variable);
            String _plus_8 = (_plus_7 + ", contract.");
            String _variable_1 = ((VariableRef) r2).getVariable();
            String _plus_9 = (_plus_8 + _variable_1);
            String _plus_10 = (_plus_9 + ")\n");
            addRule = _plus_10;
          }
        }
      }
    }
    return addRule;
  }

  public String getSpecifiedRulesCondObligation(final Obligation oblC, final Model model) {
    String addRule = "";
    EList<Rule> _rules = model.getRules();
    for (final Rule rule : _rules) {
      {
        Permission contr = rule.getPermission();
        Ref rl = rule.getAccessedRole();
        Ref r2 = rule.getController();
        String rName = "";
        ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource = rule.getAccessedResource();
        if ((_accessedResource instanceof ResourceObligation)) {
          ca.uottawa.csmlab.symboleo.symboleo.Resource _accessedResource_1 = rule.getAccessedResource();
          final ResourceObligation obr = ((ResourceObligation) _accessedResource_1);
          Obligation _resourceOp = obr.getResourceOp();
          final Obligation obl = ((Obligation) _resourceOp);
          String _name = obl.getName();
          String _plus = ("obligations." + _name);
          rName = _plus;
          if (((obl.getTrigger() != null) && (oblC.getName() == obl.getName()))) {
            String _lowerCase = rule.getAction().toLowerCase();
            String _plus_1 = ((addRule + "contract.accessPolicy.addRulee(\"") + _lowerCase);
            String _plus_2 = (_plus_1 + "\", \"");
            String _lowerCase_1 = contr.getName().toLowerCase();
            String _plus_3 = (_plus_2 + _lowerCase_1);
            String _plus_4 = (_plus_3 + "\", contract.");
            String _plus_5 = (_plus_4 + rName);
            String _plus_6 = (_plus_5 + ", contract.");
            String _variable = ((VariableRef) rl).getVariable();
            String _plus_7 = (_plus_6 + _variable);
            String _plus_8 = (_plus_7 + ", contract.");
            String _variable_1 = ((VariableRef) r2).getVariable();
            String _plus_9 = (_plus_8 + _variable_1);
            String _plus_10 = (_plus_9 + ")\n");
            addRule = _plus_10;
          }
        }
      }
    }
    return addRule;
  }

  public String compileInitMethod(final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("async init(ctx, args) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("let roleObj;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("const inputs = JSON.parse(args);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contractInstance = new ");
    String _contractName = model.getContractName();
    _builder.append(_contractName, "  ");
    _builder.append(" (");
    final Function1<Parameter, String> _function = (Parameter p) -> {
      String _name = p.getName();
      return ("inputs." + _name);
    };
    String _join = IterableExtensions.join(ListExtensions.<Parameter, String>map(model.getParameters(), _function), ", ");
    _builder.append(_join, "  ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("this.initialize(contractInstance)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contractInstance.activated()) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// call trigger transitions for legal positions");
    _builder.newLine();
    {
      for(final Obligation obligation : this.triggeredObligations) {
        {
          Proposition _antecedent = obligation.getAntecedent();
          if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
            _builder.append("    ");
            _builder.append("contractInstance.obligations.");
            String _name = obligation.getName();
            _builder.append(_name, "    ");
            _builder.append(".trigerredUnconditional()");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("    ");
            _builder.append("contractInstance.obligations.");
            String _name_1 = obligation.getName();
            _builder.append(_name_1, "    ");
            _builder.append(".trigerredConditional()");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      for(final Obligation obligation_1 : this.triggeredSurvivingObligations) {
        {
          Proposition _antecedent_1 = obligation_1.getAntecedent();
          if ((_antecedent_1 instanceof PAtomPredicateTrueLiteral)) {
            _builder.append("    ");
            _builder.append("contractInstance.survivingObligations.");
            String _name_2 = obligation_1.getName();
            _builder.append(_name_2, "    ");
            _builder.append(".trigerredUnconditional()");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("    ");
            _builder.append("contractInstance.survivingObligations.");
            String _name_3 = obligation_1.getName();
            _builder.append(_name_3, "    ");
            _builder.append(".trigerredConditional()");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      for(final Power power : this.triggeredPowers) {
        {
          Proposition _antecedent_2 = power.getAntecedent();
          if ((_antecedent_2 instanceof PAtomPredicateTrueLiteral)) {
            _builder.append("    ");
            _builder.append("contractInstance.powers.");
            String _name_4 = power.getName();
            _builder.append(_name_4, "    ");
            _builder.append(".trigerredUnconditional()");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("    ");
            _builder.append("contractInstance.powers.");
            String _name_5 = power.getName();
            _builder.append(_name_5, "    ");
            _builder.append(".trigerredConditional()");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("// First security layer");
    _builder.newLine();
    _builder.append("          \t");
    _builder.append("try{           \t");
    _builder.newLine();
    _builder.append("          \t       ");
    _builder.append("roleObj = contractInstance.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("          \t       ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contractInstance)");
    _builder.newLine();
    _builder.append("          \t");
    _builder.newLine();
    _builder.append("          \t             ");
    _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) not exist in our conttract");
    _builder.newLine();
    _builder.append("          \t              ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("          \t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("          \t");
    _builder.newLine();
    _builder.append("          \t    ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("          \t        ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("          \t        ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("          \t    ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("await ctx.stub.putState(contractInstance.id, Buffer.from(serialize(contractInstance)))");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: true, contractId: contractInstance.id}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String code = _builder.toString();
    return code;
  }

  public List<String> compileEventTriggerMethods(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    for (final Variable variable : this.eventVariables) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("async trigger_");
      String _name = variable.getName();
      _builder.append(_name);
      _builder.append("(ctx, args) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("const cid = new ClientIdentity(ctx.stub);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("let roleObj;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("const inputs = JSON.parse(args);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("const contractId = inputs.contractId;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("const event = inputs.event;");
      _builder.newLine();
      _builder.append("  \t");
      _builder.append("const contractState = await ctx.stub.getState(contractId)");
      _builder.newLine();
      _builder.append("  \t");
      _builder.append("if (contractState == null) {");
      _builder.newLine();
      _builder.append("\t   \t\t ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contract = deserialize(contractState.toString())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("//notification");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const oldMessagesList = []");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("oldMessagesList.push(contract.notified.message.slice())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("this.initialize(contract)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contract.isInEffect() ");
      String _survivEvent = this.survivEvent(variable.getName());
      _builder.append(_survivEvent, "  ");
      _builder.append(" ){");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t");
      _builder.append("// First security layer");
      _builder.newLine();
      _builder.append("  \t");
      _builder.append("try{           \t");
      _builder.newLine();
      _builder.append("  \t       ");
      _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
      _builder.newLine();
      _builder.append("  \t       ");
      _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
      _builder.newLine();
      _builder.append("  \t");
      _builder.newLine();
      _builder.append("  \t             ");
      _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
      _builder.newLine();
      _builder.append("  \t              ");
      _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
      _builder.newLine();
      _builder.append("  \t         ");
      _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.append("// wrong certificate");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  \t");
      _builder.newLine();
      _builder.append("  \t    ");
      _builder.append("}catch(err){");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.append("console.log(\'access control error: \', err)");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.append("return { successful: false, message: err.message }");
      _builder.newLine();
      _builder.append("  \t    ");
      _builder.append("}// end of first layer");
      _builder.newLine();
      _builder.append("  \t    ");
      _builder.append("//seond layer");
      _builder.newLine();
      _builder.append("  \t    ");
      _builder.append("let controllers = contract.");
      String _name_1 = variable.getName();
      _builder.append(_name_1, "  \t    ");
      _builder.append("._controller");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t");
      _builder.append("if(!contract.accessPolicy.hasPermesstion(\'grant\',\'read\', contract.");
      String _name_2 = variable.getName();
      _builder.append(_name_2, "  \t");
      _builder.append(",roleObj, contract.");
      String _name_3 = variable.getName();
      _builder.append(_name_3, "  \t");
      _builder.append(".getController(controllers.length - 1)) || ");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t      ");
      _builder.append("!contract.accessPolicy.isValid(new Rule(\'grant\',\'read\', contract.");
      String _name_4 = variable.getName();
      _builder.append(_name_4, "  \t      ");
      _builder.append(", roleObj, contract.");
      String _name_5 = variable.getName();
      _builder.append(_name_5, "  \t      ");
      _builder.append(".getController(controllers.length - 1))) ){");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t        ");
      _builder.append("throw new Error(`access denied...`)");
      _builder.newLine();
      _builder.append("  \t      ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("contract.");
      String _name_6 = variable.getName();
      _builder.append(_name_6, "    ");
      _builder.append(".happen(event)");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("Events.emitEvent(contract, new InternalEvent(InternalEventSource.contractEvent, InternalEventType.contractEvent.Happened, contract.");
      String _name_7 = variable.getName();
      _builder.append(_name_7, "    ");
      _builder.append("))");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      RegularType base = Helpers.getBaseType(variable.getType());
      _builder.newLineIfNotEmpty();
      {
        boolean _notEquals = (!Objects.equals(base, null));
        if (_notEquals) {
          {
            String _name_8 = base.getOntologyType().getName();
            boolean _equals = Objects.equals(_name_8, "DataTransfer");
            if (_equals) {
              _builder.append("//Send notification about datatransfer (i.e., temperature) alert");
              _builder.newLine();
              _builder.append("let MSG= \"sensorId: \" + event.sensorId + \", value: \" + event.value + \", sensorTimestamp: \" + event.sensorTimestamp + \", \" + contractId;");
              _builder.newLine();
              _builder.append("contract.notified.message.push({name: \'");
              String _name_9 = variable.getName();
              _builder.append(_name_9);
              _builder.append("Alert\', message: MSG, roles:contract.accessPolicy.permissionValid(contract.");
              String _name_10 = variable.getName();
              _builder.append(_name_10);
              _builder.append(",");
              _builder.newLineIfNotEmpty();
              _builder.append("contract._roles,contract.");
              String _name_11 = variable.getName();
              _builder.append(_name_11);
              _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("     ");
      _builder.append("//notification");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("for (const message of contract.notified.message) {");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("if (!oldMessagesList[0].includes(message)) {");
      _builder.newLine();
      _builder.append("             ");
      _builder.append("this.trigger_notification(ctx, message)");
      _builder.newLine();
      _builder.append("           ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("       ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("   ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: true}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      methods.add(_builder.toString());
    }
    return methods;
  }

  public String compilePowerCondition(final PowerFunction powerFunction) {
    String con = "";
    boolean _matched = false;
    if (powerFunction instanceof PFObligationSuspended) {
      _matched=true;
      String _name = ((PFObligationSuspended)powerFunction).getNorm().getName();
      String _plus = ("resourceType: \'obligation\', resource: \'" + _name);
      String _plus_1 = (_plus + "\', state:\'suspension\'");
      con = _plus_1;
    }
    if (!_matched) {
      if (powerFunction instanceof PFObligationResumed) {
        _matched=true;
        String _name = ((PFObligationResumed)powerFunction).getNorm().getName();
        String _plus = ("resourceType: \'obligation\', resource: \'" + _name);
        String _plus_1 = (_plus + "\', state:\'suspension\'");
        con = _plus_1;
      }
    }
    if (!_matched) {
      if (powerFunction instanceof PFObligationDischarged) {
        _matched=true;
        String _name = ((PFObligationDischarged)powerFunction).getNorm().getName();
        String _plus = ("resourceType: \'obligation\', resource: \'" + _name);
        String _plus_1 = (_plus + "\', state:\'discharge\'");
        con = _plus_1;
      }
    }
    if (!_matched) {
      if (powerFunction instanceof PFObligationTerminated) {
        _matched=true;
        String _name = ((PFObligationTerminated)powerFunction).getNorm().getName();
        String _plus = ("resourceType: \'obligation\', resource: \'" + _name);
        String _plus_1 = (_plus + "\', state:\'unsuccessfultermination\'");
        con = _plus_1;
      }
    }
    if (!_matched) {
      if (powerFunction instanceof PFObligationTriggered) {
        _matched=true;
        String _name = ((PFObligationTriggered)powerFunction).getNorm().getName();
        String _plus = ("resourceType: \'obligation\', resource: \'" + _name);
        String _plus_1 = (_plus + "\', state:\'create\'");
        con = _plus_1;
      }
    }
    if (!_matched) {
      if (powerFunction instanceof PFContractSuspended) {
        _matched=true;
        con = "resourceType: \'contract\', resource: \'contract\', state:\'suspension\'";
      }
    }
    if (!_matched) {
      if (powerFunction instanceof PFContractResumed) {
        _matched=true;
        con = "resourceType: \'contract\', resource: \'contract\', state:\'suspension\'";
      }
    }
    if (!_matched) {
      if (powerFunction instanceof PFContractTerminated) {
        _matched=true;
        con = "resourceType: \'contract\', resource: \'contract\', state:\'unsuccessfultermination\'";
      }
    }
    return con;
  }

  /**
   * Phase 3 (O4b) transfer transactions -- see the xtend source for
   * rationale. Emits one transferResource_<var> Fabric transaction per
   * top-level resource carrying an explicit `Grant transfer` rule.
   */
  public List<String> compileTransferTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    final java.util.HashSet<String> seen = new java.util.HashSet<String>();
    for (final Rule rule : model.getRules()) {
      // The grammar puts the DECISION into rule.action (grant/revoke) and
      // the ACTION into rule.permission ({read,write,all,transfer}); we
      // match the ontology's Action here, not its Decision.
      Permission _perm = rule.getPermission();
      String _permName = _perm == null ? null : _perm.getName();
      if (_permName != null && "transfer".equalsIgnoreCase(_permName)
          && rule.getAccessedResource() instanceof ResourceDot) {
        final ResourceDot resourceDot = (ResourceDot) rule.getAccessedResource();
        String baseName = this.generateDotExpressionString(resourceDot.getResourceDot(), "");
        String trimmed = baseName.contains(".") ? baseName.substring(0, baseName.indexOf(".")) : baseName;
        if (seen.add(trimmed)) {
          methods.add(this.generateTransferTransaction(trimmed));
        }
      }
    }
    return methods;
  }

  public String generateTransferTransaction(final String resourceVar) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("async transferResource_");
    _builder.append(resourceVar);
    _builder.append("(ctx, contractId, newOwnerName, newOwnerOrg, newOwnerDept) {");
    _builder.newLineIfNotEmpty();
    _builder.append("  const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("  let actorRole;");
    _builder.newLine();
    _builder.append("  const contractState = await ctx.stub.getState(contractId);");
    _builder.newLine();
    _builder.append("  if (contractState == null) { return { successful: false } }");
    _builder.newLine();
    _builder.append("  const contract = deserialize(contractState.toString());");
    _builder.newLine();
    _builder.append("  this.initialize(contract);");
    _builder.newLine();
    _builder.append("  if (!contract.isInEffect() && !contract.isSuccessfulTermination()) {");
    _builder.newLine();
    _builder.append("    return { successful: false, message: \'Contract not in effect\' }");
    _builder.newLine();
    _builder.append("  }");
    _builder.newLine();
    _builder.append("  if (contract.");
    _builder.append(resourceVar);
    _builder.append(" == null) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    return { successful: false, message: \'Resource ");
    _builder.append(resourceVar);
    _builder.append(" not found\' }");
    _builder.newLineIfNotEmpty();
    _builder.append("  }");
    _builder.newLine();
    _builder.append("  try {");
    _builder.newLine();
    _builder.append("    actorRole = contract.authenticate(");
    _builder.newLine();
    _builder.append("      cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'),");
    _builder.newLine();
    _builder.append("      cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'), contract);");
    _builder.newLine();
    _builder.append("    if (actorRole === null) { throw new Error(\'Unauthorized: Unknown access\'); }");
    _builder.newLine();
    _builder.append("  } catch (err) {");
    _builder.newLine();
    _builder.append("    console.log(\'access control error: \', err);");
    _builder.newLine();
    _builder.append("    return { successful: false, message: err.message };");
    _builder.newLine();
    _builder.append("  }");
    _builder.newLine();
    _builder.append("  const newOwnerRole = (contract._roles || []).find(r =>");
    _builder.newLine();
    _builder.append("    r.name && r.name._value === newOwnerName");
    _builder.newLine();
    _builder.append("    && r.org && r.org._value === newOwnerOrg");
    _builder.newLine();
    _builder.append("    && r.dept && r.dept._value === newOwnerDept);");
    _builder.newLine();
    _builder.append("  if (newOwnerRole == null) {");
    _builder.newLine();
    _builder.append("    return { successful: false, message: \'Unknown new-owner role\' };");
    _builder.newLine();
    _builder.append("  }");
    _builder.newLine();
    _builder.append("  if (!contract.accessPolicy.transferResource(contract.");
    _builder.append(resourceVar);
    _builder.append(", actorRole, newOwnerRole)) {");
    _builder.newLineIfNotEmpty();
    _builder.append("    return { successful: false, message: \'Transfer denied by access-control policy\' };");
    _builder.newLine();
    _builder.append("  }");
    _builder.newLine();
    _builder.append("  await ctx.stub.putState(contractId, Buffer.from(serialize(contract)));");
    _builder.newLine();
    _builder.append("  const MSG = `Ownership of ");
    _builder.append(resourceVar);
    _builder.append(" transferred to ${newOwnerName}, ${contractId}`;");
    _builder.newLineIfNotEmpty();
    _builder.append("  contract.notified.message.push({");
    _builder.newLine();
    _builder.append("    name: \'contract.");
    _builder.append(resourceVar);
    _builder.append("\', message: MSG,");
    _builder.newLineIfNotEmpty();
    _builder.append("    roles: [actorRole.name._value, newOwnerRole.name._value],");
    _builder.newLine();
    _builder.append("    time: new Date().toISOString()");
    _builder.newLine();
    _builder.append("  });");
    _builder.newLine();
    _builder.append("  for (const message of contract.notified.message) {");
    _builder.newLine();
    _builder.append("    this.trigger_notification(ctx, message);");
    _builder.newLine();
    _builder.append("  }");
    _builder.newLine();
    _builder.append("  return { successful: true };");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public List<String> compilePowerTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        final PowerFunction powerFunction = power.getConsequent();
        boolean _matched = false;
        if (powerFunction instanceof PFObligationSuspended) {
          _matched=true;
          methods.add(
            this.generatePowerTransactionForObligation(power.getName(), ((PFObligationSuspended)powerFunction).getNorm().getName(), "suspended"));
        }
        if (!_matched) {
          if (powerFunction instanceof PFObligationResumed) {
            _matched=true;
            methods.add(
              this.generatePowerTransactionForObligation(power.getName(), ((PFObligationResumed)powerFunction).getNorm().getName(), "resumed"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFObligationDischarged) {
            _matched=true;
            methods.add(
              this.generatePowerTransactionForObligation(power.getName(), ((PFObligationDischarged)powerFunction).getNorm().getName(), "discharged"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFObligationTerminated) {
            _matched=true;
            methods.add(
              this.generatePowerTransactionForObligation(power.getName(), ((PFObligationTerminated)powerFunction).getNorm().getName(), "terminated"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFObligationTriggered) {
            _matched=true;
            methods.add(
              this.generatePowerTransactionForObligation(power.getName(), ((PFObligationTriggered)powerFunction).getNorm().getName(), "triggered"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFContractSuspended) {
            _matched=true;
            methods.add(this.generatePowerTransactionForContract(power.getName(), "suspended"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFContractResumed) {
            _matched=true;
            methods.add(this.generatePowerTransactionForContract(power.getName(), "resumed"));
          }
        }
        if (!_matched) {
          if (powerFunction instanceof PFContractTerminated) {
            _matched=true;
            methods.add(this.generatePowerTransactionForContract(power.getName(), "terminated"));
          }
        }
      }
    }
    return methods;
  }

  public List<String> compileViolationEventsTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    for (final Obligation obligation : this.allObligations) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("async violateObligation_");
      String _name = obligation.getName();
      _builder.append(_name);
      _builder.append("(ctx, contractId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("const cid = new ClientIdentity(ctx.stub);");
      _builder.newLine();
      _builder.append("\t    \t");
      _builder.append("let roleObj;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contractState = await ctx.stub.getState(contractId)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contractState == null) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contract = deserialize(contractState.toString())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("this.initialize(contract)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contract.isInEffect()) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("if (contract.obligations.");
      String _name_1 = obligation.getName();
      _builder.append(_name_1, "    ");
      _builder.append(" != null){");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t            ");
      _builder.append("try{");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.newLine();
      _builder.append("  \t               ");
      _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
      _builder.newLine();
      _builder.append("  \t               ");
      _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.newLine();
      _builder.append("  \t                     ");
      _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
      _builder.newLine();
      _builder.append("  \t                      ");
      _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
      _builder.newLine();
      _builder.append("  \t                 ");
      _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("// wrong certificate");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.newLine();
      _builder.append("  \t            ");
      _builder.append("}catch(err){");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("console.log(\'access control error: \', err)");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("return { successful: false, message: err.message }");
      _builder.newLine();
      _builder.append("  \t            ");
      _builder.append("}// end of first layer");
      _builder.newLine();
      _builder.append("  \t            ");
      _builder.append("//seond layer ");
      _builder.newLine();
      _builder.append("  \t          \t");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("let controllers = contract.obligations.");
      String _name_2 = obligation.getName();
      _builder.append(_name_2, "  \t                ");
      _builder.append("._controller");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t        ");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.append("if(!contract.accessPolicy.hasPermesstion(\'grant\',\'read\', contract.obligations.");
      String _name_3 = obligation.getName();
      _builder.append(_name_3, "  \t        ");
      _builder.append(", roleObj, contract.obligations.");
      String _name_4 = obligation.getName();
      _builder.append(_name_4, "  \t        ");
      _builder.append(".getController(controllers.length - 1)) || ");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t                  ");
      _builder.append("!contract.accessPolicy.isValid(new Rule(\'grant\',\'read\', contract.obligations.");
      String _name_5 = obligation.getName();
      _builder.append(_name_5, "  \t                  ");
      _builder.append(", roleObj, contract.obligations.");
      String _name_6 = obligation.getName();
      _builder.append(_name_6, "  \t                  ");
      _builder.append(".getController(controllers.length - 1))) ){");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t                    ");
      _builder.append("throw new Error(`access denied...`)");
      _builder.newLine();
      _builder.append("  \t                  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  \t            ");
      _builder.append("let transitionState = contract.");
      String _xifexpression = null;
      boolean _isSurvivingObligation = this.isSurvivingObligation(obligation.getName());
      if (_isSurvivingObligation) {
        _xifexpression = "survivingObligations";
      } else {
        _xifexpression = "obligations";
      }
      _builder.append(_xifexpression, "  \t            ");
      _builder.append(".");
      String _name_7 = obligation.getName();
      _builder.append(_name_7, "  \t            ");
      _builder.append(".state;");
      _builder.newLineIfNotEmpty();
      _builder.append("    \t");
      _builder.append("if (contract.obligations.");
      String _name_8 = obligation.getName();
      _builder.append(_name_8, "    \t");
      _builder.append(".violated()) {      ");
      _builder.newLineIfNotEmpty();
      _builder.append("      \t\t");
      _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))        ");
      _builder.newLine();
      _builder.append("      \t\t");
      String _xifexpression_1 = null;
      boolean _isSurvivingObligation_1 = this.isSurvivingObligation(obligation.getName());
      if (_isSurvivingObligation_1) {
        _xifexpression_1 = "survivingObligations";
      } else {
        String _name_9 = obligation.getName();
        _xifexpression_1 = (("obligations" + ".") + _name_9);
      }
      final String obName = ("contract." + _xifexpression_1);
      _builder.newLineIfNotEmpty();
      _builder.append("      \t\t");
      _builder.append("//notify");
      _builder.newLine();
      _builder.append("      \t\t");
      _builder.append("let MSG= transitionState+\" Changed to \"+");
      _builder.append(obName, "      \t\t");
      _builder.append(".state+\",\"+");
      _builder.append(obName, "      \t\t");
      _builder.append(".name+\", \" + contractId;");
      _builder.newLineIfNotEmpty();
      _builder.append("      \t\t");
      _builder.append("contract.notified.message.push({name: \'");
      _builder.append(obName, "      \t\t");
      _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
      _builder.append(obName, "      \t\t");
      _builder.append(",[");
      _builder.append(obName, "      \t\t");
      _builder.append(".creditor,");
      _builder.append(obName, "      \t\t");
      _builder.append(".debtor],");
      _builder.append(obName, "      \t\t");
      _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()})         ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t  \t\t        ");
      _builder.append("//notification");
      _builder.newLine();
      _builder.append("\t  \t\t        ");
      _builder.append("for (const message of contract.notified.message) {");
      _builder.newLine();
      _builder.append("\t  \t\t                 ");
      _builder.append("this.trigger_notification(ctx, message)");
      _builder.newLine();
      _builder.append("\t  \t\t             ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("      \t\t");
      _builder.newLine();
      _builder.append("      \t\t");
      _builder.append("return {successful: true}");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("      \t\t");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}else {");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      methods.add(_builder.toString());
    }
    for (final Obligation obligation_1 : this.allSurvivingObligations) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("async violateSurvivingObligations_");
      String _name_10 = obligation_1.getName();
      _builder_1.append(_name_10);
      _builder_1.append("(ctx, contractId) {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("const cid = new ClientIdentity(ctx.stub);");
      _builder_1.newLine();
      _builder_1.append("\t    \t");
      _builder_1.append("let roleObj;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("const contractState = await ctx.stub.getState(contractId)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (contractState == null) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("const contract = deserialize(contractState.toString())");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("this.initialize(contract)");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (contract.isInEffect() || contract.isSuccessfulTermination()) {");
      _builder_1.newLine();
      _builder_1.append("  \t          \t            ");
      _builder_1.append("try{");
      _builder_1.newLine();
      _builder_1.append("  \t          \t        ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t               ");
      _builder_1.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t               ");
      _builder_1.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
      _builder_1.newLine();
      _builder_1.append("  \t          \t        ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                     ");
      _builder_1.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                      ");
      _builder_1.append("throw new Error(\'Unauthorized: Unknown access\'); ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                 ");
      _builder_1.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("// wrong certificate");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  \t          \t        ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t            ");
      _builder_1.append("}catch(err){");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("console.log(\'access control error: \', err)");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("return { successful: false, message: err.message }");
      _builder_1.newLine();
      _builder_1.append("  \t          \t            ");
      _builder_1.append("}// end of first layer");
      _builder_1.newLine();
      _builder_1.append("  \t          \t            ");
      _builder_1.append("//seond layer ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t          \t");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("let controllers = contract.survivingObligations.");
      String _name_11 = obligation_1.getName();
      _builder_1.append(_name_11, "  \t          \t                ");
      _builder_1.append("._controller");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  \t          \t        ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t        ");
      _builder_1.append("if(!contract.accessPolicy.hasPermesstion(\'grant\',\'read\', contract.survivingObligations.");
      String _name_12 = obligation_1.getName();
      _builder_1.append(_name_12, "  \t          \t        ");
      _builder_1.append(", roleObj, contract.survivingObligations.");
      String _name_13 = obligation_1.getName();
      _builder_1.append(_name_13, "  \t          \t        ");
      _builder_1.append(".getController(controllers.length - 1)) || ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  \t          \t                  ");
      _builder_1.append("!contract.accessPolicy.isValid(new Rule(\'grant\',\'read\', contract.survivingObligations.");
      String _name_14 = obligation_1.getName();
      _builder_1.append(_name_14, "  \t          \t                  ");
      _builder_1.append(", roleObj, contract.survivingObligations.");
      String _name_15 = obligation_1.getName();
      _builder_1.append(_name_15, "  \t          \t                  ");
      _builder_1.append(".getController(controllers.length - 1))) ){");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  \t          \t                    ");
      _builder_1.append("throw new Error(`access denied...`)");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  \t");
      _builder_1.append("let transitionState = contract.survivingObligations.");
      String _name_16 = obligation_1.getName();
      _builder_1.append(_name_16, "  \t");
      _builder_1.append(".state;");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("    ");
      _builder_1.append("if (contract.survivingObligations.");
      String _name_17 = obligation_1.getName();
      _builder_1.append(_name_17, "    ");
      _builder_1.append(" != null && contract.survivingObligations.");
      String _name_18 = obligation_1.getName();
      _builder_1.append(_name_18, "    ");
      _builder_1.append(".violated()) { ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t\t\t\t");
      String _name_19 = obligation_1.getName();
      String obName_1 = ("contract.survivingObligations." + _name_19);
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("   \t\t");
      _builder_1.append("//notify");
      _builder_1.newLine();
      _builder_1.append("   \t\t");
      _builder_1.append("let MSG= transitionState+\" Changed to \"+");
      _builder_1.append(obName_1, "   \t\t");
      _builder_1.append(".state+\",\"+");
      _builder_1.append(obName_1, "   \t\t");
      _builder_1.append(".name+\", \" + contractId;");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("   \t\t");
      _builder_1.append("contract.notified.message.push({name: \'");
      _builder_1.append(obName_1, "   \t\t");
      _builder_1.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
      _builder_1.append(obName_1, "   \t\t");
      _builder_1.append(",[");
      _builder_1.append(obName_1, "   \t\t");
      _builder_1.append(".creditor,");
      _builder_1.append(obName_1, "   \t\t");
      _builder_1.append(".debtor],");
      _builder_1.append(obName_1, "   \t\t");
      _builder_1.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()})         ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  \t\t        ");
      _builder_1.append("//notification");
      _builder_1.newLine();
      _builder_1.append("  \t\t        ");
      _builder_1.append("for (const message of contract.notified.message) {");
      _builder_1.newLine();
      _builder_1.append("  \t\t                 ");
      _builder_1.append("this.trigger_notification(ctx, message)");
      _builder_1.newLine();
      _builder_1.append("  \t\t             ");
      _builder_1.append("}     ");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return {successful: true}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      methods.add(_builder_1.toString());
    }
    return methods;
  }

  public List<String> compileExpirationTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    for (final Obligation obligation : this.conditionalObligations) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("async expireObligation_");
      String _name = obligation.getName();
      _builder.append(_name);
      _builder.append("(ctx, contractId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("const cid = new ClientIdentity(ctx.stub);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("let roleObj;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contractState = await ctx.stub.getState(contractId)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contractState == null) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contract = deserialize(contractState.toString())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("this.initialize(contract)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contract.isInEffect()) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("if (contract.obligations.");
      String _name_1 = obligation.getName();
      _builder.append(_name_1, "    ");
      _builder.append(" != null){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("try{");
      _builder.newLine();
      _builder.append("\t\t\t\t          \t        ");
      _builder.newLine();
      _builder.append("      \t               ");
      _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
      _builder.newLine();
      _builder.append("      \t               ");
      _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
      _builder.newLine();
      _builder.append("      \t        ");
      _builder.newLine();
      _builder.append("      \t                     ");
      _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
      _builder.newLine();
      _builder.append("      \t                      ");
      _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
      _builder.newLine();
      _builder.append("      \t                 ");
      _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
      _builder.newLine();
      _builder.append("      \t                ");
      _builder.append("// wrong certificate");
      _builder.newLine();
      _builder.append("      \t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("      \t        ");
      _builder.newLine();
      _builder.append("      \t            ");
      _builder.append("}catch(err){");
      _builder.newLine();
      _builder.append("      \t                ");
      _builder.append("console.log(\'access control error: \', err)");
      _builder.newLine();
      _builder.append("      \t                ");
      _builder.append("return { successful: false, message: err.message }");
      _builder.newLine();
      _builder.append("      \t            ");
      _builder.append("}// end of first layer");
      _builder.newLine();
      _builder.append("      \t            ");
      _builder.append("//seond layer ");
      _builder.newLine();
      _builder.append("      \t          \t");
      _builder.newLine();
      _builder.append("      \t                ");
      _builder.append("let controllers = contract.obligations.");
      String _name_2 = obligation.getName();
      _builder.append(_name_2, "      \t                ");
      _builder.append("._controller");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t  \t        ");
      _builder.newLine();
      _builder.append("\t\t\t\t  \t        ");
      _builder.append("if(!contract.accessPolicy.hasPermesstion(\'grant\',\'read\', contract.obligations.");
      String _name_3 = obligation.getName();
      _builder.append(_name_3, "\t\t\t\t  \t        ");
      _builder.append(", roleObj, contract.obligations.");
      String _name_4 = obligation.getName();
      _builder.append(_name_4, "\t\t\t\t  \t        ");
      _builder.append(".getController(controllers.length - 1)) || ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t  \t                  ");
      _builder.append("!contract.accessPolicy.isValid(new Rule(\'grant\',\'read\', contract.obligations.");
      String _name_5 = obligation.getName();
      _builder.append(_name_5, "\t\t\t\t  \t                  ");
      _builder.append(", roleObj, contract.obligations.");
      String _name_6 = obligation.getName();
      _builder.append(_name_6, "\t\t\t\t  \t                  ");
      _builder.append(".getController(controllers.length - 1))) ){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t  \t                    ");
      _builder.append("throw new Error(`access denied...`)");
      _builder.newLine();
      _builder.append("\t\t\t\t  \t                  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("let transitionState = contract.");
      String _xifexpression = null;
      boolean _isSurvivingObligation = this.isSurvivingObligation(obligation.getName());
      if (_isSurvivingObligation) {
        _xifexpression = "survivingObligations";
      } else {
        _xifexpression = "obligations";
      }
      _builder.append(_xifexpression, "\t\t\t\t");
      _builder.append(".");
      String _name_7 = obligation.getName();
      _builder.append(_name_7, "\t\t\t\t");
      _builder.append(".state;");
      _builder.newLineIfNotEmpty();
      _builder.append("    \t");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("if (contract.obligations.");
      String _name_8 = obligation.getName();
      _builder.append(_name_8, "    \t");
      _builder.append(".expired()) {         ");
      _builder.newLineIfNotEmpty();
      _builder.append("       \t\t");
      String _xifexpression_1 = null;
      boolean _isSurvivingObligation_1 = this.isSurvivingObligation(obligation.getName());
      if (_isSurvivingObligation_1) {
        _xifexpression_1 = "survivingObligations";
      } else {
        String _name_9 = obligation.getName();
        _xifexpression_1 = (("obligations" + ".") + _name_9);
      }
      final String obName = ("contract." + _xifexpression_1);
      _builder.newLineIfNotEmpty();
      _builder.append("       \t\t");
      _builder.append("//notify");
      _builder.newLine();
      _builder.append("       \t\t");
      _builder.append("let MSG= transitionState+\" Changed to \"+");
      _builder.append(obName, "       \t\t");
      _builder.append(".state+\",\"+");
      _builder.append(obName, "       \t\t");
      _builder.append(".name+\", \" + contractId;");
      _builder.newLineIfNotEmpty();
      _builder.append("       \t\t");
      _builder.append("contract.notified.message.push({name: \'");
      _builder.append(obName, "       \t\t");
      _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
      _builder.append(obName, "       \t\t");
      _builder.append(",[");
      _builder.append(obName, "       \t\t");
      _builder.append(".creditor,");
      _builder.append(obName, "       \t\t");
      _builder.append(".debtor],");
      _builder.append(obName, "       \t\t");
      _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()})         ");
      _builder.newLineIfNotEmpty();
      _builder.append(" \t  \t\t        ");
      _builder.append("//notification");
      _builder.newLine();
      _builder.append(" \t  \t\t        ");
      _builder.append("for (const message of contract.notified.message) {");
      _builder.newLine();
      _builder.append(" \t  \t\t                 ");
      _builder.append("this.trigger_notification(ctx, message)");
      _builder.newLine();
      _builder.append(" \t  \t\t             ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    \t\t               \t\t    ");
      _builder.newLine();
      _builder.append("     \t\t ");
      _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder.newLine();
      _builder.append("      \t\t ");
      _builder.append("return {successful: true}");
      _builder.newLine();
      _builder.append("    \t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("      \t\t");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("   \t\t ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("     \t\t");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("}\t\t ");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      methods.add(_builder.toString());
    }
    for (final Obligation obligation_1 : this.conditionalSurvivingObligations) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("async expireSurvivingObligation_");
      String _name_10 = obligation_1.getName();
      _builder_1.append(_name_10);
      _builder_1.append("(ctx, contractId) {");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("\t");
      _builder_1.append("const cid = new ClientIdentity(ctx.stub);");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("let roleObj;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("const contractState = await ctx.stub.getState(contractId)");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (contractState == null) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("const contract = deserialize(contractState.toString())");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("this.initialize(contract)");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("if (contract.isInEffect() || contract.isSuccessfulTermination()) {");
      _builder_1.newLine();
      _builder_1.append("  \t");
      _builder_1.append("try{");
      _builder_1.newLine();
      _builder_1.append("  \t          \t        ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t               ");
      _builder_1.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t               ");
      _builder_1.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
      _builder_1.newLine();
      _builder_1.append("  \t          \t        ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                     ");
      _builder_1.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                      ");
      _builder_1.append("throw new Error(\'Unauthorized: Unknown access\'); ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                 ");
      _builder_1.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("// wrong certificate");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  \t          \t        ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t            ");
      _builder_1.append("}catch(err){");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("console.log(\'access control error: \', err)");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("return { successful: false, message: err.message }");
      _builder_1.newLine();
      _builder_1.append("  \t          \t            ");
      _builder_1.append("}// end of first layer");
      _builder_1.newLine();
      _builder_1.append("  \t          \t            ");
      _builder_1.append("//seond layer ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t          \t");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                ");
      _builder_1.append("let controllers = contract.survivingObligations.");
      String _name_11 = obligation_1.getName();
      _builder_1.append(_name_11, "  \t          \t                ");
      _builder_1.append("._controller");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  \t          \t        ");
      _builder_1.newLine();
      _builder_1.append("  \t          \t        ");
      _builder_1.append("if(!contract.accessPolicy.hasPermesstion(\'grant\',\'read\', contract.survivingObligations.");
      String _name_12 = obligation_1.getName();
      _builder_1.append(_name_12, "  \t          \t        ");
      _builder_1.append(", roleObj, contract.survivingObligations.");
      String _name_13 = obligation_1.getName();
      _builder_1.append(_name_13, "  \t          \t        ");
      _builder_1.append(".getController(controllers.length - 1)) || ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  \t          \t                  ");
      _builder_1.append("!contract.accessPolicy.isValid(new Rule(\'grant\',\'read\', contract.survivingObligations.");
      String _name_14 = obligation_1.getName();
      _builder_1.append(_name_14, "  \t          \t                  ");
      _builder_1.append(", roleObj, contract.survivingObligations.");
      String _name_15 = obligation_1.getName();
      _builder_1.append(_name_15, "  \t          \t                  ");
      _builder_1.append(".getController(controllers.length - 1))) ){");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("  \t          \t                    ");
      _builder_1.append("throw new Error(`access denied...`)");
      _builder_1.newLine();
      _builder_1.append("  \t          \t                  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("if (contract.survivingObligations.");
      String _name_16 = obligation_1.getName();
      _builder_1.append(_name_16, "    ");
      _builder_1.append(" != null && contract.survivingObligations.");
      String _name_17 = obligation_1.getName();
      _builder_1.append(_name_17, "    ");
      _builder_1.append(".expired()) {      ");
      _builder_1.newLineIfNotEmpty();
      _builder_1.append("      ");
      _builder_1.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return {successful: true}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("      ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("} else {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return {successful: false}");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      methods.add(_builder_1.toString());
    }
    return methods;
  }

  public List<String> compilePowerExpirationTransactions(final Model model) {
    final ArrayList<String> methods = new ArrayList<String>();
    for (final Power power : this.allPowers) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("async expirePower_");
      String _name = power.getName();
      _builder.append(_name);
      _builder.append("(ctx, contractId) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("const cid = new ClientIdentity(ctx.stub);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("let roleObj;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contractState = await ctx.stub.getState(contractId)");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contractState == null) {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("const contract = deserialize(contractState.toString())");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("this.initialize(contract)");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("if (contract.isInEffect()) {");
      _builder.newLine();
      _builder.append("  \t            ");
      _builder.append("try{");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.newLine();
      _builder.append("  \t               ");
      _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
      _builder.newLine();
      _builder.append("  \t               ");
      _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.newLine();
      _builder.append("  \t                     ");
      _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
      _builder.newLine();
      _builder.append("  \t                      ");
      _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
      _builder.newLine();
      _builder.append("  \t                 ");
      _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("// wrong certificate");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.newLine();
      _builder.append("  \t            ");
      _builder.append("}catch(err){");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("console.log(\'access control error: \', err)");
      _builder.newLine();
      _builder.append("  \t                ");
      _builder.append("return { successful: false, message: err.message }");
      _builder.newLine();
      _builder.append("  \t            ");
      _builder.append("}// end of first layer");
      _builder.newLine();
      _builder.append("  \t            ");
      _builder.append("//seond layer ");
      _builder.newLine();
      _builder.append("  \t          \t");
      _builder.newLine();
      _builder.append("  \t         ");
      _builder.append("let controllers = contract.powers.");
      String _name_1 = power.getName();
      _builder.append(_name_1, "  \t         ");
      _builder.append("._controller");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t        ");
      _builder.newLine();
      _builder.append("  \t        ");
      _builder.append("if(!contract.accessPolicy.hasPermesstion(\'grant\',\'read\', contract.powers.");
      String _name_2 = power.getName();
      _builder.append(_name_2, "  \t        ");
      _builder.append(", roleObj, contract.powers.");
      String _name_3 = power.getName();
      _builder.append(_name_3, "  \t        ");
      _builder.append(".getController(controllers.length - 1)) || ");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t                  ");
      _builder.append("!contract.accessPolicy.isValid(new Rule(\'grant\',\'read\', contract.powers.");
      String _name_4 = power.getName();
      _builder.append(_name_4, "  \t                  ");
      _builder.append(", roleObj, contract.powers.");
      String _name_5 = power.getName();
      _builder.append(_name_5, "  \t                  ");
      _builder.append(".getController(controllers.length - 1))) ){");
      _builder.newLineIfNotEmpty();
      _builder.append("  \t                    ");
      _builder.append("throw new Error(`access denied...`)");
      _builder.newLine();
      _builder.append("  \t                  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("let transitionState = contract.powers.");
      String _name_6 = power.getName();
      _builder.append(_name_6, "\t\t\t");
      _builder.append(".state;");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("if (contract.powers.");
      String _name_7 = power.getName();
      _builder.append(_name_7, "    ");
      _builder.append(".expired()) {   ");
      _builder.newLineIfNotEmpty();
      _builder.append("       \t\t");
      String _name_8 = power.getName();
      String powerName = ("contract.powers." + _name_8);
      _builder.newLineIfNotEmpty();
      _builder.append("       \t\t");
      _builder.append("//notify");
      _builder.newLine();
      _builder.append("       \t\t");
      _builder.append("let MSG= transitionState+\" Changed to \"+");
      _builder.append(powerName, "       \t\t");
      _builder.append(".state+\",\"+");
      _builder.append(powerName, "       \t\t");
      _builder.append(".name+\", \" + contractId;");
      _builder.newLineIfNotEmpty();
      _builder.append("       \t\t");
      _builder.append("contract.notified.message.push({name: \'");
      _builder.append(powerName, "       \t\t");
      _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
      _builder.append(powerName, "       \t\t");
      _builder.append(",[");
      _builder.append(powerName, "       \t\t");
      _builder.append(".creditor,");
      _builder.append(powerName, "       \t\t");
      _builder.append(".debtor],");
      _builder.append(powerName, "       \t\t");
      _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()})         ");
      _builder.newLineIfNotEmpty();
      _builder.append(" \t  \t\t        ");
      _builder.append("//notification");
      _builder.newLine();
      _builder.append(" \t  \t\t        ");
      _builder.append("for (const message of contract.notified.message) {");
      _builder.newLine();
      _builder.append(" \t  \t\t                 ");
      _builder.append("this.trigger_notification(ctx, message)");
      _builder.newLine();
      _builder.append(" \t  \t\t             ");
      _builder.append("}   ");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {successful: true}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("                  ");
      _builder.append("return {successful: false}");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      methods.add(_builder.toString());
    }
    return methods;
  }

  public String generatePowerTransactionForObligation(final String powerName, final String obligationName, final String stateMethod) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("async p_");
    _builder.append(powerName);
    _builder.append("_");
    _builder.append(stateMethod);
    _builder.append("_o_");
    _builder.append(obligationName);
    _builder.append("(ctx, contractId) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("let roleObj;\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contract.isInEffect() && contract.powers.");
    _builder.append(powerName, "  ");
    _builder.append(" != null && contract.powers.");
    _builder.append(powerName, "  ");
    _builder.append(".isInEffect()) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("try{");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("//const userId = cid.getID();");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("// wrong certificate");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("//seond layer ");
    _builder.newLine();
    _builder.append("      \t");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("let controllers = contract.powers.");
    _builder.append(powerName, "            ");
    _builder.append("._controller");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if(!contract.accessPolicy.hasPermesstion(\'grant\',\'read\', contract.powers.");
    _builder.append(powerName, "    ");
    _builder.append(", roleObj, contract.powers.");
    _builder.append(powerName, "    ");
    _builder.append(".getController(controllers.length - 1)) || ");
    _builder.newLineIfNotEmpty();
    _builder.append("              ");
    _builder.append("!contract.accessPolicy.isValid(new Rule(\'grant\',\'read\', contract.powers.");
    _builder.append(powerName, "              ");
    _builder.append(", roleObj, contract.powers.");
    _builder.append(powerName, "              ");
    _builder.append(".getController(controllers.length - 1))) ){");
    _builder.newLineIfNotEmpty();
    _builder.append("                ");
    _builder.append("throw new Error(`access denied...`)");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    {
      boolean _equals = stateMethod.equals("triggered");
      if (_equals) {
        _builder.append("    ");
        _builder.append("if (contract.powers.");
        _builder.append(powerName, "    ");
        _builder.append(".exerted()) {");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("    ");
        _builder.append("let transitionState = contract.");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(obligationName);
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        _builder.append(_xifexpression, "    ");
        _builder.append(".");
        _builder.append(obligationName, "    ");
        _builder.append(".state;");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        String _xifexpression_1 = null;
        boolean _isSurvivingObligation_1 = this.isSurvivingObligation(obligationName);
        if (_isSurvivingObligation_1) {
          _xifexpression_1 = "survivingObligations";
        } else {
          _xifexpression_1 = (("obligations" + ".") + obligationName);
        }
        final String obName = ("contract." + _xifexpression_1);
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("const obligation = contract.");
        String _xifexpression_2 = null;
        boolean _isSurvivingObligation_2 = this.isSurvivingObligation(obligationName);
        if (_isSurvivingObligation_2) {
          _xifexpression_2 = "survivingObligations";
        } else {
          _xifexpression_2 = "obligations";
        }
        _builder.append(_xifexpression_2, "    ");
        _builder.append(".");
        _builder.append(obligationName, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("if (obligation != null && obligation.");
        _builder.append(stateMethod, "    ");
        _builder.append("() && contract.powers.");
        _builder.append(powerName, "    ");
        _builder.append(".exerted()) {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("\t    ");
        _builder.append("//notify");
        _builder.newLine();
        _builder.append("    ");
        _builder.append("\t          ");
        _builder.append("let MSG= transitionState+\" Changed to \"+");
        _builder.append(obName, "    \t          ");
        _builder.append(".state+\",\"+");
        _builder.append(obName, "    \t          ");
        _builder.append(".name+\", \" +contractId;");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("\t          ");
        _builder.append("contract.notified.message.push({name: \'");
        _builder.append(obName, "    \t          ");
        _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
        _builder.append(obName, "    \t          ");
        _builder.append(",[");
        _builder.append(obName, "    \t          ");
        _builder.append(".creditor,");
        _builder.append(obName, "    \t          ");
        _builder.append(".debtor],");
        _builder.append(obName, "    \t          ");
        _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("      ");
    _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))          ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("//notification");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("for (const message of contract.notified.message) {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("this.trigger_notification(ctx, message)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {successful: true}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }

  public String generatePowerTransactionForContract(final String powerName, final String stateMethod) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("async p_");
    _builder.append(powerName);
    _builder.append("_");
    _builder.append(stateMethod);
    _builder.append("_contract(ctx, contractId) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("const cid = new ClientIdentity(ctx.stub);");
    _builder.newLine();
    _builder.append("\t    \t");
    _builder.append("let roleObj;");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contractState = await ctx.stub.getState(contractId)");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contractState == null) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("const contract = deserialize(contractState.toString())");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("this.initialize(contract)");
    _builder.newLine();
    _builder.newLine();
    _builder.append("  ");
    _builder.append("if (contract.isInEffect() && contract.powers.");
    _builder.append(powerName, "  ");
    _builder.append(" != null && contract.powers.");
    _builder.append(powerName, "  ");
    _builder.append(".isInEffect()) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("try{");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("roleObj = contract.authenticate(cid.getAttributeValue(\'HF.role\'), cid.getAttributeValue(\'HF.name\'), ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("cid.getAttributeValue(\'organization\'), cid.getAttributeValue(\'department\'),contract)");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("if(roleObj === null ){ // this mean the roleObj (role who calls the transaction) exist in our conttract");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("throw new Error(\'Unauthorized: Unknown access\'); ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("//roleObj: we do not have a role that has the same name and type that calls the transaction like e.g., there is no shipper");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("// wrong certificate");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}catch(err){");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("console.log(\'access control error: \', err)");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("return { successful: false, message: err.message }");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}// end of first layer");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("//seond layer ");
    _builder.newLine();
    _builder.append("      \t");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("let controllers = contract.powers.");
    _builder.append(powerName, "            ");
    _builder.append("._controller");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if(!contract.accessPolicy.hasPermesstion(\'grant\',\'read\', contract.powers.");
    _builder.append(powerName, "    ");
    _builder.append(", roleObj, contract.powers.");
    _builder.append(powerName, "    ");
    _builder.append(".getController(controllers.length - 1)) || ");
    _builder.newLineIfNotEmpty();
    _builder.append("              ");
    _builder.append("!contract.accessPolicy.isValid(new Rule(\'grant\',\'read\', contract.powers.");
    _builder.append(powerName, "              ");
    _builder.append(", roleObj, contract.powers.");
    _builder.append(powerName, "              ");
    _builder.append(".getController(controllers.length - 1))) ){");
    _builder.newLineIfNotEmpty();
    _builder.append("                ");
    _builder.append("throw new Error(`access denied...`)");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// contract state notification");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("const stateM=\"");
    _builder.append(stateMethod, "    ");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("//notify");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("controllers = contract._controller");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("let MSG= \"Contract \"+Contract._name+\" is \"+  stateM+\', \'+ contractId;");
    _builder.newLine();
    _builder.append("\t      ");
    _builder.append("contract.notified.message.push({name: contract._name, message: MSG, roles:contract.accessPolicy.permissionValid(contract,contract._controller,contract.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
    _builder.newLine();
    _builder.append("\t            ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (let index in contract.obligations) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("const obligation = contract.obligations[index]");
    _builder.newLine();
    {
      boolean _equals = stateMethod.equals("suspended");
      if (_equals) {
        _builder.append("      ");
        _builder.append("obligation._suspendedByContractSuspension = true");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("obligation.suspended()");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("controllers = obligation._controller");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("let MSG= \"Obligation \"+obligation.name+\" is suspended By Contract Suspension, \"+contractId;");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("contract.notified.message.push({name: obligation.name, message: MSG, roles:contract.accessPolicy.permissionValid(obligation,[obligation.creditor,obligation.debtor],obligation.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
        _builder.newLine();
      } else {
        boolean _equals_1 = stateMethod.equals("resumed");
        if (_equals_1) {
          _builder.append("      ");
          _builder.append("if (obligation._suspendedByContractSuspension === true){");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("obligation.resumed()");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("controllers = obligation._controller");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("let MSG= \"Obligation \"+obligation.name+\" is resumed By Contract resume, \"+contractId;");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("contract.notified.message.push({name: obligation.name, message: MSG, roles:contract.accessPolicy.permissionValid(obligation,[obligation.creditor,obligation.debtor],obligation.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("}");
          _builder.newLine();
        } else {
          boolean _equals_2 = stateMethod.equals("terminated");
          if (_equals_2) {
            _builder.append("      ");
            _builder.append("obligation.terminated({emitEvent: false})");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("controllers = obligation._controller");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("let MSG= \"Obligation \"+obligation.name+\" is terminated By Contract termination, \"+contractId;");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("contract.notified.message.push({name: obligation.name, message: MSG, roles:contract.accessPolicy.permissionValid(obligation,[obligation.creditor,obligation.debtor],obligation.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
            _builder.newLine();
            _builder.append("      ");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (let index in contract.survivingObligations) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("const obligation = contract.survivingObligations[index]");
    _builder.newLine();
    {
      boolean _equals_3 = stateMethod.equals("suspended");
      if (_equals_3) {
        _builder.append("      ");
        _builder.append("obligation._suspendedByContractSuspension = true");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("obligation.suspended()");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("controllers = obligation._controller");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("let MSG= \"survivingObligations \"+obligation.name+\" is suspended By Contract Suspension, \"+contractId;");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("contract.notified.message.push({name: obligation.name, message: MSG, roles:contract.accessPolicy.permissionValid(obligation,[obligation.creditor,obligation.debtor],obligation.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
        _builder.newLine();
        _builder.append("      ");
        _builder.newLine();
      } else {
        boolean _equals_4 = stateMethod.equals("resumed");
        if (_equals_4) {
          _builder.append("      ");
          _builder.append("if (obligation._suspendedByContractSuspension === true){");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("obligation.resumed()");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("controllers = obligation._controller");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("let MSG= \"survivingObligation \"+obligation.name+\" is resumed By Contract resume, \"+contractId;");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("contract.notified.message.push({name: obligation.name, message: MSG, roles:contract.accessPolicy.permissionValid(obligation,[obligation.creditor,obligation.debtor],obligation.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("}");
          _builder.newLine();
        } else {
          boolean _equals_5 = stateMethod.equals("terminated");
          if (_equals_5) {
            _builder.append("      ");
            _builder.append("obligation.terminated()");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("controllers = obligation._controller");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("let MSG= \"survivingObligation \"+obligation.name+\" is terminated By Contract termination, \"+contractId;");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("contract.notified.message.push({name: obligation.name, message: MSG, roles:contract.accessPolicy.permissionValid(obligation,[obligation.creditor,obligation.debtor],obligation.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
            _builder.newLine();
            _builder.append("      ");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for (let index in contract.powers) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("const power = contract.powers[index]");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (index === \'");
    _builder.append(powerName, "      ");
    _builder.append("\') {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("continue;");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    {
      boolean _equals_6 = stateMethod.equals("suspended");
      if (_equals_6) {
        _builder.append("      ");
        _builder.append("power._suspendedByContractSuspension = true");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("power.suspended()");
        _builder.newLine();
        _builder.append("      ");
        _builder.append("controllers = power._controller");
        _builder.newLine();
        _builder.append("      ");
        _builder.append(" ");
        _builder.append("let MSG= \"Power \"+power.name+\" is suspended By Contract Suspension, \"+contractId;");
        _builder.newLine();
        _builder.append("      ");
        _builder.append(" ");
        _builder.append("contract.notified.message.push({name: power.name, message: MSG, roles:contract.accessPolicy.permissionValid(power,[power.creditor,power.debtor],power.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
        _builder.newLine();
        _builder.append("      ");
        _builder.newLine();
      } else {
        boolean _equals_7 = stateMethod.equals("resumed");
        if (_equals_7) {
          _builder.append("      ");
          _builder.append("if (power._suspendedByContractSuspension === true){");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("power.resumed()");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.append("controllers = power._controller");
          _builder.newLine();
          _builder.append("      ");
          _builder.append(" ");
          _builder.append("let MSG= \"Power \"+power.name+\" is resumed By Contract resume, \"+contractId;");
          _builder.newLine();
          _builder.append("      ");
          _builder.append(" ");
          _builder.append("contract.notified.message.push({name: power.name, message: MSG, roles:contract.accessPolicy.permissionValid(power,[power.creditor,power.debtor],power.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("  ");
          _builder.newLine();
          _builder.append("      ");
          _builder.append("}");
          _builder.newLine();
        } else {
          boolean _equals_8 = stateMethod.equals("terminated");
          if (_equals_8) {
            _builder.append("      ");
            _builder.append("power.terminated()");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("  ");
            _builder.append("controllers = power._controller");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("   ");
            _builder.append("let MSG= \"Power \"+power.name+\" is terminated By Contract termination, \"+contractId;");
            _builder.newLine();
            _builder.append("      ");
            _builder.append("   ");
            _builder.append("contract.notified.message.push({name: power.name, message: MSG, roles:contract.accessPolicy.permissionValid(power,[power.creditor,power.debtor],power.getController(controllers.length - 1), contract) , time: new Date().toISOString()})");
            _builder.newLine();
            _builder.append("      ");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}        ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("if (contract.");
    _builder.append(stateMethod, "    ");
    _builder.append("() && contract.powers.");
    _builder.append(powerName, "    ");
    _builder.append(".exerted()) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("//notification");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("for (const message of contract.notified.message) {");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("this.trigger_notification(ctx, message)");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    \t");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("await ctx.stub.putState(contractId, Buffer.from(serialize(contract)))");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {successful: true}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("return {successful: false}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }

  public void parse(final Model model) {
    this.parameters.addAll(model.getParameters());
    this.variables.addAll(model.getVariables());
    EList<DomainType> _domainTypes = model.getDomainTypes();
    for (final DomainType domainType : _domainTypes) {
      if ((domainType instanceof RegularType)) {
        RegularType base = Helpers.getBaseType(domainType);
        if ((base != null)) {
          String _name = base.getOntologyType().getName();
          if (_name != null) {
            switch (_name) {
              case "Asset":
                this.assets.add(((RegularType) domainType));
                break;
              case "Event":
                this.events.add(((RegularType) domainType));
                break;
              case "DataTransfer":
                this.events.add(((RegularType) domainType));
                break;
              case "Role":
                this.roles.add(((RegularType) domainType));
                break;
            }
          }
        }
      } else {
        if ((domainType instanceof Enumeration)) {
          this.enumerations.add(((Enumeration) domainType));
        }
      }
    }
    EList<Variable> _variables = model.getVariables();
    for (final Variable variable : _variables) {
      int _indexOf = this.events.indexOf(variable.getType());
      boolean _notEquals = (_indexOf != (-1));
      if (_notEquals) {
        this.eventVariables.add(variable);
      }
    }
    EList<Obligation> _obligations = model.getObligations();
    for (final Obligation obligation : _obligations) {
      {
        Proposition _trigger = obligation.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          this.untriggeredObligations.add(obligation);
        } else {
          this.triggeredObligations.add(obligation);
        }
        Proposition _antecedent = obligation.getAntecedent();
        if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
          this.unconditionalObligations.add(obligation);
        } else {
          this.conditionalObligations.add(obligation);
        }
      }
    }
    EList<Obligation> _survivingObligations = model.getSurvivingObligations();
    for (final Obligation obligation_1 : _survivingObligations) {
      {
        Proposition _trigger = obligation_1.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          this.untriggeredSurvivingObligations.add(obligation_1);
        } else {
          this.triggeredSurvivingObligations.add(obligation_1);
        }
        Proposition _antecedent = obligation_1.getAntecedent();
        if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
          this.unconditionalSurvivingObligations.add(obligation_1);
        } else {
          this.conditionalSurvivingObligations.add(obligation_1);
        }
      }
    }
    EList<Power> _powers = model.getPowers();
    for (final Power power : _powers) {
      {
        Proposition _trigger = power.getTrigger();
        boolean _tripleNotEquals = (_trigger != null);
        if (_tripleNotEquals) {
          this.untriggeredPowers.add(power);
        } else {
          this.triggeredPowers.add(power);
        }
        Proposition _antecedent = power.getAntecedent();
        if ((_antecedent instanceof PAtomPredicateTrueLiteral)) {
          this.unconditionalPowers.add(power);
        } else {
          this.conditionalPowers.add(power);
        }
      }
    }
    this.allObligations.addAll(this.untriggeredObligations);
    this.allObligations.addAll(this.triggeredObligations);
    this.allSurvivingObligations.addAll(this.untriggeredSurvivingObligations);
    this.allSurvivingObligations.addAll(this.triggeredSurvivingObligations);
    this.allPowers.addAll(this.untriggeredPowers);
    this.allPowers.addAll(this.triggeredPowers);
    for (final Obligation obligation_2 : this.untriggeredObligations) {
      {
        final Proposition proposition = obligation_2.getTrigger();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.obligationTriggerEvents.put(obligation_2, list);
        }
      }
    }
    for (final Obligation obligation_3 : this.untriggeredSurvivingObligations) {
      {
        final Proposition proposition = obligation_3.getTrigger();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.survivingObligationTriggerEvents.put(obligation_3, list);
        }
      }
    }
    for (final Power power_1 : this.untriggeredPowers) {
      {
        final Proposition proposition = power_1.getTrigger();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.powerTriggerEvents.put(power_1, list);
        }
      }
    }
    for (final Obligation obligation_4 : this.allObligations) {
      {
        final Proposition proposition = obligation_4.getConsequent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.obligationFullfilmentEvents.put(obligation_4, list);
        }
      }
    }
    for (final Obligation obligation_5 : this.allSurvivingObligations) {
      {
        final Proposition proposition = obligation_5.getConsequent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.survivingObligationFullfilmentEvents.put(obligation_5, list);
        }
      }
    }
    for (final Obligation obligation_6 : this.conditionalObligations) {
      {
        final Proposition proposition = obligation_6.getAntecedent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.obligationAntecedentEvents.put(obligation_6, list);
        }
      }
    }
    for (final Obligation obligation_7 : this.conditionalSurvivingObligations) {
      {
        final Proposition proposition = obligation_7.getAntecedent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.survivingObligationAntecedentEvents.put(obligation_7, list);
        }
      }
    }
    for (final Power power_2 : this.conditionalPowers) {
      {
        final Proposition proposition = power_2.getAntecedent();
        final List<PAtomPredicate> list = this.collectPropositionEvents(proposition);
        int _size = list.size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          this.powerAntecedentEvents.put(power_2, list);
        }
      }
    }
  }

  public void generateNPMFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"name\": \"");
    String _lowerCase = model.getContractName().toLowerCase();
    _builder.append(_lowerCase, "  ");
    _builder.append("\",");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("\"version\": \"1.0.0\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"description\": \"\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"main\": \"index.js\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"engines\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"node\": \">=14\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"npm\": \">=5\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"scripts\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"lint\": \"eslint .\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"pretest\": \"npm run lint\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"test\": \"nyc mocha --recursive\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"start\": \"fabric-chaincode-node start\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"engineStrict\": true,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"author\": \"Symboleo2SC\",");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"dependencies\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"fabric-contract-api\": \"2.2.0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"fabric-shim\": \"2.2.0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"flatted\": \"^3.3.3\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"symboleoac-js-core\": \"^1.0.23\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"devDependencies\": {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"chai\": \"^4.1.2\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"eslint\": \"^8.7.0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"eslint-config-airbnb-base\": \"^15.0.0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"eslint-plugin-import\": \"^2.25.4\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"mocha\": \"^8.0.1\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"nyc\": \"^14.1.1\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"sinon\": \"^6.0.0\",");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("\"sinon-chai\": \"^3.2.0\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String file = _builder.toString();
    String _contractName = model.getContractName();
    String _plus = ("./" + _contractName);
    String _plus_1 = (_plus + "/package.json");
    fsa.generateFile(_plus_1, file);
  }

  public String compileEventsMap() {
    Set<Obligation> _keySet = this.obligationTriggerEvents.keySet();
    for (final Obligation obligation : _keySet) {
      List<PAtomPredicate> _get = this.obligationTriggerEvents.get(obligation);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("EventListeners.createObligation_");
      String _name = obligation.getName();
      _builder.append(_name);
      this.arrays.add(
        this.generateEventMapLineString(_get, _builder.toString()));
    }
    Set<Obligation> _keySet_1 = this.survivingObligationTriggerEvents.keySet();
    for (final Obligation obligation_1 : _keySet_1) {
      List<PAtomPredicate> _get_1 = this.survivingObligationTriggerEvents.get(obligation_1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("EventListeners.createSurvivingObligation_");
      String _name_1 = obligation_1.getName();
      _builder_1.append(_name_1);
      this.arrays.add(
        this.generateEventMapLineString(_get_1, _builder_1.toString()));
    }
    Set<Power> _keySet_2 = this.powerTriggerEvents.keySet();
    for (final Power power : _keySet_2) {
      List<PAtomPredicate> _get_2 = this.powerTriggerEvents.get(power);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("EventListeners.createPower_");
      String _name_2 = power.getName();
      _builder_2.append(_name_2);
      this.arrays.add(
        this.generateEventMapLineString(_get_2, _builder_2.toString()));
    }
    Set<Obligation> _keySet_3 = this.obligationAntecedentEvents.keySet();
    for (final Obligation obligation_2 : _keySet_3) {
      List<PAtomPredicate> _get_3 = this.obligationAntecedentEvents.get(obligation_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("EventListeners.activateObligation_");
      String _name_3 = obligation_2.getName();
      _builder_3.append(_name_3);
      this.arrays.add(
        this.generateEventMapLineString(_get_3, _builder_3.toString()));
    }
    Set<Obligation> _keySet_4 = this.survivingObligationAntecedentEvents.keySet();
    for (final Obligation obligation_3 : _keySet_4) {
      List<PAtomPredicate> _get_4 = this.survivingObligationAntecedentEvents.get(obligation_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("EventListeners.activateSurvivingObligation_");
      String _name_4 = obligation_3.getName();
      _builder_4.append(_name_4);
      this.arrays.add(
        this.generateEventMapLineString(_get_4, _builder_4.toString()));
    }
    Set<Power> _keySet_5 = this.powerAntecedentEvents.keySet();
    for (final Power power_1 : _keySet_5) {
      List<PAtomPredicate> _get_5 = this.powerAntecedentEvents.get(power_1);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("EventListeners.activatePower_");
      String _name_5 = power_1.getName();
      _builder_5.append(_name_5);
      this.arrays.add(
        this.generateEventMapLineString(_get_5, _builder_5.toString()));
    }
    Set<Obligation> _keySet_6 = this.obligationFullfilmentEvents.keySet();
    for (final Obligation obligation_4 : _keySet_6) {
      List<PAtomPredicate> _get_6 = this.obligationFullfilmentEvents.get(obligation_4);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("EventListeners.fulfillObligation_");
      String _name_6 = obligation_4.getName();
      _builder_6.append(_name_6);
      this.arrays.add(
        this.generateEventMapLineString(_get_6, _builder_6.toString()));
    }
    Set<Obligation> _keySet_7 = this.survivingObligationFullfilmentEvents.keySet();
    for (final Obligation obligation_5 : _keySet_7) {
      List<PAtomPredicate> _get_7 = this.survivingObligationFullfilmentEvents.get(obligation_5);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("EventListeners.fulfillSurvivingObligation_");
      String _name_7 = obligation_5.getName();
      _builder_7.append(_name_7);
      this.arrays.add(
        this.generateEventMapLineString(_get_7, _builder_7.toString()));
    }
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("function getEventMap(contract) {");
    _builder_8.newLine();
    _builder_8.append("  ");
    _builder_8.append("return [");
    _builder_8.newLine();
    {
      for(final String line : this.arrays) {
        _builder_8.append("    ");
        _builder_8.append(line, "    ");
        _builder_8.newLineIfNotEmpty();
      }
    }
    _builder_8.append("  ");
    _builder_8.append("]");
    _builder_8.newLine();
    _builder_8.append("}");
    _builder_8.newLine();
    return _builder_8.toString();
  }

  public void compileSerializerFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("   ");
    _builder.append("//Flat library to solve the circular problem when stringifying node objects");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("const {stringify, parse } = require(\'flatted\')");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("const { ");
    String _contractName = model.getContractName();
    _builder.append(_contractName, "   ");
    _builder.append(" } = require(\"./domain/contract/");
    String _contractName_1 = model.getContractName();
    _builder.append(_contractName_1, "   ");
    _builder.append(".js\")");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("const { Obligation, ObligationActiveState, ObligationState } = require(");
    _builder.append(this.OBLIGATION_CLASS_IMPORT_PATH, "   ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("const { InternalEventType, InternalEvent, InternalEventSource} = require(");
    _builder.append(this.EVENTS_CLASS_IMPORT_PATH, "   ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("const { Event } = require(");
    _builder.append(this.EVENTS_CLASS_IMPORT_PATH, "   ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("const { Power } = require(");
    _builder.append(this.POWER_CLASS_IMPORT_PATH, "   ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("const { ACPolicy } = require(");
    _builder.append(this.ACPolicy_CLASS_IMPORT_PATH, "   ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("const { DataTransfer } = require(\"symboleoac-js-core\")");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("let contract = null");
    _builder.newLine();
    _builder.append("   ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("function deserialize(data) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("let object = parse(data,reviver);");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("// to update all the assign variable with the new value. We check the type of the variable before assiging the new value");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("contract = new ");
    String _contractName_2 = model.getContractName();
    _builder.append(_contractName_2, "     ");
    _builder.append("(");
    final Function1<Parameter, String> _function = (Parameter p) -> {
      String _name = p.getName();
      return ("object." + _name);
    };
    String _join = IterableExtensions.join(ListExtensions.<Parameter, String>map(model.getParameters(), _function), ",");
    _builder.append(_join, "     ");
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      for(final String e : this.AssignVar) {
        _builder.append("     ");
        _builder.append("contract.");
        _builder.append(e, "     ");
        _builder.append("= object.");
        _builder.append(e, "     ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("   ");
    _builder.append("contract.state = object.state");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("contract.activeState = object.activeState");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("// Add roles to role list");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("for(obj of object._roles){");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("contract.addRole(obj)");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("// Remove roles that were removed at runtime as initiating the contract genrates the same roles at design time");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("let toRemoveRole = []");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("for (let i = 0; i < contract._roles.length; i++) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("let isRole = false");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if (contract._roles[i] !== undefined) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("isRole = object._roles.some(obj => obj._name === contract._roles[i]._name && obj._type === contract._roles[i]._type)");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("if (!isRole) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("toRemoveRole.push(contract._roles[i])");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("contract._roles = contract._roles.filter(");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("item => !toRemoveRole.some(");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("other => other._name === item._name && other._type === item._type");
    _builder.newLine();
    _builder.append("     ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("   ");
    _builder.append(");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("//AC for genrtaing certificate for each user, use name as an enrollment ID");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("contract.userList = object.userList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("//AC- acpolicy");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("const ac = new ACPolicy()");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("//ac = object.accessPolicy");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("contract.accessPolicy = ac  ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("//return all objects ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("for (const key of Object.keys(object)) {");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if(key !== \'obligations\' && key !== \'powers\'){");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("if (typeof object[key] === \'object\' && object[key] !== null && !Array.isArray(object[key])) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("for(const eKey of Object.keys(object[key])) {");
    _builder.newLine();
    _builder.append("          \t");
    _builder.append("if(typeof  object[key][eKey] === \'object\' &&  object[key][eKey] !== null){");
    _builder.newLine();
    _builder.append("          \t\t");
    _builder.append("if(object[key][eKey]._type === \'Attribute\'){");
    _builder.newLine();
    _builder.append("             \t\t");
    _builder.append("contract[key][eKey]._value = object[key][eKey]._value");
    _builder.newLine();
    _builder.append("          \t  ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("           \t");
    _builder.append("//if it is a list but it is not controller, bring it back");
    _builder.newLine();
    _builder.append("           \t");
    _builder.append("const x = object[key][eKey]");
    _builder.newLine();
    _builder.append("           \t");
    _builder.append("if(eKey !== \'_controller\'){");
    _builder.newLine();
    _builder.append("                \t");
    _builder.append("if(contract[object[key][eKey]._name] !=  undefined){ ");
    _builder.newLine();
    _builder.append("                 \t\t");
    _builder.append("if(contract[x._name]._type === x._type){");
    _builder.newLine();
    _builder.append("   ");
    _builder.newLine();
    _builder.append("                   \t\t");
    _builder.append("contract[key][eKey] =  contract[x._name]");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("                 \t\t");
    _builder.append("}else{//return objects that does not have type");
    _builder.newLine();
    _builder.append("                 \t\t");
    _builder.newLine();
    _builder.append("                   \t\t");
    _builder.append("if(contract[key][eKey] !=  undefined){");
    _builder.newLine();
    _builder.append("                   \t\t      ");
    _builder.append("contract[key][eKey] = object[key][eKey]");
    _builder.newLine();
    _builder.append("                   \t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                 \t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                                 ");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}else{//return objects that does not have name ");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("if(contract[key] !=  undefined){");
    _builder.newLine();
    _builder.append("                                 ");
    _builder.append("contract[key][eKey] = object[key][eKey]");
    _builder.newLine();
    _builder.append("                               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("               ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}else{//string/numerical and so on ");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("if(contract[key] !=  undefined){");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("contract[key][eKey] = object[key][eKey]");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("             ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("}//nested for");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("   ");
    _builder.append("contract.accessPolicy._rules = object.accessPolicy._rules");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("// internal events (violated, suspended, ..)     ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("for (const eventType of Object.keys(InternalEventType.contract)) {");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("if (object._events[eventType] != null) {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("const eventObject = new Event()");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("eventObject._triggered = object._events[eventType]._triggered");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("eventObject._timestamp = object._events[eventType]._timestamp");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("contract._events[eventType] = eventObject");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      for(final Obligation obligation : this.allObligations) {
        _builder.append("   ");
        _builder.append("if (object.obligations.");
        String _name = obligation.getName();
        _builder.append(_name, "   ");
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("const obligation = new Obligation(\'");
        String _name_1 = obligation.getName();
        _builder.append(_name_1, "       ");
        _builder.append("\', ");
        String _generateDotExpressionString = SymboleoGenerator.generateDotExpressionString(obligation.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString, "       ");
        _builder.append(", ");
        String _generateDotExpressionString_1 = SymboleoGenerator.generateDotExpressionString(obligation.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_1, "       ");
        _builder.append(", contract)");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("obligation.state = object.obligations.");
        String _name_2 = obligation.getName();
        _builder.append(_name_2, "       ");
        _builder.append(".state");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("obligation.activeState = object.obligations.");
        String _name_3 = obligation.getName();
        _builder.append(_name_3, "       ");
        _builder.append(".activeState");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("obligation.consequent = object.obligations.");
        String _name_4 = obligation.getName();
        _builder.append(_name_4, "       ");
        _builder.append(".consequent");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("obligation.antecedent = object.obligations.");
        String _name_5 = obligation.getName();
        _builder.append(_name_5, "       ");
        _builder.append(".antecedent");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("obligation._createdPowerNames = object.obligations.");
        String _name_6 = obligation.getName();
        _builder.append(_name_6, "       ");
        _builder.append("._createdPowerNames");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("obligation._suspendedByContractSuspension = object.obligations.");
        String _name_7 = obligation.getName();
        _builder.append(_name_7, "       ");
        _builder.append("._suspendedByContractSuspension");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("for (const eventType of Object.keys(InternalEventType.obligation)) {");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("      ");
        _builder.append("if (object.obligations.");
        String _name_8 = obligation.getName();
        _builder.append(_name_8, "         ");
        _builder.append("._events[eventType] != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("        ");
        _builder.append("const eventObject = new Event()");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("        ");
        _builder.append("eventObject._triggered = object.obligations.");
        String _name_9 = obligation.getName();
        _builder.append(_name_9, "           ");
        _builder.append("._events[eventType]._triggered");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("        ");
        _builder.append("eventObject._timestamp = object.obligations.");
        String _name_10 = obligation.getName();
        _builder.append(_name_10, "           ");
        _builder.append("._events[eventType]._timestamp");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("        ");
        _builder.append("obligation._events[eventType] = eventObject");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("    ");
        _builder.append("contract.obligations.");
        String _name_11 = obligation.getName();
        _builder.append(_name_11, "       ");
        _builder.append(" = obligation");
        _builder.newLineIfNotEmpty();
        _builder.append("   ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("   ");
    _builder.newLine();
    {
      for(final Obligation obligation_1 : this.allSurvivingObligations) {
        _builder.append("     ");
        _builder.append("if (object.survivingObligations.");
        String _name_12 = obligation_1.getName();
        _builder.append(_name_12, "     ");
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("const obligation = new Obligation(\'");
        String _name_13 = obligation_1.getName();
        _builder.append(_name_13, "       ");
        _builder.append("\', ");
        String _generateDotExpressionString_2 = SymboleoGenerator.generateDotExpressionString(obligation_1.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_2, "       ");
        _builder.append(", ");
        String _generateDotExpressionString_3 = SymboleoGenerator.generateDotExpressionString(obligation_1.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_3, "       ");
        _builder.append(", contract,null, true)");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("obligation.state = object.survivingObligations.");
        String _name_14 = obligation_1.getName();
        _builder.append(_name_14, "       ");
        _builder.append(".state");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("obligation.activeState = object.survivingObligations.");
        String _name_15 = obligation_1.getName();
        _builder.append(_name_15, "       ");
        _builder.append(".activeState");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("obligation._createdPowerNames = object.survivingObligations.");
        String _name_16 = obligation_1.getName();
        _builder.append(_name_16, "       ");
        _builder.append("._createdPowerNames");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("obligation._suspendedByContractSuspension = object.survivingObligations.");
        String _name_17 = obligation_1.getName();
        _builder.append(_name_17, "       ");
        _builder.append("._suspendedByContractSuspension");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("for (const eventType of Object.keys(InternalEventType.obligation)) {");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("    ");
        _builder.append("if (object.survivingObligations.");
        String _name_18 = obligation_1.getName();
        _builder.append(_name_18, "         ");
        _builder.append("._events[eventType] != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("      ");
        _builder.append("const eventObject = new Event()");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("      ");
        _builder.append("eventObject._triggered = object.survivingObligations.");
        String _name_19 = obligation_1.getName();
        _builder.append(_name_19, "           ");
        _builder.append("._events[eventType]._triggered");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("      ");
        _builder.append("eventObject._timestamp = object.survivingObligations.");
        String _name_20 = obligation_1.getName();
        _builder.append(_name_20, "           ");
        _builder.append("._events[eventType]._timestamp");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("      ");
        _builder.append("obligation._events[eventType] = eventObject");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("contract.survivingObligations.");
        String _name_21 = obligation_1.getName();
        _builder.append(_name_21, "       ");
        _builder.append(" = obligation");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("     ");
    _builder.newLine();
    {
      for(final Power power : this.allPowers) {
        _builder.append("     ");
        _builder.append("if (object.powers.");
        String _name_22 = power.getName();
        _builder.append(_name_22, "     ");
        _builder.append(" != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("const power = new Power(\'");
        String _name_23 = power.getName();
        _builder.append(_name_23, "       ");
        _builder.append("\', ");
        String _generateDotExpressionString_4 = SymboleoGenerator.generateDotExpressionString(power.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_4, "       ");
        _builder.append(", ");
        String _generateDotExpressionString_5 = SymboleoGenerator.generateDotExpressionString(power.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_5, "       ");
        _builder.append(", contract)");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("power.state = object.powers.");
        String _name_24 = power.getName();
        _builder.append(_name_24, "       ");
        _builder.append(".state");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("power.activeState = object.powers.");
        String _name_25 = power.getName();
        _builder.append(_name_25, "       ");
        _builder.append(".activeState");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("power.consequent = object.powers.");
        String _name_26 = power.getName();
        _builder.append(_name_26, "       ");
        _builder.append(".consequent");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("power.antecedent = object.powers.");
        String _name_27 = power.getName();
        _builder.append(_name_27, "       ");
        _builder.append(".antecedent");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("for (const eventType of Object.keys(InternalEventType.power)) {");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("    ");
        _builder.append("if (object.powers.");
        String _name_28 = power.getName();
        _builder.append(_name_28, "         ");
        _builder.append("._events[eventType] != null) {");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("      ");
        _builder.append("const eventObject = new Event()");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("      ");
        _builder.append("eventObject._triggered = object.powers.");
        String _name_29 = power.getName();
        _builder.append(_name_29, "           ");
        _builder.append("._events[eventType]._triggered");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("      ");
        _builder.append("eventObject._timestamp = object.powers.");
        String _name_30 = power.getName();
        _builder.append(_name_30, "           ");
        _builder.append("._events[eventType]._timestamp");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("      ");
        _builder.append("power._events[eventType] = eventObject");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("     ");
        _builder.append("  ");
        _builder.append("contract.powers.");
        String _name_31 = power.getName();
        _builder.append(_name_31, "       ");
        _builder.append(" = power");
        _builder.newLineIfNotEmpty();
        _builder.append("     ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("   ");
    _builder.append("const contractList=[");
    final Function1<Variable, String> _function_1 = (Variable v) -> {
      String _name_32 = v.getName();
      String _plus = ("\'" + _name_32);
      return (_plus + "\'");
    };
    String _join_1 = IterableExtensions.join(ListExtensions.<Variable, String>map(this.variables, _function_1), ",");
    _builder.append(_join_1, "   ");
    _builder.append(",\'accessPolicy\']  ");
    _builder.newLineIfNotEmpty();
    _builder.append("   ");
    _builder.append("for (const key of contractList) {");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("if(object[key] === \'undefined\'){");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("continue");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("                   ");
    _builder.append("contract[key]._controller = []");
    _builder.newLine();
    _builder.append("                   ");
    _builder.append("for(const valuet of object[key]._controller) {");
    _builder.newLine();
    _builder.append("                     ");
    _builder.append("contract[key].addController(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("                ");
    _builder.newLine();
    _builder.append("                   ");
    _builder.append("}//for Event");
    _builder.newLine();
    _builder.append("                   ");
    _builder.append("if(contract[key] instanceof Event || (contract[key] instanceof DataTransfer)){");
    _builder.newLine();
    _builder.append("                     ");
    _builder.append("contract[key]._performer = []");
    _builder.newLine();
    _builder.append("                     ");
    _builder.append("for(const valuet of object[key]._performer) {");
    _builder.newLine();
    _builder.append("                     \t");
    _builder.append("contract[key].addPerformer(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("                     ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("                   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("//retrive and add controller to attributes ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("for (const eKey of Object.keys(object[key])) { ");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("let attr = object[key][eKey]");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("if(typeof attr === \'object\' && attr !== null){");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("if(attr._type === \'Attribute\'){");
    _builder.newLine();
    _builder.append("                            ");
    _builder.append("contract[key][eKey]._controller = []");
    _builder.newLine();
    _builder.append("                             ");
    _builder.append("for(const valuet of object[key][eKey]._controller) {");
    _builder.newLine();
    _builder.append("                             ");
    _builder.append("contract[key][eKey].addController(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("                           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("                         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("           ");
    _builder.newLine();
    _builder.append("                 ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("//retrive all obligation and add controllers, performers and so on");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (const key of Object.keys(contract.obligations)){");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("contract.obligations[key]._controller = []");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("for(const valuet of object.obligations[key]._controller) {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("contract.obligations[key].addController(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("contract.obligations[key]._performer = []");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("for(const valuet of object.obligations[key]._performer) {");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("contract.obligations[key].addPerformer(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("            ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("contract.obligations[key]._rightHolder = []");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("for(const valuet of object.obligations[key]._rightHolder) {");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("contract.obligations[key].addRightHolder(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("contract.obligations[key]._liable = []");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("for(const valuet of object.obligations[key]._liable) {");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("contract.obligations[key].addLiable(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("      ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("//power");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("//retrive all power and add controllers, performers and so on");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("for (const key of Object.keys(contract.powers)){");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.powers[key]._controller = []");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("for(const valuet of object.powers[key]._controller) {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract.powers[key].addController(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract.powers[key]._performer = []");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("for(const valuet of object.powers[key]._performer) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("contract.powers[key].addPerformer(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract.powers[key]._rightHolder = []");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("for(const valuet of object.powers[key]._rightHolder) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("contract.powers[key].addRightHolder(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract.powers[key]._liable = []");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("for(const valuet of object.powers[key]._liable) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("contract.powers[key].addLiable(reviverList(valuet)) ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("//add controller to contract ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("contract._controller = []");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("for(obj of object._controller){");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("contract.addController(reviverList(obj)) ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("//retrive all rules of all resourcers ");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("contract.accessPolicy._rules = []");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("for (let i = 0; i < object.accessPolicy._rules.length; i++) {");
    _builder.newLine();
    _builder.append("       ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("let obj = object.accessPolicy._rules[i].accessedResource");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("let accessedResource = obj");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("//retrive rules of obligation and power");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if(object.accessPolicy._rules[i].accessedResource._type.toLowerCase() === \'obligation\' || object.accessPolicy._rules[i].accessedResource._type.toLowerCase() === \'power\'){");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("accessedResource = contract.findLegalPosition(obj.name, obj._type, contract)");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}else{//worked and retrive rules for all resources acccept resources.attribute is in the else");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("if(contract[obj._name] != undefined){");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("accessedResource = contract[obj._name]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("           ");
    _builder.append("accessedResource = contract[obj._parent][obj._name]");
    _builder.newLine();
    _builder.append("         ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("//retrive accessedRole");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("obj = object.accessPolicy._rules[i].accessedRole");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("let accessedRole=obj");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if(obj != undefined){");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("accessedRole = reviverList(obj)");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("//retrive byRole");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("obj = object.accessPolicy._rules[i].byRole");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("let byRole =  obj");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("if(obj != undefined){");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("byRole =  reviverList(obj)");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("contract.accessPolicy.addRulee(object.accessPolicy._rules[i].decision,object.accessPolicy._rules[i].permission, accessedResource, accessedRole, byRole)//worked, added to rules");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.newLine();
    _builder.append("     ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("return contract");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("// to stringify the contract");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("function replacer(key, value) {   ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("if (value === undefined) {     ");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return \"<undefined>\";   }   ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("return value;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("// return roles\' objects from contract that are equavelent to the roles\' objects in the object after parsing contract data (let object = parse(data,reviver)) ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("function reviverList(aController) {  ");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("if(aController._name !== undefined && aController._name !== \'undefined\' && aController !== null  &&  aController !== undefined){");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("return contract.getRole(aController._name, aController._type)");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}else{");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("return null");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("// used in pars function to unify the undefined values  ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("function reviver(key, value) {   ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("if (value === \"<undefined>\") {     ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("return undefined;   ");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return value; ");
    _builder.newLine();
    _builder.append("       ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("function serialize(contract) {");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("for (const key of Object.keys(contract.obligations)){");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("contract.obligations[key].contract = undefined");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("for (const key of Object.keys(contract.powers)){");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("contract.powers[key].contract = undefined");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("for (const key of Object.keys(contract.survivingObligations)){");
    _builder.newLine();
    _builder.append("     ");
    _builder.append("contract.survivingObligations[key].contract = undefined");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("return stringify(contract, replacer, 2); // instead of stringify(contract, null, 2) to solve circular issue when pars the contract");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("}");
    _builder.newLine();
    _builder.append(" ");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("module.exports.deserialize = deserialize");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("module.exports.serialize = serialize");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName_3 = model.getContractName();
    String _plus = ("./" + _contractName_3);
    String _plus_1 = (_plus + "/");
    String _plus_2 = (_plus_1 + "serializer.js");
    fsa.generateFile(_plus_2, code);
  }

  public void compileEventsFile(final IFileSystemAccess2 fsa, final Model model) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("const { LegalSituation, InternalEventSource, InternalEvent, InternalEventType } = require(");
    _builder.append(this.EVENTS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Obligation } = require(");
    _builder.append(this.OBLIGATION_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Power } = require(");
    _builder.append(this.POWER_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Predicates } = require(");
    _builder.append(this.PREDICATES_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Utils } = require(");
    _builder.append(this.UTILS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Str } = require(");
    _builder.append(this.UTILS_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    {
      for(final Enumeration enumeration : this.enumerations) {
        _builder.append("const { ");
        String _name = enumeration.getName();
        _builder.append(_name);
        _builder.append(" } = require(\"./domain/types/");
        String _name_1 = enumeration.getName();
        _builder.append(_name_1);
        _builder.append(".js\")");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("const { ACPolicy } = require(");
    _builder.append(this.ACPolicy_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.append("const { Resource } = require(");
    _builder.append(this.Resource_CLASS_IMPORT_PATH);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("const EventListeners = {");
    _builder.newLine();
    {
      Set<Obligation> _keySet = this.obligationTriggerEvents.keySet();
      for(final Obligation obligation : _keySet) {
        _builder.append("  ");
        _builder.append("createObligation_");
        String _name_2 = obligation.getName();
        _builder.append(_name_2, "  ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (");
        String _generatePropositionString = this.generatePropositionString(obligation.getTrigger());
        _builder.append(_generatePropositionString, "    ");
        _builder.append(") { ");
        String _generatePropositionAssignString = this.generatePropositionAssignString(obligation.getTrigger());
        String _plus = ("\n" + _generatePropositionAssignString);
        _builder.append(_plus, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (contract.obligations.");
        String _name_3 = obligation.getName();
        _builder.append(_name_3, "      ");
        _builder.append(" == null || contract.obligations.");
        String _name_4 = obligation.getName();
        _builder.append(_name_4, "      ");
        _builder.append(".isFinished()) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("const isNewInstance =  contract.obligations.");
        String _name_5 = obligation.getName();
        _builder.append(_name_5, "        ");
        _builder.append(" != null && contract.obligations.");
        String _name_6 = obligation.getName();
        _builder.append(_name_6, "        ");
        _builder.append(".isFinished()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.");
        String _name_7 = obligation.getName();
        _builder.append(_name_7, "        ");
        _builder.append("Situation = new LegalSituation();");
        _builder.newLineIfNotEmpty();
        {
          Proposition _consequent = obligation.getConsequent();
          boolean _not = (!(_consequent instanceof PAtomPredicateTrueLiteral));
          if (_not) {
            Proposition _consequent_1 = obligation.getConsequent();
            String _name_8 = obligation.getName();
            String _plus_1 = ("contract." + _name_8);
            String _plus_2 = (_plus_1 + "Situation.addConsequentOf(");
            String _generateLegalpositionCondition = this.generateLegalpositionCondition(_consequent_1, _plus_2);
            _builder.append(_generateLegalpositionCondition);
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          Proposition _antecedent = obligation.getAntecedent();
          boolean _not_1 = (!(_antecedent instanceof PAtomPredicateTrueLiteral));
          if (_not_1) {
            _builder.append("  ");
            _builder.append("      ");
            Proposition _antecedent_1 = obligation.getAntecedent();
            String _name_9 = obligation.getName();
            String _plus_3 = ("contract." + _name_9);
            String _plus_4 = (_plus_3 + "Situation.addAntecedentOf(");
            String _generateLegalpositionCondition_1 = this.generateLegalpositionCondition(_antecedent_1, _plus_4);
            _builder.append(_generateLegalpositionCondition_1, "        ");
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append("       ");
        _builder.append("contract.obligations.");
        String _name_10 = obligation.getName();
        _builder.append(_name_10, "         ");
        _builder.append(" = new Obligation(\'");
        String _name_11 = obligation.getName();
        _builder.append(_name_11, "         ");
        _builder.append("\', ");
        String _generateDotExpressionString = SymboleoGenerator.generateDotExpressionString(obligation.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString, "         ");
        _builder.append(", ");
        String _generateDotExpressionString_1 = SymboleoGenerator.generateDotExpressionString(obligation.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_1, "         ");
        _builder.append(", contract, contract.");
        String _name_12 = obligation.getName();
        _builder.append(_name_12, "         ");
        _builder.append("Situation)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("       ");
        String _specifiedControllerObligation = this.getSpecifiedControllerObligation(obligation, "contract");
        _builder.append(_specifiedControllerObligation, "         ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("       ");
        String _specifiedRulesCondObligation = this.getSpecifiedRulesCondObligation(obligation, model);
        _builder.append(_specifiedRulesCondObligation, "         ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("if (");
        String _xifexpression = null;
        Proposition _antecedent_2 = obligation.getAntecedent();
        if ((_antecedent_2 instanceof PAtomPredicateTrueLiteral)) {
          _xifexpression = "true";
        } else {
          String _generatePropositionString_ante = this.generatePropositionString(obligation.getAntecedent());
          _xifexpression = (("!isNewInstance && (" + _generatePropositionString_ante) + ")");
        }
        _builder.append(_xifexpression, "        ");
        _builder.append(" ) { ");
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(obligation.getAntecedent());
        String _plus_5 = ("\n" + _generatePropositionAssignString_1);
        _builder.append(_plus_5, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.obligations.");
        String _name_13 = obligation.getName();
        _builder.append(_name_13, "          ");
        _builder.append(".trigerredUnconditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("let transitionState = contract.obligations.");
        String _name_14 = obligation.getName();
        _builder.append(_name_14, "          ");
        _builder.append(".state;");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("if (!isNewInstance && ");
        String _generatePropositionString_1 = this.generatePropositionString(obligation.getConsequent());
        _builder.append(_generatePropositionString_1, "          ");
        _builder.append(") { ");
        String _generatePropositionAssignString_2 = this.generatePropositionAssignString(obligation.getConsequent());
        String _plus_6 = ("\n" + _generatePropositionAssignString_2);
        _builder.append(_plus_6, "          ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.append("contract.obligations.");
        String _name_15 = obligation.getName();
        _builder.append(_name_15, "            ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        String _name_16 = obligation.getName();
        String obName = ("contract.obligations." + _name_16);
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.append("let controllers = contract.obligations.");
        String _name_17 = obligation.getName();
        _builder.append(_name_17, "            ");
        _builder.append("._controller");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("     \t\t");
        _builder.append("//notify");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("     \t\t");
        _builder.append("let MSG= transitionState+\" Changed to \"+");
        _builder.append(obName, "       \t\t");
        _builder.append(".state+\",\"+");
        _builder.append(obName, "       \t\t");
        _builder.append(".name+\", \" + ");
        _builder.append(obName, "       \t\t");
        _builder.append(".contract.id;");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("     \t\t");
        _builder.append("contract.notified.message.push({name: \'");
        _builder.append(obName, "       \t\t");
        _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
        _builder.append(obName, "       \t\t");
        _builder.append(",[");
        _builder.append(obName, "       \t\t");
        _builder.append(".creditor,");
        _builder.append(obName, "       \t\t");
        _builder.append(".debtor],");
        _builder.append(obName, "       \t\t");
        _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()})         ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.obligations.");
        String _name_18 = obligation.getName();
        _builder.append(_name_18, "          ");
        _builder.append(".trigerredConditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_1 = this.survivingObligationTriggerEvents.keySet();
      for(final Obligation obligation_1 : _keySet_1) {
        _builder.append("  ");
        _builder.append("createSurvivingObligation_");
        String _name_19 = obligation_1.getName();
        _builder.append(_name_19, "  ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (");
        String _generatePropositionString_2 = this.generatePropositionString(obligation_1.getTrigger());
        _builder.append(_generatePropositionString_2, "    ");
        _builder.append(") { ");
        String _generatePropositionAssignString_3 = this.generatePropositionAssignString(obligation_1.getTrigger());
        String _plus_7 = ("\n" + _generatePropositionAssignString_3);
        _builder.append(_plus_7, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (contract.survivingObligations.");
        String _name_20 = obligation_1.getName();
        _builder.append(_name_20, "      ");
        _builder.append(" == null || contract.survivingObligations.");
        String _name_21 = obligation_1.getName();
        _builder.append(_name_21, "      ");
        _builder.append(".isFinished()) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("const isNewInstance =  contract.survivingObligations.");
        String _name_survInst1 = obligation_1.getName();
        _builder.append(_name_survInst1, "        ");
        _builder.append(" != null && contract.survivingObligations.");
        String _name_survInst2 = obligation_1.getName();
        _builder.append(_name_survInst2, "        ");
        _builder.append(".isFinished()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.survivingObligations.");
        String _name_22 = obligation_1.getName();
        _builder.append(_name_22, "        ");
        _builder.append(" = new Obligation(\'");
        String _name_23 = obligation_1.getName();
        _builder.append(_name_23, "        ");
        _builder.append("\', ");
        String _generateDotExpressionString_2 = SymboleoGenerator.generateDotExpressionString(obligation_1.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_2, "        ");
        _builder.append(", ");
        String _generateDotExpressionString_3 = SymboleoGenerator.generateDotExpressionString(obligation_1.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_3, "        ");
        _builder.append(", contract,null, true)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("       ");
        String _specifiedControllerObligation_1 = this.getSpecifiedControllerObligation(obligation_1, "contract");
        _builder.append(_specifiedControllerObligation_1, "         ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("       ");
        String _specifiedRulesCondObligation_1 = this.getSpecifiedRulesCondObligation(obligation_1, model);
        _builder.append(_specifiedRulesCondObligation_1, "         ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("if (");
        String _generatePropositionString_3 = this.generatePropositionString(obligation_1.getAntecedent());
        _builder.append(_generatePropositionString_3, "        ");
        _builder.append(") { ");
        String _generatePropositionAssignString_4 = this.generatePropositionAssignString(obligation_1.getAntecedent());
        String _plus_8 = ("\n" + _generatePropositionAssignString_4);
        _builder.append(_plus_8, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.survivingObligations.");
        String _name_24 = obligation_1.getName();
        _builder.append(_name_24, "          ");
        _builder.append(".trigerredUnconditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("//AC");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("let transitionState = contract.survivingObligations.");
        String _name_25 = obligation_1.getName();
        _builder.append(_name_25, "          ");
        _builder.append(".state;");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        String _xifexpression_1 = null;
        Proposition _consequent_2 = obligation_1.getConsequent();
        if ((_consequent_2 instanceof PAtomPredicate)) {
          _xifexpression_1 = "";
        } else {
          String _generatePropositionString_4 = this.generatePropositionString(obligation_1.getAntecedent());
          String _plus_9 = (" if ( !isNewInstance &&" + _generatePropositionString_4);
          _xifexpression_1 = (_plus_9 + ")");
        }
        _builder.append(_xifexpression_1, "          ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("if (");
        String _generatePropositionString_5 = this.generatePropositionString(obligation_1.getConsequent());
        _builder.append(_generatePropositionString_5, "          ");
        _builder.append(" ) { ");
        String _generatePropositionAssignString_5 = this.generatePropositionAssignString(obligation_1.getConsequent());
        String _plus_10 = ("\n" + _generatePropositionAssignString_5);
        _builder.append(_plus_10, "          ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.append("contract.survivingObligations.");
        String _name_26 = obligation_1.getName();
        _builder.append(_name_26, "            ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.append("//AC");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("          ");
        String _name_27 = obligation_1.getName();
        String obName_1 = ("contract.survivingObligations." + _name_27);
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.append("let controllers = contract.survivingObligations.");
        String _name_28 = obligation_1.getName();
        _builder.append(_name_28, "            ");
        _builder.append("._controller");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.append("//notify");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("           ");
        _builder.append("let MSG= transitionState+\" Changed to \"+");
        _builder.append(obName_1, "             ");
        _builder.append(".state+\",\"+");
        _builder.append(obName_1, "             ");
        _builder.append(".name+\", \" + ");
        _builder.append(obName_1, "             ");
        _builder.append(".contract.id;");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("           ");
        _builder.append("contract.notified.message.push({name: \'");
        _builder.append(obName_1, "             ");
        _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
        _builder.append(obName_1, "             ");
        _builder.append(",[");
        _builder.append(obName_1, "             ");
        _builder.append(".creditor,");
        _builder.append(obName_1, "             ");
        _builder.append(".debtor],");
        _builder.append(obName_1, "             ");
        _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()})         ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("          ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.survivingObligations.");
        String _name_29 = obligation_1.getName();
        _builder.append(_name_29, "          ");
        _builder.append(".trigerredConditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Power> _keySet_2 = this.powerTriggerEvents.keySet();
      for(final Power power : _keySet_2) {
        _builder.append("  ");
        _builder.append("createPower_");
        String _name_30 = power.getName();
        _builder.append(_name_30, "  ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("const effects = { powerCreated: false }");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (");
        String _generatePropositionString_6 = this.generatePropositionString(power.getTrigger());
        _builder.append(_generatePropositionString_6, "    ");
        _builder.append(") { ");
        String _generatePropositionAssignString_6 = this.generatePropositionAssignString(power.getTrigger());
        String _plus_11 = ("\n" + _generatePropositionAssignString_6);
        _builder.append(_plus_11, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("if (contract.powers.");
        String _name_31 = power.getName();
        _builder.append(_name_31, "      ");
        _builder.append(" == null || contract.powers.");
        String _name_32 = power.getName();
        _builder.append(_name_32, "      ");
        _builder.append(".isFinished()){");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("const isNewInstance =  contract.powers.");
        String _name_33 = power.getName();
        _builder.append(_name_33, "        ");
        _builder.append(" != null && contract.powers.");
        String _name_34 = power.getName();
        _builder.append(_name_34, "        ");
        _builder.append(".isFinished()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.");
        String _name_35 = power.getName();
        _builder.append(_name_35, "        ");
        _builder.append("Situation = new LegalSituation();            ");
        _builder.newLineIfNotEmpty();
        {
          Proposition _antecedent_3 = power.getAntecedent();
          boolean _not_2 = (!(_antecedent_3 instanceof PAtomPredicateTrueLiteral));
          if (_not_2) {
            Proposition _antecedent_4 = power.getAntecedent();
            String _name_36 = power.getName();
            String _plus_12 = ("contract." + _name_36);
            String _plus_13 = (_plus_12 + "Situation.addAntecedentOf(");
            String _generateLegalpositionCondition_2 = this.generateLegalpositionCondition(_antecedent_4, _plus_13);
            _builder.append(_generateLegalpositionCondition_2);
            _builder.append(" ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.");
        String _name_37 = power.getName();
        _builder.append(_name_37, "        ");
        _builder.append("Situation.addConsequentOf({_type: \'stateCondition\',");
        String _compilePowerCondition = this.compilePowerCondition(power.getConsequent());
        _builder.append(_compilePowerCondition, "        ");
        _builder.append("})");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("contract.powers.");
        String _name_38 = power.getName();
        _builder.append(_name_38, "        ");
        _builder.append(" = new Power(\'");
        String _name_39 = power.getName();
        _builder.append(_name_39, "        ");
        _builder.append("\', ");
        String _generateDotExpressionString_4 = SymboleoGenerator.generateDotExpressionString(power.getCreditor(), "contract");
        _builder.append(_generateDotExpressionString_4, "        ");
        _builder.append(", ");
        String _generateDotExpressionString_5 = SymboleoGenerator.generateDotExpressionString(power.getDebtor(), "contract");
        _builder.append(_generateDotExpressionString_5, "        ");
        _builder.append(", contract, contract.");
        String _name_40 = power.getName();
        _builder.append(_name_40, "        ");
        _builder.append("Situation)");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("effects.powerCreated = true");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("effects.powerName = \'");
        String _name_41 = power.getName();
        _builder.append(_name_41, "        ");
        _builder.append("\'");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        String _specifiedControllerPower = this.getSpecifiedControllerPower(power, "contract");
        _builder.append(_specifiedControllerPower, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        String _specifiedRulesCondPower = this.getSpecifiedRulesCondPower(power, model);
        _builder.append(_specifiedRulesCondPower, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("if (");
        String _xifexpression_2 = null;
        Proposition _antecedent_5 = power.getAntecedent();
        if ((_antecedent_5 instanceof PAtomPredicateTrueLiteral)) {
          _xifexpression_2 = "true";
        } else {
          String _generatePropositionString_7 = this.generatePropositionString(power.getAntecedent());
          _xifexpression_2 = ("!isNewInstance && " + _generatePropositionString_7);
        }
        _builder.append(_xifexpression_2, "        ");
        _builder.append(" ) { ");
        String _generatePropositionAssignString_7 = this.generatePropositionAssignString(power.getAntecedent());
        String _plus_14 = ("\n" + _generatePropositionAssignString_7);
        _builder.append(_plus_14, "        ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.powers.");
        String _name_42 = power.getName();
        _builder.append(_name_42, "          ");
        _builder.append(".trigerredUnconditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("} else {");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("        ");
        _builder.append("contract.powers.");
        String _name_43 = power.getName();
        _builder.append(_name_43, "          ");
        _builder.append(".trigerredConditional()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("      ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("return effects");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_3 = this.obligationAntecedentEvents.keySet();
      for(final Obligation obligation_2 : _keySet_3) {
        _builder.append("  ");
        _builder.append("activateObligation_");
        String _name_44 = obligation_2.getName();
        _builder.append(_name_44, "  ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("  ");
        _builder.append("if (contract.obligations.");
        String _name_45 = obligation_2.getName();
        _builder.append(_name_45, "    ");
        _builder.append(" != null && (");
        String _generatePropositionString_8 = this.generatePropositionString(obligation_2.getAntecedent());
        _builder.append(_generatePropositionString_8, "    ");
        _builder.append(")) { ");
        String _generatePropositionAssignString_8 = this.generatePropositionAssignString(obligation_2.getAntecedent());
        String _plus_15 = ("\n" + _generatePropositionAssignString_8);
        _builder.append(_plus_15, "    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("    ");
        _builder.append("contract.obligations.");
        String _name_46 = obligation_2.getName();
        _builder.append(_name_46, "      ");
        _builder.append(".activated()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("                  ");
        _builder.append("if (");
        String _generatePropositionString_9 = this.generatePropositionString(obligation_2.getConsequent());
        _builder.append(_generatePropositionString_9, "                    ");
        _builder.append(") { ");
        String _generatePropositionAssignString_9 = this.generatePropositionAssignString(obligation_2.getConsequent());
        String _plus_16 = ("\n" + _generatePropositionAssignString_9);
        _builder.append(_plus_16, "                    ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("                    ");
        _builder.append("//AC");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("                    ");
        _builder.append("let transitionState = contract.obligations.");
        String _name_47 = obligation_2.getName();
        _builder.append(_name_47, "                      ");
        _builder.append(".state;");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("                    ");
        _builder.append("contract.obligations.");
        String _name_48 = obligation_2.getName();
        _builder.append(_name_48, "                      ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("                    ");
        _builder.append("//AC");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("                    ");
        _builder.append("let controllers = contract.obligations.");
        String _name_49 = obligation_2.getName();
        _builder.append(_name_49, "                      ");
        _builder.append("._controller");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("                    ");
        String _name_50 = obligation_2.getName();
        String obName_2 = ("contract.obligations." + _name_50);
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("               \t\t");
        _builder.append("//notify");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("               \t\t");
        _builder.append("let MSG= transitionState+\" Changed to \"+");
        _builder.append(obName_2, "                 \t\t");
        _builder.append(".state+\",\"+");
        _builder.append(obName_2, "                 \t\t");
        _builder.append(".name+\", \" + ");
        _builder.append(obName_2, "                 \t\t");
        _builder.append(".contract.id;");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("               \t\t");
        _builder.append("contract.notified.message.push({name: \'");
        _builder.append(obName_2, "                 \t\t");
        _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
        _builder.append(obName_2, "                 \t\t");
        _builder.append(",[");
        _builder.append(obName_2, "                 \t\t");
        _builder.append(".creditor,");
        _builder.append(obName_2, "                 \t\t");
        _builder.append(".debtor],");
        _builder.append(obName_2, "                 \t\t");
        _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()}) ");
        _builder.newLineIfNotEmpty();
        _builder.append("  ");
        _builder.append("                    ");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("                  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("                ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("  ");
        _builder.append("              ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_4 = this.survivingObligationAntecedentEvents.keySet();
      for(final Obligation obligation_3 : _keySet_4) {
        _builder.append("                ");
        _builder.append("activateSurvivingObligation_");
        String _name_51 = obligation_3.getName();
        _builder.append(_name_51, "                ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("  ");
        _builder.append("if (contract.survivingObligations.");
        String _name_52 = obligation_3.getName();
        _builder.append(_name_52, "                  ");
        _builder.append(" != null  && (");
        String _generatePropositionString_10 = this.generatePropositionString(obligation_3.getAntecedent());
        _builder.append(_generatePropositionString_10, "                  ");
        _builder.append(")  ) { ");
        String _generatePropositionAssignString_10 = this.generatePropositionAssignString(obligation_3.getAntecedent());
        String _plus_17 = ("\n" + _generatePropositionAssignString_10);
        _builder.append(_plus_17, "                  ");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("contract.survivingObligations.");
        String _name_53 = obligation_3.getName();
        _builder.append(_name_53, "                    ");
        _builder.append(".activated()");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("if (");
        String _generatePropositionString_11 = this.generatePropositionString(obligation_3.getConsequent());
        _builder.append(_generatePropositionString_11, "                    ");
        _builder.append(") { ");
        String _generatePropositionAssignString_11 = this.generatePropositionAssignString(obligation_3.getConsequent());
        String _plus_18 = ("\n" + _generatePropositionAssignString_11);
        _builder.append(_plus_18, "                    ");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("      ");
        _builder.append("let transitionState = contract.survivingObligations.");
        String _name_54 = obligation_3.getName();
        _builder.append(_name_54, "                      ");
        _builder.append(".state;");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("      ");
        _builder.append("contract.survivingObligations.");
        String _name_55 = obligation_3.getName();
        _builder.append(_name_55, "                      ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("      ");
        _builder.append("let controllers = contract.survivingObligations.");
        String _name_56 = obligation_3.getName();
        _builder.append(_name_56, "                      ");
        _builder.append("._controller");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("      ");
        String _name_57 = obligation_3.getName();
        String obName_3 = ("contract.survivingObligations." + _name_57);
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append(" \t\t");
        _builder.append("//notify");
        _builder.newLine();
        _builder.append("                ");
        _builder.append(" \t\t");
        _builder.append("let MSG= transitionState+\" Changed to \"+");
        _builder.append(obName_3, "                 \t\t");
        _builder.append(".state+\",\"+");
        _builder.append(obName_3, "                 \t\t");
        _builder.append(".name+\", \" + ");
        _builder.append(obName_3, "                 \t\t");
        _builder.append(".contract.id;");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append(" \t\t");
        _builder.append("contract.notified.message.push({name: \'");
        _builder.append(obName_3, "                 \t\t");
        _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
        _builder.append(obName_3, "                 \t\t");
        _builder.append(",[");
        _builder.append(obName_3, "                 \t\t");
        _builder.append(".creditor,");
        _builder.append(obName_3, "                 \t\t");
        _builder.append(".debtor],");
        _builder.append(obName_3, "                 \t\t");
        _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()}) ");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Power> _keySet_5 = this.powerAntecedentEvents.keySet();
      for(final Power power_1 : _keySet_5) {
        _builder.append("                ");
        _builder.append("activatePower_");
        String _name_58 = power_1.getName();
        _builder.append(_name_58, "                ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("  ");
        _builder.append("if (contract.powers.");
        String _name_59 = power_1.getName();
        _builder.append(_name_59, "                  ");
        _builder.append(" != null && (");
        String _generatePropositionString_12 = this.generatePropositionString(power_1.getAntecedent());
        _builder.append(_generatePropositionString_12, "                  ");
        _builder.append(")) {  ");
        String _generatePropositionAssignString_12 = this.generatePropositionAssignString(power_1.getAntecedent());
        String _plus_19 = ("\n" + _generatePropositionAssignString_12);
        _builder.append(_plus_19, "                  ");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("contract.powers.");
        String _name_60 = power_1.getName();
        _builder.append(_name_60, "                    ");
        _builder.append(".activated()");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_6 = this.obligationFullfilmentEvents.keySet();
      for(final Obligation obligation_4 : _keySet_6) {
        _builder.append("                ");
        _builder.append("fulfillObligation_");
        String _name_61 = obligation_4.getName();
        _builder.append(_name_61, "                ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("  ");
        _builder.append("if (contract.obligations.");
        String _name_62 = obligation_4.getName();
        _builder.append(_name_62, "                  ");
        _builder.append(" != null && (");
        String _generatePropositionString_13 = this.generatePropositionString(obligation_4.getConsequent());
        _builder.append(_generatePropositionString_13, "                  ");
        _builder.append(") ) { ");
        String _generatePropositionAssignString_13 = this.generatePropositionAssignString(obligation_4.getConsequent());
        String _plus_20 = ("\n" + _generatePropositionAssignString_13);
        _builder.append(_plus_20, "                  ");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("let transitionState = contract.obligations.");
        String _name_63 = obligation_4.getName();
        _builder.append(_name_63, "                    ");
        _builder.append(".state;");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("contract.obligations.");
        String _name_64 = obligation_4.getName();
        _builder.append(_name_64, "                    ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("      ");
        _builder.append("let controllers = contract.obligations.");
        String _name_65 = obligation_4.getName();
        _builder.append(_name_65, "                      ");
        _builder.append("._controller");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("      ");
        String _name_66 = obligation_4.getName();
        String obName_4 = ("contract.obligations." + _name_66);
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append(" \t\t");
        _builder.append("//notify");
        _builder.newLine();
        _builder.append("                ");
        _builder.append(" \t\t");
        _builder.append("let MSG= transitionState+\" Changed to \"+");
        _builder.append(obName_4, "                 \t\t");
        _builder.append(".state+\",\"+");
        _builder.append(obName_4, "                 \t\t");
        _builder.append(".name+\", \" + ");
        _builder.append(obName_4, "                 \t\t");
        _builder.append(".contract.id;");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append(" \t\t");
        _builder.append("contract.notified.message.push({name: \'");
        _builder.append(obName_4, "                 \t\t");
        _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
        _builder.append(obName_4, "                 \t\t");
        _builder.append(",[");
        _builder.append(obName_4, "                 \t\t");
        _builder.append(".creditor,");
        _builder.append(obName_4, "                 \t\t");
        _builder.append(".debtor],");
        _builder.append(obName_4, "                 \t\t");
        _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()}) ");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    {
      Set<Obligation> _keySet_7 = this.survivingObligationFullfilmentEvents.keySet();
      for(final Obligation obligation_5 : _keySet_7) {
        _builder.append("                ");
        _builder.append("fulfillSurvivingObligation_");
        String _name_67 = obligation_5.getName();
        _builder.append(_name_67, "                ");
        _builder.append("(contract) {");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("  ");
        _builder.append("if (contract.survivingObligations.");
        String _name_68 = obligation_5.getName();
        _builder.append(_name_68, "                  ");
        _builder.append(" != null && ");
        String _generatePropositionString_14 = this.generatePropositionString(obligation_5.getConsequent());
        _builder.append(_generatePropositionString_14, "                  ");
        _builder.append(" ) { ");
        String _generatePropositionAssignString_14 = this.generatePropositionAssignString(obligation_5.getConsequent());
        String _plus_21 = ("\n" + _generatePropositionAssignString_14);
        _builder.append(_plus_21, "                  ");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("let transitionState = contract.survivingObligations.");
        String _name_69 = obligation_5.getName();
        _builder.append(_name_69, "                    ");
        _builder.append(".state;");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("contract.survivingObligations.");
        String _name_70 = obligation_5.getName();
        _builder.append(_name_70, "                    ");
        _builder.append(".fulfilled()");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.append("//AC");
        _builder.newLine();
        _builder.append("\t                          ");
        _builder.append("let controllers = contract.survivingObligations.");
        String _name_71 = obligation_5.getName();
        _builder.append(_name_71, "\t                          ");
        _builder.append("._controller");
        _builder.newLineIfNotEmpty();
        _builder.append("\t                          ");
        String _name_72 = obligation_5.getName();
        String obName_5 = ("contract.survivingObligations." + _name_72);
        _builder.newLineIfNotEmpty();
        _builder.append("\t                     \t\t");
        _builder.append("//notify");
        _builder.newLine();
        _builder.append("\t                     \t\t");
        _builder.append("let MSG= transitionState+\" Changed to \"+");
        _builder.append(obName_5, "\t                     \t\t");
        _builder.append(".state+\",\"+");
        _builder.append(obName_5, "\t                     \t\t");
        _builder.append(".name+\", \" + ");
        _builder.append(obName_5, "\t                     \t\t");
        _builder.append(".contract.id;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t                     \t\t");
        _builder.append("contract.notified.message.push({name: \'");
        _builder.append(obName_5, "\t                     \t\t");
        _builder.append("\', message: MSG, roles:contract.accessPolicy.permissionValid(");
        _builder.append(obName_5, "\t                     \t\t");
        _builder.append(",[");
        _builder.append(obName_5, "\t                     \t\t");
        _builder.append(".creditor,");
        _builder.append(obName_5, "\t                     \t\t");
        _builder.append(".debtor],");
        _builder.append(obName_5, "\t                     \t\t");
        _builder.append(".getController(controllers.length - 1), contract) , time: new Date().toISOString()}) ");
        _builder.newLineIfNotEmpty();
        _builder.append("                ");
        _builder.append("    ");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("                ");
        _builder.append("},");
        _builder.newLine();
      }
    }
    _builder.append("                ");
    _builder.append("successfullyTerminateContract(contract) {");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("for (const oblKey of Object.keys(contract.obligations)) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if (contract.obligations[oblKey].isActive()) {");
    _builder.newLine();
    _builder.append("                      ");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("if (contract.obligations[oblKey].isViolated() && Array.isArray(contract.obligations[oblKey]._createdPowerNames)) {");
    _builder.newLine();
    _builder.append("                      ");
    _builder.append("for (const pKey of contract.obligations[oblKey]._createdPowerNames) {");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("if (!contract.powers[pKey].isSuccessfulTermination()) {");
    _builder.newLine();
    _builder.append("                          ");
    _builder.append("return;");
    _builder.newLine();
    _builder.append("                        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("contract.fulfilledActiveObligations()");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("// if all the obligations are fullfilled (this include the notification on their functions in the listner in events) so the contract will be terminate successfully. Then");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("// the roles must be notified by only contract state");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("// contract notification");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("let controllers = contract._controller");
    _builder.newLine();
    _builder.append("             \t\t");
    _builder.append("//notify");
    _builder.newLine();
    _builder.append("             \t\t");
    _builder.append("let MSG= \" Contract \"+contract.name+\" is Successfully Terminated,\"+\", \" + contract.id;");
    _builder.newLine();
    _builder.append("             \t\t");
    _builder.append("contract.notified.message.push({name: contract.name, message: MSG, roles:contract.accessPolicy.permissionValid(contract,controllers,contract.getController(controllers.length - 1), contract) , time: new Date().toISOString()}) ");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("unsuccessfullyTerminateContract(contract) {");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("for (let index in contract.obligations) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("contract.obligations[index].terminated({emitEvent: false})");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("let obl=contract.obligations[index]");
    _builder.newLine();
    _builder.append("                      ");
    _builder.append("let controllers = obl._controller");
    _builder.newLine();
    _builder.append("  \t                 \t  ");
    _builder.append("//notify");
    _builder.newLine();
    _builder.append("  \t                 \t  ");
    _builder.append("let MSG= \" Power \"+obl.name+\" is \"+obl.state+ \" because contract is terminated unsuccessfully,\"+\", \" + obl.contract.id;");
    _builder.newLine();
    _builder.append("  \t                 \t  ");
    _builder.append("contract.notified.message.push({name: obl.name, message: MSG, roles:contract.accessPolicy.permissionValid(obl,controllers,obl.getController(controllers.length - 1), contract) , time: new Date().toISOString()}) ");
    _builder.newLine();
    _builder.append("                                             ");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("for (let index in contract.powers) {");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("contract.powers[index].terminated()");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("let power=contract.powers[index]");
    _builder.newLine();
    _builder.append("                    ");
    _builder.append("let controllers = power._controller");
    _builder.newLine();
    _builder.append("\t                 \t  ");
    _builder.append("//notify");
    _builder.newLine();
    _builder.append("\t                 \t  ");
    _builder.append("let MSG= \" Power \"+power.name+\" is \"+power.state+ \" because contract is terminated unsuccessfully,\"+\", \" + power.contract.id;");
    _builder.newLine();
    _builder.append("\t                 \t  ");
    _builder.append("contract.notified.message.push({name: power.name, message: MSG, roles:contract.accessPolicy.permissionValid(power,controllers,power.getController(controllers.length - 1), contract) , time: new Date().toISOString()}) ");
    _builder.newLine();
    _builder.append("                    ");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("contract.terminated()");
    _builder.newLine();
    _builder.append("                  ");
    _builder.append("let controllers = contract._controller");
    _builder.newLine();
    _builder.append("             \t\t");
    _builder.append("//notify");
    _builder.newLine();
    _builder.append("             \t\t");
    _builder.append("let MSG= \" Contract \"+contract.name+\" is Unsuccessfully Terminated,\"+\", \" + contract.id;");
    _builder.newLine();
    _builder.append("             \t\t");
    _builder.append("contract.notified.message.push({name: contract.name, message: MSG, roles:contract.accessPolicy.permissionValid(contract,controllers,contract.getController(controllers.length - 1), contract) , time: new Date().toISOString()}) ");
    _builder.newLine();
    _builder.append("                  ");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("}     ");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("              ");
    _builder.newLine();
    _builder.append("              ");
    String _compileEventsMap = this.compileEventsMap();
    _builder.append(_compileEventsMap, "              ");
    _builder.newLineIfNotEmpty();
    _builder.append("              ");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("module.exports.EventListeners = EventListeners");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("module.exports.getEventMap = getEventMap");
    _builder.newLine();
    final String code = _builder.toString();
    String _contractName = model.getContractName();
    String _plus_22 = ("./" + _contractName);
    String _plus_23 = (_plus_22 + "/");
    String _plus_24 = (_plus_23 + "events.js");
    fsa.generateFile(_plus_24, code);
  }

  @Override
  public String generateExpressionString(final Expression argExpression, final String thisString) {
    boolean _matched = false;
    if (argExpression instanceof Or) {
      _matched=true;
      String _generateExpressionString = this.generateExpressionString(((Or)argExpression).getLeft(), thisString);
      String _plus = (_generateExpressionString + " || ");
      String _generateExpressionString_1 = this.generateExpressionString(((Or)argExpression).getRight(), thisString);
      return (_plus + _generateExpressionString_1);
    }
    if (!_matched) {
      if (argExpression instanceof And) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((And)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " && ");
        String _generateExpressionString_1 = this.generateExpressionString(((And)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Equality) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Equality)argExpression).getLeft(), thisString);
        String _equalityOperator = this.getEqualityOperator(((Equality)argExpression).getOp());
        String _plus = (_generateExpressionString + _equalityOperator);
        String _generateExpressionString_1 = this.generateExpressionString(((Equality)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Comparison) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Comparison)argExpression).getLeft(), thisString);
        String _op = ((Comparison)argExpression).getOp();
        String _plus = (_generateExpressionString + _op);
        String _generateExpressionString_1 = this.generateExpressionString(((Comparison)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Plus) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Plus)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " + ");
        String _generateExpressionString_1 = this.generateExpressionString(((Plus)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Minus) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Minus)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " - ");
        String _generateExpressionString_1 = this.generateExpressionString(((Minus)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Multi) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Multi)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " * ");
        String _generateExpressionString_1 = this.generateExpressionString(((Multi)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Div) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Div)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " / ");
        String _generateExpressionString_1 = this.generateExpressionString(((Div)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof Mod) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((Mod)argExpression).getLeft(), thisString);
        String _plus = (_generateExpressionString + " % ");
        String _generateExpressionString_1 = this.generateExpressionString(((Mod)argExpression).getRight(), thisString);
        return (_plus + _generateExpressionString_1);
      }
    }
    if (!_matched) {
      if (argExpression instanceof PrimaryExpressionRecursive) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((PrimaryExpressionRecursive)argExpression).getInner(), thisString);
        String _plus = ("(" + _generateExpressionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (argExpression instanceof PrimaryExpressionFunctionCall) {
        _matched=true;
        return this.generateFunctionCall(((PrimaryExpressionFunctionCall)argExpression), thisString);
      }
    }
    if (!_matched) {
      if (argExpression instanceof NegatedPrimaryExpression) {
        _matched=true;
        String _generateExpressionString = this.generateExpressionString(((NegatedPrimaryExpression)argExpression).getExpression(), thisString);
        String _plus = ("!(" + _generateExpressionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionTrue) {
        _matched=true;
        return "true";
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionFalse) {
        _matched=true;
        return "false";
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionDouble) {
        _matched=true;
        return Double.valueOf(((AtomicExpressionDouble)argExpression).getValue()).toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionInt) {
        _matched=true;
        return Integer.valueOf(((AtomicExpressionInt)argExpression).getValue()).toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionDate) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(new Date(\"");
        String _string = ((AtomicExpressionDate)argExpression).getValue().toInstant().toString();
        _builder.append(_string);
        _builder.append("\").toISOString())");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionEnum) {
        _matched=true;
        Enumeration _enumeration = ((AtomicExpressionEnum)argExpression).getEnumeration();
        String _plus = (_enumeration + ".");
        EnumItem _enumItem = ((AtomicExpressionEnum)argExpression).getEnumItem();
        return (_plus + _enumItem);
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionString) {
        _matched=true;
        String _value = ((AtomicExpressionString)argExpression).getValue();
        String _plus = ("\"" + _value);
        return (_plus + "\"");
      }
    }
    if (!_matched) {
      if (argExpression instanceof AtomicExpressionParameter) {
        _matched=true;
        return SymboleoGenerator.generateDotExpressionString(((AtomicExpressionParameter)argExpression).getValue(), thisString);
      }
    }
    return null;
  }

  @Override
  public String generateFunctionCall(final PrimaryExpressionFunctionCall argFunctionCallExp, final String thisString) {
    final FunctionCall functionCall = argFunctionCallExp.getFunction();
    boolean _matched = false;
    if (functionCall instanceof TwoArgMathFunction) {
      _matched=true;
      String _name = ((TwoArgMathFunction)functionCall).getName();
      String _plus = (_name + "(");
      String _generateExpressionString = this.generateExpressionString(((TwoArgMathFunction)functionCall).getArg1(), thisString);
      String _plus_1 = (_plus + _generateExpressionString);
      String _plus_2 = (_plus_1 + ",");
      String _generateExpressionString_1 = this.generateExpressionString(((TwoArgMathFunction)functionCall).getArg2(), thisString);
      String _plus_3 = (_plus_2 + _generateExpressionString_1);
      return (_plus_3 + ")");
    }
    if (!_matched) {
      if (functionCall instanceof OneArgMathFunction) {
        _matched=true;
        String _name = ((OneArgMathFunction)functionCall).getName();
        String _plus = (_name + "(");
        String _generateExpressionString = this.generateExpressionString(((OneArgMathFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        return (_plus_1 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof ThreeArgStringFunction) {
        _matched=true;
        String _replace = ((ThreeArgStringFunction)functionCall).getName().replace("String", "Str");
        String _plus = (_replace + "(");
        String _generateExpressionString = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        String _plus_2 = (_plus_1 + ",");
        String _generateExpressionString_1 = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg2(), thisString);
        String _plus_3 = (_plus_2 + _generateExpressionString_1);
        String _plus_4 = (_plus_3 + ",");
        String _generateExpressionString_2 = this.generateExpressionString(((ThreeArgStringFunction)functionCall).getArg3(), thisString);
        String _plus_5 = (_plus_4 + _generateExpressionString_2);
        return (_plus_5 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof TwoArgStringFunction) {
        _matched=true;
        String _replace = ((TwoArgStringFunction)functionCall).getName().replace("String", "Str");
        String _plus = (_replace + "(");
        String _generateExpressionString = this.generateExpressionString(((TwoArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        String _plus_2 = (_plus_1 + ",");
        String _generateExpressionString_1 = this.generateExpressionString(((TwoArgStringFunction)functionCall).getArg2(), thisString);
        String _plus_3 = (_plus_2 + _generateExpressionString_1);
        return (_plus_3 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof OneArgStringFunction) {
        _matched=true;
        String _replace = ((OneArgStringFunction)functionCall).getName().replace("String", "Str");
        String _plus = (_replace + "(");
        String _generateExpressionString = this.generateExpressionString(((OneArgStringFunction)functionCall).getArg1(), thisString);
        String _plus_1 = (_plus + _generateExpressionString);
        return (_plus_1 + ")");
      }
    }
    if (!_matched) {
      if (functionCall instanceof ThreeArgDateFunction) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Utils.addTime(");
        // L4: a bare Event variable as arg1 means "n units after the event's
        // occurrence" -- append ._timestamp. event.attr / Date params unchanged.
        Expression _a1 = ((ThreeArgDateFunction)functionCall).getArg1();
        boolean _a1IsEventVar = (_a1 instanceof AtomicExpressionParameter)
          && (((AtomicExpressionParameter) _a1).getValue() instanceof VariableRef)
          && !this.generateDotExpressionType(((AtomicExpressionParameter) _a1).getValue()).isEmpty();
        String _generateExpressionString = this.generateExpressionString(_a1, thisString);
        if (_a1IsEventVar) {
          _generateExpressionString = (_generateExpressionString + "._timestamp");
        }
        _builder.append(_generateExpressionString);
        _builder.append(", ");
        String _generateExpressionString_1 = this.generateExpressionString(((ThreeArgDateFunction)functionCall).getValue(), thisString);
        _builder.append(_generateExpressionString_1);
        _builder.append(", \"");
        String _timeUnit = ((ThreeArgDateFunction)functionCall).getTimeUnit();
        _builder.append(_timeUnit);
        _builder.append("\")");
        return _builder.toString();
      }
    }
    return null;
  }

  /**
   * compileDomainTypes
   */
  public String generatePropositionString(final Proposition proposition) {
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      String _generatePropositionString = this.generatePropositionString(((POr)proposition).getLeft());
      String _plus = (_generatePropositionString + " || ");
      String _generatePropositionString_1 = this.generatePropositionString(((POr)proposition).getRight());
      return (_plus + _generatePropositionString_1);
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PAnd)proposition).getLeft());
        String _plus = (_generatePropositionString + " && ");
        String _generatePropositionString_1 = this.generatePropositionString(((PAnd)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PEquality)proposition).getLeft());
        String _equalityOperator = this.getEqualityOperator(((PEquality)proposition).getOp());
        String _plus = (_generatePropositionString + _equalityOperator);
        String _generatePropositionString_1 = this.generatePropositionString(((PEquality)proposition).getRight());
        return (_plus + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PComparison)proposition).getLeft());
        String _plus = (_generatePropositionString + " ");
        String _op = ((PComparison)proposition).getOp();
        String _plus_1 = (_plus + _op);
        String _plus_2 = (_plus_1 + " ");
        String _generatePropositionString_1 = this.generatePropositionString(((PComparison)proposition).getRight());
        return (_plus_2 + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PArithmetic) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PArithmetic)proposition).getLeft());
        String _plus = (_generatePropositionString + " ");
        String _op = ((PArithmetic)proposition).getOp();
        String _plus_1 = (_plus + _op);
        String _plus_2 = (_plus_1 + " ");
        String _generatePropositionString_1 = this.generatePropositionString(((PArithmetic)proposition).getRight());
        return (_plus_2 + _generatePropositionString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((PAtomRecursive)proposition).getInner());
        String _plus = ("(" + _generatePropositionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        String _generatePropositionString = this.generatePropositionString(((NegatedPAtom)proposition).getNegated());
        String _plus = ("!(" + _generatePropositionString);
        return (_plus + ")");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        return this.generatePredicateFunctionString(((PAtomPredicate)proposition).getPredicateFunction());
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomEnum) {
        _matched=true;
        String _name = ((PAtomEnum)proposition).getEnumeration().getName();
        String _plus = (_name + ".");
        String _name_1 = ((PAtomEnum)proposition).getEnumItem().getName();
        return (_plus + _name_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomVariable) {
        _matched=true;
        return SymboleoGenerator.generateDotExpressionString(((PAtomVariable)proposition).getVariable(), "contract");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateTrueLiteral) {
        _matched=true;
        return "true";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateFalseLiteral) {
        _matched=true;
        return "false";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomDoubleLiteral) {
        _matched=true;
        return Double.valueOf(((PAtomDoubleLiteral)proposition).getValue()).toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomIntLiteral) {
        _matched=true;
        return Integer.valueOf(((PAtomIntLiteral)proposition).getValue()).toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomDateLiteral) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(new Date(\"");
        String _string = ((PAtomDateLiteral)proposition).getValue().toInstant().toString();
        _builder.append(_string);
        _builder.append("\").toISOString())");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomStringLiteral) {
        _matched=true;
        return ((PAtomStringLiteral)proposition).getValue();
      }
    }
    return null;
  }

  public String generateLegalpositionCondition(final Proposition proposition, final String addAC) {
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      String _generateLegalpositionCondition = this.generateLegalpositionCondition(((POr)proposition).getLeft(), addAC);
      String _plus = (_generateLegalpositionCondition + " ");
      String _generateLegalpositionCondition_1 = this.generateLegalpositionCondition(((POr)proposition).getRight(), addAC);
      return (_plus + _generateLegalpositionCondition_1);
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        String _generateLegalpositionCondition = this.generateLegalpositionCondition(((PAnd)proposition).getLeft(), addAC);
        String _plus = (_generateLegalpositionCondition + " ");
        String _generateLegalpositionCondition_1 = this.generateLegalpositionCondition(((PAnd)proposition).getRight(), addAC);
        return (_plus + _generateLegalpositionCondition_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        String _generateLegalpositionCondition = this.generateLegalpositionCondition(((PEquality)proposition).getLeft(), addAC);
        String _plus = ((addAC + "{ leftSide:\'") + _generateLegalpositionCondition);
        String _plus_1 = (_plus + "\', op:\'");
        String _equalityOperator = this.getEqualityOperator(((PEquality)proposition).getOp());
        String _plus_2 = (_plus_1 + _equalityOperator);
        String _plus_3 = (_plus_2 + 
          "\', rightSide: \'");
        String _generateLegalpositionCondition_1 = this.generateLegalpositionCondition(((PEquality)proposition).getRight(), addAC);
        String _plus_4 = (_plus_3 + _generateLegalpositionCondition_1);
        return (_plus_4 + "\', _type: \'Condition\'})\n");
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        String _generateLegalpositionCondition = this.generateLegalpositionCondition(((PComparison)proposition).getLeft(), addAC);
        String _plus = ((addAC + "{ leftSide:\'") + _generateLegalpositionCondition);
        String _plus_1 = (_plus + "\', op:\'");
        String _op = ((PComparison)proposition).getOp();
        String _plus_2 = (_plus_1 + _op);
        String _plus_3 = (_plus_2 + "\', ");
        String _plus_4 = (_plus_3 + 
          " rightSide: \'");
        String _generateLegalpositionCondition_1 = this.generateLegalpositionCondition(((PComparison)proposition).getRight(), addAC);
        String _plus_5 = (_plus_4 + _generateLegalpositionCondition_1);
        return (_plus_5 + "\', _type: \'Condition\'}) \n");
      }
    }
    if (!_matched) {
      if (proposition instanceof PArithmetic) {
        _matched=true;
        String _generateLegalpositionCondition = this.generateLegalpositionCondition(((PArithmetic)proposition).getLeft(), addAC);
        String _plus = (_generateLegalpositionCondition + " ");
        String _op = ((PArithmetic)proposition).getOp();
        String _plus_1 = (_plus + _op);
        String _plus_2 = (_plus_1 + " ");
        String _generateLegalpositionCondition_1 = this.generateLegalpositionCondition(((PArithmetic)proposition).getRight(), addAC);
        return (_plus_2 + _generateLegalpositionCondition_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        return this.generateLegalpositionCondition(((PAtomRecursive)proposition).getInner(), addAC);
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        return this.generateLegalpositionCondition(((NegatedPAtom)proposition).getNegated(), addAC);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        String _generatePredicateFunctionCondition = this.generatePredicateFunctionCondition(((PAtomPredicate)proposition).getPredicateFunction());
        String _plus = (("\n" + addAC) + _generatePredicateFunctionCondition);
        return (_plus + ")\n");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomEnum) {
        _matched=true;
        String _name = ((PAtomEnum)proposition).getEnumeration().getName();
        String _plus = (_name + ".");
        String _name_1 = ((PAtomEnum)proposition).getEnumItem().getName();
        return (_plus + _name_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomVariable) {
        _matched=true;
        return SymboleoGenerator.generateDotExpressionString(((PAtomVariable)proposition).getVariable(), "contract");
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateTrueLiteral) {
        _matched=true;
        return "true";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicateFalseLiteral) {
        _matched=true;
        return "false";
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomDoubleLiteral) {
        _matched=true;
        return Double.valueOf(((PAtomDoubleLiteral)proposition).getValue()).toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomIntLiteral) {
        _matched=true;
        return Integer.valueOf(((PAtomIntLiteral)proposition).getValue()).toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomDateLiteral) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("(new Date(\"");
        String _string = ((PAtomDateLiteral)proposition).getValue().toInstant().toString();
        _builder.append(_string);
        _builder.append("\").toISOString())");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomStringLiteral) {
        _matched=true;
        return ((PAtomStringLiteral)proposition).getValue();
      }
    }
    return null;
  }

  public String generatePredicateFunctionCondition(final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionHappens) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _generateEventVariableCondition = this.generateEventVariableCondition(((PredicateFunctionHappens)predicate).getEvent());
      _builder.append(_generateEventVariableCondition);
      _builder.append(" ");
      return _builder.toString();
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensAfter) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateEventVariableCondition = this.generateEventVariableCondition(((PredicateFunctionHappensAfter)predicate).getEvent());
        _builder.append(_generateEventVariableCondition);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateEventVariableCondition = this.generateEventVariableCondition(((PredicateFunctionWHappensBefore)predicate).getEvent());
        _builder.append(_generateEventVariableCondition);
        _builder.append(" ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateEventVariableCondition = this.generateEventVariableCondition(((PredicateFunctionSHappensBefore)predicate).getEvent());
        _builder.append(_generateEventVariableCondition);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensWithin) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateEventVariableCondition = this.generateEventVariableCondition(((PredicateFunctionHappensWithin)predicate).getEvent());
        _builder.append(_generateEventVariableCondition);
        _builder.append(" ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionAssignment) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        String _generateEventVariableCondition = this.generateEventVariableCondition(((PredicateFunctionAssignment)predicate).getEvent());
        _builder.append(_generateEventVariableCondition);
        _builder.append(" ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionAssignmentOnly) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("true");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generateEventVariableCondition(final Event event) {
    boolean _matched = false;
    if (event instanceof VariableEvent) {
      _matched=true;
      String _generateDotExpressionString = SymboleoGenerator.generateDotExpressionString(((VariableEvent)event).getVariable(), "");
      String _plus = ("{_type: \'eventCondition\', resource:\"" + _generateDotExpressionString);
      String _plus_1 = (_plus + "\", resourceType:\"");
      String _generateDotExpressionType = this.generateDotExpressionType(((VariableEvent)event).getVariable());
      String _plus_2 = (_plus_1 + _generateDotExpressionType);
      return (_plus_2 + "\"}");
    }
    if (!_matched) {
      if (event instanceof PowerEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("{{_type: \'stateCondition\', resourceType:\"power\", resource:\"");
        String _name = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name);
        _builder.append("\", state: \"");
        String _eventName = ((PowerEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append("\"}");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ObligationEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        _builder.append("{_type: \'stateCondition\', resourceType:\"");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(((ObligationEvent)event).getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligation";
        } else {
          _xifexpression = "obligation";
        }
        _builder.append(_xifexpression, " ");
        _builder.append("\", resource: \"");
        String _name = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name, " ");
        _builder.append("\", state:\"");
        String _eventName = this.geteventName(((ObligationEvent)event).getEventName());
        _builder.append(_eventName, " ");
        _builder.append("\"}");
        return _builder.toString();
      }
    }
    return null;
  }

  public String geteventName(final String eventName) {
    String st = "";
    String _string = eventName.toString();
    if (_string != null) {
      switch (_string) {
        case "Triggered":
          st = "create";
          break;
        case "Discharged":
          st = "discharge";
          break;
        case "Activated":
          st = "active";
          break;
        case "Suspended":
          st = "suspension";
          break;
        case "Resumed":
          st = "suspension";
          break;
        case "Violated":
          st = "violation";
          break;
        case "Fulfilled":
          st = "fulfillment";
          break;
        case "Terminated":
          st = "unsuccessfultermination";
          break;
      }
    }
    return st;
  }

  public String generateDotExpressionType(final Ref argRef) {
    String ids = "";
    Ref ref = argRef;
    if ((ref instanceof VariableRef)) {
      for (final Variable v : this.eventVariables) {
        String _variable = ((VariableRef) ref).getVariable();
        String _name = v.getName();
        boolean _equals = Objects.equals(_variable, _name);
        if (_equals) {
          ids = v.getType().getName();
        }
      }
    }
    return ids;
  }

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Model> _filter = Iterables.<Model>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Model.class);
    for (final Model e : _filter) {
      {
        this.assets.clear();
        this.events.clear();
        this.roles.clear();
        this.enumerations.clear();
        this.parameters.clear();
        this.arrays.clear();
        this.conditionalObligations.clear();
        this.conditionalSurvivingObligations.clear();
        this.conditionalPowers.clear();
        this.unconditionalObligations.clear();
        this.unconditionalSurvivingObligations.clear();
        this.unconditionalPowers.clear();
        this.untriggeredObligations.clear();
        this.untriggeredSurvivingObligations.clear();
        this.untriggeredPowers.clear();
        this.triggeredObligations.clear();
        this.triggeredSurvivingObligations.clear();
        this.triggeredPowers.clear();
        this.allObligations.clear();
        this.allSurvivingObligations.clear();
        this.allPowers.clear();
        this.eventVariables.clear();
        this.obligationTriggerEvents.clear();
        this.survivingObligationTriggerEvents.clear();
        this.powerTriggerEvents.clear();
        this.obligationAntecedentEvents.clear();
        this.survivingObligationAntecedentEvents.clear();
        this.powerAntecedentEvents.clear();
        this.obligationFullfilmentEvents.clear();
        this.survivingObligationFullfilmentEvents.clear();
        Symboleo2SC symboleo2SC = new Symboleo2SC();
        symboleo2SC.generateHFSource(fsa, e);
        SymboleoPCGenerator symboleoPC = new SymboleoPCGenerator();
        symboleoPC.generatePCSource(fsa, e);
      }
    }
  }

  public String generateIntervalExpresionArgString(final IntervalExpression interval) {
    boolean _matched = false;
    if (interval instanceof IntervalFunction) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      String _generatePointExpresionString = this.generatePointExpresionString(((IntervalFunction)interval).getArg1());
      _builder.append(_generatePointExpresionString);
      _builder.append(", ");
      String _generatePointExpresionString_1 = this.generatePointExpresionString(((IntervalFunction)interval).getArg2());
      _builder.append(_generatePointExpresionString_1);
      return _builder.toString();
    }
    if (!_matched) {
      if (interval instanceof SituationExpression) {
        _matched=true;
        final Situation situation = ((SituationExpression)interval).getSituation();
        boolean _matched_1 = false;
        if (situation instanceof ObligationState) {
          _matched_1=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("contract.");
          String _xifexpression = null;
          boolean _isSurvivingObligation = this.isSurvivingObligation(((ObligationState)situation).getObligationVariable().getName());
          if (_isSurvivingObligation) {
            _xifexpression = "survivingObligations";
          } else {
            _xifexpression = "obligations";
          }
          _builder.append(_xifexpression);
          _builder.append(".");
          String _name = ((ObligationState)situation).getObligationVariable().getName();
          _builder.append(_name);
          _builder.append(", \"Obligation.");
          String _stateName = ((ObligationState)situation).getStateName();
          _builder.append(_stateName);
          _builder.append("\"");
          return _builder.toString();
        }
        if (!_matched_1) {
          if (situation instanceof PowerState) {
            _matched_1=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("contract.powers.");
            String _name = ((PowerState)situation).getPowerVariable().getName();
            _builder.append(_name);
            _builder.append(", \"Power.");
            String _stateName = ((PowerState)situation).getStateName();
            _builder.append(_stateName);
            _builder.append("\"\"");
            return _builder.toString();
          }
        }
        if (!_matched_1) {
          if (situation instanceof ContractState) {
            _matched_1=true;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("contract, \"Contract.");
            String _stateName = ((ContractState)situation).getStateName();
            _builder.append(_stateName);
            _builder.append("\"");
            return _builder.toString();
          }
        }
      }
    }
    return null;
  }

  public String generateEventVariableString(final Event event) {
    boolean _matched = false;
    if (event instanceof VariableEvent) {
      _matched=true;
      return SymboleoGenerator.generateDotExpressionString(((VariableEvent)event).getVariable(), "contract");
    }
    if (!_matched) {
      if (event instanceof PowerEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract.powers.");
        String _name = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(" && contract.powers.");
        String _name_1 = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name_1);
        _builder.append("._events.");
        String _eventName = ((PowerEvent)event).getEventName();
        _builder.append(_eventName);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ObligationEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract.");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(((ObligationEvent)event).getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        _builder.append(_xifexpression);
        _builder.append(".");
        String _name = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(" && contract.");
        String _xifexpression_1 = null;
        boolean _isSurvivingObligation_1 = this.isSurvivingObligation(((ObligationEvent)event).getObligationVariable().getName());
        if (_isSurvivingObligation_1) {
          _xifexpression_1 = "survivingObligations";
        } else {
          _xifexpression_1 = "obligations";
        }
        _builder.append(_xifexpression_1);
        _builder.append(".");
        String _name_1 = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name_1);
        _builder.append("._events.");
        String _eventName = ((ObligationEvent)event).getEventName();
        _builder.append(_eventName);
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ContractEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract._events.");
        String _eventName = ((ContractEvent)event).getEventName();
        _builder.append(_eventName);
        return _builder.toString();
      }
    }
    return null;
  }

  public String generatePredicateFunctionString(final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionHappens) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Predicates.happens(");
      String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappens)predicate).getEvent());
      _builder.append(_generateEventVariableString);
      _builder.append(") ");
      return _builder.toString();
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensAfter) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.happensAfter(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensAfter)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionHappensAfter)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionWHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.weakHappensBefore(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionWHappensBefore)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionWHappensBefore)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(") ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionSHappensBefore) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.strongHappensBefore(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionSHappensBefore)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generatePointExpresionString = this.generatePointExpresionString(((PredicateFunctionSHappensBefore)predicate).getPoint().getPointExpression());
        _builder.append(_generatePointExpresionString);
        _builder.append(") ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionHappensWithin) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.happensWithin(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionHappensWithin)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(", ");
        String _generateIntervalExpresionArgString = this.generateIntervalExpresionArgString(((PredicateFunctionHappensWithin)predicate).getInterval().getIntervalExpression());
        _builder.append(_generateIntervalExpresionArgString);
        _builder.append(") ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionAssignment) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Predicates.happens(");
        String _generateEventVariableString = this.generateEventVariableString(((PredicateFunctionAssignment)predicate).getEvent());
        _builder.append(_generateEventVariableString);
        _builder.append(") ");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionAssignmentOnly) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("true");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generatePointInternalEventObjectString(final PointExpression p) {
    boolean _matched = false;
    if (p instanceof PointFunction) {
      _matched=true;
      final String res = this.generatePointInternalEventObjectString(((PointFunction)p).getArg());
      if ((res != null)) {
        return res;
      } else {
        return null;
      }
    }
    if (!_matched) {
      if (p instanceof PointAtomParameterDotExpression) {
        _matched=true;
        Boolean _isDotExpressionTypeOfEvent = Helpers.isDotExpressionTypeOfEvent(((PointAtomParameterDotExpression)p).getVariable(), this.variables, this.parameters);
        if ((_isDotExpressionTypeOfEvent).booleanValue()) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("new InternalEvent(InternalEventSource.contractEvent, InternalEventType.contractEvent.Happened, ");
          String _generateDotExpressionString = SymboleoGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)p).getVariable(), "contract");
          _builder.append(_generateDotExpressionString);
          _builder.append(")");
          return _builder.toString();
        } else {
          return null;
        }
      }
    }
    if (!_matched) {
      if (p instanceof PointAtomObligationEvent) {
        _matched=true;
        Event _obligationEvent = ((PointAtomObligationEvent)p).getObligationEvent();
        final ObligationEvent e = ((ObligationEvent) _obligationEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.obligation, InternalEventType.obligation.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(", contract.");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(e.getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        _builder.append(_xifexpression);
        _builder.append(".");
        String _name = e.getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (p instanceof PointAtomContractEvent) {
        _matched=true;
        Eselfvent _contractEvent = ((PointAtomContractEvent)p).getContractEvent();
        final ContractEvent e = ((ContractEvent) _contractEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.contract, InternalEventType.contract.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(", contract)");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (p instanceof PointAtomPowerEvent) {
        _matched=true;
        Event _powerEvent = ((PointAtomPowerEvent)p).getPowerEvent();
        final PowerEvent e = ((PowerEvent) _powerEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.power, InternalEventType.power.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(", contract.powers.");
        String _name = e.getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generateInternalEventObjectString(final Event event) {
    boolean _matched = false;
    if (event instanceof VariableEvent) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("new InternalEvent(InternalEventSource.contractEvent, InternalEventType.contractEvent.Happened, ");
      String _generateDotExpressionString = SymboleoGenerator.generateDotExpressionString(((VariableEvent)event).getVariable(), "contract");
      _builder.append(_generateDotExpressionString);
      _builder.append(")");
      return _builder.toString();
    }
    if (!_matched) {
      if (event instanceof ObligationEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.obligation, InternalEventType.obligation.");
        String _eventName = ((ObligationEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append(", contract.");
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(((ObligationEvent)event).getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        _builder.append(_xifexpression);
        _builder.append(".");
        String _name = ((ObligationEvent)event).getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof ContractEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.contract, InternalEventType.contract.");
        String _eventName = ((ContractEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append(", contract)");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (event instanceof PowerEvent) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("new InternalEvent(InternalEventSource.power, InternalEventType.power.");
        String _eventName = ((PowerEvent)event).getEventName();
        _builder.append(_eventName);
        _builder.append(", contract.powers.");
        String _name = ((PowerEvent)event).getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(")");
        return _builder.toString();
      }
    }
    return null;
  }

  public String generateEventMapLineString(final List<PAtomPredicate> predicates, final String listenerName) {
    final StringBuilder line = new StringBuilder();
    line.append("[[");
    for (final PAtomPredicate predicate : predicates) {
      {
        final PredicateFunction pf = predicate.getPredicateFunction();
        boolean _matched = false;
        if (pf instanceof PredicateFunctionHappens) {
          _matched=true;
          String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionHappens)pf).getEvent());
          String _plus = (_generateInternalEventObjectString + ", ");
          line.append(_plus);
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionWHappensBefore) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionWHappensBefore)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
          }
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionHappensAfter) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionHappensAfter)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
          }
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionSHappensBefore) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionSHappensBefore)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
            final String res = this.generatePointInternalEventObjectString(((PredicateFunctionSHappensBefore)pf).getPoint().getPointExpression());
            if ((res != null)) {
              line.append((res + ", "));
            }
          }
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionHappensWithin) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionHappensWithin)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
            final IntervalExpression interval = ((PredicateFunctionHappensWithin)pf).getInterval().getIntervalExpression();
            boolean _matched_1 = false;
            if (interval instanceof IntervalFunction) {
              _matched_1=true;
              final String res1 = this.generatePointInternalEventObjectString(((IntervalFunction)interval).getArg1());
              final String res2 = this.generatePointInternalEventObjectString(((IntervalFunction)interval).getArg2());
              if ((res1 != null)) {
                line.append((res1 + ", "));
              }
              if ((res2 != null)) {
                line.append((res2 + ", "));
              }
            }
          }
        }
        if (!_matched) {
          if (pf instanceof PredicateFunctionAssignment) {
            _matched=true;
            String _generateInternalEventObjectString = this.generateInternalEventObjectString(((PredicateFunctionAssignment)pf).getEvent());
            String _plus = (_generateInternalEventObjectString + ", ");
            line.append(_plus);
          }
        }
      }
    }
    String _string = line.toString();
    boolean _notEquals = (!Objects.equals(_string, "[["));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("], ");
      _builder.append(listenerName);
      _builder.append("],");
      line.append(_builder);
      return line.toString();
    } else {
      return "";
    }
  }

  public String generatePointExpresionString(final PointExpression point) {
    boolean _matched = false;
    if (point instanceof PointFunction) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Utils.addTime(");
      String _generatePointExpresionString = this.generatePointExpresionString(((PointFunction)point).getArg());
      _builder.append(_generatePointExpresionString);
      _builder.append(", ");
      String _generateTimeValueString = this.generateTimeValueString(((PointFunction)point).getValue());
      _builder.append(_generateTimeValueString);
      _builder.append(", \"");
      String _timeUnit = ((PointFunction)point).getTimeUnit();
      _builder.append(_timeUnit);
      _builder.append("\")");
      return _builder.toString();
    }
    if (!_matched) {
      if (point instanceof PointAtomParameterDotExpression) {
        _matched=true;
        Boolean _isDotExpressionTypeOfEvent = Helpers.isDotExpressionTypeOfEvent(((PointAtomParameterDotExpression)point).getVariable(), this.variables, this.parameters);
        if ((_isDotExpressionTypeOfEvent).booleanValue()) {
          StringConcatenation _builder = new StringConcatenation();
          String _generateDotExpressionString = SymboleoGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)point).getVariable(), "contract");
          _builder.append(_generateDotExpressionString);
          _builder.append("._timestamp");
          return _builder.toString();
        } else {
          return SymboleoGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)point).getVariable(), "contract");
        }
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomObligationEvent) {
        _matched=true;
        Event _obligationEvent = ((PointAtomObligationEvent)point).getObligationEvent();
        final ObligationEvent e = ((ObligationEvent) _obligationEvent);
        String _xifexpression = null;
        boolean _isSurvivingObligation = this.isSurvivingObligation(e.getObligationVariable().getName());
        if (_isSurvivingObligation) {
          _xifexpression = "survivingObligations";
        } else {
          _xifexpression = "obligations";
        }
        final String obligationRef = _xifexpression;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract.");
        _builder.append(obligationRef);
        _builder.append(".");
        String _name = e.getObligationVariable().getName();
        _builder.append(_name);
        _builder.append(" && contract.");
        _builder.append(obligationRef);
        _builder.append(".");
        String _name_1 = e.getObligationVariable().getName();
        _builder.append(_name_1);
        _builder.append("._events.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(" && contract.");
        _builder.append(obligationRef);
        _builder.append(".");
        String _name_2 = e.getObligationVariable().getName();
        _builder.append(_name_2);
        _builder.append("._events.");
        String _eventName_1 = e.getEventName();
        _builder.append(_eventName_1);
        _builder.append("._timestamp");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomPowerEvent) {
        _matched=true;
        Event _powerEvent = ((PointAtomPowerEvent)point).getPowerEvent();
        final PowerEvent e = ((PowerEvent) _powerEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract.powers.");
        String _name = e.getPowerVariable().getName();
        _builder.append(_name);
        _builder.append(" && contract.powers.");
        String _name_1 = e.getPowerVariable().getName();
        _builder.append(_name_1);
        _builder.append("._events.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(" && contract.powers.");
        String _name_2 = e.getPowerVariable().getName();
        _builder.append(_name_2);
        _builder.append("._events.");
        String _eventName_1 = e.getEventName();
        _builder.append(_eventName_1);
        _builder.append("._timestamp");
        return _builder.toString();
      }
    }
    if (!_matched) {
      if (point instanceof PointAtomContractEvent) {
        _matched=true;
        Eselfvent _contractEvent = ((PointAtomContractEvent)point).getContractEvent();
        final ContractEvent e = ((ContractEvent) _contractEvent);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("contract._events.");
        String _eventName = e.getEventName();
        _builder.append(_eventName);
        _builder.append(" && contract._events.");
        String _eventName_1 = e.getEventName();
        _builder.append(_eventName_1);
        _builder.append("._timestamp");
        return _builder.toString();
      }
    }
    return null;
  }

  public boolean isSurvivingObligation(final String name) {
    for (final Obligation obligation : this.allObligations) {
      boolean _equals = obligation.getName().equals(name);
      if (_equals) {
        return false;
      }
    }
    for (final Obligation obligation_1 : this.allSurvivingObligations) {
      boolean _equals_1 = obligation_1.getName().equals(name);
      if (_equals_1) {
        return true;
      }
    }
    return false;
  }

  public String survivEvent(final String e) {
    boolean survive = false;
    boolean related = false;
    for (final String line : this.arrays) {
      {
        if ((line.contains(("contract." + e)) && ((line.contains("EventListeners.fulfillSurvivingObligation") || 
          line.contains("EventListeners.createSurvivingObligation")) || 
          line.contains("EventListeners.activateSurvivingObligation")))) {
          survive = true;
        }
        if ((line.contains(("contract." + e)) && (((((line.contains("EventListeners.fulfillObligation") || 
          line.contains("EventListeners.createObligation")) || 
          line.contains("EventListeners.activateObligation")) || 
          line.contains("EventListeners.createPower")) || 
          line.contains("EventListeners.activatePower")) || 
          line.contains("EventListeners.fulfillPower")))) {
          related = true;
        }
      }
    }
    if ((survive && (!related))) {
      return " || contract.isSuccessfulTermination() || contract.isUnsuccessfulTermination()";
    } else {
      return "";
    }
  }

  @Override
  public void afterGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    this.assets.clear();
    this.events.clear();
    this.roles.clear();
    this.enumerations.clear();
    this.parameters.clear();
    this.conditionalObligations.clear();
    this.conditionalSurvivingObligations.clear();
    this.conditionalPowers.clear();
    this.unconditionalObligations.clear();
    this.unconditionalSurvivingObligations.clear();
    this.unconditionalPowers.clear();
    this.untriggeredObligations.clear();
    this.untriggeredSurvivingObligations.clear();
    this.untriggeredPowers.clear();
    this.triggeredObligations.clear();
    this.triggeredSurvivingObligations.clear();
    this.triggeredPowers.clear();
    this.allObligations.clear();
    this.allSurvivingObligations.clear();
    this.allPowers.clear();
    this.eventVariables.clear();
    this.AssignVar.clear();
    this.obligationTriggerEvents.clear();
    this.survivingObligationTriggerEvents.clear();
    this.powerTriggerEvents.clear();
    this.obligationAntecedentEvents.clear();
    this.survivingObligationAntecedentEvents.clear();
    this.powerAntecedentEvents.clear();
    this.obligationFullfilmentEvents.clear();
    this.survivingObligationFullfilmentEvents.clear();
  }
}
