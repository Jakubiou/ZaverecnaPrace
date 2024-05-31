package TowerBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreManagerTest {

    @BeforeEach
    void setUp() {
        HighScoreManager.getHighScores();
    }

    @Test
    void addHighScore() {
        HighScoreManager.addHighScore("Player1",50);
        HighScoreManager.addHighScore("Player2",40);
        HighScoreManager.addHighScore("Player3",30);
        List<HighScore> highScores = HighScoreManager.getHighScores();
        assertEquals(3,highScores.size());
        assertEquals("Player1",highScores.get(0).getName());
        assertEquals(50,highScores.get(0).getScore());
    }

    @Test
    void getHighScores() {
    }

    @Test
    void isHighScore() {
    }
}