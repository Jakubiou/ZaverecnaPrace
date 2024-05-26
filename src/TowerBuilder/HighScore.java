package TowerBuilder;

/**
 * The HighScore class represents the highest score record in Tower Builder.
 */
public class HighScore implements Comparable<HighScore>{

    private String name;
    private int score;

    /**
     * Creates a new high score record with name and score.
     * @param name Player name.
     * @param score Player score.
     */
    public HighScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Returns the name of the player.
     * @return Player name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the player's score.
     * @return Player score.
     */
    public int getScore() {
        return score;
    }

    /**
     * It compares this high score record with another according to their score.
     * @param other the object to be compared.
     * @return A negative number, zero, or a positive number if this score is less than, equal to, or greater than the score of another record.
     */
    @Override
    public int compareTo(HighScore other) {
        return Integer.compare(other.getScore(),this.score);
    }
}
