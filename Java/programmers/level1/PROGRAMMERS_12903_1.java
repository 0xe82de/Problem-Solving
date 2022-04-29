package programmers.level1;

/**
 * PROGRAMMERS 12903 가운데 글자 가져오기
 * Level 1
 * 문자열
 */

public class PROGRAMMERS_12903_1 {

    public static void main(String[] args) {
        // input
        String s = "qwer";

        // logic
        String answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(String s) {
        String answer = "";

        int length = s.length();
        int half = length / 2;

        answer = length % 2 != 0 ?
                s.substring(half, half + 1) :
                s.substring(half - 1, half + 1);

        return answer;
    }
}
