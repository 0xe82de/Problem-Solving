package boj.silver;

import java.io.*;

/**
 * BOJ 2579 계단 오르기
 * S3
 * DP
 */

public class BOJ_2579_1 {

    /**
     * 1 <= N <= 300
     */
    static int N;

    static int[] point;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        point = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        int maxPoint = getMaxPoint();

        // output
        bw.write(String.valueOf(maxPoint));

        // io close
        bw.close();
        br.close();
    }

    static int getMaxPoint() {
        dp[1] = point[1];

        if (N >= 2) {
            dp[2] = point[1] + point[2];
            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3] + point[i - 1]) + point[i];
            }
        }

        return dp[N];
    }
}
