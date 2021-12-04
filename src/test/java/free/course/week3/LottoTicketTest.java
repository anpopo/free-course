package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTicketTest {

    @RepeatedTest(500)
    @DisplayName("LottoNumber 6 개를 가지는 LottoTicket 생성")
    void generateLottoTicketWithSixLottoNumbers() {
        LottoTicket lottoTicket = LottoTicket.generateLottoTicket();
        Assertions.assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
        Assertions.assertThat(lottoTicket.getLottoNumbers()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("1000 원에 1 게임씩 LottoTicket 을 생성")
    void generateLottoTicketByPrice() {
        List<LottoTicket> lottoTicketList1 = LottoSeller.sellLottoTicketByPrice(1000);
        Assertions.assertThat(lottoTicketList1.size()).isEqualTo(1);
        List<LottoTicket> lottoTicketList5 = LottoSeller.sellLottoTicketByPrice(5600);
        Assertions.assertThat(lottoTicketList5.size()).isEqualTo(5);
    }

}
