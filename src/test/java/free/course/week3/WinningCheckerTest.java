package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Map;

public class WinningCheckerTest {

    @Test
    @DisplayName("3개가 일치하면 WinnerRank.FOURTH 반환")
    void winnerRankFourth() {
        int match = 3;
        String source = "1, 12, 13, 24, 25, 36";

        WinnerChecker winnerChecker = WinnerChecker.createWinnerChecker(source);
        WinnerRank winnerRank = winnerChecker.check(match);

        Assertions.assertThat(WinnerRank.FOURTH).isEqualTo(winnerRank);
        Assertions.assertThat(WinnerRank.THIRD).isNotEqualTo(winnerRank);
    }

    @Test
    @DisplayName("4개가 일치하면 WinnerRank.THIRD 반환")
    void winnerRankThird() {
        int match = 4;
        String source = "1, 12, 13, 24, 25, 36";

        WinnerChecker winnerChecker = WinnerChecker.createWinnerChecker(source);
        WinnerRank winnerRank = winnerChecker.check(match);

        Assertions.assertThat(WinnerRank.THIRD).isEqualTo(winnerRank);
        Assertions.assertThat(WinnerRank.FOURTH).isNotEqualTo(winnerRank);
    }

    @Test
    @DisplayName("로또 티켓을 넣으면 매치되는 숫자를 가지고 온다. ")
    void getWinnerRank() {
        LottoTicket lottoTicket = LottoTicketSeller.sellLottoTicket(1000);
        String source = "1, 12, 13, 24, 25, 36";

        WinnerChecker winnerChecker = WinnerChecker.createWinnerChecker(source);
        List<Integer> matchNumberList = winnerChecker.matcher(lottoTicket);
        Map<WinnerRank, Integer> winnerRankList = winnerChecker.check(matchNumberList);

        Assertions.assertThat(winnerRankList.size()).isEqualTo(1);
    }

    @RepeatedTest(1000)
    @DisplayName("로또 티켓을 넣으면 매치되는 숫자를 가지고 온다. - 다수 게임")
    void getWinnerRank1000() {
        LottoTicket lottoTicket = LottoTicketSeller.sellLottoTicket(100000);
        String source = "1, 12, 13, 24, 25, 36";

        WinnerChecker winnerChecker = WinnerChecker.createWinnerChecker(source);
        List<Integer> matchNumberList = winnerChecker.matcher(lottoTicket);
        Map<WinnerRank, Integer> winnerRankList = winnerChecker.check(matchNumberList);


        Assertions.assertThat(winnerRankList.size()).isGreaterThanOrEqualTo(0);
    }

//    @RepeatedTest(100)
//    @DisplayName("수익률 구하기")
//    void getMarginRatio() {
//        LottoTicket lottoTicket = LottoTicketSeller.sellLottoTicket(100000);
//        String source = "1, 12, 13, 24, 25, 36";
//
//        WinnerChecker winnerChecker = WinnerChecker.createWinnerChecker(source);
//        List<Integer> matchNumberList = winnerChecker.matcher(lottoTicket);
//        Map<WinnerRank, Integer> winnerRankList = winnerChecker.check(matchNumberList);
//
//        winnerChecker.getRatio();
//    }

}
