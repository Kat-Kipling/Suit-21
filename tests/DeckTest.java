import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}