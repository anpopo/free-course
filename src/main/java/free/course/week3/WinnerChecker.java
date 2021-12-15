package free.course.week3;

import java.nio.file.AccessDeniedException;
import java.util.*;
import java.util.stream.Collectors;

public class WinnerChecker {

    private static List<WinningNumber> winningNumbers;

    private Float ratio;

    public static WinnerChecker createWinnerChecker(String source) {
        WinnerChecker winnerChecker = new WinnerChecker();
        winnerChecker.setWinningNumber(WinningNumberGenerator.winningNumberGenerate(source));
        return winnerChecker;
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
        int totalGameMoney = matchNumberList.size() * LottoTicketSeller.LOTTO_GAME_COST;
        int totalPrice = 0;
        for (Integer count : matchNumberList) {
            WinnerRank winnerRank = check(count);
            totalPrice += winnerRank.getPrice();
            rankList.put(winnerRank, rankList.getOrDefault(winnerRank, 0) + 1);
        }

        setRatio(totalPrice, totalGameMoney);

        return rankList;
    }

    private void setRatio(int totalPrice, int totalGameMoney) {
        ratio = (float)totalPrice / totalGameMoney;
    }

    public Float getRatio() {
        if(!winningNumbers.isEmpty() && Objects.nonNull(ratio)) return ratio;
        throw new RuntimeException("접근 불가");
    }

}
