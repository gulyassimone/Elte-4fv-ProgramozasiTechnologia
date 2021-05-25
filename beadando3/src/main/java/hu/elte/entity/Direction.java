/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;

/**
 *
 * @author gulya
 */
public enum Direction {
    UP(0, -10), DOWN(0, 10), LEFT(-10, 0),  RIGHT(10, 0);
    
    public int x, y;
    private Direction end;
    
    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    static{
        UP.end = DOWN;
        DOWN.end = UP;
        LEFT.end = RIGHT;
        RIGHT.end = LEFT;
    }
    
    
}
