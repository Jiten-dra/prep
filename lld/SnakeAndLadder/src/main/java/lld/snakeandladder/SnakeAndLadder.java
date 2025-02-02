package lld.snakeandladder;

public class SnakeAndLadder {
    public static void main(String[] args) {
        Player jitu = new Player("jiten");
        Player tara = new Player("tara");

        Dice dice = new Dice(6);
        Board board = new Board(100, 5, 5);
        Game game = new Game(board);
        game.addPlayer(tara);
        game.addPlayer(jitu);

        GameController gameController = new GameController(game, dice);
        
        gameController.start();
    }
}
