package main.artfix.other;

import java.util.Random;

public class RandomCodeGenerator {
    public static String generate() {
        Random random = new Random();
        int code = random.nextInt(999999) + 1;
        return String.format("%06d", code);
    }
}
