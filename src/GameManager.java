import java.util.HashMap;

public class GameManager
{
    private int numberOfGames;
    private Player[] players;
    private HashMap<Player, Double> playerTotalScores;
    private ScoreCalculator scoreCalculator;
    private ConsoleDisplayStrategy consoleDisplay;

    public GameManager(int numberOfGames, int numberOfPlayers, Player[] players)
    {
        this.numberOfGames = numberOfGames;
        this.players = players;
        this.playerTotalScores = new HashMap<>();
        this.scoreCalculator = new ScoreCalculator();
    }

    public void launchGames()
    {
        // Run the specified number of games
        for (int i = 1; i <= numberOfGames; i++)
        {
            System.out.println("Starting Game " + i);
            Game game = new Game(1, this.players); // Pass players to the game
            game.startGame();  // Start the current game
            updateTotalScores(game.calculateScores()); // After game is over, update scores for players
        }

        // After all games, print final scores and declare the winner
        printFinalScores();
    }

    private void updateTotalScores(HashMap<Player, Double> gameScores)
    {
        for (Player player : gameScores.keySet())
        {
            playerTotalScores.put(player, playerTotalScores.getOrDefault(player, 0.0) + gameScores.get(player));
        }
    }

    private void printFinalScores()
    {
        consoleDisplay.printFinalScores(players, playerTotalScores, numberOfGames);
    }
}
