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
