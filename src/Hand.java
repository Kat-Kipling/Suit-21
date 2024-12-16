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

    public Card add(Card newCard)
    {
        if(this.hand.add(newCard))
        {
            return newCard;
        }
        else return null;
    }
}
