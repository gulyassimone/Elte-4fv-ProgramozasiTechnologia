import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {

    @Test
    public void oneInputTest(){
        List<PlaneFigure> planeFigures = new ArrayList<>();
        Square square = new Square(new Point(2.4, -1.4), 3.);
        planeFigures.add(square);
        Rectangle rectangle = new Rectangle(planeFigures);
        System.out.println(rectangle);
       // assertEquals(rectangle.getSide(), 3.);
        assertEquals(rectangle.getSideB(), 3.);
    }
}
