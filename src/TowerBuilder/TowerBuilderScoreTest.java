package TowerBuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerBuilderScoreTest {

    @Test
    void increaseScore() {
        assertEquals(0,TowerBuilderScore.getScore());
        TowerBuilderScore.increaseScore();
        assertEquals(1,TowerBuilderScore.getScore());
    }
}