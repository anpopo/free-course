package free.course.week3;

import java.util.List;

public class LottoTicket {

    private static List<LottoNumber> lottoNumbers;

    private LottoTicket() {}

    public static LottoTicket generateLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.setLottoNumbers(LottoNumberGenerator.generateSixLottoNumber());
        return lottoTicket;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void setLottoNumbers(List<LottoNumber> lottoNumbers) {
        LottoTicket.lottoNumbers = lottoNumbers;
    }
}
