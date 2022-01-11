package free.course.racing.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final Random RAND = new Random();

    public static int getRandomNumber() {
        return RAND.nextInt(10);
    }
}
