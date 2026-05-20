package ca.uottawa.csmlab.symboleo.generator;

import ca.uottawa.csmlab.symboleo.symboleo.And;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDate;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDouble;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionEnum;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionFalse;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionInt;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionParameter;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionString;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionTrue;
import ca.uottawa.csmlab.symboleo.symboleo.Comparison;
import ca.uottawa.csmlab.symboleo.symboleo.Controller;
import ca.uottawa.csmlab.symboleo.symboleo.Div;
import ca.uottawa.csmlab.symboleo.symboleo.EnumItem;
import ca.uottawa.csmlab.symboleo.symboleo.Enumeration;
import ca.uottawa.csmlab.symboleo.symboleo.Equality;
import ca.uottawa.csmlab.symboleo.symboleo.Expression;
import ca.uottawa.csmlab.symboleo.symboleo.FunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.Minus;
import ca.uottawa.csmlab.symboleo.symboleo.Mod;
import ca.uottawa.csmlab.symboleo.symboleo.Model;
import ca.uottawa.csmlab.symboleo.symboleo.Multi;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPAtom;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPrimaryExpression;
import ca.uottawa.csmlab.symboleo.symboleo.OAssignExpression;
import ca.uottawa.csmlab.symboleo.symboleo.OAssignment;
import ca.uottawa.csmlab.symboleo.symboleo.Obligation;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Or;
import ca.uottawa.csmlab.symboleo.symboleo.PAnd;
import ca.uottawa.csmlab.symboleo.symboleo.PArithmetic;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomPredicate;
import ca.uottawa.csmlab.symboleo.symboleo.PAtomRecursive;
import ca.uottawa.csmlab.symboleo.symboleo.PComparison;
import ca.uottawa.csmlab.symboleo.symboleo.PEquality;
import ca.uottawa.csmlab.symboleo.symboleo.POr;
import ca.uottawa.csmlab.symboleo.symboleo.Parameter;
import ca.uottawa.csmlab.symboleo.symboleo.Plus;
import ca.uottawa.csmlab.symboleo.symboleo.Power;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunction;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionAssignment;
import ca.uottawa.csmlab.symboleo.symboleo.PredicateFunctionAssignmentOnly;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionFunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionRecursive;
import ca.uottawa.csmlab.symboleo.symboleo.Proposition;
import ca.uottawa.csmlab.symboleo.symboleo.Ref;
import ca.uottawa.csmlab.symboleo.symboleo.RegularType;
import ca.uottawa.csmlab.symboleo.symboleo.ThreeArgDateFunction;
import ca.uottawa.csmlab.symboleo.symboleo.ThreeArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Timevalue;
import ca.uottawa.csmlab.symboleo.symboleo.TimevalueInt;
import ca.uottawa.csmlab.symboleo.symboleo.TimevalueVariable;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Variable;
import ca.uottawa.csmlab.symboleo.symboleo.VariableDotExpression;
import ca.uottawa.csmlab.symboleo.symboleo.VariableRef;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * s code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class SymboleoGenerator extends AbstractGenerator {
  private final String ASSET_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String EVENT_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String ROLE_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String POWER_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String OBLIGATION_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String ACPolicy_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String ATTRIBUTE_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String Rule_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String Resource_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String Operation_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String CONTRACT_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String EVENTS_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String PREDICATES_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final String UTILS_CLASS_IMPORT_PATH = "\"symboleoac-js-core\"";

  private final ArrayList<RegularType> assets = new ArrayList<RegularType>();

  private final ArrayList<RegularType> events = new ArrayList<RegularType>();

  private final ArrayList<RegularType> roles = new ArrayList<RegularType>();

  private final ArrayList<Enumeration> enumerations = new ArrayList<Enumeration>();

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

  private final HashMap<Resource, List<Controller>> controller = new HashMap<Resource, List<Controller>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationTriggerEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationTriggerEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Power, List<PAtomPredicate>> powerTriggerEvents = new HashMap<Power, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationAntecedentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationAntecedentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Power, List<PAtomPredicate>> powerAntecedentEvents = new HashMap<Power, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> obligationFullfilmentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final HashMap<Obligation, List<PAtomPredicate>> survivingObligationFullfilmentEvents = new HashMap<Obligation, List<PAtomPredicate>>();

  private final ArrayList<Parameter> parameters = new ArrayList<Parameter>();

  private final ArrayList<Variable> variables = new ArrayList<Variable>();

  private final ArrayList<String> AssignVar = new ArrayList<String>();

  public String generateOAssignObjectString(final List<OAssignment> a) {
    String s = "";
    String eName = "";
    boolean found = false;
    for (final OAssignment e : a) {
      {
        found = false;
        System.out.println(("assign element=e" + e));
        if ((e instanceof OAssignExpression)) {
          Ref _name2 = ((OAssignExpression)e).getName2();
          String _plus = ("assign element name after instance" + _name2);
          System.out.println(_plus);
          eName = SymboleoGenerator.generateDotExpressionString(((OAssignExpression)e).getName2(), "");
          System.out.println(("assign element name after generateDotExpression" + eName));
          boolean _contains = this.AssignVar.contains(eName);
          boolean _not = (!_contains);
          if (_not) {
            for (final Parameter p : this.parameters) {
              String _string = p.getName().toString();
              String _string_1 = eName.toString();
              boolean _equals = Objects.equals(_string, _string_1);
              if (_equals) {
                found = true;
              }
            }
            if ((!found)) {
              this.AssignVar.add(eName);
            }
          }
          String _generateDotExpressionString = SymboleoGenerator.generateDotExpressionString(((OAssignExpression)e).getName2(), "contract");
          String _plus_1 = (s + _generateDotExpressionString);
          String _plus_2 = (_plus_1 + " = ");
          String _generateExpressionString = this.generateExpressionString(((OAssignExpression)e).getValue(), "contract");
          String _plus_3 = (_plus_2 + _generateExpressionString);
          s = _plus_3;
          s = (s + " \n");
        }
      }
    }
    return s;
  }

  public List<PAtomPredicate> collectPropositionEvents(final Proposition proposition) {
    final ArrayList<PAtomPredicate> list = new ArrayList<PAtomPredicate>();
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      list.addAll(this.collectPropositionEvents(((POr)proposition).getLeft()));
      list.addAll(this.collectPropositionEvents(((POr)proposition).getRight()));
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PAnd)proposition).getLeft()));
        list.addAll(this.collectPropositionEvents(((PAnd)proposition).getRight()));
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PEquality)proposition).getLeft()));
        list.addAll(this.collectPropositionEvents(((PEquality)proposition).getRight()));
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PComparison)proposition).getLeft()));
        list.addAll(this.collectPropositionEvents(((PComparison)proposition).getRight()));
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PAtomRecursive)proposition).getInner()));
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((NegatedPAtom)proposition).getNegated()));
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        PredicateFunction _predicateFunction = ((PAtomPredicate)proposition).getPredicateFunction();
        boolean _not = (!(_predicateFunction instanceof PredicateFunctionAssignmentOnly));
        if (_not) {
          list.add(((PAtomPredicate)proposition));
        }
      }
    }
    if (!_matched) {
      if (proposition instanceof PArithmetic) {
        _matched=true;
        list.addAll(this.collectPropositionEvents(((PArithmetic)proposition).getLeft()));
        list.addAll(this.collectPropositionEvents(((PArithmetic)proposition).getRight()));
      }
    }
    return list;
  }

  public String generatePropositionAssignString(final Proposition proposition) {
    boolean _matched = false;
    if (proposition instanceof POr) {
      _matched=true;
      String _generatePropositionAssignString = this.generatePropositionAssignString(((POr)proposition).getLeft());
      String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((POr)proposition).getRight());
      return (_generatePropositionAssignString + _generatePropositionAssignString_1);
    }
    if (!_matched) {
      if (proposition instanceof PAnd) {
        _matched=true;
        String _generatePropositionAssignString = this.generatePropositionAssignString(((PAnd)proposition).getLeft());
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((PAnd)proposition).getRight());
        return (_generatePropositionAssignString + _generatePropositionAssignString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PEquality) {
        _matched=true;
        String _generatePropositionAssignString = this.generatePropositionAssignString(((PEquality)proposition).getLeft());
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((PEquality)proposition).getRight());
        return (_generatePropositionAssignString + _generatePropositionAssignString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PComparison) {
        _matched=true;
        String _generatePropositionAssignString = this.generatePropositionAssignString(((PComparison)proposition).getLeft());
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((PComparison)proposition).getRight());
        return (_generatePropositionAssignString + _generatePropositionAssignString_1);
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomRecursive) {
        _matched=true;
        return this.generatePropositionAssignString(((PAtomRecursive)proposition).getInner());
      }
    }
    if (!_matched) {
      if (proposition instanceof NegatedPAtom) {
        _matched=true;
        return this.generatePropositionAssignString(((NegatedPAtom)proposition).getNegated());
      }
    }
    if (!_matched) {
      if (proposition instanceof PAtomPredicate) {
        _matched=true;
        return this.generatePredicateAssignString(((PAtomPredicate)proposition).getPredicateFunction());
      }
    }
    if (!_matched) {
      if (proposition instanceof PArithmetic) {
        _matched=true;
        String _generatePropositionAssignString = this.generatePropositionAssignString(((PArithmetic)proposition).getLeft());
        String _generatePropositionAssignString_1 = this.generatePropositionAssignString(((PArithmetic)proposition).getRight());
        return (_generatePropositionAssignString + _generatePropositionAssignString_1);
      }
    }
    return " ";
  }

  public String generatePredicateAssignString(final PredicateFunction predicate) {
    boolean _matched = false;
    if (predicate instanceof PredicateFunctionAssignment) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(" ");
      String _generateOAssignObjectString = this.generateOAssignObjectString(((PredicateFunctionAssignment)predicate).getAssignment());
      _builder.append(_generateOAssignObjectString, " ");
      _builder.append(" ");
      return _builder.toString();
    }
    if (!_matched) {
      if (predicate instanceof PredicateFunctionAssignmentOnly) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(" ");
        String _generateOAssignObjectString = this.generateOAssignObjectString(((PredicateFunctionAssignmentOnly)predicate).getAssignment());
        _builder.append(_generateOAssignObjectString, " ");
        _builder.append(" ");
        return _builder.toString();
      }
    }
    return " ";
  }

  public String generateTimeValueString(final Timevalue tv) {
    boolean _matched = false;
    if (tv instanceof TimevalueInt) {
      _matched=true;
      return Integer.valueOf(((TimevalueInt)tv).getValue()).toString();
    }
    if (!_matched) {
      if (tv instanceof TimevalueVariable) {
        _matched=true;
        return SymboleoGenerator.generateDotExpressionString(((TimevalueVariable)tv).getVariable(), "contract");
      }
    }
    return null;
  }

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

  public static String generateDotExpressionString(final Ref argRef, final String thisString) {
    final ArrayList<String> ids = new ArrayList<String>();
    Ref ref = argRef;
    String _xifexpression = null;
    if ((thisString == "P")) {
      _xifexpression = "this";
    } else {
      _xifexpression = thisString;
    }
    String thisV = _xifexpression;
    while ((ref instanceof VariableDotExpression)) {
      {
        if ((thisString == "P")) {
          ids.add(((VariableDotExpression)ref).getTail().getName());
        } else {
          String _name = ((VariableDotExpression)ref).getTail().getName();
          String _plus = (_name + "._value");
          ids.add(_plus);
        }
        ref = ((VariableDotExpression)ref).getRef();
      }
    }
    if ((ref instanceof VariableRef)) {
      ids.add(((VariableRef) ref).getVariable());
    }
    if ((!(thisString == ""))) {
      ids.add(thisV);
    }
    return IterableExtensions.join(ListExtensions.<String>reverse(ids), ".");
  }

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
        String _generateExpressionString = this.generateExpressionString(((ThreeArgDateFunction)functionCall).getArg1(), thisString);
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

  public String getEqualityOperator(final String op) {
    if (op != null) {
      switch (op) {
        case "!=":
          return "!==";
        case "==":
          return "===";
      }
    }
    return null;
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
        String _contractName = e.getContractName();
        String _plus = ("generate2SCSource: " + _contractName);
        System.out.println(_plus);
        Symboleo2SC symboleo2SC = new Symboleo2SC();
        String _contractName_1 = e.getContractName();
        String _plus_1 = ("generateHFSource: " + _contractName_1);
        System.out.println(_plus_1);
        symboleo2SC.generateHFSource(fsa, e);
        String _contractName_2 = e.getContractName();
        String _plus_2 = ("generatePCSource: " + _contractName_2);
        System.out.println(_plus_2);
        SymboleoPCGenerator symboleoPC = new SymboleoPCGenerator();
        symboleoPC.generatePCSource(fsa, e);
      }
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
