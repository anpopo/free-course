package free.course.week3;

import java.util.*;

public class LottoNumberGenerator {

    public static final Random random = new Random();

    private static int generateNumber() {
        return random.nextInt(45) + 1;
    }

    public static LottoNumber generateOneRandomNumber() {
        return new LottoNumber(generateNumber());
    }

    public static List<LottoNumber> generateSixLottoNumber() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        while (lottoNumberList.size() < 6) {
            LottoNumber lottoNumber = generateOneRandomNumber();
            checkAndAddLottoNumber(lottoNumber, lottoNumberList);
        }

        sortListAsc(lottoNumberList);

        return lottoNumberList;
    }

    public static LottoNumber generateOneNumberByString(String sourceString) {
        int number;
        try {
            number = parsingStringToInt(sourceString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't convert String to Integer");
        }
        return new LottoNumber(number);
    }

    public static List<LottoNumber> generateSixLottoNumbersByString(String sourceString) {

        StringTokenizer tokens = new StringTokenizer(sourceString, ", ");
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        while (tokens.hasMoreTokens()) {
            LottoNumber lottoNumber = generateOneNumberByString(tokens.nextToken());
            checkAndAddLottoNumber(lottoNumber, lottoNumberList);
        }

        sortListAsc(lottoNumberList);

        if(lottoNumberList.size() < 6) throw new IllegalArgumentException("Check the input of numbers");

        return lottoNumberList;
    }

    private static void sortListAsc(List<LottoNumber> lottoNumberList) {
        lottoNumberList.sort(Comparator.comparing(LottoNumber::getLottoNumber));
    }

    private static void checkAndAddLottoNumber(LottoNumber lottoNumber, List<LottoNumber> lottoNumberList) {
        if(!lottoNumberList.contains(lottoNumber)) lottoNumberList.add(lottoNumber);
    }

    private static int parsingStringToInt(String sourceString) {
        int number;
        number = Integer.parseInt(sourceString);
        if(numberIsNotInRange(number)) {
            throw new RuntimeException("Number is out of range");
        }
        return number;
    }

    private static boolean numberIsNotInRange(int number) {
        return number < 1 || number > 45;
    }
}
