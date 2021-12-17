package free.course.week3.lotto;

import java.util.LinkedHashSet;
import java.util.Set;

public class LottoGame {

    private Set<LottoNumber> lottoNumbers;

    private LottoGame () {}

    private LottoGame(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoGame create() {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();

        do lottoNumbers.add(LottoNumber.create());
        while(lottoNumbers.size() < 6);

        return new LottoGame(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
