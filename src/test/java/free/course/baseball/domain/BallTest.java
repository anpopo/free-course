package free.course.baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class BallTest {


    @RepeatedTest(100)
    @DisplayName("1 ~ 9 숫자를 가지는 뽈 하나를 생성")
    void createBall () {
        Ball ball = Ball.of();
        int num = ball.getNum();
        Assertions.assertThat(num).isBetween(1, 9);
    }

    @Test
    @DisplayName("1 ~ 9 숫자를 가지는 뽈 3개를 가지는 ball container 생성")
    void ballContainerTest () {
        BallContainer ballContainer = BallContainer.of();

        Assertions.assertThat(ballContainer).isNotNull();
        Assertions.assertThat(ballContainer.getBalls().size()).isEqualTo(3);
        Assertions.assertThat(ballContainer.getBalls()).doesNotHaveDuplicates();
    }
}
