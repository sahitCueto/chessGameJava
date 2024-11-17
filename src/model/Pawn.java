package model;

public class Pawn extends Piece {
    public Pawn(String color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean isValidMove(int newRow, int newCol, Board board) {
        int direction = color.equals("white") ? -1 : 1;
        if (col == newCol && newRow == row + direction) {
            return board.getPiece(newRow, newCol) == null;
        }
        return false;
    }

    @Override
    public char getSymbol() {
        return color.equals("white") ? 'P' : 'p';
    }
}
