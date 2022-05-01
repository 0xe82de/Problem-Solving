package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12910 나누어 떨어지는 숫자 배열
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12910_1 {

    public static void main(String[] args) {
        // input
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        // logic
        int[] answer = solution(arr, divisor);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        answer = Arrays.stream(arr)
                .filter(number -> number % divisor == 0)
                .sorted()
                .toArray();

        if (answer.length == 0) {
            answer = new int[]{-1};
        }

        return answer;
    }
}
