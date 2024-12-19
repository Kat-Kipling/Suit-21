public interface PlayerStrategy
{
    Card chooseCardToPlay(Player player, Hand hand);

    boolean exchange(Card cardToExchange, Card newCard, Hand hand, Player player);
}
