package free.course.baseball.domain;

import java.util.EnumMap;
import java.util.List;

public class GameResult {

    private GameResult () {

    }
    public static GameResult of() {

        return new GameResult();
    }

    public EnumMap<Result, Integer> matching(BallContainer winningBalls, BallContainer clientBalls) {
        EnumMap<Result, Integer> resultMap = new EnumMap<>(Result.class);

        for (Ball ball : clientBalls.getBalls()) {
            Result result = matching(winningBalls.getBalls(), clientBalls.getBalls(), ball);
            resultMap.put(result, resultMap.getOrDefault(result, 0) + 1);
        }

        return resultMap;
    }

    private Result matching(List<Ball> winningBalls, List<Ball> clientBalls, Ball ball) {
        if (winningBalls.indexOf(ball) == clientBalls.indexOf(ball)) {
            return Result.STRIKE;
        }  else if (winningBalls.contains(ball)) {
            return Result.BALL;
        }
        return Result.NOTHING;
    }

}
