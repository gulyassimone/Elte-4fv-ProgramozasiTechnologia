package hu.elte.entity;

import java.awt.*;

public abstract class GameObject {

    protected Field[][] table;
    protected int size;
    protected final int scale;

    public GameObject(Field[][] field, int size, int scale) {
        this.table = field;
        this.size = size;
        this.scale = scale;
    }

    public boolean setTable(Coordinate coordinate, GameObject gameObject) {
        boolean canTakeThisPosition = false;
        if(getTable(coordinate).gameObject == null){
            canTakeThisPosition = true;
            getTable(coordinate).gameObject = gameObject;
        }
        return canTakeThisPosition;
    }

    public Field getTable(Coordinate coordinate) {
        return table[coordinate.getX()][coordinate.getY()];
    }

    public abstract void draw(Graphics2D g2);
    public abstract void randomizeLocate();

}
