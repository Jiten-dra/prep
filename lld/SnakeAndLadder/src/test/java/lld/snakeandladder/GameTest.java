package lld.snakeandladder;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Board board;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        board = new Board(100, 5, 5);
        game = new Game(board);
        player1 = new Player("Alice");
        player2 = new Player("Bob");
    }

    @Test
    void testAddPlayer() {
        game.addPlayer(player1);
        game.addPlayer(player2);

        assertEquals(2, game.getAllPlayers().size());
        assertTrue(game.getAllPlayers().contains(player1));
        assertTrue(game.getAllPlayers().contains(player2));
    }

    @Test
    void testPlayerPositions() {
        game.addPlayer(player1);
        game.addPlayer(player2);

        assertEquals(0, game.getPlayerPos(player1)); // Initial position should be 0
        assertEquals(0, game.getPlayerPos(player2));

        game.setPlayerPos(player1, 10);
        assertEquals(10, game.getPlayerPos(player1));
    }

    @Test
    void testGameStatus() {
        assertFalse(game.isFinished()); // Game should not be finished initially

        game.setWinner(player1);
        assertTrue(game.isFinished()); // Game should be finished after setting a winner
        assertEquals(player1, game.winnPlayer);
    }
}