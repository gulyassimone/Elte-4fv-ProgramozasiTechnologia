
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTests {

    @ParameterizedTest
    @ValueSource(doubles = 1.5)
    public void pointTest(Double a){
        Point point = new Point(a, a);
        assertEquals(a, point.getX());
        assertEquals(a, point.getY());
    }
    @ParameterizedTest
    @ValueSource (doubles = {-1,0})
    public void circleNegativeTest(Double a){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Circle(new Point(1.5, 1.5),a));
        String message = "The radius cannot be less than or equal to zero!";
        assertEquals(message, exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource (doubles = {0.1,100})
    public void circlePositiveTest(Double a){
        Circle circle = new Circle(new Point(1.5, -1.5),a);
        assertEquals(a, circle.getradius());
    }
    @ParameterizedTest
    @ValueSource (doubles = {-1,0})
    public void squareNegativeTest(Double a){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Square(new Point(1.5, 1.5),a));
        String message = "The side cannot be less than or equal to zero!";
        assertEquals(message, exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource (doubles = {0.1,100})
    public void squarePositiveTest(Double a){
        Square square = new Square(new Point(1.5, 1.5),a);
        assertEquals(a, square.getSide());
    }
    @ParameterizedTest
    @ValueSource (doubles = {-1,0})
    public void triangleNegativeTest(Double a){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(new Point(1.5, 1.5),a));
        String message = "The side cannot be less than or equal to zero!";
        assertEquals(message, exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource (doubles = {0.1,100})
    public void trianglePositiveTest(Double a){
        Triangle triangle = new Triangle(new Point(1.5, 1.5),a);
        assertEquals(a, triangle.getSide());
    }
    @ParameterizedTest
    @ValueSource (doubles = {-1,0})
    public void hexagonNegativeTest(Double a){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Hexagon(new Point(1.5, 1.5),a));
        String message = "The side cannot be less than or equal to zero!";
        assertEquals(message, exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource (doubles = {0.1,100})
    public void hexagonPositiveTest(Double a){
        Hexagon hexagon = new Hexagon(new Point(1.5, 1.5),a);
        assertEquals(a, hexagon.getSide());
    }

    @Test
    public void reactangleNullInputTest(){
         assertThrows(FileNotFoundException.class, () -> new Rectangle("nothing.txt"));
    }
    @Test
    public void reactangleWrongShapeInputTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Rectangle("src/main/resources/wrongShape.txt"));
        String message = "Only the following planes are acceptable: triangle, square,circle,hexagon";
        assertEquals(message, exception.getMessage());
    }

    @Test
    public void reactangleInputTest() throws FileNotFoundException {
        Rectangle rectangle = new Rectangle("src/main/resources/circle.txt");
        assertEquals(6.2, rectangle.getMaxX());
        assertEquals(8., rectangle.getMaxY());
        assertEquals(-3.8, rectangle.getMinX() );
        assertEquals(-2, rectangle.getMinY());
    }
}
