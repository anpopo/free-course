package free.course.week3;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket() {
        lottoNumbers = new ArrayList<>();

        while(lottoNumbers.size() < 6) {
            LottoNumber lottoNumber = LottoNumberGenerator.generateLottoNumber();
            lottoNumberDuplicateChecker(lottoNumber);
        }
    }

    private void lottoNumberDuplicateChecker(LottoNumber lottoNumber) {
        if(!lottoNumbers.contains(lottoNumber)) lottoNumbers.add(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
