package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("아무 번호를 가진 로또 번호 생성")
    void lottoNumberCreateTest() {
        LottoNumber lottoNumber = LottoNumberGenerator.generateLottoNumber();

        Assertions.assertThat(lottoNumber.getNumber()).isGreaterThan(0);
    }


}
