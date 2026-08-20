package ca.uottawa.csmlab.symboleo.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;

/**
 * Attaches actionable hints to the ANTLR parse errors that recur in generated
 * SymboleoAC, where the raw message names grammar internals rather than the
 * mistake (a reserved word used as a type name surfaces as "mismatched input
 * 'Asset' expecting 'endDomain'" - neither the offending identifier nor the
 * legal alternative).
 *
 * The default message passes through byte-for-byte; the hint travels out of
 * band in the issue's data array under {@link #HINT_CODE}. Consumers matching
 * on message text are unaffected, and surfacing a hint is an opt-in per issue
 * code rather than prose to reparse out of the message.
 *
 * Hints are keyed off the offending token alone - the provider cannot see
 * syntactic context - so several are phrased conditionally.
 */
public class SymboleoSyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {

  /**
   * Issue code marking a diagnostic whose {@code getData()[0]} carries a hint.
   * The hint is advisory prose, not a stable contract - wording will improve.
   */
  public static final String HINT_CODE = "ca.uottawa.csmlab.symboleo.syntaxHint";

  private static final Set<String> BASE_TYPES = new HashSet<String>(
      Arrays.asList("Number", "String", "Boolean"));
  private static final Set<String> ONTOLOGY_TYPES = new HashSet<String>(
      Arrays.asList("Asset", "Event", "Role", "Contract", "DataTransfer"));
  /** The PowerFunction actions — legal as a power's consequent, nowhere else. */
  private static final Set<String> NORM_STATES = new HashSet<String>(
      Arrays.asList("Suspended", "Resumed", "Discharged", "Terminated", "Triggered"));

  /**
   * Keywords the grammar allows after {@code ID ':'}, where the reserved-word
   * hint below must stay silent. A declaration and a norm open identically
   * ({@code name=ID ':' Type 'with'} vs {@code name=ID ':' ... 'O' '('}), so an
   * unresolved error inside Declarations leaves the parser reading norms as
   * more declarations and reporting a correct {@code o1: O(...)} as "mismatched
   * input 'O' expecting RULE_ID" - and a rename hint there instructs the reader
   * to break a correct line.
   *
   * Members are the norm heads plus the first-set of the optional trigger
   * Proposition, stated from the grammar rules rather than from observed
   * failures; some are unreachable because an earlier branch claims them first,
   * and are listed anyway so the set encodes the rule. Applied whichever token
   * was expected, not only RULE_ID: an unclosed Domain section derails the same
   * way, and none of these words is a plausible declared name to begin with.
   */
  private static final Set<String> LEGAL_AFTER_NAME_COLON = new HashSet<String>(Arrays.asList(
      "O", "Obligation", "P", "Power",
      "Happens", "WhappensBefore", "ShappensBefore", "HappensWithin", "WhappensBeforeE",
      "ShappensBeforeE", "HappensAfter", "Occurs", "HappensAssign", "Assign",
      "IsEqual", "IsOwner", "CannotBeAssigned",
      "not", "true", "false", "Date"));

  @Override
  public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
    SyntaxErrorMessage standard = super.getSyntaxErrorMessage(context);
    if (standard == null) {
      return null;
    }
    String hint = hintFor(context);
    if (hint == null) {
      return standard;
    }
    // The default provider leaves the issue code null for syntax errors, so
    // overwriting it loses nothing.
    return new SyntaxErrorMessage(standard.getMessage(), HINT_CODE, new String[] {hint});
  }

  private String hintFor(IParserErrorContext context) {
    RecognitionException exception = context.getRecognitionException();
    if (exception == null || exception.token == null) {
      return null;
    }
    String text = exception.token.getText();
    if (text == null) {
      return null;
    }
    String[] names = context.getTokenNames();
    String expecting = expectedTokenName(exception, names);
    boolean noViableAlt = exception instanceof NoViableAltException;

    if ("Date".equals(text)) {
      if ("RULE_ID".equals(expecting)) {
        return standaloneValueHint("Date");
      }
      if (noViableAlt) {
        return "a Date(\"yyyy/MM/dd HH:mm:ss\") literal is legal only in a declaration's "
            + "with-binding, and Date.add(...) only in a with-binding or in a temporal "
            + "predicate's time position (WhappensBefore, ShappensBefore, HappensAfter, "
            + "Interval). In a predicate, reference a Date attribute you bound in "
            + "Declarations instead.";
      }
      return null;
    }
    if (BASE_TYPES.contains(text)) {
      if ("RULE_ID".equals(expecting)) {
        return standaloneValueHint(text);
      }
      if (noViableAlt) {
        return "'" + text + "' cannot be used here. A base type name is legal only as an "
            + "attribute or parameter type, or after 'isA'. There is no '" + text
            + "(...)' constructor - write the value itself (a number, a quoted string) "
            + "or reference an attribute or parameter that holds it.";
      }
      return null;
    }
    if (ONTOLOGY_TYPES.contains(text)) {
      return "'" + text + "' is the base ontology word and is legal only to the right of "
          + "'isA'/'isAn'. Wherever a type is referenced - an attribute, a parameter, a "
          + "declaration - write a domain type you declared with 'isA" + article(text)
          + " " + text + "', never the base word itself"
          + ("Role".equals(text)
              ? " (for example 'performer: Seller', never 'performer: Role')"
              : "")
          + ".";
    }
    if ("Assign".equals(text) || "HappensAssign".equals(text)) {
      return "'Assign(...)' and 'HappensAssign(...)' are legal only as an obligation's "
          + "consequent. A power's consequent must be a state change - Terminated(self), "
          + "Suspended(obligations.<name>), Resumed(obligations.<name>), "
          + "Triggered(obligations.<name>) - so a value update belongs in an obligation, "
          + "not in a power.";
    }
    if (NORM_STATES.contains(text) && noViableAlt) {
      // The most frequent generated mistake: a mandatory "shall terminate"
      // written as O(..., Terminated(self)); the raw error names neither the
      // restriction nor the construct to move to.
      return "'" + text + "(...)' changes the state of a norm or the contract, and only "
          + "a power's consequent may do that. If this is an obligation's consequent, "
          + "move it to a power - 'p1: P(creditor, debtor, <antecedent>, " + text
          + "(...))' - and model even a mandatory \"shall suspend/terminate\" as a "
          + "power, since the language has no other way to express a state change.";
    }
    if ("Happens".equals(text) && noViableAlt) {
      return "if this 'Happens' is the last argument of a P(...) power: a power's "
          + "consequent must be a state change such as Terminated(self) or "
          + "Suspended(obligations.<name>); an awaited event belongs in the power's "
          + "antecedent (the third argument) instead.";
    }
    // An identifier-shaped keyword where a name or section terminator was
    // expected: a reserved word used as a declared name - unless the grammar
    // allows the word there, which marks a derailed parse instead (see
    // LEGAL_AFTER_NAME_COLON).
    if (isKeywordToken(exception.token, names) && looksLikeIdentifier(text)
        && !LEGAL_AFTER_NAME_COLON.contains(text)
        && ("RULE_ID".equals(expecting) || "endDomain".equals(expecting)
            || "endContract".equals(expecting))) {
      // Offer a suffix without presuming the category: a reader copies the
      // example literally, and 'Event' is wrong for anything not an event.
      return "'" + text + "' is a reserved word in SymboleoAC and cannot be used as a "
          + "name you declare. Rename it here and at every reference to it - a suffix "
          + "naming what it is works ('" + text + "Event' for an event, '" + text
          + "Record' for an asset).";
    }
    return null;
  }

  private String standaloneValueHint(String type) {
    return "'" + type + "' is a base type and cannot be the type of a declared variable: "
        + "every declaration is an instance of a domain type from the Domain section, so "
        + "there are no standalone values. Bind the value to an attribute of a domain "
        + "type, or make it a contract parameter (for example 'lateFee: Number' in the "
        + "parameter list) and reference the parameter directly.";
  }

  /** The expected token's bare name ("RULE_ID", "endDomain"), or null. */
  private String expectedTokenName(RecognitionException exception, String[] names) {
    if (!(exception instanceof MismatchedTokenException) || names == null) {
      return null;
    }
    int expecting = ((MismatchedTokenException) exception).expecting;
    if (expecting < 0 || expecting >= names.length || names[expecting] == null) {
      return null;
    }
    return stripQuotes(names[expecting]);
  }

  private boolean isKeywordToken(Token token, String[] names) {
    int type = token.getType();
    return names != null && type >= 0 && type < names.length && names[type] != null
        && names[type].startsWith("'");
  }

  private boolean looksLikeIdentifier(String text) {
    if (text.isEmpty() || !Character.isJavaIdentifierStart(text.charAt(0))) {
      return false;
    }
    for (int i = 1; i < text.length(); i++) {
      if (!Character.isJavaIdentifierPart(text.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private String stripQuotes(String tokenName) {
    if (tokenName.length() >= 2 && tokenName.startsWith("'") && tokenName.endsWith("'")) {
      return tokenName.substring(1, tokenName.length() - 1);
    }
    return tokenName;
  }

  private String article(String ontologyWord) {
    return ("Asset".equals(ontologyWord) || "Event".equals(ontologyWord)) ? "n" : "";
  }
}
