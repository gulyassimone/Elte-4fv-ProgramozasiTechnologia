/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static hu.elte.entity.Direction.*;

/**
 * @author Simone Gulyas
 */
public class Snake extends GameObject {
    private List<Coordinate> body;
    private Direction direction;
    private Boolean end;

    Snake(Field[][] table, int size, int scale) {
        super(table, size, scale);
        randomizeLocate();

        body = new ArrayList<>();
        for(int i = 0; i<2; ++i){
            Coordinate head = new Coordinate(size / 2 - i * direction.coordinate.getX(), size / 2 - i * direction.coordinate.getY());
            body.add(head);
            setTable(head, this);
        }
        this.end = false;
    }


    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.GREEN);
        body.forEach(elem -> g2.fillRect(elem.getX() * scale, elem.getY() * scale, scale, scale));
    }

    @Override
    public void randomizeLocate() {

        Direction[] dimension = {UP,DOWN,LEFT,RIGHT};
        Random rand = new Random();
        int randDir = rand.nextInt(dimension.length);
        direction = dimension[randDir];
    }

    public List<Coordinate> getBody() {
        return body;
    }


    public void move() {
        Coordinate reference;
        checkEnd();
        if (!end) {
            getTable(body.get(body.size()-1)).setGameObject(null);
            for (int i = body.size() - 1; i >= 0; --i) {
                if (i > 0) {
                    reference = new Coordinate(body.get(i - 1));
                    body.set(i, reference);
                } else {
                    body.set(i, body.get(i).add(direction.coordinate));
                    setTable(body.get(i), this);
                }
            }
            System.out.println(body.get(0));
        }

    }

    public void checkEnd() {
        Coordinate coordinate = body.get(0);
        Coordinate front = new Coordinate(coordinate.getX() + direction.coordinate.getX(),
                coordinate.getY() + direction.coordinate.getY());

        if (!(front.getX() >= 0 &&
                front.getX() < size &&
                front.getY() >= 0 &&
                front.getY() < size &&
                (getTable(front).gameObject == null ||
                        getTable(front).gameObject instanceof Food))) {
            System.out.print("END");
            end = true;
        }
    }

    public void eat() {
        Coordinate last = new Coordinate(body.get(body.size() - 1));
        body.add(last.add(direction.invalidWay.coordinate));
    }

    public Boolean getEnd() {
        return end;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    public void clearEnd(){
        end = null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Snake snake = (Snake) o;
        return Objects.equals(body, snake.body) && direction == snake.direction && Objects.equals(end, snake.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), body, direction, end);
    }
}
