package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 동전 0
 * S2
 * 그리디
 */

public class BOJ_11047_1 {

    static int coinCnt = 0;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1 <= N <= 10
        final int N = Integer.parseInt(st.nextToken());
        // 1 <= K <= 100,000,000 => 1억
        int K = Integer.parseInt(st.nextToken());

        int[] values = new int[N];
        for (int i = 0; i < N; ++i) {
            values[i] = Integer.parseInt(br.readLine());
        }

        int j = N - 1;
        while (K > 0) {
            if (K < values[j]) {
                --j;
            }
            else {
                coinCnt += (K / values[j]);
                K %= values[j];
                --j;
            }
        }

        // output
        bw.write(String.valueOf(coinCnt));

        // io close
        bw.close();
        br.close();
    }

}
