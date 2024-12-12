public class Hand implements HandInterface
{
    private Card[] hand;
    private int cardCount;
    private static final int DEFAULT_CAPACITY = 5;

    public Hand()
    {
        this(Hand.DEFAULT_CAPACITY);
    }

    public Hand(int capacity)
    {
        this.hand = new Card[capacity];
        this.cardCount = 0;
    }
}
