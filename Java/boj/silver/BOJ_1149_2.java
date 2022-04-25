package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1149 RGB거리
 * S1
 * DP
 */

public class BOJ_1149_2 {

    /**
     * 집의 수
     * 2 <= N <= 1,000
     */
    static int N;

    static int[][] dp;

    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dp[i][R] = r + Math.min(dp[i - 1][G], dp[i - 1][B]);
            dp[i][G] = g + Math.min(dp[i - 1][R], dp[i - 1][B]);
            dp[i][B] = b + Math.min(dp[i - 1][R], dp[i - 1][G]);
        }

        int sum = Math.min(dp[N][R], Math.min(dp[N][G], dp[N][B]));

        // output
        bw.write(String.valueOf(sum));

        // io close
        bw.close();
        br.close();
    }
}
