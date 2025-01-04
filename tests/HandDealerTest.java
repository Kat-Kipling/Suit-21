import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HandDealerTest {
    private HandDealer handDealer;
    private Player[] players;
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
        players = new Player[]{new Player("Player 1", new ConsoleDisplayStrategy(), new ComputerStrategy()),
                new Player("Player 2", new ConsoleDisplayStrategy(), new ComputerStrategy())};
        handDealer = new HandDealer(deck);
    }

    @Test
    void testDealHands() {
        handDealer.dealHands(players);
        for (Player player : players) {
            assertEquals(5, player.getHand().getCurrentSize(), "Each player should have 5 cards");
        }
    }
}
