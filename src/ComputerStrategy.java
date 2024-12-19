public class ComputerStrategy implements PlayerStrategy
{
    @Override
    public Card chooseCardToPlay(Player player, Hand hand)
    {
        player.displayHand();
        // Simple AI: Play the first card
        return player.getCard(0);
    }

    @Override
    public boolean exchange(Card cardToExchange, Card newCard, Hand hand, Player player)
    {
        if (hand.exchange(cardToExchange, newCard))
        {
            player.setSuitScores(player.scoreHand());
            return true;
        }
        else return false;
    }
}
