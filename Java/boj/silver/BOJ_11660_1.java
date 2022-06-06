package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11660 구간 합 구하기 5
 * S1
 * DP, 누적 합
 */

public class BOJ_11660_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /**
         * 표의 크기 N
         * 1 <= N <= 1,024
         */
        int N = Integer.parseInt(st.nextToken());

        /**
         * 합을 구해야 하는 횟수 M
         * 1 <= M <= 100,000
         */
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken()) + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
            sb.append(sum).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
