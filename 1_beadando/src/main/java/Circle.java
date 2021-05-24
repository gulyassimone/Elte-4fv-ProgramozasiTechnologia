/**
 * This class implements a circle represented by the radius and a the center of circle
 */

public class Circle extends PlaneFigure {

  Double radius;

  public Circle(Point center, Double radius) {
    super(center);
    if(radius <=0 ) throw new IllegalArgumentException("The radius cannot be less than or equal to zero!");
    this.radius = radius;
  }

  public Double getradius() {
    return radius;
  }

  @Override
  public Double getMinX() {
  return (center.x - radius);
  }

  @Override
  public Double getMaxX() {
  return (center.x + radius);
  }


  @Override
  public Double getMinY() {
  return (center.y - radius);
  }


  @Override
  public Double getMaxY() {
  return (center.y + radius);
  }


}