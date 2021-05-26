package hu.elte.view;

import hu.elte.entity.Board;
import hu.elte.entity.Direction;
import hu.elte.entity.HighScore;

import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author gulyas
 */
public class Game {
    private JFrame frame;
    private Board board;
    private final int fps = 300;


    public Game() {
        frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        board = new Board();
        frame.getContentPane().add(BorderLayout.CENTER, board.getDrawArea());
        frame.setFocusable(true);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        JMenuItem newMenu = new JMenuItem("New");
        JMenuItem menuScore = new JMenuItem("Top 10 Player");

        gameMenu.add(newMenu);
        gameMenu.add(menuScore);
        menuBar.add(gameMenu);

        newMenu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().remove(board.getDrawArea());
                    board = new Board();
                    frame.getContentPane().add(board.getDrawArea(), BorderLayout.CENTER);
                    frame.pack();

                    board.timer = new Timer(fps, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            Dimension d = board.getDrawArea().getSize();
                            board.getSnake().move();
                            frame.repaint();
                        }
                    });

                    board.start();
                }
            });
        menuScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<HighScore> results;
                HighScoreManager highScores = new HighScoreManager();
                results = highScores.getSortedHighScores();
                JDialog dialog = new HighScoreDialog(null, "Score" , results);
                dialog.pack();
            }
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent key) {
                if ((key.getKeyCode() == KeyEvent.VK_LEFT) && (board.getSnake().getDirection()!= Direction.RIGHT)) {
                    board.getSnake().setDirection(Direction.LEFT);
                }else if ((key.getKeyCode() == KeyEvent.VK_RIGHT) && (board.getSnake().getDirection() != Direction.LEFT))  {
                    board.getSnake().setDirection(Direction.RIGHT);
                }else if ((key.getKeyCode() == KeyEvent.VK_UP) && (board.getSnake().getDirection() != Direction.DOWN))  {
                    board.getSnake().setDirection(Direction.UP);
                }else if ((key.getKeyCode() == KeyEvent.VK_DOWN) && (board.getSnake().getDirection() != Direction.UP))  {
                    board.getSnake().setDirection(Direction.DOWN);
                }
            }
        });



        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });



        frame.pack();
        frame.setVisible(true);

    }

}
