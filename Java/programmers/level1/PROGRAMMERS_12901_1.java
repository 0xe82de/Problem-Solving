package programmers.level1;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * PROGRAMMERS 12901 2016년
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12901_1 {

    public static void main(String[] args) {
        // input
        int a = 5;
        int b = 24;

        // logic
        String answer = solution(a, b);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(int a, int b) {
        String answer = "";

        answer = LocalDate.of(2016, a, b)
                .getDayOfWeek()
                .getDisplayName(TextStyle.SHORT, Locale.US)
                .toUpperCase();

        return answer;
    }
}
