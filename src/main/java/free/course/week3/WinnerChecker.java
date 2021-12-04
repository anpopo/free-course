package free.course.week3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerChecker {
    private WinningNumbers winningNumbers;
    private final Map<WinnerPlace, Integer> winningList;
    private int gameCount;

    private WinnerChecker() {
        HashMap<WinnerPlace, Integer> winningList = new HashMap<>();
        winningList.put(WinnerPlace.FIRST, 0);
        winningList.put(WinnerPlace.SECOND, 0);
        winningList.put(WinnerPlace.THIRD, 0);
        winningList.put(WinnerPlace.FOURTH, 0);
        winningList.put(WinnerPlace.NONE, 0);

        this.winningList = winningList;
    }

    public static WinnerChecker generateWinnerChecker() {
        return new WinnerChecker();
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void checkLottoTicket(List<LottoTicket> lottoTicketList) {
        this.gameCount = lottoTicketList.size();

        lottoTicketList.forEach(lottoTicket -> {
            WinnerPlace winnerPlace = WinnerPlace.getWinnerPlace(winningNumbers.check(lottoTicket));
            if(winnerPlace != null) winningList.put(winnerPlace, winningList.getOrDefault(winnerPlace, 0) + 1);
        });
    }

    public Map<WinnerPlace, Integer> getWinningList() {
        return winningList;
    }

    public int getGameCount() {
        return gameCount;
    }
}
