package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 86051 없는 숫자 더하기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_86051_1 {

    public static void main(String[] args) {
        // input
        int[] numbers = {1,2,3,4,6,7,8,0};

        // logic
        int answer = solution(numbers);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] numbers) {
        int answer = 0;

        answer = 45 - Arrays.stream(numbers).sum();

        return answer;
    }
}
