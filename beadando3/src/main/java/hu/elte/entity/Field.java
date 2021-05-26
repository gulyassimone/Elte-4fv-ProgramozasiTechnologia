package hu.elte.entity;

import java.util.Objects;

public class Field {
    Coordinate position;
    GameObject gameObject;

    Field(Coordinate position){
        this.position = position;
        gameObject = null;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public Coordinate getPosition() {
        return position;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(position, field.position) && Objects.equals(gameObject, field.gameObject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, gameObject);
    }
}
