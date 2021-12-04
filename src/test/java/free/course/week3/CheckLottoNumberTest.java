package free.course.week3;

import net.bytebuddy.pool.TypePool;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckLottoNumberTest {

    @Test
    @DisplayName("문자열 1개 LottoNumber 객체로 변환")
    void generateLottoNumberByString() {
        LottoNumber lottoNumber = LottoNumberGenerator.generateOneNumberByString("9");
        Assertions.assertThat(lottoNumber.getLottoNumber()).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("범위 내의 문자열이 아닐 경우 Exception 발생")
    void generateLottoNumberByStringWithException() {

        Assertions.assertThatThrownBy(() -> LottoNumberGenerator.generateOneNumberByString("46"))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessageContaining("range");

        Assertions.assertThatThrownBy(() -> LottoNumberGenerator.generateOneNumberByString("-44"))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessageContaining("range");

        Assertions.assertThatThrownBy(() -> LottoNumberGenerator.generateOneNumberByString("rhs"))
                .isExactlyInstanceOf(NumberFormatException.class)
                .hasMessageContaining("Can't");
    }

    @Test
    @DisplayName("문자열 6개를 Comma 로 구분해 List<LottoNumber> 객체로 변환")
    void generateLottoNumberListByString() {
        List<LottoNumber> lottoNumberList = LottoNumberGenerator.generateSixLottoNumbersByString("1, 2, 3, 4, 5, 6");

        Assertions.assertThat(lottoNumberList.size()).isEqualTo(6);
        Assertions.assertThat(lottoNumberList).doesNotHaveDuplicates();
        Assertions.assertThat(lottoNumberList.get(0).getLottoNumber()).isEqualTo(1);
        Assertions.assertThat(lottoNumberList.get(5).getLottoNumber()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 번호를 담는 WinningNumber 생성")
    void generateWinningNumber() {
        WinningNumbers winningNumbers = WinningNumbers.generateWinningNumbers("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(winningNumbers.getWinningNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 번호를 담는 WinningNumber 생성시 숫자가 부족할 경우 예외 처리")
    void generateWinningNumberWithException() {
        Assertions.assertThatThrownBy(() -> WinningNumbers.generateWinningNumbers("1, 2, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numbers");
    }
}
