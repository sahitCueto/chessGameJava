package view;

import controller.GameController;
import model.Board;
import model.Piece;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessGUI extends JFrame {
    private JPanel boardPanel;
    private JButton nextButton, prevButton, loadButton;
    private GameController controller;


    public ChessGUI() {
        controller = new GameController();
        setTitle("Chess - Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardPanel = new JPanel(new GridLayout(8, 8));
        add(boardPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");
        loadButton = new JButton("Load PGN");

        controlPanel.add(loadButton);
        controlPanel.add(prevButton);
        controlPanel.add(nextButton);

        add(controlPanel, BorderLayout.SOUTH);

        addEventListeners();
    }

    private void addEventListeners() {
        loadButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try {
                    controller.loadGame(fileChooser.getSelectedFile().getPath());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "No es pendejada, carga el archivo PGN");
                }
            }
        });

        nextButton.addActionListener(e -> {
            controller.nextMove();
            renderBoard(controller.getBoard());
            System.out.println("Loaded next button");
        });

        prevButton.addActionListener(e -> {
            controller.previousMove();
            renderBoard(controller.getBoard());
        });
    }

    public void renderBoard(Board board) {
        boardPanel.removeAll();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JLabel cell = new JLabel();
                cell.setHorizontalAlignment(SwingConstants.CENTER);
                cell.setVerticalAlignment(SwingConstants.CENTER);
                Piece piece = board.getPiece(row, col);
                if (piece != null) {
                    cell.setText(String.valueOf(piece.getSymbol()));
                }
                boardPanel.add(cell);
            }
        }

        boardPanel.revalidate();
        boardPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGUI gui = new ChessGUI();
            gui.setVisible(true);
        });
    }
}