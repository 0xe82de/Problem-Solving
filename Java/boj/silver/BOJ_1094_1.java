package boj.silver;

import java.io.*;

/**
 * BOJ 1094 막대기
 * S5
 * 수학, 비트마스킹
 */

public class BOJ_1094_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 1 <= X <= 644
         */
        int X = Integer.parseInt(br.readLine());

        // output
        bw.write("" + Integer.bitCount(X));

        // io close
        bw.close();
        br.close();
    }
}
