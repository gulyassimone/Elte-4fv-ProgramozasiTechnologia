/**
 * This class implements a hexagon represented by the center of the shape and a side
 */
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