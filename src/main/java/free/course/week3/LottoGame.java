package free.course.week3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGame {

    private final List<LottoNumber> lottoNumbers;

    public LottoGame() {
        lottoNumbers = new ArrayList<>();

        while(lottoNumbers.size() < 6) {
            LottoNumber lottoNumber = LottoNumberGenerator.generateLottoNumber();
            lottoNumberDuplicateChecker(lottoNumber);
        }

        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
    }

    private void lottoNumberDuplicateChecker(LottoNumber lottoNumber) {
        if(!lottoNumbers.contains(lottoNumber)) lottoNumbers.add(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        this.lottoNumbers.forEach(lottoNumber -> sb.append(lottoNumber.getNumber()).append(", "));
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
