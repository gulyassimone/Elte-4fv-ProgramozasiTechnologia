public class Hexagon extends Triangle {

  public Hexagon(Point center, Double side) {
    super(center, side);
  }


  @Override
  public Double getMinX() {
  return center.x - side;
  }

  @Override
  public Double getMaxX() {
  return center.x + side;
  }

  @Override
  public Double getMinY() {
  return center.y - height;
  }

  @Override
  public Double getMaxY() {
  return center.y + height;
  }
}