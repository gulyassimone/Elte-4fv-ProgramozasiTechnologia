import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * This class implements a smallest rectangle that covers all planes
 */
public class Rectangle extends Square {

    private ArrayList<PlaneFigure> planeFigures = new ArrayList<>();
    private Double sideB;

    /**
     * The constructor calculates the data required for the rectangle.
     * @param filename
     * @throws FileNotFoundException
     */
    public Rectangle(String filename) throws FileNotFoundException{
        super();
        readData(filename);
        if (planeFigures == null) throw new NullPointerException("One plane figure is necessery");
        Double maxX = planeFigures.stream().max(Comparator.comparing(elem -> elem.getMaxX())).get().getMaxX();
        Double minX = planeFigures.stream().min(Comparator.comparing(elem -> elem.getMinX())).get().getMinX();
        Double maxY = planeFigures.stream().max(Comparator.comparing(elem -> elem.getMaxY())).get().getMaxY();
        Double minY = planeFigures.stream().min(Comparator.comparing(elem -> elem.getMinY())).get().getMinY();


        side = Math.abs(maxX - minX);
        sideB = Math.abs(maxY - minY);
        center = new Point(maxX - side / 2, maxY - sideB / 2);


    }

    /**
     * Function read data from input file
     * @param filename
     * @throws FileNotFoundException
     */
    public void readData(String filename) throws FileNotFoundException{
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename))).useLocale(Locale.US);
        int numPlaneFigures= sc.nextInt();
        while (sc.hasNext()) {
            PlaneFigure planeFigure;
            String kind = sc.next();
            Double x = sc.nextDouble();
            Double y = sc.nextDouble();
            Double side = sc.nextDouble();
            switch (kind.toLowerCase(Locale.ROOT)) {
                case "triangle":
                    planeFigure = new Triangle(new Point(x,y),side);
                    break;
                case "square":
                    planeFigure = new Square(new Point(x,y),side);
                    break;
                case "circle":
                    planeFigure = new Circle(new Point(x,y),side);
                    break;
                case "hexagon":
                    planeFigure = new Hexagon(new Point(x,y),side);
                    break;
                default:
                    throw new IllegalArgumentException("Only the following planes are acceptable: triangle, square,circle,hexagon");
            }

            planeFigures.add(planeFigure);
        }

    }


    public Double getSideB() {
        return sideB;
    }

    @Override
    public Double getMinY() {
        return center.y - sideB / 2;
    }

    @Override
    public Double getMaxY() {
        return center.y + sideB / 2;
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