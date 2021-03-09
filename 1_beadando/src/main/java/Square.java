public class Square extends PlaneFigure {

  protected Double side;

  public Square(Point center, Double side) {
    super(center);
    if(side <=0 ) throw new IllegalArgumentException("The side cannot be less than or equal to zero!");
    this.side = side;
  }

  public Double getSide() {
    return side;
  }

  @Override
  public String toString() {
    return "Square{" +
            "center=" + center +
            ", side=" + side +
            '}';
  }

  @Override
  public Double getMinX() {
  return (center.x - side / 2);
  }

  @Override
  public Double getMaxX() {
  return (center.x + side / 2);
  }

  @Override
  public Double getMinY() {
    return (center.y - side / 2);
  }

  @Override
  public Double getMaxY() {
  return (center.y + side / 2);
  }
}