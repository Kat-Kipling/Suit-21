import java.util.Scanner;
import java.util.InputMismatchException;

public class GameLauncher {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ConsoleDisplayStrategy consoleDisplay = new ConsoleDisplayStrategy();

        // Initialize helper classes
        GameSetup gameSetup = new GameSetup(consoleDisplay);
        PlayerFactory playerFactory = new PlayerFactory(input);

        // Get valid number of players
        int numberOfPlayers = getValidInput(input, "Enter number of players: ", 2, 6);

        // Create players
        Player[] players = playerFactory.createPlayers(numberOfPlayers, consoleDisplay);

        // Get valid number of games
        int numberOfGames = getValidInput(input, "Enter number of games to play: ", 1, 100);

        // Create a GameManager to handle multiple games
        GameManager gameManager = new GameManager(numberOfGames, numberOfPlayers, players);
        gameManager.launchGames(); // Start all games and track scores

        input.close();
    }

    private static int getValidInput(Scanner scanner, String prompt, int min, int max) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                String inputLine = scanner.nextLine().trim();

                // Check for empty input
                if (inputLine.isEmpty()) {
                    System.out.println("Error: Input cannot be empty. Please enter a number between " +
                            min + " and " + max + ".");
                    continue;
                }

                // Try to parse the input as an integer
                value = Integer.parseInt(inputLine);

                // Validate the range
                if (value < min || value > max) {
                    System.out.println("Error: Please enter a number between " + min + " and " + max + ".");
                    continue;
                }

                validInput = true;

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

        return value;
    }
}