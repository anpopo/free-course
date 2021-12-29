package free.course.baseball.domain;

import free.course.baseball.exception.NotValidInputException;
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

    @RepeatedTest(20)
    @DisplayName("1 ~ 9 숫자를 가지는 뽈 3개를 가지는 ball container 생성")
    void ballContainerTest () {
        BallContainer ballContainer = BallContainer.of();

        Assertions.assertThat(ballContainer).isNotNull();
        Assertions.assertThat(ballContainer.getBalls().size()).isEqualTo(3);
        Assertions.assertThat(ballContainer.getBalls()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("사용자가 입력한 숫자에 대해 볼을 생성한다.")
    void inputCreateBallTest() {
        String input = "1";
        Ball ball = Ball.of(input);

        Assertions.assertThat(ball).isNotNull();
        Assertions.assertThat(ball.getNum()).isGreaterThan(0);
    }

    @Test
    @DisplayName("사용자가 입력한 세자리 수에 대해 볼을 생성한다.")
    void inputCreateBallTest2() {
        String input = "123";
        BallContainer ballContainer = BallContainer.of(input);

        Assertions.assertThat(ballContainer).isNotNull();
        Assertions.assertThat(ballContainer.getBalls().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("예외 - 사용자 입력값이 허용되지 않으면 튕겨내야 한다.")
    void inputCreateBallTest3() {
        String input1 = "1 ";
        String input2 = "12222244";
        String input3 = "1 1";

        Assertions.assertThatThrownBy(() -> BallContainer.of(input1))
                .isInstanceOf(NotValidInputException.class)
                .hasMessageContaining("입력");

        Assertions.assertThatThrownBy(() -> BallContainer.of(input2))
                .isInstanceOf(NotValidInputException.class)
                .hasMessageContaining("입력");

        Assertions.assertThatThrownBy(() -> BallContainer.of(input3))
                .isInstanceOf(NotValidInputException.class)
                .hasMessageContaining("입력");
    }
}
