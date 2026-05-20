package ca.uottawa.csmlab.symboleo.generator;

import ca.uottawa.csmlab.symboleo.symboleo.PointExpression;

@SuppressWarnings("all")
public class SymboleoPredicate {
  public predicateType predicate;

  public String event;

  public Tpoint time1;

  public Tpoint time2;

  public SymboleoPredicate(final predicateType predicate, final String event) {
    this.predicate = predicate;
    this.event = event;
  }

  public SymboleoPredicate(final predicateType predicate, final String event, final PointExpression point) {
    this.predicate = predicate;
    this.event = event;
    Tpoint _tpoint = new Tpoint(point);
    this.time1 = _tpoint;
  }

  public SymboleoPredicate(final predicateType predicate, final String event, final PointExpression point1, final PointExpression point2) {
    this.predicate = predicate;
    this.event = event;
    Tpoint _tpoint = new Tpoint(point1);
    this.time1 = _tpoint;
    Tpoint _tpoint_1 = new Tpoint(point2);
    this.time2 = _tpoint_1;
  }
}
