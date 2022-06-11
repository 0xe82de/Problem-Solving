package boj.silver;

import java.io.*;

/**
 * BOJ 2156 포도주 시식
 * S1
 * DP
 */

public class BOJ_2156_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 포도주 잔의 개수
         * 1 <= n <= 10,000
         */
        int n = Integer.parseInt(br.readLine());
        int[] amounts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            amounts[i] = Integer.parseInt(br.readLine());
        }

        int maxAmount = calc(amounts);

        // output
        bw.write("" + maxAmount);

        // io close
        bw.close();
        br.close();
    }

    static int calc(int[] amounts) {
        final int SIZE = amounts.length - 1;
        int[] dp = new int[SIZE + 1];

        dp[1] = amounts[1];
        if (SIZE > 1) {
            dp[2] = amounts[1] + amounts[2];
            for (int i = 3; i <= SIZE; i++) {
                dp[i] += amounts[i];
                dp[i] += Math.max(dp[i - 2], dp[i - 3] + amounts[i - 1]);
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
        }

        return dp[SIZE];
    }
}
