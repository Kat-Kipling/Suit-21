import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {
    private Card aceSpades;
    private Card aceSpadesCopy;
    private Card kingHearts;

    @BeforeEach
    void setUp() {
        aceSpades = new Card(Suit.SPADES, Rank.ACE);
        aceSpadesCopy = new Card(Suit.SPADES, Rank.ACE);
        kingHearts = new Card(Suit.HEARTS, Rank.KING);
    }

    @Test
    void testGetSuit() {
        Assertions.assertEquals(Suit.SPADES, aceSpades.getSuit());
        Assertions.assertEquals(Suit.HEARTS, kingHearts.getSuit());
    }

    @Test
    void testGetRank() {
        Assertions.assertEquals(Rank.ACE, aceSpades.getRank());
        Assertions.assertEquals(Rank.KING, kingHearts.getRank());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("ACE of SPADES", aceSpades.toString());
        Assertions.assertEquals("KING of HEARTS", kingHearts.toString());
    }

    @Test
    void testEquals() {
        Assertions.assertTrue(aceSpades.equals(aceSpadesCopy));
        Assertions.assertFalse(aceSpades.equals(kingHearts));
    }

    @Test
    void testHashCode() {
        Assertions.assertEquals(aceSpades.hashCode(), aceSpadesCopy.hashCode());
        Assertions.assertNotEquals(aceSpades.hashCode(), kingHearts.hashCode());
    }
}
