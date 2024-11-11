public enum Suit
{
    CLUBS(1),
    DIAMONDS(2),
    HEARTS(3),
    SPADES(4);

    private final int value;

    Suit(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Suit fromValue(int value) {
        for (Suit suit : Suit.values()) {
            if (suit.getValue() == value) {
                return suit;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
