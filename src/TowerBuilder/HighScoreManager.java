package TowerBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScoreManager {

    private static List<HighScore> highScores = new ArrayList<>();

    public void addHighScore(String name,int score){
        highScores.add(new HighScore(name,score));
        Collections.sort(highScores);
        if(highScores.size() > 3){
            highScores.remove(3);
        }
    }
    public static List<HighScore> getHighScores(){
        return  highScores;
    }
    public boolean isHighScore(int score){
        if(highScores.size() < 3){
            return true;
        }
        return  score > highScores.get(2).getScore();
    }
}
