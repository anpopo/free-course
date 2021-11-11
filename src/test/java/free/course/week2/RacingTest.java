package free.course.week2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingTest {

    @BeforeEach
    public void setUp () {
        List<Car> cars = CarsFactory.createCars(List.of("카이로", "서울", "부에노스아이레스", "타이페이", "도쿄"));
    }

    @Test
    void 정해진_횟수만큼_자동차들이_달린다() {
    }
}
