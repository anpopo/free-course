package free.course.week2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarUtilsTest {

    public static final String TEST_CAR_NAME1 = "람보르기니";
    public static final String TEST_CAR_NAME2 = "아우디";
    public static final String TEST_CAR_NAME3 = "벤츠";

    @Test
    void 이름을_받아오면_컴마로_구분한다() {

        String carNames = TEST_CAR_NAME1 + "," + TEST_CAR_NAME2 + "," + TEST_CAR_NAME3;

        List<String> carNameList = CarUtils.separateCarNamesWithComma(carNames);

        Assertions.assertThat(carNameList.size()).isEqualTo(3);
        Assertions.assertThat(carNameList.get(0)).isEqualTo(TEST_CAR_NAME1);
        Assertions.assertThat(carNameList.get(1)).isEqualTo(TEST_CAR_NAME2);
        Assertions.assertThat(carNameList.get(2)).isEqualTo(TEST_CAR_NAME3);
    }
}
