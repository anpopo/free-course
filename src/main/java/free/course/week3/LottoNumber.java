package free.course.week3;

public class LottoNumber {

    private final int lottoNumber;
    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object obj) {
        return this.lottoNumber == ((LottoNumber) obj).getLottoNumber();
    }
}
