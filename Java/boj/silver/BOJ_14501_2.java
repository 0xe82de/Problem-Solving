package boj.silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 14501 퇴사
 * S3
 * DP, 브루트포스
 */

public class BOJ_14501_2 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = parseInt.applyAsInt(br.readLine());
        int[][] TP = new int[N][2];
        int[] dp = new int[N];

        final int T = 0;
        final int P = 1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            TP[i][T] = parseInt.applyAsInt(st.nextToken());
            ;
            TP[i][P] = parseInt.applyAsInt(st.nextToken());
            ;
            dp[i] = TP[i][P];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int period = i - j;
                if (period >= TP[j][T]) {
                    dp[i] = Math.max(TP[i][P] + dp[j], dp[i]);
                }
            }
        }

        int maxProfit = 0;
        for (int i = 0; i < N; i++) {
            if (i + TP[i][T] <= N) {
                maxProfit = Math.max(maxProfit, dp[i]);
            }
        }

        // output
        bw.write(maxProfit + "");

        // io close
        bw.close();
        br.close();
    }
}
