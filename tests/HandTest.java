import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HandTest
{
    private Hand hand;
    private Card aceSpades;
    private Card kingHearts;
    private Card twoClubs;

    @BeforeEach
    void setUp() {
        hand = new Hand();
        aceSpades = new Card(Suit.SPADES, Rank.ACE);
        kingHearts = new Card(Suit.HEARTS, Rank.KING);
        twoClubs = new Card(Suit.CLUBS, Rank.TWO);
    }

    @Test
    void testConstructor() {
        assertEquals(0, hand.getCurrentSize());
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(aceSpades);
        Hand handWithCards = new Hand(cards);
        assertEquals(1, handWithCards.getCurrentSize());
    }

    @Test
    void testAdd() {
        assertTrue(hand.add(aceSpades));
        assertEquals(1, hand.getCurrentSize());
    }

    @Test
    void testGetHand() {
        hand.add(aceSpades);
        ArrayList<Card> cards = hand.getHand();
        assertEquals(1, cards.size());
        assertEquals(aceSpades, cards.get(0));
    }

    @Test
    void testExchange() {
        hand.add(aceSpades);
        assertTrue(hand.exchange(aceSpades, kingHearts));
        assertEquals(kingHearts, hand.get(0));
        assertFalse(hand.exchange(twoClubs, kingHearts)); // Card not in hand
    }

    @Test
    void testClear() {
        hand.add(aceSpades);
        hand.add(kingHearts);
        hand.clear();
        assertEquals(0, hand.getCurrentSize());
    }

    @Test
    void testGet() {
        hand.add(aceSpades);
        assertEquals(aceSpades, hand.get(0));
    }

    @Test
    void testGetLowestValueCardInSuit() {
        hand.add(aceSpades); // Value 11
        Card kingSpades = new Card(Suit.SPADES, Rank.KING); // Value 10
        Card twoSpades = new Card(Suit.SPADES, Rank.TWO); // Value 2
        hand.add(kingSpades);
        hand.add(twoSpades);
        hand.add(kingHearts); // Different suit

        assertEquals(twoSpades, hand.getLowestValueCardInSuit(Suit.SPADES));
        assertEquals(kingHearts, hand.getLowestValueCardInSuit(Suit.HEARTS));
        assertNull(hand.getLowestValueCardInSuit(Suit.DIAMONDS)); // No diamonds in hand
    }

    @Test
    void testToString() {
        hand.add(aceSpades);
        hand.add(kingHearts);
        String expected = "ACE of SPADES\nKING of HEARTS\n";
        assertEquals(expected, hand.toString());
    }
}