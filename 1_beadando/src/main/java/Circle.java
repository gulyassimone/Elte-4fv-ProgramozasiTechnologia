public class Circle extends PlaneFigure {

  Double sugar;

  public Circle(Point center, Double sugar) {
    super(center);
    if(sugar <=0 ) throw new IllegalArgumentException("The radius cannot be less than or equal to zero!");
    this.sugar = sugar;
  }

  public Double getSugar() {
    return sugar;
  }

  @Override
  public Double getMinX() {
  return (center.x - sugar);
  }

  @Override
  public Double getMaxX() {
  return (center.x + sugar);
  }

  @Override
  public Double getMinY() {
  return (center.y - sugar);
  }

  @Override
  public Double getMaxY() {
  return (center.x + sugar);
  }


}