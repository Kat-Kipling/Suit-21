public interface DisplayStrategy
{
    void displayHand(Player player);

    void promptForPlayerCount();

    void showPlayerCountError();

    void promptForGameCount();
}
