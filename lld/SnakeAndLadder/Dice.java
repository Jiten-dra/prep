package lld.SnakeAndLadder;

import java.util.Random;

public class Dice {
    int faces;
    Random random = new Random();
    Dice(int faces){
        this.faces = faces;
    }
    int roll(){
        return random.nextInt(faces) + 1;
    }
}
