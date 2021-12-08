package free.course.week3;

public class LottoNumberGenerator {
    public static LottoNumber generateLottoNumber() {
        return new LottoNumber();
    }

    @Deprecated
    public static LottoNumber generateLottoNumber(int testNumber) {
        return new LottoNumber(testNumber);
    }
}
