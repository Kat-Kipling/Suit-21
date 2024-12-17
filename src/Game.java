import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game
{
    private Player[] players;
    private Deck deck;
    private Round round;
    private int pointPerRound;
    private Scanner input = new Scanner(System.in);


    public Game(int pointPerRound, Player[] players)
    {
        this.pointPerRound = pointPerRound;
        this.deck = new Deck();
        this.players = players;
    }

    public void startGame()
    {
        boolean gameWon = false;
        for (Player player : players)
        {
            player.initializeHand(deck);  // Player is now responsible for its hand
        }
        round = new Round(deck, players);


        // Game loop
        while (!gameWon && deck.getCardCount() > players.length)
        {
            round.playRound(input);  // Play a round

            if (round.isRoundWon())
            {
                gameWon = true;
            }
        }
    }

    public HashMap<Player, Double> calculateScores()
    {
        ArrayList<Player> winningPlayers = round.getWinningPlayers();
        HashMap<Player, Double> playerScores = new HashMap<>();

        if (!winningPlayers.isEmpty())
        {
            double pointsPerWinner = (double) this.pointPerRound / winningPlayers.size();
            for (Player player : players)
            {
                if (winningPlayers.contains(player))
                {
                    playerScores.put(player, pointsPerWinner);
                } else
                {
                    playerScores.put(player, 0.0);
                }
            }
        }
        return playerScores;
    }
}
