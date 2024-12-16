import java.util.EnumMap;

public class Player {
    private String name;
    private int playerNumber;
    private Hand hand;


    public Player(String name, int playOrder) {
        this.name = name;
        this.playerNumber = playOrder;
        this.hand = new Hand();
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public void clearHand() {
        this.hand.clear();
    }

    public String getHand() {
        return this.hand.toString();
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
