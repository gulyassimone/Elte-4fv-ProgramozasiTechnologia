

public class Triangle extends Square {

  protected Double height;

  @Override
  public Double getMinY() {
  return (center.y - Math.sqrt(3)/3*(side/2));
  }

  @Override
  public Double getMaxY() {
  return (super.center.y + (height - Math.sqrt(3)/3*(side/2)));
  }

  public Triangle(Point center,  Double side) {
    super(center, side);
    height = (Math.sqrt(3)/2)*side;
  }
}