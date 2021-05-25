/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author Simone Gulyas
 */
public class Food {
    private Coordinate food;
    private int size;

    public Food(int size) {
        this.size = size;
        food = new Coordinate(0,0);
    }

    public Coordinate getFood() {
        return food;
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        g2.fillOval(food.getX(), food.getY(), 10, 10);
    }
    
    public void randomizeLocate(){
        Random rand = new Random();
        int randX = rand.nextInt(size);
        int randY = rand.nextInt(size);
        food.setX(randX);
        food.setY(randY);
    }
    
}
