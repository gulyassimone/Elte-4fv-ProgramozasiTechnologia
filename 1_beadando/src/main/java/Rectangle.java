import java.util.Comparator;
import java.util.List;

public class Rectangle extends Square {

  private Double sideB;

  public Rectangle(List<PlaneFigure> planeFigures) {
    super(null, 0.);

    Double maxX = planeFigures.stream().max(Comparator.comparing(elem -> elem.getMaxX())).get().getMaxX();
    Double minX = planeFigures.stream().max(Comparator.comparing(elem -> elem.getMaxX())).get().getMinX();
    Double maxY = planeFigures.stream().max(Comparator.comparing(elem -> elem.getMaxY())).get().getMaxY();
    Double minY = planeFigures.stream().min(Comparator.comparing(elem -> elem.getMinY())).get().getMinY();

    side = Math.abs(maxX - minX);
    sideB = Math.abs(maxY - minY);
    center = new Point(side/2, sideB/2);
  }

  public Double getSideB() {
    return sideB;
  }

  @Override
  public Double getMinY() {
    return center.y - sideB/2;
  }

  @Override
  public Double getMaxY() {
    return center.y + sideB/2;
  }

  @Override
  public String toString() {
    return "Rectangle{" +
            "center=" + center +
            ", sideB=" + sideB +
            ", side=" + side +
            '}';
  }
}