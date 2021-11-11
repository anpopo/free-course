package free.course.week2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarTest {

    public static final String TEST_CAR_NAME1 = "람보르기니";
    public static final String TEST_CAR_NAME2 = "아우디";
    public static final String TEST_CAR_NAME3 = "벤츠";
    public static final String TEST_CAR_NAME4 = "세상에서 제일가는 포테이토 칩";

    @Test
    void 자동차_1대에_이름을_붙일수_있다() {
        Car car = new Car();

        car.validCarNameAndSetName(TEST_CAR_NAME1);

        Assertions.assertThat(car.getCarName()).isEqualTo(TEST_CAR_NAME1);

        car.validCarNameAndSetName(TEST_CAR_NAME4);

        Assertions.assertThat(car.getCarName()).isEqualTo(TEST_CAR_NAME1);
    }


    @Test
    void 자동차_여러대에_이름을_붙일수_있다() {
        List<Car> carList = CarsFactory.createCars(List.of(TEST_CAR_NAME1, TEST_CAR_NAME2, TEST_CAR_NAME3));

        Assertions.assertThat(carList.size()).isEqualTo(3);

        Assertions.assertThat(carList).extracting("carName")
                .containsExactly(TEST_CAR_NAME1, TEST_CAR_NAME2, TEST_CAR_NAME3);

    }
}
