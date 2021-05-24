package calc;

import java.awt.Color;

public class Field {

    private Boolean isEmpty;
    private Color color;

    public Field() {
        color = null;
        isEmpty = true;
    }

    public Boolean getIsEmpty() {
        return isEmpty;
    }

    public Color getColor() {
        return color;
    }

    public void setIsEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
