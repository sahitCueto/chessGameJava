package model;

public class Bishop extends Piece {
    public Bishop(String color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isValidMove(int newRow, int newCol, Board board) {
        return newRow == row || newCol == col;
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'B' : 'b';
    }
}