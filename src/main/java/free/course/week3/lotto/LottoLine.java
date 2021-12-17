package free.course.week3.lotto;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoLine {

    private Set<LottoNumber> lottoNumbers;

    private LottoLine () {}

    private LottoLine(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoLine generateLottoLine() {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();

        do lottoNumbers.add(LottoNumber.create());
        while(lottoNumbers.size() < 6);

        return new LottoLine(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new LinkedHashSet<>(this.lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoLine {" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
