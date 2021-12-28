package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11051 이항 계수 2
 * S1
 * 수학, DP, 조합론
 */

public class BOJ_11051_1 {

    static final int MOD = 10007;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1 <= N <= 1,000
        final int N = Integer.parseInt(st.nextToken());
        // 0 <= K <= N
        final int K = Integer.parseInt(st.nextToken());

        int result = 0;
        if (N == K || K == 0) {
            result = 1;
        }
        else {
            dp = new int[N + 1][K + 1];
            result = (BC(N - 1, K - 1) + BC(N - 1, K)) % MOD;
        }

        // output
        bw.write(String.valueOf(result));

        // io close
        bw.close();
        br.close();
    }

    private static int BC(int n, int r) {
        // 메모이제이션
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        // 파스칼의 삼각형
        return dp[n][r] = (BC(n - 1, r - 1) + BC(n - 1, r)) % MOD;
    }

}
