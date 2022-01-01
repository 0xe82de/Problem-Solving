package boj.bronze;

import java.io.*;

/**
 * BOJ 2523 별 찍기 - 13
 * B3
 * 구현
 */

public class BOJ_2523_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // logic
        final int N = Integer.parseInt(br.readLine());
        final int CNT = N * 2;

        for (int i = 1; i < CNT; ++i) {
            if (i <= N) {
                for (int j = 0; j < i; ++j) {
                    System.out.print("*");
                }
            }
            else {
                for (int j = 0; j < CNT - i; ++j) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        // io close
        br.close();
    }

}
