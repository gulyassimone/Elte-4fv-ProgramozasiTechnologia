/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Objects;
import java.util.Random;

/**
 * @author Simone Gulyas
 */
public class Food extends GameObject {

    private Coordinate coordinate;

    public Food(Field[][] table, int size, int scale) {
        super(table, size,scale);
        randomizeLocate();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillOval(coordinate.getX() *scale, coordinate.getY()*scale, scale, scale);
    }

    @Override
    public void randomizeLocate() {
        do {
            Random rand = new Random();
            int randX = rand.nextInt(size);
            int randY = rand.nextInt(size);
            if (coordinate == null) {
                coordinate = new Coordinate(randX, randY);
            } else {
                coordinate.setX(randX);
                coordinate.setY(randY);
            }
        } while (!setTable(coordinate, this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Food food = (Food) o;
        return Objects.equals(coordinate, food.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coordinate);
    }
}
