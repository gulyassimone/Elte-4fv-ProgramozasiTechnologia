
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @ParameterizedTest
    @ValueSource (doubles = 1.5)
    public void pointTest(Double a){
        Point point = new Point(a, a);
        assertEquals(a, point.getX());
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
        Circle circle = new Circle(new Point(1.5, 1.5),a);
        assertEquals(a, circle.getSugar());
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

}
