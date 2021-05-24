
public abstract class PlaneFigure {

  protected Point center;

  public PlaneFigure(Point center) {
    this.center = center;
  }

  protected PlaneFigure() {

  }

  public Point getCenter() {
  return center;
  }

  /**
   * This function calculates the smallest horizontal value
   * @return
   */
  public abstract Double getMinX();

  /**
   * This function calculates the greatest horizontal value
   * @return
   */
  public abstract Double getMaxX();

  /**
   * This function calculates the smallest vertical value
   * @return
   */
  public abstract Double getMinY();

  /**
   * This function calculates the greatest vertical value
   * @return
   */
  public abstract Double getMaxY();

}