package boj.silver;

import java.io.*;

/**
 * BOJ 10844
 * S1
 * DP
 */

public class BOJ_10844_1 {

    /**
     * 1 <= N <= 100
     */
    static int N;

    static long[][] dp;

    static int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        long count = compute();

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    static long compute() {
        dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        return result % mod;
    }
}
