package free.course.week3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int ZERO_VALUE = 0;

    public static int splitAndSum(String source) {
        if(source == null || source.isEmpty()) return ZERO_VALUE;

        Matcher m = Pattern.compile("^//(.)\n(.*)$").matcher(source);

        int sum = 0;
        String[] tokens;

        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens= m.group(2).split(customDelimiter);
        } else {
            tokens = source.split("[,:]");
        }

        for (String s : tokens) {
            int token = Integer.parseInt(s);
            if(token < 0) throw new RuntimeException("음수는 가질 수 없습니다.");
            sum += token;
        }

        return sum;
    }


}
