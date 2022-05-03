package programmers.level1;

/**
 * PROGRAMMERS 12918 문자열 다루기 기본
 * Level 1
 * 문자열
 */

public class PROGRAMMERS_12918_1 {

    public static void main(String[] args) {
        // input
        String s = "1234";

        // logic
        boolean answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public boolean solution(String s) {
        boolean answer = true;

        int length = s.length();
        if (length != 4 && length != 6) {
            answer = false;
        } else {
            for (char c : s.toCharArray()) {
                if (!('0' <= c && c <= '9')) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
