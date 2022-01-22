package boj.gold;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ 1339 단어 수학
 * G4
 * 그리디, 브루트포스
 */

public class BOJ_1339_1 {

    static final int SIZE = 26;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        // 1 <= N <= 10
        int[][] wordAndCount = new int[SIZE][2];
        final int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            char[] input = br.readLine().toCharArray();
            for (int i = 0, MAX_LEN = input.length; i < MAX_LEN; i++) {
                wordAndCount[input[i] - 'A'][1] += Math.pow(10, MAX_LEN - i - 1);
            }
        }

        Arrays.sort(wordAndCount, (w1, w2) -> w2[1] - w1[1]);

        int sum = 0;
        int number = 9;
        for (int i = 0; i < SIZE; i++) {
            if (wordAndCount[i][1] == 0) break;
            sum += wordAndCount[i][1] * number--;
        }

        // output
        bw.write(String.valueOf(sum));

        // io close
        bw.close();
        br.close();
    }

}
