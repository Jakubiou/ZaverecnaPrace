package TowerBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreManagerTest {

    @BeforeEach
    void setUp() {
        HighScoreManager.getHighScores().clear();
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
    void isHighScore() {
        int score1 = 50;
        int score2 = 40;
        int score3 = 30;
        int score4 = 10;
        assertTrue(HighScoreManager.isHighScore(score1));
        HighScoreManager.addHighScore("Player1", score1);
        assertTrue(HighScoreManager.isHighScore(score2));
        HighScoreManager.addHighScore("Player2", score2);
        assertTrue(HighScoreManager.isHighScore(score3));
        HighScoreManager.addHighScore("Player3", score3);
        assertFalse(HighScoreManager.isHighScore(score4));
    }
}