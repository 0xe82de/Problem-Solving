package programmers.level2;

/**
 * PROGRAMMERS 12913 땅따먹기
 * Level 2
 * DP
 */

public class PROGRAMMERS_12913_1 {

    public static void main(String[] args) {
        // input
        int[][] land = {
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        };

        // logic
        int answer = solution(land);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[][] land) {
        int answer = 0;

        final int SIZE = land.length;
        int[][] dp = new int[SIZE][4];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < SIZE; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[SIZE - 1][i]);
        }

        return answer;
    }
}
