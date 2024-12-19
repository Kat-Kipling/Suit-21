import java.util.Scanner;

public class GameLauncher
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ConsoleDisplayStrategy consoleDisplay = new ConsoleDisplayStrategy();

        // Initialize helper classes
        GameSetup gameSetup = new GameSetup(input);
        PlayerFactory playerFactory = new PlayerFactory(input);

        // Prompt user for number of players
        int numberOfPlayers = gameSetup.getNumberOfPlayers();

        // Create players
        Player[] players = playerFactory.createPlayers(numberOfPlayers, consoleDisplay);

        // Prompt for the number of games to play
        int numberOfGames = gameSetup.getNumberOfGames();

        // Create a GameManager to handle multiple games
        GameManager gameManager = new GameManager(numberOfGames, numberOfPlayers, players);
        gameManager.launchGames(); // Start all games and track scores
    }
}
