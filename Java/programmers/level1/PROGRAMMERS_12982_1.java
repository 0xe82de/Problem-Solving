package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12982 예산
 * Level 1
 * 정렬
 */

public class PROGRAMMERS_12982_1 {

    public static void main(String[] args) {
        // input
        int[][] d = {
                {1,3,2,5,4},
                {2,2,3,3}
        };
        int[] budget = {9, 10};
        int[] result = {3, 4};

        for (int i = 0; i < 2; i++) {
            // logic
            int answer = solution(d[i], budget[i]);

            // output
            System.out.println((result[i] == answer) + "\t answer = " + answer);
        }
    }

    static public int solution(int[] d, int budget) {
        int answer = 0;

        answer = getAnswer(d, budget);

        return answer;
    }

    static int getAnswer(int[] d, int budget) {
        int count = 0;
        
        Arrays.sort(d);
        for (int amount : d) {
            budget -= amount;
            if (budget < 0) break;
            ++count;
        }

        return count;
    }
}
