import java.util.Scanner;

public class GameLoop
{
    private Round round;
    private Player[] players;
    private Deck deck;
    private boolean gameWon = false;

    public GameLoop(Round round, Player[] players, Deck deck)
    {
        this.round = round;
        this.players = players;
        this.deck = deck;
    }

    public void run() {
        while (!gameWon && deck.getCardCount() >= players.length)
        {
            round.playRound(new Scanner(System.in));
            if (round.isRoundWon()) {
                gameWon = true;
            }
        }
    }
}
