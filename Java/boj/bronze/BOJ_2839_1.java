package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2839 설탕 배달
 * B1
 * 수학, DP, 그리디
 */

public class BOJ_2839_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = Integer.parseInt(br.readLine());
        int[] dp = new int[5000 + 1];
        dp[3] = dp[5] = 1;

        for (int i = 6; i <= N; ++i) {
            // i - 3 지점이 0이면 나눌 수 없다.
            if (dp[i - 3] > 0) dp[i] = dp[i - 3] + 1;
            // i - 5 지점이 0보다 크면 나눌 수는 있다.
            if (dp[i - 5] > 0) {
                // i - 3 지점이 0이 아니면 3으로 한 번 체크를 했으므로 최소값을 저장한다.
                if (dp[i - 3] != 0) dp[i] = Math.min(dp[i], dp[i - 5] + 1);
                // i - 3 지점이 0이면 i - 5 지점에서 1을 증가시킨다.
                else dp[i] = dp[i - 5] + 1;
            }
        }
        if (dp[N] == 0) dp[N] = -1;

        // output
        bw.write(String.valueOf(dp[N]));

        // io close
        bw.close();
        br.close();
    }

}
