import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class TexasPokerTest {

    TexasPoker texaspoker = new TexasPoker();

    @BeforeEach
    void setUp() {
        System.out.println("测试开始");
    }

    @AfterEach
    void tearDown() {
        System.out.println("测试结束");
    }

    @org.junit.jupiter.api.Test
    void checkWinner() {
        assertEquals("White wins", texaspoker.CheckWinner("2H 3D 5S 9C KD", "2C 3H 4S 8C AH"));
        assertEquals("Black wins", texaspoker.CheckWinner("2H 4S 4C 2D 4H", "2S 8S AS QS 3S"));
        assertEquals("Black wins", texaspoker.CheckWinner("2H 3D 5S 9C KD", "2C 3H 4S 8C KH"));
        assertEquals("Tie", texaspoker.CheckWinner("2H 3D 5S 9C KD", "2D 3H 5C 9S KH"));
    }

    @org.junit.jupiter.api.Test
    void checkPokerType() {
    }

    @org.junit.jupiter.api.Test
    void checkFlush() {
        assertEquals(true, texaspoker.CheckFlush("2S 8S AS QS 3S"));
        assertEquals(false, texaspoker.CheckFlush("2S 8D AS QS 3S"));
    }

    @org.junit.jupiter.api.Test
    void checkStraight() {
        assertEquals(true, texaspoker.CheckFlush("2S 3S 4S 5S 6S"));
        assertEquals(false, texaspoker.CheckFlush("2S 8D AS QS 3S"));
    }

    @org.junit.jupiter.api.Test
    void checkKinds() {
    }

    @org.junit.jupiter.api.Test
    void checkPairs() {
    }
}