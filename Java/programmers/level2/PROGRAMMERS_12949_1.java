package programmers.level2;

import java.util.Arrays;

/**
 * PROGRAMMERS 12949 행렬의 곱셈
 * Level 2
 * 수학
 */

public class PROGRAMMERS_12949_1 {

    public static void main(String[] args) {
        // input
//        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
//        int[][] arr2 = {{3, 3}, {3, 3}};
        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        // logic
        int[][] answer = solution(arr1, arr2);

        // output
        System.out.println("answer = " + Arrays.deepToString(answer));
    }

    static public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        answer = getAnswer(arr1, arr2);

        return answer;
    }

    static int[][] getAnswer(int[][] arr1, int[][] arr2) {
        final int ROW_SIZE = arr1.length;
        final int COL_SIZE = arr2[0].length;
        final int MID_SIZE = arr1[0].length;

        int[][] answer = new int[ROW_SIZE][COL_SIZE];
        for (int r = 0; r < ROW_SIZE; r++) {
            for (int c = 0; c < COL_SIZE; c++) {
                for (int k = 0; k < MID_SIZE; k++) {
                    answer[r][c] += arr1[r][k] * arr2[k][c];
                }
            }
        }

        return answer;
    }
}
