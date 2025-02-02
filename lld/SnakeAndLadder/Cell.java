package lld.SnakeAndLadder;

public class Cell {
    int position, finalPosition;
    CellType type;
    Cell(int pos){
        position = pos;
        type = CellType.NORMAL;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setFinalPosition(int finalPosition) {
        this.finalPosition = finalPosition;
    }

    public int getFinalPosition() {
        if(type == CellType.SNAKE || type == CellType.LADDER) return finalPosition;
        return position;
    }

    public CellType getType() {
        return type;
    }
}
