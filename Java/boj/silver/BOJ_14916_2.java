package boj.silver;

import java.io.*;

/**
 * BOJ 14916 거스름돈
 * S5
 * 수학, DP, 그리디
 */

public class BOJ_14916_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int money = 2; money <= n; money++) {
            if (money % 2 == 0) {
                dp[money] = money / 2;
            }

            if (money >= 5) {
                if (money % 5 == 0) {
                    dp[money] = money / 5;
                } else if (dp[money - 5] > 0) {
                    dp[money] = dp[money - 5] + 1;
                }
            }
        }

        // output
        bw.write((dp[n] == 0 ? -1 : dp[n]) + "");

        // io close
        bw.close();
        br.close();
    }
}
