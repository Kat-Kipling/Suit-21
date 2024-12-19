public class ComputerStrategy implements PlayerStrategy
{
    @Override
    public Card chooseCardToPlay(Player player, Hand hand)
    {
        player.displayHand();
        // Simple AI: Play the first card
        return player.getCard(0);
    }
}
