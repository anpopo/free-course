package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LottoTicketTest {

    @RepeatedTest(500)
    @DisplayName("LottoNumber 6 개를 가지는 LottoTicket 생성")
    void generateLottoTicketWithSixLottoNumbers() {
        LottoTicket lottoTicket = LottoTicket.generateLottoTicket();
        Assertions.assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
        Assertions.assertThat(lottoTicket.getLottoNumbers()).doesNotHaveDuplicates();
    }
}
