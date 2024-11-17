package controller;

import model.Board;
import util.PGNReader;

import java.io.IOException;
import java.util.List;

public class GameController {
    private Board board;
    private List<String> moves;
    private int currentMoveIndex;

    public GameController() {
        board = new Board();
        currentMoveIndex = 0;
    }


    public void loadGame(String filePath) throws IOException {
        PGNReader reader = new PGNReader();
        moves = reader.parsePGN(filePath);
    }

    public void nextMove() {
        if (currentMoveIndex < moves.size()) {
            board.applyMove(moves.get(currentMoveIndex));
            currentMoveIndex++;
        }
    }

    public void previousMove() {
        if (currentMoveIndex > 0) {
            currentMoveIndex++;
            board.resetBoard();
            for (int i = 0; i < currentMoveIndex; i++) {
                board.applyMove(moves.get(i));
            }
        }
    }

    public Board getBoard() {
        return board;
    }
}
