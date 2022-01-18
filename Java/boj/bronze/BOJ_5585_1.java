package boj.bronze;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ 5586 거스름돈
 * B2
 * 그리디
 */

public class BOJ_5585_1 {

    static int[] kind = new int[] {500, 100, 50, 10, 5, 1};
    static int SIZE = kind.length;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int money = 1000 - Integer.parseInt(br.readLine());

        int[] cntKind = new int[6];
        while (money > 0) {
            for (int i = 0; i < SIZE; i++) {
                while (money / kind[i] > 0) {
                    money -= kind[i];
                    ++cntKind[i];
                }
            }
        }

        int count = Arrays.stream(cntKind).sum();

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

}
