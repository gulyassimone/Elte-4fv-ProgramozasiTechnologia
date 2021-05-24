package colorclicker;

import java.awt.Color;

public class Field {

    private Color color;
    private int number;

    public Field() {
        color = null;
        number = -1;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
