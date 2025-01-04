import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void testInitialDeckSize() {
        assertEquals(52, deck.getCardCount());
    }

    @Test
    void testDealAllCards() {
        ArrayList<Card> dealtCards = new ArrayList<>();
        while (deck.getCardCount() > 0) {
            dealtCards.add(deck.deal());
        }

        // Test that we got all cards
        assertEquals(52, dealtCards.size());

        // Test that we got the right number of each suit
        long spadesCount = dealtCards.stream()
                .filter(card -> card.getSuit() == Suit.SPADES)
                .count();
        assertEquals(13, spadesCount);
    }

    @Test
    void testDeckShuffling() {
        // Create two different decks
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();

        // Compare the order of the cards between deck1 and deck2
        Stack<Card> deck1Stack = deck1.getDeck();
        Stack<Card> deck2Stack = deck2.getDeck();

        // Assert that the two stacks are not identical by comparing the order of cards
        assertNotEquals(deck1Stack, deck2Stack, "The decks should be shuffled and not identical.");
    }
}