package programmers.level2;

/**
 * PROGRAMMERS 12905 가장 큰 정사각형 찾기
 * Level 2
 * DP
 */

public class PROGRAMMERS_12905_1 {

    public static void main(String[] args) {
        // input
        int[][][] board = {
                {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}},
                {{0, 0, 1, 1}, {1, 1, 1, 1}}
        };
        int[] result = {9, 4};

        for (int i = 0; i < result.length; i++) {
            // logic
            int answer = solution(board[i]);

            // output
            System.out.println((result[i] == answer) + "\t answer = " + answer);
        }
    }

    static public int solution(int[][] board) {
        int answer = 0;

        answer = getAnswer(board);

        return answer;
    }

    static int getAnswer(int[][] board) {
        int size = getMaxSquareSize(board);
        return (int) Math.pow(size, 2);
    }

    static int getMaxSquareSize(int[][] board) {
        final int ROW_SIZE = board.length;
        final int COL_SIZE = board[0].length;
        int[][] dp = new int[ROW_SIZE + 1][COL_SIZE + 1];
        int size = 0;

        for (int r = 0; r < ROW_SIZE; r++) {
            for (int c = 0; c < COL_SIZE; c++) {
                dp[r + 1][c + 1] = board[r][c];
            }
        }

        for (int r = 1; r <= ROW_SIZE; r++) {
            for (int c = 1; c <= COL_SIZE; c++) {
                if (dp[r][c] != 0) {
                    dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
                    size = Math.max(size, dp[r][c]);
                }
            }
        }

        return size;
    }
}
