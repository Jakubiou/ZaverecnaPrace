package TowerBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class TowerBuilderTest {

    private TowerBuilder towerBuilder;
    private JFrame frame;

    @BeforeEach
    void setUp() {
        frame = new JFrame();
        towerBuilder = new TowerBuilder(frame);
    }

    @Test
    void checkGameOver() {
        towerBuilder.checkGameOver();
        assertFalse(towerBuilder.isGameOver());

        towerBuilder.setIsSpacePressed(true);
        towerBuilder.checkGameOver();
        assertFalse(towerBuilder.isGameOver());

        towerBuilder.setMovingBlockX(towerBuilder.getBASE_BLOCK_WIDTH() + 201);
        frame.dispose();
        towerBuilder.checkGameOver();
        assertTrue(towerBuilder.isGameOver());
    }
}