/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;

import hu.elte.view.DrawArea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author Simone Gulyas
 */


public class Board {
    int DIMENSION = 30;
    private Field[][] table;
    public Timer timer;
    private Snake snake;
    private Food food;
    private Stone stone;
    private final int scale = 10;
    private  DrawArea drawArea;

    public Board() {

        table = new Field[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; ++i) {
            for (int j = 0; j < DIMENSION; ++j) {
                table[i][j] = new Field(new Coordinate(i, j));
            }
        }

        snake = new Snake(table, DIMENSION, scale);
        stone = new Stone(table, DIMENSION, scale);
        food = new Food(table, DIMENSION, scale);


        drawArea = new DrawArea(snake, food, stone, this);
        drawArea.setPreferredSize(new Dimension(DIMENSION * scale, DIMENSION * scale));


    }

    public void end() {
        System.out.println("Leállítottam a számolást");
        snake.clearEnd();
        timer.stop();
    }
    public void start() {
        System.out.println("Beállítottam a számolást a számolást");
        timer.start();
    }

    public Snake getSnake() {
        return snake;
    }

    public int getDIMENSION() {
        return DIMENSION;
    }

    public DrawArea getDrawArea() {
        return drawArea;
    }
}
    
