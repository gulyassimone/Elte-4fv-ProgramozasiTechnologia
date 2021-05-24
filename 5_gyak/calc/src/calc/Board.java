/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.Point;
import java.awt.Color;



/**
 *
 * @author gulya
 */
public class Board {
    
    private Field[][] board;
    private final int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new Field[this.boardSize][this.boardSize];
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                board[i][j] = new Field();
            }
        }
    }

    public boolean isOver() {
        for (int i = 0; i < boardSize; i++) {
        }
        return true;
    }

    public Field get(int x, int y) {
        return board[x][y];
    }

    public Field get(Point point) {
        int x = (int) point.getX();
        int y = (int) point.getY();
        return get(x, y);
    }

    public int getBoardSize() {
        return boardSize;
    }

}
