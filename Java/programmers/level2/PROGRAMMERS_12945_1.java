package programmers.level2;

/**
 * PROGRAMMERS 12945 피보나치 수
 * Level 2
 * DP
 */

public class PROGRAMMERS_12945_1 {

    public static void main(String[] args) {
        // input
        int n = 5;

        // logic
        int answer = solution(n);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n) {
        int answer = 0;

        answer = getAnswer(n);

        return answer;
    }

    static int getAnswer(int n) {
        final int divide = 1234567;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % divide;
        }

        return dp[n];
    }
}
