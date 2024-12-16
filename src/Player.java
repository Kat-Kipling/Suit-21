import java.util.ArrayList;

public class Player
{
    private String name;
    private int playerNumber;
    private Hand hand;


    public Player(String name, int playOrder)
    {
        this.name = name;
        this.playerNumber = playOrder;
        this.hand = new Hand();
    }

    public void addCard(Card card)
    {
        this.hand.add(card);
    }

    public boolean exchange(Card cardToExchange, Card newCard)
    {
        return this.hand.exchange(cardToExchange, newCard);
    }

    public Card getCard(int index)
    {
        return this.hand.get(index);
    }

    public Card getCard(Card card)
    {
        return null;
    }

    public void clearHand()
    {
        this.hand.clear();
    }

    public Hand getHand()
    {
        return this.hand;
    }

    public String getName() {
        return name;
    }
}
