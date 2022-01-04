package free.course.racing.util;

import free.course.racing.exception.InvalidNameException;
import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public class RacingCarValidationUtil {

    public static String isValidName (String racingCarName) {
        racingCarName = racingCarName.trim();
        if(racingCarName.length() > 5) throw new InvalidNameException(racingCarName + " is Too LONG!!");
        if(!StringUtils.hasText(racingCarName)) throw new InvalidNameException(racingCarName + " is Too SHORT!!");
        if (!Pattern.matches("^[a-zA-Z가-힣0-9]*$", racingCarName)) throw new InvalidNameException(racingCarName + " is Not Matched!!");
        return racingCarName;
    }
}
