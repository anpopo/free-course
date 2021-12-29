package free.course.baseball.util;

import free.course.baseball.exception.NotValidInputException;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static final String NOT_VALID_INPUT_MESSAGE = "옳지 않은 입력입니다.";

    public static String[] validateClientInputNum(String input) {
        input = trimMachine(input);

        if(input.length() != 3) throw new NotValidInputException(NOT_VALID_INPUT_MESSAGE);

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotValidInputException(NOT_VALID_INPUT_MESSAGE);
        }

        String[] strArr = input.split("");
        if(strArr.length != 3) throw new NotValidInputException(NOT_VALID_INPUT_MESSAGE);

        return strArr;
    }

    public static boolean validateClientReplay(String input) {
        input = trimMachine(input);
        return Pattern.matches("^1$", input);
    }

    private static String trimMachine (String source) {
        return source.trim();
    }
}
