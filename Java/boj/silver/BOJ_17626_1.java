package boj.silver;

import java.io.*;

/**
 * BOJ 17626 Four Squares
 * S4
 * DP, 브루트포스
 */

public class BOJ_17626_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int n = Integer.parseInt(br.readLine());
        int[] dp = result(n);

        // output
        bw.write("" + dp[n]);

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
