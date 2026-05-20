package ca.uottawa.csmlab.symboleo;

import ca.uottawa.csmlab.symboleo.symboleo.Expression;
import org.eclipse.emf.ecore.EReference;

@SuppressWarnings("all")
public class ResolveExpressionResult {
  public ResolveExpressionResult(final String argType, final Expression argError, final String argMessage, final EReference argRef) {
    this.type = argType;
    this.message = argMessage;
    this.error = argError;
    this.ref = argRef;
  }

  public ResolveExpressionResult(final String argType) {
    this(argType, null, null, null);
  }

  public ResolveExpressionResult(final Expression argError, final String argMessage, final EReference argRef) {
    this(null, argError, argMessage, argRef);
  }

  public String type;

  public String message;

  public Expression error;

  public EReference ref;
}
