package programmers.skillcheck;

import java.util.Arrays;

/**
 * PROGRAMMERS SKILL CHECK Level 1 2번 문제
 * 정렬
 */

public class PROGRAMMERS_SKILL_CHECK_Level_1_2 {

    public static void main(String[] args) {
        // input
        int[] numbers = {1,2,3,4,6,7,8,0};

        // logic
        int answer = solution(numbers);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] numbers) {
        int answer = -1;

        Arrays.sort(numbers);
        answer = 45;
        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }
}
