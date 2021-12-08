package free.course.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumberGenerator {
    public static List<WinningNumber> winningNumberGenerate(String strSource) {
        List<WinningNumber> winningNumbers = new ArrayList<>();

        Arrays.stream(strSource.split(", "))
                .forEach(str -> {
                    WinningNumber winningNumber = new WinningNumber(converterStringToInt(str));

                    if(winningNumbers.contains(winningNumber))
                        throw new RuntimeException("not a valid number! please check the numbers");

                    winningNumbers.add(winningNumber);
                });
        return winningNumbers;
    }

    private static int converterStringToInt(String strSource) {
        try {
            return Integer.parseInt(strSource);
        } catch (Exception e){
            throw new RuntimeException("not a proper string source");
        }
    }
}
