package free.course.week3.lotto;

import java.util.Random;

public class LottoNumber extends Number {

    private LottoNumber() {}

    public static LottoNumber create() {
        LottoNumber lottoNumber = new LottoNumber();
        return lottoNumber.generateNumber();
    }

    @Override
    LottoNumber generateNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(45) + 1;

        this.setNumber(randomNumber);
        return this;
    }
}
