package lld.snakeandladder;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    private Dice dice;

    @BeforeEach
    void setUp() {
        dice = new Dice(6); // Standard 6-faced dice
    }

    @Test
    void testRoll() {
        for (int i = 0; i < 100; i++) { // Test multiple rolls
            int rollValue = dice.roll();
            assertTrue(rollValue >= 1 && rollValue <= 6, "Dice roll should be between 1 and 6");
        }
    }
}
