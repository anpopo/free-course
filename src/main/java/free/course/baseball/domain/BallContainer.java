package free.course.baseball.domain;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class BallContainer {
    private final Set<Ball> balls;

    private BallContainer () {
        balls = new LinkedHashSet<>();
        while (balls.size() < 3) {
            balls.add(Ball.of());
        }
    }

    public static BallContainer of() {
        return new BallContainer();
    }

    public Set<Ball> getBalls() {
        return new LinkedHashSet<>(balls);
    }
}
