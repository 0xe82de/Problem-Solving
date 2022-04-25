package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12954 x만큼 간격이 있는 n개의 숫자
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12954_1 {

    public static void main(String[] args) {
        // input
        int x = 2;
        int n = 5;

        // logic
        long[] answer = solution(x, n);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public long[] solution(int x, int n) {
        long[] answer = {};

        answer = new long[n];
        answer[0] = x;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;
    }
}
