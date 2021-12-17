package free.course.week3.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호를 1개 생성한다.")
    void createLottoNumberTest() {
        Number lottoNumber = LottoNumber.create();
        Assertions.assertThat(lottoNumber).isNotNull();
    }

    @Test
    @DisplayName("로또 번호를 1개 생성한다. - 숫자를 가지고 있는")
    void createLottoNumberGWithNumberTest() {
        Number lottoNumber = LottoNumber.create();
        Assertions.assertThat(lottoNumber.getNumber()).isNotNull();
        Assertions.assertThat(lottoNumber.getNumber()).isGreaterThan(0);
    }

    @RepeatedTest(100)
    @DisplayName("로또 번호를 1개 생성한다. - 1부터 45 까지의 랜덤한 숫자를 가지고 있는")
    void createLottoNumberWithRandomNumberTest() {
        Number lottoNumber = LottoNumber.create();
        Assertions.assertThat(lottoNumber.getNumber()).isNotNull();
        Assertions.assertThat(lottoNumber.getNumber()).isGreaterThan(0);
        Assertions.assertThat(lottoNumber.getNumber()).isLessThanOrEqualTo(45);
    }
}
