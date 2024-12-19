import java.util.HashMap;

public class Game
{
    private final Player[] players;
    private Deck deck;
    private Round round;
    private final int pointPerRound;
    private final ScoreCalculator scoreCalculator;


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
        GameLoop gameLoop = new GameLoop(round, players, deck);
        gameLoop.run();
    }


    private void dealHands()
    {
        HandDealer handDealer = new HandDealer(deck);
        handDealer.dealHands(players);
    }


    public HashMap<Player, Double> calculateScores()
    {
        return scoreCalculator.calculateScores(round.getWinningPlayers(), players, pointPerRound);
    }
}
