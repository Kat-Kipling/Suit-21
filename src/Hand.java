import java.util.ArrayList;

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
    public int scoreSuit(Suit suitToScore) {
        int suitScore = 0;
        for(Card card : this.hand)
        {
            if (card.getSuit().equals(suitToScore))
            {
                suitScore+=card.getRank().getValue();
            }

        }

        if (suitScore > 21) // If score goes over 21, any aces are more beneficial as 1's rather than 11's
        {
            suitScore = 0;
            for(Card card : this.hand)
            {
                if (card.getSuit().equals(suitToScore))
                {
                    suitScore+=card.getRank().getAlt_value();
                }
            }
        }

        return suitScore;
    }

    @Override
    public int[] scoreHand()
    {
        int[] scores = new int[4];
        scores[0] = scoreSuit(Suit.CLUBS);
        scores[1] = scoreSuit(Suit.DIAMONDS);
        scores[2] = scoreSuit(Suit.HEARTS);
        scores[3] = scoreSuit(Suit.SPADES);
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
