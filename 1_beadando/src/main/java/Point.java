
public class Point {

  public Double x;

  public Double y;

  @Override
  public String toString() {
    return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }

  public Point(Double x, Double y) {
    this.x = x;
    this.y = y;
  }

  public Double getX() {
  return x;
  }

  public Double getY() {
  return y;
  }

}