package TowerBulder;

public class TowerBuilderScore {

    private int score;

    public TowerBuilderScore(){
        this.score = 0;
    }

    public void increaseScore(){
        score++;
    }

    public int getScore(){
        return score;
    }
}
