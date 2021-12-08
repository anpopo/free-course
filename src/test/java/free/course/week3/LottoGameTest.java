package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class LottoGameTest {
    private LottoGame lottoGame;
    @BeforeEach
    void setup() {
         lottoGame = LottoGameGenerator.createLottoGame();
    }

    @Test
    @DisplayName("로또 게임 생성 - 돈을 안내도 로또 게임을 생성 해 준다.")
    void createLottoGame() {
        Assertions.assertThat(lottoGame).isNotNull();
    }

    @Disabled
    @RepeatedTest(200)
    @DisplayName("로또 게임 생성 - 돈을 안내도 로또 게임을 생성 해 준다. - 중복될 수도 있는 번호 6개를 가진")
    void createLottoGameWithLottoNumbersNoRandom() {

        Assertions.assertThat(lottoGame.getLottoNumbers().size()).isEqualTo(6);
        Assertions.assertThat(lottoGame.getLottoNumbers()).doesNotHaveDuplicates();
    }

    @RepeatedTest(200)
    @DisplayName("로또 게임 생성 - 돈을 안내도 로또 게임을 생성 해 준다. - 중복 없는 번호 6개를 가진")
    void createLottoGameWithLottoNumbersYesRandom() {
        Assertions.assertThat(lottoGame.getLottoNumbers().size()).isEqualTo(6);
        Assertions.assertThat(lottoGame.getLottoNumbers()).doesNotHaveDuplicates();
    }
}
