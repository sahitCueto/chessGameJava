package model;

public class Knight extends Piece {
    public Knight(String color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isValidMove(int newRow, int newCol, Board board) {
        return newRow == row || newCol == col;
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'K' : 'k';
    }
}