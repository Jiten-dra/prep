package lld.SnakeAndLadder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameController {
    Game game;
    Dice dice;
    List<Move> moveHistory;
    Queue<Player> queue;
    int winPos;
    public GameController(Game game, Dice dice) {
        this.game = game;
        this.dice = dice;
        this.winPos = game.getBoard().getWinPosition();
        System.out.println("winPos: "+ winPos);
        moveHistory = new ArrayList<>();
        queue = new LinkedList<>();
        queue.addAll(game.getAllPlayers());
    }

    Move makeMove(Player player) {
        int diceValue = this.dice.roll();
        int startPosition = game.getPlayerPos(player);
        int tentativePos = startPosition + diceValue;
        if(tentativePos > winPos) {
            tentativePos = startPosition;
        }
        int finalPosition = game.getBoard().getNextPosition(tentativePos);
        game.setPlayerPos(player, finalPosition);
        Move move = new Move(player, diceValue, startPosition, tentativePos, finalPosition);

        return move;
    }

    void start(){
        while (!game.isFinished()) {
            Player currPlayer = queue.poll();
            System.out.printf("current turn of player: %s%n", currPlayer.getName());
            Move move = makeMove(currPlayer);
            moveHistory.add(move);
            System.out.println(move.toString());
            if(move.getFinalPosition() == winPos ){
                game.setWinner(currPlayer);
                System.out.printf("GAME end.%nPlayer: %s won the game", currPlayer.getName());
                break;
            }
            queue.add(currPlayer);
        }
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }

    
}
