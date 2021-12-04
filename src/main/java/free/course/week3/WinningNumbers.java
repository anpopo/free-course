package free.course.week3;

import java.util.List;
import java.util.Map;

public class WinningNumbers {

    private List<LottoNumber> winningNumbers;

    private int match;

    private WinningNumbers() {}

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

    public int check(LottoTicket lottoTicket) {
        lottoTicket.getLottoNumbers().forEach(lottoNumber -> {
            if(winningNumbers.contains(lottoNumber)) match++;
        });
        return match;
    }
}
