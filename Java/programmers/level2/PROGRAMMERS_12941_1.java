package programmers.level2;

import java.util.Arrays;

/**
 * PROGRAMMERS 12941 최솟값 만들기
 * Level 2
 * 구현
 */

public class PROGRAMMERS_12941_1 {

    public static void main(String[] args) {
        // input
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        // logic
        long answer = solution(A, B);

        // output
        System.out.println("answer = " + answer);
    }

    static public long solution(int[] A, int[] B) {
        int answer = 0;

        final int SIZE = A.length;

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < SIZE; i++) {
            answer += A[i] * B[SIZE - i - 1];
        }

        return answer;
    }
}
