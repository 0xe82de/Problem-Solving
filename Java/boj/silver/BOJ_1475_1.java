package boj.silver;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ 1475 방 번호
 * S5
 * 구현
 */

public class BOJ_1475_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[10];
        while (N > 0) {
            int number = N % 10;
            if (number == 6 || number == 9) {
                if (count[6] <= count[9]) {
                    ++count[6];
                } else {
                    ++count[9];
                }
            } else {
                ++count[number];
            }

            N /= 10;
        }

        // output
        bw.write(String.valueOf(Arrays.stream(count).max().getAsInt()));

        // io close
        bw.close();
        br.close();
    }

}
