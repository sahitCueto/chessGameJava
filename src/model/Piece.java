package model;

public abstract class Piece {
    protected String color;
    protected int row, col;

    public Piece(String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public abstract boolean isValidMove(int newRow, int newCol, Board board);
        public String getColor() {
            return color;
        }

    public abstract char getSymbol();

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
}