package boj.silver;

import java.io.*;

/**
 * BOJ 1904 01타일
 * S3
 * DP
 */

public class BOJ_1904_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        // output
        bw.write(String.valueOf(dp[N]));

        // io close
        bw.close();
        br.close();
    }
}
