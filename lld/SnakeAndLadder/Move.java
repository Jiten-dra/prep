package lld.SnakeAndLadder;

public class Move {
    Player player;
    int diceRoll;
    int startPosition;
    int tentativePosition;
    int finalPosition; // After applying snake/ladder adjustments
    // Optional: timestamp, move number, etc.
    public Move(Player player, int diceRoll, int startPosition, int tentativePosition, int finalPosition) {
        this.player = player;
        this.diceRoll = diceRoll;
        this.startPosition = startPosition;
        this.tentativePosition = tentativePosition;
        this.finalPosition = finalPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    @Override
    public String toString() {
        return "Move [player=" + player.getName() + ", diceRoll=" + diceRoll + ", startPosition=" + startPosition
                + ", tentativePosition=" + tentativePosition + ", finalPosition=" + finalPosition + "]";
    }

    
}

