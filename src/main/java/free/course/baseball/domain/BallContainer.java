package free.course.baseball.domain;

import free.course.baseball.util.ValidationUtil;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BallContainer {
    public  final int MAX_BALL_SIZE = 3;
    private final Set<Ball> balls = new LinkedHashSet<>();

    private BallContainer () {
        while (balls.size() < MAX_BALL_SIZE) {
            balls.add(Ball.of());
        }
    }

    private BallContainer(String input) {
        String[] validatedArr= ValidationUtil.validateClientInputNum(input);

        while (balls.size() < validatedArr.length) {
            balls.add(Ball.of(validatedArr[balls.size()]));
        }
    }

    public static BallContainer of() {
        return new BallContainer();
    }

    public static BallContainer of(String input) {
        return new BallContainer(input);
    }

    public List<Ball> getBalls() {
        return new ArrayList<>(balls);
    }
}
