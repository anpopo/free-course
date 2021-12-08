package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {


    @Test
    @DisplayName("로또 티켓 생성 - 돈을 안내도 로또 티켓을 생성 해 준다.")
    void createLottoTicket() {
        LottoTicket lottoTicket = LottoTicketSeller.createLottoTicket(0);

        Assertions.assertThat(lottoTicket).isNotNull();
    }
}
