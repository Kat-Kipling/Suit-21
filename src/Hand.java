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
        return cardCount;
    }

    @Override
    public Card add(Card newCard) {
        if (this.hand.add(newCard))
        {
            this.cardCount++;
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
        this.cardCount = 0;
    }

    @Override
    public int scoreSuit(Suit suitToScore) {
        return 0;
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
