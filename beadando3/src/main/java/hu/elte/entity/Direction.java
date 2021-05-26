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
    UP(0, -1), DOWN(0, 1), LEFT(-1, 0),  RIGHT(1, 0);
    
    Coordinate coordinate;
    Direction invalidWay;
    
    Direction(int x, int y){
        coordinate = new Coordinate(x,y);
    }
    
    static {
        UP.invalidWay = DOWN;
        DOWN.invalidWay = UP;
        LEFT.invalidWay = RIGHT;
        RIGHT.invalidWay = LEFT;
    }
}
