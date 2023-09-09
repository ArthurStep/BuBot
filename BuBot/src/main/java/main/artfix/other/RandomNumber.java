package main.artfix.other;

import java.util.Random;

public class RandomNumber {
    public static int get() {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1;
        if (randomNumber <= 5) {
            randomNumber = 0;
        } else {
            randomNumber = 1;
        }
        return randomNumber;
    }
}
