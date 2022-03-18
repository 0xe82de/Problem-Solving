package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2480 주사위 세개
 * B4
 * 수학, 사칙연산
 */

public class BOJ_2480_1 {

    static final int SIZE = 3;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int[] dice = new int[SIZE];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < SIZE; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        if (dice[0] == dice[1] && dice[1] == dice[2]) {
            result = 10000 + dice[0] * 1000;
        } else if (dice[0] != dice[1] && dice[1] != dice[2] && dice[0] != dice[2]) {
            result = 100 * Math.max(dice[0], Math.max(dice[1], dice[2]));
        } else {
            result = 100;
            if (dice[0] == dice[1]) {
                result *= dice[0];
            } else if (dice[1] == dice[2]) {
                result *= dice[1];
            } else {
                result *= dice[0];
            }
            result += 1000;
        }

        // output
        bw.write(String.valueOf(result));

        // io close
        bw.close();
        br.close();
    }
}
