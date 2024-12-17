import java.util.ArrayList;
import java.util.EnumMap;

public class Hand implements HandInterface {

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    public Hand(ArrayList<Card> cards) {
        this.hand = cards;
    }

    @Override
    public int getCurrentSize() {
        return this.hand.size();
    }

    @Override
    public boolean add(Card newCard) {
        if (this.hand.add(newCard))
        {
            return true;
        } else return false;
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
        int aceCount = 0;

        // Calculate the score for the given suit and count aces
        for (Card card : this.hand) {
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
    public Card get(int index) {
        return this.hand.get(index);
    }

    @Override
    public Card get(Card card) {
        return null;
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
