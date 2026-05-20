package ca.uottawa.csmlab.symboleo;

import ca.uottawa.csmlab.symboleo.scoping.MyAttributeImpl;
import ca.uottawa.csmlab.symboleo.scoping.MyBaseTypeImpl;
import ca.uottawa.csmlab.symboleo.symboleo.Alias;
import ca.uottawa.csmlab.symboleo.symboleo.And;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDate;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionDouble;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionEnum;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionFalse;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionInt;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionParameter;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionString;
import ca.uottawa.csmlab.symboleo.symboleo.AtomicExpressionTrue;
import ca.uottawa.csmlab.symboleo.symboleo.Attribute;
import ca.uottawa.csmlab.symboleo.symboleo.BaseType;
import ca.uottawa.csmlab.symboleo.symboleo.Comparison;
import ca.uottawa.csmlab.symboleo.symboleo.Div;
import ca.uottawa.csmlab.symboleo.symboleo.DomainType;
import ca.uottawa.csmlab.symboleo.symboleo.Enumeration;
import ca.uottawa.csmlab.symboleo.symboleo.Equality;
import ca.uottawa.csmlab.symboleo.symboleo.Expression;
import ca.uottawa.csmlab.symboleo.symboleo.FunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.Minus;
import ca.uottawa.csmlab.symboleo.symboleo.Multi;
import ca.uottawa.csmlab.symboleo.symboleo.NegatedPrimaryExpression;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OneArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.OntologyType;
import ca.uottawa.csmlab.symboleo.symboleo.Or;
import ca.uottawa.csmlab.symboleo.symboleo.Parameter;
import ca.uottawa.csmlab.symboleo.symboleo.ParameterType;
import ca.uottawa.csmlab.symboleo.symboleo.Plus;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionFunctionCall;
import ca.uottawa.csmlab.symboleo.symboleo.PrimaryExpressionRecursive;
import ca.uottawa.csmlab.symboleo.symboleo.Ref;
import ca.uottawa.csmlab.symboleo.symboleo.RegularType;
import ca.uottawa.csmlab.symboleo.symboleo.SymboleoPackage;
import ca.uottawa.csmlab.symboleo.symboleo.ThreeArgDateFunction;
import ca.uottawa.csmlab.symboleo.symboleo.ThreeArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgMathFunction;
import ca.uottawa.csmlab.symboleo.symboleo.TwoArgStringFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Variable;
import ca.uottawa.csmlab.symboleo.symboleo.VariableDotExpression;
import ca.uottawa.csmlab.symboleo.symboleo.VariableRef;
import ca.uottawa.csmlab.symboleo.symboleo.impl.RegularTypeImpl;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Helpers {
  public static List<Attribute> getAttributesOfRegularType(final RegularType argType) {
    final ArrayList<Attribute> attributes = new ArrayList<Attribute>();
    RegularType type = argType;
    attributes.addAll(type.getAttributes());
    while ((type.getRegularType() != null)) {
      {
        type = type.getRegularType();
        attributes.addAll(type.getAttributes());
      }
    }
    boolean _equalsIgnoreCase = type.getOntologyType().getName().equalsIgnoreCase("Event");
    if (_equalsIgnoreCase) {
      final RegularTypeImpl rti = ((RegularTypeImpl) type);
      MyBaseTypeImpl _myBaseTypeImpl = new MyBaseTypeImpl("Date");
      final MyAttributeImpl tsAttribute = new MyAttributeImpl("_timestamp", _myBaseTypeImpl, rti);
      attributes.add(tsAttribute);
    }
    return attributes;
  }

  public static RegularType getBaseType(final DomainType domainType) {
    Object _switchResult = null;
    boolean _matched = false;
    if (domainType instanceof RegularType) {
      _matched=true;
      OntologyType _ontologyType = ((RegularType)domainType).getOntologyType();
      boolean _tripleNotEquals = (_ontologyType != null);
      if (_tripleNotEquals) {
        return ((RegularType)domainType);
      } else {
        return Helpers.getBaseType(((RegularType)domainType).getRegularType());
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return ((RegularType)_switchResult);
  }

  public static ResolveExpressionResult handleExpressionError(final ResolveExpressionResult res) {
    if ((res.error != null)) {
      return res;
    }
    return null;
  }

  public static ResolveExpressionResult resolveExpressionType(final Expression exp, final List<Variable> variables, final List<Parameter> parameters) {
    boolean _matched = false;
    if (exp instanceof Or) {
      _matched=true;
      final ResolveExpressionResult l = Helpers.resolveExpressionType(((Or)exp).getLeft(), variables, parameters);
      if ((l.error != null)) {
        return l;
      }
      final ResolveExpressionResult r = Helpers.resolveExpressionType(((Or)exp).getRight(), variables, parameters);
      if ((r.error != null)) {
        return r;
      }
      boolean _equals = l.type.equals("Boolean");
      boolean _not = (!_equals);
      if (_not) {
        return new ResolveExpressionResult(exp, (l.type + " is not Boolean."), 
          SymboleoPackage.Literals.OR__LEFT);
      }
      boolean _equals_1 = r.type.equals("Boolean");
      boolean _not_1 = (!_equals_1);
      if (_not_1) {
        return new ResolveExpressionResult(exp, (r.type + " is not Boolean."), 
          SymboleoPackage.Literals.OR__RIGHT);
      }
      return new ResolveExpressionResult("Boolean");
    }
    if (!_matched) {
      if (exp instanceof And) {
        _matched=true;
        final ResolveExpressionResult l = Helpers.resolveExpressionType(((And)exp).getLeft(), variables, parameters);
        if ((l.error != null)) {
          return l;
        }
        final ResolveExpressionResult r = Helpers.resolveExpressionType(((And)exp).getRight(), variables, parameters);
        if ((r.error != null)) {
          return r;
        }
        boolean _equals = l.type.equals("Boolean");
        boolean _not = (!_equals);
        if (_not) {
          return new ResolveExpressionResult(exp, (l.type + " is not Boolean."), 
            SymboleoPackage.Literals.AND__LEFT);
        }
        boolean _equals_1 = r.type.equals("Boolean");
        boolean _not_1 = (!_equals_1);
        if (_not_1) {
          return new ResolveExpressionResult(exp, (r.type + " is not Boolean."), 
            SymboleoPackage.Literals.AND__RIGHT);
        }
        return new ResolveExpressionResult("Boolean");
      }
    }
    if (!_matched) {
      if (exp instanceof Equality) {
        _matched=true;
        final ResolveExpressionResult l = Helpers.resolveExpressionType(((Equality)exp).getLeft(), variables, parameters);
        if ((l.error != null)) {
          return l;
        }
        final ResolveExpressionResult r = Helpers.resolveExpressionType(((Equality)exp).getRight(), variables, parameters);
        if ((r.error != null)) {
          return r;
        }
        boolean _equals = l.type.equals(r.type);
        boolean _not = (!_equals);
        if (_not) {
          return new ResolveExpressionResult(exp, 
            ((l.type + " does not match ") + r.type), 
            SymboleoPackage.Literals.EQUALITY__LEFT);
        }
        return new ResolveExpressionResult("Boolean");
      }
    }
    if (!_matched) {
      if (exp instanceof Comparison) {
        _matched=true;
        final ResolveExpressionResult l = Helpers.resolveExpressionType(((Comparison)exp).getLeft(), variables, parameters);
        if ((l.error != null)) {
          return l;
        }
        final ResolveExpressionResult r = Helpers.resolveExpressionType(((Comparison)exp).getRight(), variables, parameters);
        if ((r.error != null)) {
          return r;
        }
        boolean _equals = l.type.equals(r.type);
        boolean _not = (!_equals);
        if (_not) {
          return new ResolveExpressionResult(exp, 
            ((l.type + " does not match ") + r.type), 
            SymboleoPackage.Literals.COMPARISON__LEFT);
        }
        return new ResolveExpressionResult("Boolean");
      }
    }
    if (!_matched) {
      if (exp instanceof Plus) {
        _matched=true;
        final ResolveExpressionResult l = Helpers.resolveExpressionType(((Plus)exp).getLeft(), variables, parameters);
        if ((l.error != null)) {
          return l;
        }
        final ResolveExpressionResult r = Helpers.resolveExpressionType(((Plus)exp).getRight(), variables, parameters);
        if ((r.error != null)) {
          return r;
        }
        boolean _equals = l.type.equals("Number");
        boolean _not = (!_equals);
        if (_not) {
          return new ResolveExpressionResult(exp, (l.type + " is not Number."), 
            SymboleoPackage.Literals.PLUS__LEFT);
        }
        boolean _equals_1 = r.type.equals("Number");
        boolean _not_1 = (!_equals_1);
        if (_not_1) {
          return new ResolveExpressionResult(exp, (r.type + " is not Number."), 
            SymboleoPackage.Literals.PLUS__RIGHT);
        }
        return new ResolveExpressionResult("Number");
      }
    }
    if (!_matched) {
      if (exp instanceof Minus) {
        _matched=true;
        final ResolveExpressionResult l = Helpers.resolveExpressionType(((Minus)exp).getLeft(), variables, parameters);
        if ((l.error != null)) {
          return l;
        }
        final ResolveExpressionResult r = Helpers.resolveExpressionType(((Minus)exp).getRight(), variables, parameters);
        if ((r.error != null)) {
          return r;
        }
        boolean _equals = l.type.equals("Number");
        boolean _not = (!_equals);
        if (_not) {
          return new ResolveExpressionResult(exp, (l.type + " is not Number."), 
            SymboleoPackage.Literals.MINUS__LEFT);
        }
        boolean _equals_1 = r.type.equals("Number");
        boolean _not_1 = (!_equals_1);
        if (_not_1) {
          return new ResolveExpressionResult(exp, (r.type + " is not Number."), 
            SymboleoPackage.Literals.MINUS__RIGHT);
        }
        return new ResolveExpressionResult("Number");
      }
    }
    if (!_matched) {
      if (exp instanceof Multi) {
        _matched=true;
        final ResolveExpressionResult l = Helpers.resolveExpressionType(((Multi)exp).getLeft(), variables, parameters);
        if ((l.error != null)) {
          return l;
        }
        final ResolveExpressionResult r = Helpers.resolveExpressionType(((Multi)exp).getRight(), variables, parameters);
        if ((r.error != null)) {
          return r;
        }
        boolean _equals = l.type.equals("Number");
        boolean _not = (!_equals);
        if (_not) {
          return new ResolveExpressionResult(exp, (l.type + " is not Number."), 
            SymboleoPackage.Literals.MULTI__LEFT);
        }
        boolean _equals_1 = r.type.equals("Number");
        boolean _not_1 = (!_equals_1);
        if (_not_1) {
          return new ResolveExpressionResult(exp, (r.type + " is not Number."), 
            SymboleoPackage.Literals.MULTI__RIGHT);
        }
        return new ResolveExpressionResult("Number");
      }
    }
    if (!_matched) {
      if (exp instanceof Div) {
        _matched=true;
        final ResolveExpressionResult l = Helpers.resolveExpressionType(((Div)exp).getLeft(), variables, parameters);
        if ((l.error != null)) {
          return l;
        }
        final ResolveExpressionResult r = Helpers.resolveExpressionType(((Div)exp).getRight(), variables, parameters);
        if ((r.error != null)) {
          return r;
        }
        boolean _equals = l.type.equals("Number");
        boolean _not = (!_equals);
        if (_not) {
          return new ResolveExpressionResult(exp, (l.type + " is not Number."), 
            SymboleoPackage.Literals.DIV__LEFT);
        }
        boolean _equals_1 = r.type.equals("Number");
        boolean _not_1 = (!_equals_1);
        if (_not_1) {
          return new ResolveExpressionResult(exp, (r.type + " is not Number."), 
            SymboleoPackage.Literals.DIV__RIGHT);
        }
        return new ResolveExpressionResult("Number");
      }
    }
    if (!_matched) {
      if (exp instanceof PrimaryExpressionRecursive) {
        _matched=true;
        return Helpers.resolveExpressionType(((PrimaryExpressionRecursive)exp).getInner(), variables, parameters);
      }
    }
    if (!_matched) {
      if (exp instanceof PrimaryExpressionFunctionCall) {
        _matched=true;
        FunctionCall _function = ((PrimaryExpressionFunctionCall)exp).getFunction();
        boolean _matched_1 = false;
        if (_function instanceof TwoArgMathFunction) {
          _matched_1=true;
        }
        if (!_matched_1) {
          if (_function instanceof OneArgMathFunction) {
            _matched_1=true;
          }
        }
        if (_matched_1) {
          return new ResolveExpressionResult("Number");
        }
        if (!_matched_1) {
          if (_function instanceof ThreeArgStringFunction) {
            _matched_1=true;
          }
          if (!_matched_1) {
            if (_function instanceof TwoArgStringFunction) {
              _matched_1=true;
            }
          }
          if (!_matched_1) {
            if (_function instanceof OneArgStringFunction) {
              _matched_1=true;
            }
          }
          if (_matched_1) {
            return new ResolveExpressionResult("String");
          }
        }
        if (!_matched_1) {
          if (_function instanceof ThreeArgDateFunction) {
            _matched_1=true;
            return new ResolveExpressionResult("Date");
          }
        }
      }
    }
    if (!_matched) {
      if (exp instanceof NegatedPrimaryExpression) {
        _matched=true;
        final ResolveExpressionResult t = Helpers.resolveExpressionType(((NegatedPrimaryExpression)exp).getExpression(), variables, parameters);
        if ((t.error != null)) {
          return t;
        }
        boolean _equals = t.type.equals("Boolean");
        boolean _not = (!_equals);
        if (_not) {
          return new ResolveExpressionResult(exp, (t.type + " is not Boolean."), 
            SymboleoPackage.Literals.NEGATED_PRIMARY_EXPRESSION__EXPRESSION);
        }
        return new ResolveExpressionResult("Boolean");
      }
    }
    if (!_matched) {
      if (exp instanceof AtomicExpressionTrue) {
        _matched=true;
      }
      if (!_matched) {
        if (exp instanceof AtomicExpressionFalse) {
          _matched=true;
        }
      }
      if (_matched) {
        return new ResolveExpressionResult("Boolean");
      }
    }
    if (!_matched) {
      if (exp instanceof AtomicExpressionDouble) {
        _matched=true;
      }
      if (!_matched) {
        if (exp instanceof AtomicExpressionInt) {
          _matched=true;
        }
      }
      if (_matched) {
        return new ResolveExpressionResult("Number");
      }
    }
    if (!_matched) {
      if (exp instanceof AtomicExpressionDate) {
        _matched=true;
        return new ResolveExpressionResult("Date");
      }
    }
    if (!_matched) {
      if (exp instanceof AtomicExpressionEnum) {
        _matched=true;
        String _name = ((AtomicExpressionEnum)exp).getEnumeration().getName();
        return new ResolveExpressionResult(_name);
      }
    }
    if (!_matched) {
      if (exp instanceof AtomicExpressionString) {
        _matched=true;
        return new ResolveExpressionResult("String");
      }
    }
    if (!_matched) {
      if (exp instanceof AtomicExpressionParameter) {
        _matched=true;
        return Helpers.getVariableExpressionType(((AtomicExpressionParameter)exp).getValue(), variables, parameters);
      }
    }
    return null;
  }

  public static ResolveExpressionResult handleDomainType(final DomainType t) {
    boolean _matched = false;
    if (t instanceof Alias) {
      _matched=true;
      String _name = ((Alias)t).getName();
      return new ResolveExpressionResult(_name);
    }
    if (!_matched) {
      if (t instanceof RegularType) {
        _matched=true;
        String _name = ((RegularType)t).getName();
        return new ResolveExpressionResult(_name);
      }
    }
    if (!_matched) {
      if (t instanceof Enumeration) {
        _matched=true;
        String _name = ((Enumeration)t).getName();
        return new ResolveExpressionResult(_name);
      }
    }
    return null;
  }

  public static ResolveExpressionResult getVariableExpressionType(final Ref argRef, final List<Variable> variables, final List<Parameter> parameters) {
    ResolveExpressionResult _xblockexpression = null;
    {
      final EObject t = Helpers.getDotExpressionType(argRef, variables, parameters);
      ResolveExpressionResult _switchResult = null;
      boolean _matched = false;
      if (t instanceof ParameterType) {
        _matched=true;
        DomainType _domainType = ((ParameterType)t).getDomainType();
        boolean _tripleNotEquals = (_domainType != null);
        if (_tripleNotEquals) {
          return Helpers.handleDomainType(((ParameterType)t).getDomainType());
        } else {
          BaseType _baseType = ((ParameterType)t).getBaseType();
          boolean _tripleNotEquals_1 = (_baseType != null);
          if (_tripleNotEquals_1) {
            String _name = ((ParameterType)t).getBaseType().getName();
            return new ResolveExpressionResult(_name);
          }
        }
      }
      if (!_matched) {
        if (t instanceof DomainType) {
          _matched=true;
          _switchResult = Helpers.handleDomainType(((DomainType)t));
        }
      }
      if (!_matched) {
        if (t instanceof BaseType) {
          _matched=true;
          String _name = ((BaseType)t).getName();
          return new ResolveExpressionResult(_name);
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  public static EObject getDotExpressionType(final Ref argRef, final List<Variable> variables, final List<Parameter> parameters) {
    if ((argRef instanceof VariableRef)) {
      final Function1<Variable, Boolean> _function = (Variable v) -> {
        return Boolean.valueOf(v.getName().equals(((VariableRef)argRef).getVariable()));
      };
      final Variable selectedVar = IterableExtensions.<Variable>findFirst(variables, _function);
      final Function1<Parameter, Boolean> _function_1 = (Parameter p) -> {
        return Boolean.valueOf(p.getName().equals(((VariableRef)argRef).getVariable()));
      };
      final Parameter selectedParam = IterableExtensions.<Parameter>findFirst(parameters, _function_1);
      if ((selectedVar != null)) {
        return selectedVar.getType();
      } else {
        if ((selectedParam != null)) {
          return selectedParam.getType();
        }
      }
      return null;
    }
    if ((argRef instanceof VariableDotExpression)) {
      BaseType _baseType = ((VariableDotExpression)argRef).getTail().getBaseType();
      boolean _tripleNotEquals = (_baseType != null);
      if (_tripleNotEquals) {
        return ((VariableDotExpression)argRef).getTail().getBaseType();
      } else {
        DomainType _domainType = ((VariableDotExpression)argRef).getTail().getDomainType();
        boolean _tripleNotEquals_1 = (_domainType != null);
        if (_tripleNotEquals_1) {
          return ((VariableDotExpression)argRef).getTail().getDomainType();
        }
      }
    }
    return null;
  }

  public static Boolean isDotExpressionTypeOfEvent(final Ref argRef, final List<Variable> variables, final List<Parameter> parameters) {
    final EObject t = Helpers.getDotExpressionType(argRef, variables, parameters);
    boolean _matched = false;
    if (t instanceof ParameterType) {
      _matched=true;
      DomainType _domainType = ((ParameterType)t).getDomainType();
      boolean _tripleNotEquals = (_domainType != null);
      if (_tripleNotEquals) {
        return Boolean.valueOf(Helpers.getBaseType(((ParameterType)t).getDomainType()).getOntologyType().getName().equalsIgnoreCase("Event"));
      } else {
        return Boolean.valueOf(false);
      }
    }
    if (!_matched) {
      if (t instanceof DomainType) {
        _matched=true;
        return Boolean.valueOf(Helpers.getBaseType(((DomainType)t)).getOntologyType().getName().equalsIgnoreCase("Event"));
      }
    }
    if (!_matched) {
      if (t instanceof BaseType) {
        _matched=true;
        return Boolean.valueOf(false);
      }
    }
    return Boolean.valueOf(false);
  }

  public static String getDotExpressionStringType(final Ref argRef, final List<Variable> variables, final List<Parameter> parameters) {
    String _xblockexpression = null;
    {
      final EObject t = Helpers.getDotExpressionType(argRef, variables, parameters);
      String _switchResult = null;
      boolean _matched = false;
      if (t instanceof ParameterType) {
        _matched=true;
        DomainType _domainType = ((ParameterType)t).getDomainType();
        boolean _tripleNotEquals = (_domainType != null);
        if (_tripleNotEquals) {
          return ((ParameterType)t).getDomainType().getName();
        } else {
          BaseType _baseType = ((ParameterType)t).getBaseType();
          boolean _tripleNotEquals_1 = (_baseType != null);
          if (_tripleNotEquals_1) {
            return ((ParameterType)t).getBaseType().getName();
          }
        }
      }
      if (!_matched) {
        if (t instanceof DomainType) {
          _matched=true;
          _switchResult = ((DomainType)t).getName();
        }
      }
      if (!_matched) {
        if (t instanceof BaseType) {
          _matched=true;
          return ((BaseType)t).getName();
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}
