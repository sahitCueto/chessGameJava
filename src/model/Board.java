package model;

import java.util.List;
import java.util.ArrayList;

public class Board {
    private Piece[][] grid;
    private List<String> moves;


    public Board() {
        grid = new Piece[8][8];
        moves = new ArrayList<>();

    }




    public void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            grid[1][i] = new Pawn("white", 1, i);
            grid[6][i] = new Pawn("black", 6, i);
        }
        grid[0][0] = new Rook("white", 0, 0);
        grid[0][7] = new Rook("white", 0, 7);
        grid[7][0] = new Rook("black", 7, 0);
        grid[7][7] = new Rook("black", 7, 7);
        // add more pieces
    }

    public Piece getPiece(int row, int col) {
        return grid[row][col];
    }

    public void setPiece(Piece piece, int row, int col) {
        grid[row][col] = piece;
        if (piece != null) {
            piece.setPosition(row, col);
        }
    }

    public void applyMove(String move) {

    }

    public void resetBoard() {
        initializeBoard();
    }


}
