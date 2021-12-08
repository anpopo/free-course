package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    @Test
    @DisplayName("입력 금액에 맞는 티켓을 생성해 준다. - 1000원에 1장")
    void buyLottoTicket() {
        LottoTicket lottoTicket = LottoTicketSeller.sellLottoTicket(1000);

        Assertions.assertThat(lottoTicket.getLottoGames().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 금액이 맞지 않을 경우 예외 발생")
    void buyLottoTicketWithException() {
        Assertions.assertThatThrownBy(() -> LottoTicketSeller.sellLottoTicket(1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("enough");

        Assertions.assertThatThrownBy(() -> LottoTicketSeller.sellLottoTicket(100001))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("maximum");
    }

    @Test
    @DisplayName("입력 금액에 맞는 티켓을 생성해 준다. - 100장")
    void buyLottoTicket100s() {
        LottoTicket lottoTicket = LottoTicketSeller.sellLottoTicket(100000);

        Assertions.assertThat(lottoTicket.getLottoGames().size()).isEqualTo(100);
    }



}
