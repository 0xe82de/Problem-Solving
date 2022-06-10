package boj.silver;

import java.io.*;

/**
 * BOJ 2579 계단 오르기
 * S3
 * DP
 */

public class BOJ_2579_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 계단의 수
         */
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        int maxPoint = calc(values);

        // output
        bw.write("" +maxPoint);

        // io close
        bw.close();
        br.close();
    }

    static int calc(int[] values) {
        final int SIZE = values.length - 1;
        int[] dp = new int[SIZE + 1];

        dp[1] = values[1];
        if (SIZE > 1) {
            dp[2] = values[1] + values[2];
            for (int i = 3; i <= SIZE; i++) {
                dp[i] = Math.max(dp[i - 2], values[i - 1] + dp[i - 3]);
                dp[i] += values[i];
            }
        }

        return dp[SIZE];
    }
}
