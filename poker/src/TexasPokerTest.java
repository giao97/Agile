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
        assertEquals(0, texaspoker.CheckPokerType("2H 3D 5S 9C KD"));
        assertEquals(1, texaspoker.CheckPokerType("2H 2D 5S 9C KD"));
        assertEquals(2, texaspoker.CheckPokerType("2H 2D 5S 9C 5D"));
        assertEquals(3, texaspoker.CheckPokerType("2H 2D 2S 9C KD"));
        assertEquals(4, texaspoker.CheckPokerType("2H 3D 5S 6C 4D"));
        assertEquals(5, texaspoker.CheckPokerType("2D 3D 5D 9D KD"));
        assertEquals(6, texaspoker.CheckPokerType("2H 3D 2S 3C 3D"));
        assertEquals(7, texaspoker.CheckPokerType("2H 2D 2S 2C KD"));
        assertEquals(8, texaspoker.CheckPokerType("2D 3D 5D 4D 6D"));
    }

    @org.junit.jupiter.api.Test
    void checkFlush() {
        assertEquals(true, texaspoker.CheckFlush("2S 8S AS QS 3S"));
        assertEquals(false, texaspoker.CheckFlush("2S 8D AS QS 3S"));
    }

    @org.junit.jupiter.api.Test
    void checkStraight() {
        assertEquals(true, texaspoker.CheckStraight("9S 8S JS TS QS"));
        assertEquals(false, texaspoker.CheckStraight("2S 8D AS QS 3S"));
    }

    @org.junit.jupiter.api.Test
    void checkKinds() {
        assertEquals(1, texaspoker.CheckKinds("2H 3D 5S 9C KD"));
        assertEquals(2, texaspoker.CheckKinds("2H 2D 5S 9C KD"));
        assertEquals(3, texaspoker.CheckKinds("KS 2H KC 2D KD"));
    }

    @org.junit.jupiter.api.Test
    void checkPairs() {
        assertEquals(0, texaspoker.CheckPairs("2H 3D 5S 9C KD"));
        assertEquals(1, texaspoker.CheckPairs("2H 2D 5S 9C KD"));
        assertEquals(2, texaspoker.CheckPairs("2H 9D KS 2C KD"));
        assertEquals(1, texaspoker.CheckPairs("2H KS KC KD 2D"));
    }
}