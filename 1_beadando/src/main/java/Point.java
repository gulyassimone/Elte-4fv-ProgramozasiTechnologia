import java.util.Objects;

/**
 * This class implements a point which represented by distance from coordinate axis
 */
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return Objects.equals(x, point.x) && Objects.equals(y, point.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}