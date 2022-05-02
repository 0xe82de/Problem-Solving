package programmers.level1;

import java.util.stream.LongStream;

/**
 * PROGRAMMERS 12912 두 정수 사이의 합
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12912_1 {

    public static void main(String[] args) {
        // input
        int a = 3;
        int b = 5;

        // logic
        long answer = solution(a, b);

        // output
        System.out.println("answer = " + answer);
    }

    static public long solution(int a, int b) {
        long answer = 0;

        answer = LongStream
                .range(Math.min(a, b), Math.max(a, b) + 1)
                .sum();

        return answer;
    }
}
