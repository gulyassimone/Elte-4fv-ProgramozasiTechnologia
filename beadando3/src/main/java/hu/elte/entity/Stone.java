/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Simone Gulyas
 */
public class Stone extends GameObject{
    private List<Coordinate> stone;

    public Stone(Field[][] table, int size, int scale) {
        super(table, size,scale);
        stone = new ArrayList<>();
        randomizeLocate();
    }

    
    public void draw(Graphics2D g2){
        g2.setColor(Color.GRAY);
        for (Coordinate coordinate : stone){
            g2.fillRect(coordinate.getX()*scale, coordinate.getY()*scale, scale, scale);
        }
    }
    
    public void randomizeLocate(){
        Random rand = new Random();
        Coordinate coordinate = null;
        int number = rand.nextInt(10)+5;


        for ( int i = 0; i < number;  ++i){
            do{
                int randX = rand.nextInt(size);
                int randY = rand.nextInt(size);
                coordinate = new Coordinate(randX, randY);
                
            }while (!setTable(coordinate,this));
            stone.add(coordinate);
            System.out.print("STONE");
            System.out.println(coordinate);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stone stone1 = (Stone) o;
        return size == stone1.size && Objects.equals(stone, stone1.stone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stone, size);
    }
}
