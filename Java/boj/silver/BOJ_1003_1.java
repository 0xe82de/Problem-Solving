package boj.silver;

import java.io.*;

/**
 * BOJ 1003 피보나치 함수
 * S3
 * DP
 */

public class BOJ_1003_1 {

    static final int N = 41;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][2];

        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < N; ++i) {
            for (int j = 0; j < 2; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
            }
        }

        while (T-- > 0) {
            int index = Integer.parseInt(br.readLine());
            sb.append(dp[index][0] + " " + dp[index][1] + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
