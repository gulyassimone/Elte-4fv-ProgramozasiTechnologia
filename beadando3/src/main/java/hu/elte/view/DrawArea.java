package hu.elte.view;

import hu.elte.entity.Food;
import hu.elte.entity.Snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawArea extends JPanel {

    private final Snake snake;
    private final Food food;
    private final Color background = Color.WHITE;

    public DrawArea(Snake snake, Food food) {
        this.snake = snake;
        this.food = food;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        setBackground(background);
        snake.draw(g2);
        food.draw(g2);
    }
    
}
