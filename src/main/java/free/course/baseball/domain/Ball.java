package free.course.baseball.domain;

import java.util.Objects;

public class Ball {
    private int num;

    private Ball() {}

    public Ball (int num) {
        this.num = num;
    }

    public static Ball of() {
        return new Ball(RandomUtil.getRandNum());
    }

    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return num == ball.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
