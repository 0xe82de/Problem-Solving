package programmers.level1;

/**
 * PROGRAMMERS 12916 문자열 내 p와 y의 개수
 * Level 1
 * 문자열
 */

public class PROGRAMMERS_12916_1 {

    public static void main(String[] args) {
        // input
        String s = "pPoooyY";

        // logic
        boolean answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public boolean solution(String s) {
        boolean answer = true;

        answer = s.toLowerCase().chars().filter(word -> word == 'p').count() ==
                s.toLowerCase().chars().filter(word -> word == 'y').count();

        return answer;
    }
}
