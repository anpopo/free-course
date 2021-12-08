package free.course.week3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningCheckerTest {

    @Test
    @DisplayName("3개가 일치하면 WinnerRank.FOURTH 반환")
    void winnerRankFourth() {
        int match = 3;

        WinnerChecker winnerChecker = WinnerChecker.createWinnerChecker();
        WinnerRank winnerRank = winnerChecker.check(match);

        Assertions.assertThat(WinnerRank.FOURTH).isEqualTo(winnerRank);
        Assertions.assertThat(WinnerRank.THIRD).isNotEqualTo(winnerRank);
    }

    @Test
    @DisplayName("3개가 일치하면 WinnerRank.FOURTH 반환")
    void winnerRankThird() {
        int match = 4;

        WinnerChecker winnerChecker = WinnerChecker.createWinnerChecker();
        WinnerRank winnerRank = winnerChecker.check(match);

        Assertions.assertThat(winnerRank).isEqualTo(WinnerRank.THIRD);
        Assertions.assertThat(winnerRank).isNotEqualTo(WinnerRank.FOURTH);
    }

}
