package lld.snakeandladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    private GameController gameController;
    private Game game;
    private Dice dice;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        Board board = new Board(100, 5, 5);
        game = new Game(board);
        dice = new Dice(6);
        gameController = new GameController(game, dice);
        player1 = new Player("Alice");
        player2 = new Player("Bob");
        

        game.addPlayer(player1);
        game.addPlayer(player2);
    }

    @Test
    void testMakeMove() {
        Move move = gameController.makeMove(player1);
        assertNotNull(move);
        assertTrue(move.getDiceValue() >= 1 && move.getDiceValue() <= 6);
        assertTrue(move.getFinalPosition() >= 0 && move.getFinalPosition() <= 100);
    }

    @Test
    void testGameStart() {
        gameController.start(); // Simulate the game until it finishes
        assertTrue(game.isFinished()); // Game should be finished after start() is called
        assertNotNull(game.winnPlayer); // There should be a winner
    }
}
