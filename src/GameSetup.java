import java.util.Scanner;

public class GameSetup
{
    private final Scanner input = new Scanner(System.in);
    private final DisplayStrategy displayStrategy;

    public GameSetup(DisplayStrategy displayStrategy)
    {
        this.displayStrategy = displayStrategy;
    }

    public int getNumberOfPlayers()
    {
        int numberOfPlayers = -1;
        while (numberOfPlayers < 2 || numberOfPlayers > 6)
        {
            displayStrategy.promptForPlayerCount();
            numberOfPlayers = input.nextInt();
            input.nextLine(); // Clear input buffer
            if (numberOfPlayers < 2 || numberOfPlayers > 6)
            {
                displayStrategy.showPlayerCountError();
            }
        }
        return numberOfPlayers;
    }

    public int getNumberOfGames()
    {
        displayStrategy.promptForGameCount();
        return input.nextInt();
    }
}
