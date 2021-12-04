package free.course.week3;

import java.util.List;

public class WinningNumbers {

    private List<LottoNumber> winningNumbers;

    private WinningNumbers() {
    }

    public static WinningNumbers generateWinningNumbers(String sourceString) {
        WinningNumbers winningNumbers = new WinningNumbers();
        winningNumbers.setWinningNumbers(LottoNumberGenerator.generateSixLottoNumbersByString(sourceString));

        return winningNumbers;
    }

    private void setWinningNumbers(List<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
