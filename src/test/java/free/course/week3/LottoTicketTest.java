package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {


    @Test
    @DisplayName("로또 티켓 생성 - 돈을 안내도 로또 티켓을 생성 해 준다.")
    void createLottoTicket() {
        LottoTicket lottoTicket = LottoTicketSeller.createLottoTicket(0);

        Assertions.assertThat(lottoTicket).isNotNull();
    }

    @Disabled
    @RepeatedTest(200)
    @DisplayName("로또 티켓 생성 - 돈을 안내도 로또 티켓을 생성 해 준다. - 중복될 수도 있는 번호 6개를 가진")
    void createLottoTicketWithLottoNumbersNoRandom() {
        LottoTicket lottoTicket = LottoTicketSeller.createLottoTicket(0);

        Assertions.assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
        Assertions.assertThat(lottoTicket.getLottoNumbers()).doesNotHaveDuplicates();
    }

    @RepeatedTest(200)
    @DisplayName("로또 티켓 생성 - 돈을 안내도 로또 티켓을 생성 해 준다. - 중복 없는 번호 6개를 가진")
    void createLottoTicketWithLottoNumbersYesRandom() {
        LottoTicket lottoTicket = LottoTicketSeller.createLottoTicket(0);

        Assertions.assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
        Assertions.assertThat(lottoTicket.getLottoNumbers()).doesNotHaveDuplicates();

    }
}
