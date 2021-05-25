/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.entity;
import hu.elte.entity.Food;
import hu.elte.entity.Snake;
import hu.elte.view.DrawArea;
import hu.elte.view.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Timer;

/**
 *
 * @author Simone Gulyas
 */


public class Board{
    int DIMENSION = 300;
    private JFrame frame;    
    //private final Timer timer;
    
    
    public Board(){
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
        
        Snake snake = new Snake(DIMENSION);
        Food food = new Food(DIMENSION);
        DrawArea drawArea = new DrawArea(snake , food);
        drawArea.setPreferredSize(new Dimension(DIMENSION,DIMENSION));
        frame.getContentPane().add(BorderLayout.CENTER, drawArea);     
      //  frame.addKeyListener(new KeyListener());
  /*      setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();*/
  
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
     /*   timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dimension d = drawArea.getSize();
                snake.move();
                frame.repaint();
            }
        });
        
        
        timer.start();*/
        frame.pack();
        frame.setVisible(true);
    }
}
    
