package ca.uottawa.csmlab.symboleo.generator;

import ca.uottawa.csmlab.symboleo.symboleo.PointAtomParameterDotExpression;
import ca.uottawa.csmlab.symboleo.symboleo.PointExpression;
import ca.uottawa.csmlab.symboleo.symboleo.PointFunction;
import ca.uottawa.csmlab.symboleo.symboleo.Timevalue;
import ca.uottawa.csmlab.symboleo.symboleo.TimevalueInt;

@SuppressWarnings("all")
public class Tpoint {
  public enum Type {
    VARIABLE,

    EVENT;
  }

  public Integer time1;

  public timeUnit unit;

  public String time;

  public Tpoint.Type type;

  public String event;

  public Tpoint(final PointExpression point) {
    if ((point instanceof PointFunction)) {
      final Timevalue pv = ((PointFunction)point).getValue();
      final String pu = ((PointFunction)point).getTimeUnit();
      if ((pv instanceof TimevalueInt)) {
        this.time1 = Integer.valueOf(((TimevalueInt)pv).getValue());
        if (pu != null) {
          switch (pu) {
            case "seconds":
              this.unit = timeUnit.SECOND;
              break;
            case "minutes":
              this.unit = timeUnit.MINUTE;
              break;
            case "hours":
              this.unit = timeUnit.HOUR;
              break;
            case "days":
              this.unit = timeUnit.DAY;
              break;
            case "weeks":
              this.unit = timeUnit.MONTH;
              break;
            case "years":
              this.unit = timeUnit.YEAR;
              break;
            default:
              this.unit = timeUnit.DAY;
              break;
          }
        } else {
          this.unit = timeUnit.DAY;
        }
      }
    } else {
      if ((point instanceof PointAtomParameterDotExpression)) {
        this.event = SymboleoPCGenerator.generateDotExpressionString(((PointAtomParameterDotExpression)point).getVariable(), null);
        this.type = Tpoint.Type.EVENT;
      }
    }
  }
}
