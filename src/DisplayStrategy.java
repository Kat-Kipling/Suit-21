import java.util.HashMap;

public interface DisplayStrategy
{
    void displayHand(Player player);

    void promptForPlayerCount();

    void showPlayerCountError();

    void promptForGameCount();

    void printFinalScores(Player[] players, HashMap<Player, Double> playerTotalScores, int numberOfGames);
}
