package TowerBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The HighScoreManager class manages the high score in Tower Builder.
 */
public class HighScoreManager {

    private static List<HighScore> highScores = new ArrayList<>();

    /**
     * Adds a new high score.
     * @param name Player name.
     * @param score Player score.
     */
    public static void addHighScore(String name,int score){
        highScores.add(new HighScore(name,score));
        Collections.sort(highScores);
        if(highScores.size() > 3){
            highScores.remove(3);
        }
    }

    /**
     * Returns a list of top scores.
     * @return List of high scores.
     */
    public static List<HighScore> getHighScores(){
        return  highScores;
    }

    /**
     * Checks if the given score is the new best score
     * @param score Player score.
     * @return true if the score is the new best score, false otherwise.
     */
    public static boolean isHighScore(int score){
        if(highScores.size() < 3){
            return true;
        }
        return  score > highScores.get(2).getScore();
    }
}
