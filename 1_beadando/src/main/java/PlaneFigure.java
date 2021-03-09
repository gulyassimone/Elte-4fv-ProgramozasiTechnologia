
public abstract class PlaneFigure {

  protected Point center;

  public PlaneFigure(Point center) {
    this.center = center;
  }


  public Point getCenter() {
  return center;
  }

  public abstract Double getMinX();

  public abstract Double getMaxX();

  public abstract Double getMinY();

  public abstract Double getMaxY();

}