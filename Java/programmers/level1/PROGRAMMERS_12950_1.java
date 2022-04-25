package programmers.level1;

import java.util.Arrays;

/**
 * PROGRAMMERS 12950 행렬의 덧셈
 * Level 1
 * 구현
 */

public class PROGRAMMERS_12950_1 {

    public static void main(String[] args) {
        // input
        int[][] arr1 = {
                {1, 2},
                {2, 3}
        };
        int[][] arr2 = {
                {3, 4},
                {5, 6}
        };

        // logic
        int[][] answer = solution(arr1, arr2);

        // output
        System.out.println("answer = " + Arrays.deepToString(answer));
    }

    static public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        int r = arr1.length;
        int c = arr1[0].length;
        answer = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
