package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

public class LottoWinningTest {

    private List<LottoTicket> lottoTicketList;

    @BeforeEach
    void setup() {
        lottoTicketList = LottoSeller.sellLottoTicketByPrice(1000);
    }

    @RepeatedTest(500)
    @DisplayName("로또 티켓에 대하여 일치하는 수 등록하기")
    void lottoNumberChecker() {
        WinnerChecker winnerChecker = WinnerChecker.generateWinnerChecker();
        winnerChecker.setWinningNumbers(WinningNumbers.generateWinningNumbers("1, 2, 3, 4, 5, 6"));
        winnerChecker.checkLottoTicket(lottoTicketList);

        Assertions.assertThat(winnerChecker.getWinningList().get(WinnerPlace.FIRST)).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(winnerChecker.getWinningList().get(WinnerPlace.SECOND)).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(winnerChecker.getWinningList().get(WinnerPlace.THIRD)).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(winnerChecker.getWinningList().get(WinnerPlace.FOURTH)).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(winnerChecker.getWinningList().get(WinnerPlace.NONE)).isGreaterThanOrEqualTo(0);
    }



}
