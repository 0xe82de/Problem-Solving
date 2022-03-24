package boj.silver;

import java.io.*;

/**
 * BOJ 2156 포도주 시식
 * S1
 * Dp
 */

public class BOJ_2156_1 {

    /**
     * 포도주 잔의 개수
     * 1 <= n <= 10,000
     */
    static int n;

    static int[] wine;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        n = Integer.parseInt(br.readLine());
        wine = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int max = compute();

        // output
        bw.write(String.valueOf(max));

        // io close
        bw.close();
        br.close();
    }

    static int compute() {
        dp[1] = wine[1];

        if (n >= 2) {
            dp[2] = wine[1] + wine[2];
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
            }
        }

        return dp[n];
    }
}
