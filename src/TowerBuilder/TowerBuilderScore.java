package TowerBuilder;

/**
 * The TowerBuilderScore class is used to store the score in the Tower Builder game.
 */
public class TowerBuilderScore {

    private static int score;

    /**
     * Constructor of the TowerBuilderScore class.
     */
    public TowerBuilderScore(){
        this.score = 0;
    }

    /**
     * Static method to increase the score by one point.
     */
    public static void increaseScore(){
        score++;
    }

    /**
     * Static method to get the current score.
     * @return Current score.
     */
    public static int getScore(){
        return score;
    }
}
