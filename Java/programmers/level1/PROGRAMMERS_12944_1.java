package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12944 평균 구하기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12944_1 {

    public static void main(String[] args) {
        // input
        int[] arr = {1, 2, 3, 4};

        // logic
        double answer = solution(arr);

        // output
        System.out.println("answer = " + answer);
    }

    static public double solution(int[] arr) {
        double answer = 0;

        answer = Arrays.stream(arr)
                .average()
                .getAsDouble();

        return answer;
    }
}
