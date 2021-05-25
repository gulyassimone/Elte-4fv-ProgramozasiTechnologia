/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;

import static hu.elte.entity.Direction.UP;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simone Gulyas
 */
public class Snake {
    private List<Coordinate> body;
    Direction direction;
    int size;
    
    Snake(int size){
       this.size = size;
       Coordinate head = new Coordinate(size/2, size/2);
       Coordinate tail = new Coordinate(size/2, size/2+10);
       body = new ArrayList<>();
       body.add(head);
       body.add(tail);
       direction = UP;
    }
      
    public void draw(Graphics2D g2){
        g2.setColor(Color.GREEN);
        body.forEach(elem -> g2.fillRect(elem.getX(), elem.getY(), 10, 10));
    }
    
    public List<Coordinate> getBody() {
        return body;
    }

    public void setBody(List<Coordinate> body) {
        this.body = body;
    }
    
    public void move(){
        body.forEach(elem -> {
            elem.setX(elem.getX()+direction.x);
            elem.setY(elem.getY()+direction.y);
            checkEnd(elem);
        });
    }            
    
     public boolean checkEnd(Coordinate coordinate){
         boolean end = false;
         if(coordinate.getX() < 0 || coordinate.getX() >= size || coordinate.getY() < 0 || coordinate.getY() >= size ){
             System.out.print("END");
             end = true;
         }
         return end;
     } 
}
