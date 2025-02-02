package lld.SnakeAndLadder;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


enum GameStatus {
    INPROGRESS,
    FINISHED
}
public class Game {
    Board board;
    Map<Player,Integer> playerPos;
    GameStatus status;
    Player winnPlayer;

    public Game(Board board) {
        this.board = board;
        playerPos = new HashMap<>();
        status = GameStatus.INPROGRESS;
    }

    void addPlayer(Player player){
        if(playerPos.containsKey(player)){
            //TODO handle error
        }
        playerPos.put(player, 0);
    }

    Collection<Player> getAllPlayers() {
        return playerPos.keySet();
    }

    int getPlayerPos(Player player){
        return playerPos.get(player);
    }

    void setPlayerPos(Player player, int pos){
        playerPos.put(player, pos);
    }

    Board getBoard(){
        return board;
    }

    boolean isFinished(){
        return status == GameStatus.FINISHED;
    }

    void setWinner(Player player){
        status = GameStatus.FINISHED;
        winnPlayer = player;
    }
}
