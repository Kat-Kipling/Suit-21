import java.util.ArrayList;

public class Hand implements HandInterface
{
    private ArrayList<Card> hand;
    private int cardCount;

    public Hand()
    {
        this.cardCount = 0;
    }

    public Hand(ArrayList<Card> cards)
    {
        this.cardCount = 0;
        this.hand = cards;
    }

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public Card add(Card newCard)
    {
        if(this.hand.add(newCard))
        {
            return newCard;
        }
        else return null;
    }

    @Override
    public boolean exchange(Card oldCard, Card newCard) {
        for(Card card : hand)
        {
            if (card.equals(oldCard))
            {
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

    }

    @Override
    public int scoreSuit(Suit suitToScore)
    {
        return 0;
    }
}
