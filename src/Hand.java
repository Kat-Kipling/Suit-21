import java.util.ArrayList;
import java.util.EnumMap;

public class Hand implements HandInterface {
    private ArrayList<Card> hand;
    private int cardCount;

    public Hand() {
        this.cardCount = 0;
        this.hand = new ArrayList<Card>();
    }

    public Hand(ArrayList<Card> cards) {
        this.cardCount = 0;
        this.hand = cards;
    }

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public Card add(Card newCard) {
        if (this.hand.add(newCard)) {
            return newCard;
        } else return null;
    }

    @Override
    public boolean exchange(Card oldCard, Card newCard) {
        for (Card card : hand) {
            if (card.equals(oldCard)) {
                this.hand.remove(card);
                this.hand.add(newCard);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear()
    {
        this.hand.clear();
    }

    @Override
    public int scoreSuit(Suit suitToScore)
    {
        int suitScore = 0;

        // Calculate the score for the given suit
        for (Card card : this.hand)
        {
            if (card.getSuit() == suitToScore)
            {
                suitScore += card.getRank().getValue();
            }
        }

        // Adjust score for aces if it exceeds 21
        if (suitScore > 21)
        {
            suitScore = 0;
            for (Card card : this.hand)
            {
                if (card.getSuit() == suitToScore)
                {
                    suitScore += card.getRank().getAlt_value();
                }
            }
        }

        return suitScore;
    }

    @Override
    public EnumMap<Suit, Integer> scoreHand()
    {
        EnumMap<Suit, Integer> scores = new EnumMap<>(Suit.class);

        for (Suit suit : Suit.values())
        {
            scores.put(suit, scoreSuit(suit));
        }

        return scores;
    }

    @Override
    public String toString()
    {
        StringBuilder cards = new StringBuilder();
        for(Card card : hand)
        {
            cards.append(card.toString());
            cards.append("\n");
        }
        return cards.toString();
    }
}
