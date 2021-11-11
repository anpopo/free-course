package free.course.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CarUtils {


    public static List<String> separateCarNamesWithComma(String carNames) {
        return Arrays.stream(carNames.split(","))
                .filter(CarUtils::carNameValid)
                .collect(Collectors.toList());
    }

    public static boolean carNameValid(String carName) {
        return !"".equals(carName.trim()) && carName.trim().length() <= 5;
    }
}
