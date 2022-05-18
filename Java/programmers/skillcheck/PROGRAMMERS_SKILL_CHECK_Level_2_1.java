package programmers.skillcheck;

/**
 * PROGRAMMERS SKILL CEHCK Level 2 1번 문제
 * 수학
 */

public class PROGRAMMERS_SKILL_CHECK_Level_2_1 {

    public static void main(String[] args) {
        // input
        int w = 8;
        int h = 12;

        // logic
        long answer = solution(w, h);

        // output
        System.out.println("answer = " + answer);
    }

    static public long solution(int w, int h) {
        long answer = 1;

        answer = getAnswer(w, h);

        return answer;
    }

    static long getAnswer(int w, int h) {
        return ((long) w * h) - (w + h - gcd(w, h));
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
