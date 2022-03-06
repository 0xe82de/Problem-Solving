package programmers.level1;

import java.util.*;

/**
 * PROGRAMMERS 42840 모의고사
 * Level 1
 * 완전 탐색
 */

public class PROGRAMMERS_42840_1 {

    public static void main(String[] args) {
        // input
        int[] answers = {1, 3, 2, 4, 2};

        // logic
        int[] answer = {};
        final int SIZE_ANSWERS = answers.length;

        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        final int SIZE_PATTERNS = patterns.length;

        int[] count = new int[SIZE_PATTERNS];
        for (int i = 0; i < SIZE_PATTERNS; i++) {
            for (int j = 0, SIZE_PATTERN = patterns[i].length; j < SIZE_ANSWERS; j++) {
                if (answers[j] == patterns[i][j % SIZE_PATTERN]) {
                    ++count[i];
                }
            }
        }

        int max = 0;
        for (int i = 0; i < SIZE_PATTERNS; i++) {
            max = Math.max(max, count[i]);
        }

        List<Integer> answerList = new LinkedList<>();
        for (int i = 0; i < SIZE_PATTERNS; i++) {
            if (max == count[i]) answerList.add(i + 1);
        }

        answer = answerList.stream().mapToInt(i -> i).toArray();

        // output
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer));
    }
}
