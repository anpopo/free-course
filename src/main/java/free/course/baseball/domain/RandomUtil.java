package free.course.baseball.domain;

import java.util.Random;

public class RandomUtil {

    public static final Random RANDOM = new Random();
    public static final int BOUND = 9;

    public static int getRandNum() {
        return RANDOM.nextInt(BOUND) + 1;
    }
}
