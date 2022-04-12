package boj.silver;

import java.io.*;

/**
 * BOJ 1463 1로 만들기
 * S3
 * DP
 */

public class BOJ_1463_3 {

    /**
     * 1 <= N <= 1,000,000
     */
    static int N;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1];
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3]);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2]);
            ++dp[i]; // 연산 횟수 증가
        }

        // output
        bw.write(String.valueOf(dp[N]));

        // io close
        bw.close();
        br.close();
    }
}
