/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;
import hu.elte.view.DrawArea;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author Simone Gulyas
 */


public class Board {
    int DIMENSION = 30;
    private Field[][] table;
    private JFrame frame;    
    public final Timer timer;
    private Snake snake;
    private Food food;
    private Stone stone;
    private final int scale = 10;
    private final int fps = 300;
    
    public Board(){

        table = new Field[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; ++i) {
            for (int j = 0; j < DIMENSION; ++j) {
                table[i][j] = new Field(new Coordinate(i,j));
            }
        }

        frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenuItem newMenu = new JMenuItem("New");
        JMenuItem menuScore = new JMenuItem("Top 10 Player");

        gameMenu.add(newMenu);
        gameMenu.add(menuScore);        
        menuBar.add(gameMenu);
        
        
       // createGameScore(menuScore);
        
        frame.setJMenuBar(menuBar);


        snake = new Snake(table,DIMENSION, scale);
        stone = new Stone(table,DIMENSION,scale);
        food = new Food(table,DIMENSION,scale);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent key) {
                if ((key.getKeyCode() == KeyEvent.VK_LEFT) && (snake.getDirection().invalidWay != Direction.LEFT)) {
                    snake.setDirection(Direction.LEFT);
                }else if ((key.getKeyCode() == KeyEvent.VK_RIGHT) && (snake.getDirection().invalidWay != Direction.RIGHT))  {
                    snake.setDirection(Direction.RIGHT);
                }else if ((key.getKeyCode() == KeyEvent.VK_UP) && (snake.getDirection().invalidWay != Direction.UP))  {
                    snake.setDirection(Direction.UP);
                }else if ((key.getKeyCode() == KeyEvent.VK_DOWN) && (snake.getDirection().invalidWay != Direction.DOWN))  {
                    snake.setDirection(Direction.DOWN);
                }
            }
        });

        DrawArea drawArea = new DrawArea(snake , food, stone, this);
        drawArea.setPreferredSize(new Dimension(DIMENSION*scale,DIMENSION*scale));
        frame.getContentPane().add(BorderLayout.CENTER, drawArea);

        frame.setFocusable(true);

  
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
       timer = new Timer(fps, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dimension d = drawArea.getSize();
                snake.move();
                frame.repaint();
            }
        });
        
        
        timer.start();
        frame.pack();
        frame.setVisible(true);
    }
    public void end(){
        timer.stop();
    }

    public JFrame getFrame() {
        return frame;
    }

    public Snake getSnake() {
        return snake;
    }

}
    
