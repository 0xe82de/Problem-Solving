package programmers.level2;

/**
 * PROGRAMMERS 62048 멀쩡한 사각형
 * Level 2
 * 수학
 */

public class PROGRAMMERS_62048_2 {

    public static void main(String[] args) {
        // input
        int w = 8;
        int h = 12;
        long result = 80L;

        // logic
        long answer = solution(w, h);

        // output
        System.out.println((result == answer) + "\t answer = " + answer);
    }

    static public long solution(int w, int h) {
        long answer = 0;

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
