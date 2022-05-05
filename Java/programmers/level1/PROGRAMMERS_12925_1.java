package programmers.level1;

/**
 * PROGRAMMERS 12925 문자열을 정수로 바꾸기
 * Level 1
 * 문자열
 */

public class PROGRAMMERS_12925_1 {

    public static void main(String[] args) {
        // input
        String s = "-1234";

        // logic
        int answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(String s) {
        int answer = 0;

        answer = Integer.parseInt(s);

        return answer;
    }
}
