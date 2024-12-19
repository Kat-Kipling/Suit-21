public class HandDealer
{
    private Deck deck;

    public HandDealer(Deck deck)
    {
        this.deck = deck;
    }

    public void dealHands(Player[] players)
    {
        for (Player player : players)
        {
            Hand hand = new Hand();
            for (int i = 0; i < 5; i++)
            {
                hand.add(deck.deal());
            }
            player.setHand(hand);
        }
    }
}
