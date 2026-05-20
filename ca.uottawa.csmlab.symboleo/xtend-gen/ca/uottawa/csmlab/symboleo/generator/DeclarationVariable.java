package ca.uottawa.csmlab.symboleo.generator;

import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class DeclarationVariable {
  public String name;

  public String starter;

  public String type;

  public ArrayList<Pair<String, String>> parameters;

  public DeclarationVariable(final String name, final String starter, final String type, final ArrayList<Pair<String, String>> parameters) {
    this.name = name;
    this.starter = starter;
    this.type = type;
    this.parameters = parameters;
  }
}
