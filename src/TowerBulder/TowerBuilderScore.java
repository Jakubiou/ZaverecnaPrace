package TowerBulder;

public class TowerBuilderScore {

    private static int score;

    public TowerBuilderScore(){
        this.score = 0;
    }

    public static void increaseScore(){
        score++;
    }

    public static int getScore(){
        return score;
    }
}
