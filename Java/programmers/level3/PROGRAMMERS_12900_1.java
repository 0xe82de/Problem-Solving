package programmers.level3;

/**
 * PROGRAMMERS 12900 2 x n 타일링
 * Level 3
 * DP
 */

public class PROGRAMMERS_12900_1 {

    public static void main(String[] args) {
        // input
        int n = 4;

        // logic
        int answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n) {
        int answer = 0;

        final int DIVIDE = 1000000007;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIVIDE;
        }

        answer = dp[n];

        return answer;
    }
}
