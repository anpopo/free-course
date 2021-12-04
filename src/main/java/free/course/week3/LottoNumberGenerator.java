package free.course.week3;

import java.util.*;

public class LottoNumberGenerator {

    public static final Random random = new Random();

    public static LottoNumber generateOneRandomNumber() {
        return new LottoNumber(generateNumber());
    }

    private static int generateNumber() {
        return random.nextInt(45) + 1;
    }

    public static List<LottoNumber> generateSixRandomNumber() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        while (lottoNumberList.size() < 6) {
            LottoNumber lottoNumber = generateOneRandomNumber();

            if(!lottoNumberList.contains(lottoNumber)) lottoNumberList.add(lottoNumber);

        }

        return lottoNumberList;
    }
}
