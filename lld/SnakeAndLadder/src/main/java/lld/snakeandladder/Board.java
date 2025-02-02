package lld.snakeandladder;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Board {
    List<Cell> cells;
    int cellCount;
    Board(int cellCount, int snakeCount, int ladderCount){
        this.cellCount = cellCount;
        cells = new ArrayList<>(cellCount);
        
        
        for(int i=0;i<cellCount+1;i++){
            cells.add(new Cell(i));
        }
        //update type of start and end cell
        cells.get(0).setType(CellType.START);
        cells.get(cellCount).setType(CellType.END);

        Random rand = new Random();
        for (int j = 0; j < snakeCount; j++) {
            int snakeStart = rand.nextInt(cellCount-1) + 1;
            int snakeTail = rand.nextInt(Math.max(1, snakeStart - 10)) + 1;
            System.out.printf("snake %d head %d tail %d%n", j, snakeStart, snakeTail);
            cells.get(snakeStart).setFinalPosition(snakeTail);
            cells.get(snakeStart).setType(CellType.SNAKE);
        }

        for (int j = 0; j < ladderCount; j++) {
            int ladderStart = rand.nextInt(cellCount-10) + 1;
            int offset = Math.min(cellCount-1, ladderStart + 10);
            int ladderEnd = offset + rand.nextInt(Math.max(1,cellCount - 1 - offset)) + 1;
            System.out.printf("ladder %d head %d end %d%n", j, ladderStart, ladderEnd);
            cells.get(ladderStart).setFinalPosition(ladderEnd);
            cells.get(ladderStart).setType(CellType.LADDER);
        }
    }

    int getNextPosition(int tentativePos){
        return cells.get(tentativePos).getFinalPosition();
    }

    int getWinPosition(){
        return cellCount;
    }
}
