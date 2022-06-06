package boj.silver;

import java.io.*;

/**
 * BOJ 1699 제곱수의 합
 * S2
 * 수학, DP
 */

public class BOJ_1699_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 자연수 N
         * 1 <= N <= 100,000
         */
        int N = Integer.parseInt(br.readLine());
        int[] dp = result(N);

        // output
        bw.write("" + dp[N]);

        // io close
        bw.close();
        br.close();
    }

    static int[] result(int n) {
        int[] dp = new int[n + 1];

        for (int number = 1; number <= n; number++) {
            dp[number] = Integer.MAX_VALUE;
            int sqrt = (int) Math.sqrt(number);

            for (int i = 1; i <= sqrt; i++) {
                int compare = number - i * i;
                dp[number] = Math.min(dp[number], dp[compare]);
            }

            ++dp[number];
        }

        return dp;
    }
}
