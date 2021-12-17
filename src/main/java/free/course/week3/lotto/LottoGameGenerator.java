package free.course.week3.lotto;

public class LottoGameGenerator implements Generator<LottoGame> {

    LottoGameGenerator() {}

    @Override
    public LottoGame generate() {
        return LottoGame.create();
    }
}
