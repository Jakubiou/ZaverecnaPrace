package TicTacToe;

/**
 * The GameEndListener interface provides a method to handle the game end event.
 */
public interface GameEndListener {

    /**
     * A method that is called when the game ends.
     * @param winner Represents the winner of the game.
     */
    void onGameEnd(char winner);
}
