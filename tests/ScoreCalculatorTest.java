import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {
    private ScoreCalculator calculator;
    private Hand hand;

    @BeforeEach
    void setUp() {
        calculator = new ScoreCalculator();
        hand = new Hand();
    }

    @Test
    void testHasScored21() {
        EnumMap<Suit, Integer> scores = new EnumMap<>(Suit.class);
        scores.put(Suit.HEARTS, 21);
        scores.put(Suit.SPADES, 15);
        Assertions.assertTrue(calculator.hasScored21(scores));

        scores.clear();
        scores.put(Suit.HEARTS, 20);
        scores.put(Suit.SPADES, 19);
        Assertions.assertFalse(calculator.hasScored21(scores));
    }

    @Test
    void testScoreSuitBasic() {
        hand.add(new Card(Suit.HEARTS, Rank.ACE)); // Value 11
        hand.add(new Card(Suit.HEARTS, Rank.KING)); // Value 10

        int score = calculator.scoreSuit(Suit.HEARTS, hand);
        assertEquals(21, score); // ACE (11) + KING (10) = 21
    }

    @Test
    void testScoreSuitSingleAceAdjustment() {
        // Test case where Ace should be worth 1 instead of 11
        hand.add(new Card(Suit.HEARTS, Rank.ACE));  // Initially 11
        hand.add(new Card(Suit.HEARTS, Rank.KING)); // 10
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN)); // 10

        int score = calculator.scoreSuit(Suit.HEARTS, hand);
        assertEquals(21, score); // ACE (1) + KING (10) + QUEEN (10) = 21
    }

    @Test
    void testScoreSuitMultipleAceAdjustment() {
        // Test case with multiple Aces that need adjustment
        hand.add(new Card(Suit.HEARTS, Rank.ACE));  // Initially 11, should become 1
        hand.add(new Card(Suit.HEARTS, Rank.ACE));  // Initially 11, should become 1
        hand.add(new Card(Suit.HEARTS, Rank.KING)); // 10

        int score = calculator.scoreSuit(Suit.HEARTS, hand);
        assertEquals(12, score); // ACE (1) + ACE (1) + KING (10) = 12
    }

    @Test
    void testScoreSuitPartialAceAdjustment() {
        // Test case where one Ace should be 11 and one should be 1
        hand.add(new Card(Suit.HEARTS, Rank.ACE));  // Should stay 11
        hand.add(new Card(Suit.HEARTS, Rank.ACE));  // Should become 1
        hand.add(new Card(Suit.HEARTS, Rank.EIGHT)); // 8

        int score = calculator.scoreSuit(Suit.HEARTS, hand);
        assertEquals(20, score); // ACE (11) + ACE (1) + EIGHT (8) = 20
    }

    @Test
    void testScoreSuitMaximumAceValues() {
        // Test case with four Aces
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));
        hand.add(new Card(Suit.HEARTS, Rank.ACE));

        int score = calculator.scoreSuit(Suit.HEARTS, hand);
        assertEquals(14, score); // ACE (11) + ACE (1) + ACE (1) + ACE (1) = 14
    }

    @Test
    void testScoreSuitAceAdjustmentWithHighCards() {
        // Test case where Ace must be 1 due to high-value cards
        hand.add(new Card(Suit.HEARTS, Rank.ACE));   // Should become 1
        hand.add(new Card(Suit.HEARTS, Rank.KING));  // 10
        hand.add(new Card(Suit.HEARTS, Rank.QUEEN)); // 10
        hand.add(new Card(Suit.HEARTS, Rank.JACK));  // 10

        int score = calculator.scoreSuit(Suit.HEARTS, hand);
        assertEquals(31, score); // ACE (1) + KING (10) + QUEEN (10) + JACK (10) = 31
    }

    @Test
    void testScoreHandWithMultipleSuitAceAdjustments() {
        // Test Ace adjustments across multiple suits
        hand.add(new Card(Suit.HEARTS, Rank.ACE));    // Hearts: Should be 11
        hand.add(new Card(Suit.HEARTS, Rank.NINE));   // Hearts: 9
        hand.add(new Card(Suit.SPADES, Rank.ACE));    // Spades: Should be 1
        hand.add(new Card(Suit.SPADES, Rank.KING));   // Spades: 10
        hand.add(new Card(Suit.SPADES, Rank.QUEEN));  // Spades: 10

        EnumMap<Suit, Integer> scores = calculator.scoreHand(hand);
        assertEquals(20, scores.get(Suit.HEARTS));  // ACE (11) + NINE (9) = 20
        assertEquals(21, scores.get(Suit.SPADES));  // ACE (1) + KING (10) + QUEEN (10) = 21
    }

    @Test
    void testScoreHandWithNoAceAdjustmentNeeded() {
        // Test when Aces can remain at 11
        hand.add(new Card(Suit.HEARTS, Rank.ACE));    // Hearts: Should stay 11
        hand.add(new Card(Suit.HEARTS, Rank.NINE));   // Hearts: 9
        hand.add(new Card(Suit.SPADES, Rank.ACE));    // Spades: Should stay 11
        hand.add(new Card(Suit.SPADES, Rank.EIGHT));  // Spades: 8

        EnumMap<Suit, Integer> scores = calculator.scoreHand(hand);
        assertEquals(20, scores.get(Suit.HEARTS));  // ACE (11) + NINE (9) = 20
        assertEquals(19, scores.get(Suit.SPADES));  // ACE (11) + EIGHT (8) = 19
    }
}
