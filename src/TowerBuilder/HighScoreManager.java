package TowerBuilder;

import java.util.ArrayList;
import java.util.List;

public class HighScoreManager {

    private List<HighScore> highScores = new ArrayList<>();

    public void addHighScore(String name,int score){
        highScores.add(new HighScore(name,score));
        if(highScores.size() > 3){
            highScores.remove(3);
        }
    }
}
