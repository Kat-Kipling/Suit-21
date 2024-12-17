import java.util.Scanner;

public class GameLauncher {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // Prompt user for number of players
        int numberOfPlayers = getNumberOfPlayers(input);

        // Initialize and start the game
        Game game = new Game(1, numberOfPlayers); // Assuming 1 point per round
        game.startGame();  // Start the game
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
