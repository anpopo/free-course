package free.course.week1.baseball;

public class ValidationUtils {

    public static final int MAX_NUM = 9;
    public static final int MIN_NUM = 1;

    public static boolean validNumber(int num) {
        return num >= MIN_NUM && num <= MAX_NUM;
    }
}
