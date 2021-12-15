package free.course.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerChecker {

    private static List<WinningNumber> winningNumbers;

    public static WinnerChecker createWinnerChecker(String source) {
        WinnerChecker winnerChecker = new WinnerChecker();
        winnerChecker.setWinningNumber(WinningNumberGenerator.winningNumberGenerate(source));
        return winnerChecker;
    }

    public static void setWinningNumbers(List<WinningNumber> winningNumbers) {
        WinnerChecker.winningNumbers = winningNumbers;
    }

    private void setWinningNumber(List<WinningNumber> winningNumbers) {
        WinnerChecker.winningNumbers = winningNumbers;
    }


    public WinnerRank check(int match) {
        return WinnerRank.pleaseCheckMatchCount(match);
    }

    public List<Integer> matcher(LottoTicket lottoTicket) {
        List<Integer> matchCountList = new ArrayList<>();

        for (LottoGame game : lottoTicket.getLottoGames()) {
            matchCountList.add(doMatch(game));
        }

        return matchCountList;
    }

    private Integer doMatch(LottoGame game) {
        int count = 0;
        for (LottoNumber lottoNumber : game.getLottoNumbers()) {
            if(this.getNumber().contains(lottoNumber.getNumber())) count++;
        }
        return count;
    }

    private List<Integer> getNumber() {
        return winningNumbers.stream()
                .map(WinningNumber::getNumber)
                .collect(Collectors.toList());
    }

    public Map<WinnerRank, Integer> check(List<Integer> matchNumberList) {
        Map<WinnerRank, Integer> rankList = new HashMap<>();
        for (Integer count : matchNumberList) {

            WinnerRank winnerRank = check(count);
            rankList.put(winnerRank, rankList.getOrDefault(winnerRank, 0) + 1);
        }
        return rankList;
    }
}
