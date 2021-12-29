package free.course.baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

public class GameResultTest {

    @Test
    @DisplayName("입력한 숫자에 대한 맞는 갯수 판별 - 스트라이크")
    void resultCheckTest1 () {
        BallContainer b1 = BallContainer.of("123");
        BallContainer b2 = BallContainer.of("123");

        GameResult gameResult = GameResult.of();
        EnumMap<Result, Integer> matchingResult = gameResult.matching(b1, b2);

        Assertions.assertThat(matchingResult.get(Result.STRIKE)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력한 숫자에 대한 맞는 갯수 판별 - 볼")
    void resultCheckTest2 () {
        BallContainer b1 = BallContainer.of("123");
        BallContainer b2 = BallContainer.of("312");

        GameResult gameResult = GameResult.of();
        EnumMap<Result, Integer> matchingResult = gameResult.matching(b1, b2);

        Assertions.assertThat(matchingResult.get(Result.BALL)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력한 숫자에 대한 맞는 갯수 판별 - 낫싱")
    void resultCheckTest3 () {
        BallContainer b1 = BallContainer.of("123");
        BallContainer b2 = BallContainer.of("456");

        GameResult gameResult = GameResult.of();
        EnumMap<Result, Integer> matchingResult = gameResult.matching(b1, b2);

        Assertions.assertThat(matchingResult.get(Result.NOTHING)).isEqualTo(3);
    }

    @RepeatedTest(200)
    @DisplayName("입력한 숫자에 대한 맞는 갯수 판별")
    void resultCheckTest4 () {
        BallContainer b1 = BallContainer.of();
        BallContainer b2 = BallContainer.of();

        GameResult gameResult = GameResult.of();
        EnumMap<Result, Integer> matchingResult = gameResult.matching(b1, b2);

        Assertions.assertThat(matchingResult.getOrDefault(Result.STRIKE, 0)).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(3);
        Assertions.assertThat(matchingResult.getOrDefault(Result.BALL, 0)).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(3);
        Assertions.assertThat(matchingResult.getOrDefault(Result.NOTHING, 0)).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(3);
    }
}
