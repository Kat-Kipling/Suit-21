import java.util.Scanner;

public class GameLauncher
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ConsoleDisplayStrategy consoleDisplay = new ConsoleDisplayStrategy();

        // Prompt user for number of players
        int numberOfPlayers = getNumberOfPlayers(input);

        // Initialize players
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < players.length; i++)
        {
            System.out.printf("Enter name for Player %d (type 'Computer' for an AI player): ", i + 1);
            String name = input.nextLine().trim();

            // Determine the strategy based on the name
            PlayerStrategy playerStrategy = name.equalsIgnoreCase("Computer")
                    ? new ComputerStrategy()  // Assign AI strategy
                    : new HumanStrategy(input); // Assign human strategy

            players[i] = new Player(name, consoleDisplay, playerStrategy);
        }

        // Prompt for the number of games to play
        System.out.print("Enter number of games to play: ");
        int numberOfGames = input.nextInt();
        input.nextLine();  // Clear the input buffer


        // Create a GameManager to handle multiple games
        GameManager gameManager = new GameManager(numberOfGames, numberOfPlayers, players);
        gameManager.launchGames(); // Start all games and track scores
    }

    // Helper method to get a valid number of players
    private static int getNumberOfPlayers(Scanner input)
    {
        int numberOfPlayers = -1;

        while (numberOfPlayers < 2 || numberOfPlayers > 6)
        {
            System.out.println("How many players (2 - 6)?");
            numberOfPlayers = input.nextInt();
            input.nextLine(); // Clear input buffer

            if (numberOfPlayers < 2 || numberOfPlayers > 6)
            {
                System.out.println("Invalid number of players! Please enter a number between 2 and 6.");
            }
        }

        return numberOfPlayers;
    }
}
