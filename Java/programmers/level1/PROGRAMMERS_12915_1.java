package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12915 문자열 내 마음대로 정렬하기
 * Level 1
 * 정렬
 */

public class PROGRAMMERS_12915_1 {

    public static void main(String[] args) {
        // input
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        // logic
        String[] answer = solution(strings, n);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public String[] solution(String[] strings, int n) {
        String[] answer = {};

        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            } else {
                return Character.compare(o1.charAt(n), o2.charAt(n));
            }
        });
        answer = strings;

        return answer;
    }
}
