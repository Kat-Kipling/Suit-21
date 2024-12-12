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
    }

    public void addCard(Card card)
    {
        this.hand.add(card);
    }
}
