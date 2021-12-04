package free.course.week3;

import javax.management.BadAttributeValueExpException;
import java.util.*;

public class LottoNumberGenerator {

    public static final Random random = new Random();

    public static LottoNumber generateOneRandomNumber() {
        return new LottoNumber(generateNumber());
    }

    private static int generateNumber() {
        return random.nextInt(45) + 1;
    }

    public static List<LottoNumber> generateSixLottoNumber() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        while (lottoNumberList.size() < 6) {
            LottoNumber lottoNumber = generateOneRandomNumber();

            if(!lottoNumberList.contains(lottoNumber)) lottoNumberList.add(lottoNumber);

        }

        lottoNumberList.sort(Comparator.comparing(LottoNumber::getLottoNumber));

        return lottoNumberList;
    }

    public static LottoNumber generateOneNumberByString(String sourceString) {
        int number;
        try {
            number = Integer.parseInt(sourceString);
            if(numberIsNotInRange(number)) {
                throw new RuntimeException("Number is out of range");
            }

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't convert String to Integer");
        }
        return new LottoNumber(number);
    }

    private static boolean numberIsNotInRange(int number) {
        return number < 1 || number > 45;
    }

    public static List<LottoNumber> generateSixLottoNumbersByString(String sourceString) {

        StringTokenizer tokens = new StringTokenizer(sourceString, ", ");

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
            LottoNumber lottoNumber = generateOneNumberByString(tokens.nextToken());

            if(!lottoNumberList.contains(lottoNumber)) lottoNumberList.add(lottoNumber);

        }

        lottoNumberList.sort(Comparator.comparing(LottoNumber::getLottoNumber));

        if(lottoNumberList.size() < 6) throw new IllegalArgumentException("Check the input of numbers");

        return lottoNumberList;
    }
}
