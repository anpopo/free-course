package free.course.baseball.util;

import free.course.baseball.exception.NotValidInputException;

public class ValidationUtil {

    public static String[] validateClientInputNum(String input) {
        input = input.trim();

        if(input.length() != 3) throw new NotValidInputException("옳지 않은 입력입니다.");

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotValidInputException("옳지 않은 입력입니다.");
        }

        String[] strArr = input.split("");
        if(strArr.length != 3) throw new NotValidInputException("옳지 않은 입력입니다.");

        return strArr;
    }
}
