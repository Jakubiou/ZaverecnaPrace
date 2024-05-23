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
    public List<HighScore> getHighScores(){
        return  highScores;
    }
    public boolean isHighScore(int score){
        if(highScores.size() < 3){
            return true;
        }
        return  score > highScores.get(2).getScore();
    }
}
