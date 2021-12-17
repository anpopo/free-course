package free.course.week3.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("로또 가게는 전부 고유한 로또 가게이지요?")
    void uniqueLottoStore() {
        LottoStore lottoStore1 = LottoStore.createLottoStoreByApproval(true);
        LottoStore lottoStore2 = LottoStore.createLottoStoreByApproval(true);


        Assertions.assertThat(lottoStore1.getId()).isNotEqualTo(lottoStore2.getId());
    }

    @Test
    @DisplayName("1000원에 한장 팝니다~~")
    void lottoSellingTest() {
        LottoStore lottoStore = LottoStore.createLottoStoreByApproval(true);

        Lotto lotto = lottoStore.sell(10000);

        Assertions.assertThat(lotto).isNotNull();
        Assertions.assertThat(lotto.getGameCount()).isEqualTo(10);
        Assertions.assertThat(lotto.getLottoLines().size()).isEqualTo(10);
    }
}
