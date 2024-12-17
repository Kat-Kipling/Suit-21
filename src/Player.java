import java.util.EnumMap;

public class Player {
    private String name;
    private int playerNumber;
    private Hand hand;
    private EnumMap<Suit, Integer> suitScores;


    public Player(String name, int playOrder) {
        this.name = name;
        this.playerNumber = playOrder;
        this.hand = new Hand();
        this.suitScores = scoreHand();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public boolean exchange(Card cardToExchange, Card newCard)
    {
        if (this.hand.exchange(cardToExchange, newCard))
        {
            this.suitScores = scoreHand();
            return true;
        }
        else return false;
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

    public int scoreSuit(Suit suitToScore)
    {
        return this.hand.scoreSuit(suitToScore);
    }

    public EnumMap<Suit, Integer> scoreHand()
    {
        return this.hand.scoreHand();
    }
}
