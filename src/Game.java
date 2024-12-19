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
    private ScoreCalculator scoreCalculator;


    public Game(int pointPerRound, Player[] players)
    {
        this.pointPerRound = pointPerRound;
        this.deck = new Deck();
        this.players = players;
        this.scoreCalculator = new ScoreCalculator();
    }

    public void startGame()
    {
        dealHands();

        round = new Round(deck, players);

        // Game loop
        boolean gameWon = false;
        while (!gameWon && deck.getCardCount() >= players.length)
        {
            round.playRound(input);  // Play a round

            if (round.isRoundWon())
            {
                gameWon = true;
            }
        }
    }

    private void dealHands() {
        for (Player player : players)
        {
            Hand hand = new Hand();
            for (int i = 0; i < 5; i++)
            {
                hand.add(deck.deal()); // Deal 5 cards to each player's hand
            }
            player.setHand(hand); // Assign the hand to the player
        }
    }

    public HashMap<Player, Double> calculateScores()
    {
        return scoreCalculator.calculateScores(round.getWinningPlayers(), players, pointPerRound);
    }
}
