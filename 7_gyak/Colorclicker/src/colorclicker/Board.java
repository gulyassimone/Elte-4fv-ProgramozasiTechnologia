package colorclicker;

import java.awt.Point;

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
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].getColor() == null) {
                    return false;
                }
            }
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
