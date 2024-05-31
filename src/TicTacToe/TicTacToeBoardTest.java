package TicTacToe;


import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeBoardTest {

    private TicTacToeBoard board;
    private TicTacToeFrame frame;
    @BeforeEach
    void setUp() {
        frame = new TicTacToeFrame();
        board = new TicTacToeBoard(winner -> {});
        board.setTicTacToeFrame(frame);
    }

    @org.junit.jupiter.api.Test
    void checkWinRows() {
        board.buttons[0][0].setText("O");
        board.buttons[0][1].setText("O");
        board.buttons[0][2].setText("O");
        board.checkWinner();
        assertTrue(board.gameEnded);
    }
    @org.junit.jupiter.api.Test
    void checkWinColumn() {
        board.buttons[0][0].setText("O");
        board.buttons[1][0].setText("O");
        board.buttons[2][0].setText("O");
        board.checkWinner();
        assertTrue(board.gameEnded);
    }
    @org.junit.jupiter.api.Test
    void checkWinDiagonal() {
        board.buttons[0][0].setText("O");
        board.buttons[1][1].setText("O");
        board.buttons[2][2].setText("O");
        board.checkWinner();
        assertTrue(board.gameEnded);
    }
    @org.junit.jupiter.api.Test
    void testTie() {
        board.buttons[0][0].setText("X");
        board.buttons[0][1].setText("O");
        board.buttons[0][2].setText("X");
        board.buttons[1][0].setText("X");
        board.buttons[1][1].setText("X");
        board.buttons[1][2].setText("O");
        board.buttons[2][0].setText("O");
        board.buttons[2][1].setText("X");
        board.buttons[2][2].setText("O");
        board.checkWinner();
        assertTrue(board.gameEnded);
    }

    @org.junit.jupiter.api.Test
    void switchPlayer() {
        board.switchPlayer();
        assertEquals('O', board.currentPlayer);
        board.switchPlayer();
        assertEquals('X', board.currentPlayer);
    }
}