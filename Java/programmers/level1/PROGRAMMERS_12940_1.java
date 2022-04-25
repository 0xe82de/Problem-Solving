package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12940 최대공약수와 최소공배수
 * Level 1
 * 수학
 */

public class PROGRAMMERS_12940_1 {

    public static void main(String[] args) {
        // input
        int n = 3;
        int m = 12;

        // logic
        int[] answer = solution(n, m);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int n, int m) {
        int[] answer = {};

        answer = new int[] {gcd(n, m), lcm(n, m)};

        return answer;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
