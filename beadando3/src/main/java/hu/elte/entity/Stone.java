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
public class Stone {
    private Coordinate stone;
    private int size;

    public Stone(int size) {
        this.size = size;
        stone = new Coordinate(0,0);
    }

    public Coordinate getStone() {
        return stone;
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        g2.fillOval(stone.getX(), stone.getY(), 10, 10);
    }
    
    public void randomizeLocate(){
        Random rand = new Random();
        int randX = rand.nextInt(size);
        int randY = rand.nextInt(size);
        stone.setX(randX);
        stone.setY(randY);
    }
}
