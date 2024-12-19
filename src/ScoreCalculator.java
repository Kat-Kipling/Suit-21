import java.util.EnumMap;

public class ScoreCalculator
{
    public boolean hasScored21(EnumMap<Suit, Integer> suitScores)
    {
        for (EnumMap.Entry<Suit, Integer> entry : suitScores.entrySet())
        {
            if (entry.getValue() == 21) {
                return true; // If score 21 is found for any suit, return true
            }
        }
        return false; // If no suit has scored 21, return false
    }

    public int scoreSuit(Suit suitToScore, Hand hand)
    {
        int suitScore = 0;
        int aceCount = 0;

        // Calculate the score for the given suit and count aces
        for (int i = 0; i < hand.getCurrentSize(); i++)
        {
            Card card = hand.get(i);
            if (card.getSuit() == suitToScore) {
                int cardValue = card.getRank().getValue();
                suitScore += cardValue;
                if (cardValue == 1) {
                    aceCount++;
                }
            }
        }

        // Adjust score for aces if it exceeds 21
        while (suitScore > 21 && aceCount > 0) {
            suitScore -= 10;  // Ace value adjusted to 11
            aceCount--;
        }

        return suitScore;
    }

    public EnumMap<Suit, Integer> scoreHand(Hand hand)
    {
        EnumMap<Suit, Integer> scores = new EnumMap<>(Suit.class);

        for (Suit suit : Suit.values())
        {
            scores.put(suit, scoreSuit(suit, hand));
        }

        return scores;
    }
}
