package hu.elte.view;

import hu.elte.entity.Board;
import hu.elte.entity.Food;
import hu.elte.entity.Snake;
import hu.elte.entity.Stone;

import java.awt.*;
import javax.swing.*;

public class DrawArea extends JPanel {

    private final Snake snake;
    private final Food food;
    private final Stone stone;
    private final Color background = Color.WHITE;
    Board board;
    Dialog dialog;

    public DrawArea(Snake snake, Food food,Stone stone, Board board) {
        this.snake = snake;
        this.food = food;
        this.stone = stone;
        this.board = board;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        setBackground(background);
        System.out.print("Food");
        System.out.println(food.getCoordinate());

        if(snake.getBody().stream().findFirst().get().equals(food.getCoordinate())){
            snake.eat();
            food.randomizeLocate();
        }
        snake.draw(g2);
        food.draw(g2);
        stone.draw(g2);

        if(snake.getEnd()){
            System.out.println("Vége");
            board.end();
            dialog = new EndGameDialog(null, "Enter Your Name", board.getSnake().getBody().size());
        }
    }

    
}
