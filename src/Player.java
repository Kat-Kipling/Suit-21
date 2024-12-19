import java.util.EnumMap;

public class Player {
    private final String name;
    private double score;
    private Hand hand;
    private EnumMap<Suit, Integer> suitScores;
    private final DisplayStrategy displayStrategy;
    private final ScoreCalculator scoreCalculator;

    public Player(String name, DisplayStrategy displayStrategy) {
        this.name = name;
        this.hand = new Hand();
        this.displayStrategy = displayStrategy;
        this.scoreCalculator = new ScoreCalculator();
    }

    public void setHand(Hand hand)
    {
        this.hand = hand;
        this.suitScores = scoreCalculator.scoreHand(this.hand);
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
        return this.scoreCalculator.scoreSuit(suitToScore, this.hand);
    }

    public EnumMap<Suit, Integer> scoreHand()
    {
        return this.scoreCalculator.scoreHand(this.hand);
    }

    public EnumMap<Suit, Integer> getSuitScores() {
        return suitScores;
    }

    public void displayHand()
    {
        displayStrategy.displayHand(this);
    }

    public void addPoints(double points)
    {
        this.score += points;
    }

    public void updateScores()
    {
        this.suitScores = scoreCalculator.scoreHand(hand);
    }

    public boolean hasScored21()
    {
        return scoreCalculator.hasScored21(suitScores);
    }
}
