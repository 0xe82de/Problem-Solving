package boj.silver;

import java.io.*;

/**
 * BOJ 9461 파도반 수열
 * S3
 * 수학, DP
 */

public class BOJ_9461_1 {

    static final int MAX_SIZE = 100;

    static long[] dp;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        dp = new long[MAX_SIZE + 1];
        compute();

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static void compute() {
        dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i <= MAX_SIZE; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
    }
}
