package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningNumberTest {

    @Test
    @DisplayName("지난주 당첨 번호 받기 - 문자열 - winning number 와 lotto number 는 속성이 다르다고 생각하긴 함 랜덤 생성 / 지정 생성")
    void createLottoWinningNumberByString() {
        String one = "1";

        List<WinningNumber> winningNumbers = WinningNumberGenerator.winningNumberGenerate(one);

        Assertions.assertThat(winningNumbers.get(0).getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("지난주 당첨 번호 받기 - 문자열 구분자 ', '")
    void createLottoWinningNumberByStringWithDelimiter() {
        String source = "1, 2, 3, 4, 5, 6";

        List<WinningNumber> winningNumbers = WinningNumberGenerator.winningNumberGenerate(source);

        Assertions.assertThat(winningNumbers.size()).isEqualTo(6);
    }
}
