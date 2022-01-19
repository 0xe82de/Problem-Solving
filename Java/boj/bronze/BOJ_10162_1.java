package boj.bronze;

import java.io.*;

/**
 * BOJ 10162 전자레인지
 * B4
 * 수학, 구현, 그리디
 */

public class BOJ_10162_1 {

    static final int KIND = 3;
    static int[] secondValues = new int[] { 300, 60, 10 };

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int[] countSeconds = new int[KIND];

        int T = Integer.parseInt(br.readLine());
        int minSecondValue = secondValues[KIND - 1];

        while (T >= minSecondValue) {
            for (int i = 0; i < KIND; i++) {
                while (T >= secondValues[i]) {
                    T -= secondValues[i];
                    ++countSeconds[i];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (T > 0) {
            sb.append(-1);
        } else {
            for (int i = 0; i < KIND; i++) {
                sb.append(countSeconds[i] + " ");
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
