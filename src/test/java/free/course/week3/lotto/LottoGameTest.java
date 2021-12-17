package free.course.week3.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    @Test
    @DisplayName("로또 번호 6개를 가지는 로또 게임 1개 생성")
    void lottoGameGenerateTest() {
        LottoGameGenerator lottoGameGenerator = new LottoGameGenerator();

        LottoGame lottoGame = lottoGameGenerator.generate();

        Assertions.assertThat(lottoGame).isNotNull();
        Assertions.assertThat(lottoGame.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 게임 번호 중복 안됨")
    void lottoGameGenerateDuplicatedTest() {
        LottoGameGenerator lottoGameGenerator = new LottoGameGenerator();

        LottoGame lottoGame = lottoGameGenerator.generate();

        Assertions.assertThat(lottoGame.getLottoNumbers()).doesNotHaveDuplicates();
    }
}
