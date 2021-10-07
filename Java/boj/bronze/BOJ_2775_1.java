package boj.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2775 부녀회장이 될테야
 * B2
 * 수학
 */

public class BOJ_2775_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        int k , n;
        int[][] apart;
        for (int tc = 1; tc <= TC; ++tc) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            apart = new int[k + 1][n];
            for (int i = 0; i < n; ++i) {
                apart[0][i] = i + 1;
            }

            for (int i = 1; i <= k; ++i) {
                apart[i][0] = 1;
                for (int j = 1; j < n; ++j) {
                    apart[i][j] = apart[i][j - 1] + apart[i - 1][j];
                }
            }

            sb.append(apart[k][n - 1] + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
