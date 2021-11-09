package free.course.week1.baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> ballList;

    public Balls(List<Integer> answers) {
        this.ballList = mapBall(answers);
    }

    private static List<Ball> mapBall(List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public PlayResult play(List<Integer> ballNumbers) {
        Balls userBalls = new Balls(ballNumbers);
        PlayResult result = new PlayResult();
        for(Ball ball : ballList) {
            BallStatus status = userBalls.play(ball);
            result.report(status);
        }

        return result;
    }

    public BallStatus play(Ball userBall) {
        return ballList.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
