import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {
    String path = "src/main/resources/";
    @Test
    public void squareInputTest() throws FileNotFoundException {
        Rectangle rectangle = new Rectangle(path + "square1.txt");
        assertEquals(3., rectangle.getSide());
        assertEquals(3., rectangle.getSideB());
    }

    @Test
    public void triangleInputTest() throws FileNotFoundException {
        Rectangle rectangle = new Rectangle(path + "triangleAndSquare.txt");
        assertEquals(3.4, rectangle.getSide());
        assertEquals(4.97, Math.round(rectangle.getSideB() * 100.0) / 100.0);
        assertEquals(new Point(2.2, -2.3830127018922194), rectangle.getCenter());
    }
    @Test
    public void hexagonInputTest() throws FileNotFoundException {
        Rectangle rectangle = new Rectangle(path + "hexagonAndSquare.txt");
        assertEquals(6.0, rectangle.getSide());
        assertEquals(6.70, Math.round(rectangle.getSideB()*100.0)/100.0);
        assertEquals( new  Point(2.0, -3.2490381056766577),rectangle.getCenter());
    }
    @Test
    public void circlesInputTest()throws FileNotFoundException {
        Rectangle rectangle = new Rectangle(path + "circle3.txt");
        assertEquals(10., rectangle.getSide());
        assertEquals(10., rectangle.getSideB());
        assertEquals(new  Point(2., 2.), rectangle.getCenter());
    }
}
