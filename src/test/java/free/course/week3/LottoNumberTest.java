package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("아무 번호를 가진 로또 번호 생성")
    void lottoNumberCreateTest() {
        LottoNumber lottoNumber = LottoNumberGenerator.generateLottoNumber();

        Assertions.assertThat(lottoNumber.getNumber()).isGreaterThan(0);
    }

    @RepeatedTest(1000)
    @DisplayName("랜덤한 번호를 가진 로또 번호 생성")
    void randomLottoNumberCreateTest() {
        LottoNumber lottoNumber = LottoNumberGenerator.generateLottoNumber();

        Assertions.assertThat(lottoNumber.getNumber()).isGreaterThanOrEqualTo(1);
        Assertions.assertThat(lottoNumber.getNumber()).isLessThanOrEqualTo(45);
    }

    @Disabled
    @Test
    @DisplayName("같은 번호를 가진 로또 번호면 true 값이 나와야 함")
    void testSameLottoNumberCheck() {
        LottoNumber lottoNumber1 = LottoNumberGenerator.generateLottoNumber(1);
        LottoNumber lottoNumber2 = LottoNumberGenerator.generateLottoNumber(1);

        Assertions.assertThat(lottoNumber1.equals(lottoNumber2)).isTrue();
    }

    @Disabled
    @Test
    @DisplayName("다른 번호를 가진 로또 번호면 false 값이 나와야 함")
    void testDifferentLottoNumberCheck() {
        LottoNumber lottoNumber1 = LottoNumberGenerator.generateLottoNumber(1);
        LottoNumber lottoNumber2 = LottoNumberGenerator.generateLottoNumber(11);

        Assertions.assertThat(lottoNumber1.equals(lottoNumber2)).isFalse();
    }

}
