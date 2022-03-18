package boj.bronze;

import java.io.*;

/**
 * BOJ 18108 1998년생인 내가 태국에서는 2541년생?!
 * B5
 * 구현, 사칙연산
 */

public class BOJ_18108_1 {

    static final int IMMORTALITY_YEAR = 543;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int y = Integer.parseInt(br.readLine());

        // output
        bw.write(String.valueOf(y - IMMORTALITY_YEAR));

        // io close
        bw.close();
        br.close();
    }
}
