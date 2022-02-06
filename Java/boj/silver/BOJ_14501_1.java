package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 14501 퇴사
 * S3
 * DP, 브루트포스
 */

public class BOJ_14501_1 {

    /**
     * 1 <= N <= 15
     */
    static int N;

    /**
     * 1 <= T <= 5
     * 1 <= P <= 1,000
     */
    static int[][] TP;
    static final int T = 0;
    static final int P = 1;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        TP = new int[N][2];
        dp = new int[N + 1];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            TP[i][T] = Integer.parseInt(st.nextToken());
            TP[i][P] = Integer.parseInt(st.nextToken());
        }

        int maxPrice = getMaxPrice();

        // output
        bw.write(String.valueOf(maxPrice));

        // io close
        bw.close();
        br.close();
    }

    private static int getMaxPrice() {
        for (int i = 0; i < N; i++) {
            if (i + TP[i][T] <= N) {
                dp[i + TP[i][T]] = Math.max(dp[i + TP[i][T]], dp[i] + TP[i][P]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        return dp[N];
    }

}
