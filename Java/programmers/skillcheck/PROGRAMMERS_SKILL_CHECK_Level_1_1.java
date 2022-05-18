package programmers.skillcheck;

import java.util.Arrays;

/**
 * PROGRAMMERS SKILL CHECK Level 1 1번 문제
 * 문자열
 */

public class PROGRAMMERS_SKILL_CHECK_Level_1_1 {

    public static void main(String[] args) {
        // input
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        // logic
        String[] answer = solution(strings, n);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public String[] solution(String[] strings, int n) {
        String[] answer = {};

        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) != o2.charAt(n)) {
                return Character.compare(o1.charAt(n), o2.charAt(n));
            } else {
                return o1.compareTo(o2);
            }
        });
        answer = strings;

        return answer;
    }
}
