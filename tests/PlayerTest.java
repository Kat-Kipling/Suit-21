import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.EnumMap;

public class PlayerTest {
    private Player player;
    private Hand hand;
    private Deck deck;
    private ScoreCalculator scoreCalculator;
    private EnumMap<Suit, Integer> suitScores;

    @BeforeEach
    void setUp() {
        DisplayStrategy displayStrategy = new ConsoleDisplayStrategy();
        PlayerStrategy playerStrategy = new ComputerStrategy();
        player = new Player("Player 1", displayStrategy, playerStrategy);

        deck = new Deck();
        hand = new Hand();
        scoreCalculator = new ScoreCalculator();

        // Initialize the player's hand and suit scores
        hand.add(deck.deal());
        hand.add(deck.deal());
        player.setHand(hand);

        suitScores = new EnumMap<>(Suit.class);
        suitScores.put(Suit.HEARTS, 5);
        suitScores.put(Suit.CLUBS, 8);
    }

    @Test
    void testPlayCard() {
        Card cardToPlay = player.playCard();
        assertNotNull(cardToPlay, "Card played should not be null");
    }

    @Test
    void testSetHand() {
        Hand newHand = new Hand();
        newHand.add(deck.deal());
        newHand.add(deck.deal());
        player.setHand(newHand);

        assertEquals(newHand, player.getHand(), "Hand should be correctly set and retrieved");
    }

    @Test
    void testAddCard() {
        Card card = deck.deal();
        int initialSize = player.getHand().getCurrentSize();
        player.addCard(card);
        assertEquals(initialSize + 1, player.getHand().getCurrentSize(), "Card should be added to the hand");
    }

    @Test
    void testClearHand() {
        player.clearHand();
        assertTrue(player.getHand().isEmpty(), "Hand should be cleared");
    }

    @Test
    void testExchange() {
        Card cardToExchange = player.getHand().get(0);
        Card newCard = deck.deal();
        assertTrue(player.exchange(cardToExchange, newCard), "Card exchange should be successful");
    }

    @Test
    void testScoreSuit() {
        int score = player.scoreSuit(Suit.HEARTS);
        assertTrue(score >= 0, "Score for a suit should be valid");
    }

    @Test
    void testScoreHand() {
        EnumMap<Suit, Integer> scores = player.scoreHand();
        assertFalse(scores.isEmpty(), "Hand should have score values for each suit");
    }

    @Test
    void testHasScored21() {
        // Prepare the hand with specific cards to simulate suit scores
        Hand hand = new Hand();
        hand.add(new Card(Suit.HEARTS, Rank.ACE));   // 11 points
        hand.add(new Card(Suit.HEARTS, Rank.TEN));   // 10 points
        hand.add(new Card(Suit.CLUBS, Rank.KING));   // 10 points
        hand.add(new Card(Suit.CLUBS, Rank.QUEEN));  // 10 points
        hand.add(new Card(Suit.DIAMONDS, Rank.SIX)); // 6 points

        // Set the hand on the player and calculate the suit scores
        player.setHand(hand);
        EnumMap<Suit, Integer> suitScores = scoreCalculator.scoreHand(hand); // Score the hand
        player.setSuitScores(suitScores);  // Set the scores on the player

        // Assert that HEARTS has a score of 21, triggering hasScored21()
        assertTrue(player.hasScored21(), "Player should have scored 21 with the given suit scores");
    }
}
