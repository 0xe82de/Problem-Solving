package boj.bronze;

import java.io.*;

/**
 * BOJ 18406 럭키 스트레이트
 * B2
 * 구현, 문자열
 */

public class BOJ_18406_1 {

    /**
     * 10 <= N <= 99,999,999
     */
    static String N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = br.readLine();
        String output = possible(N) ? "LUCKY" : "READY";

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }

    static boolean possible(String N) {
        final int SIZE = N.length();
        String left = N.substring(0, SIZE / 2);
        String right = N.substring(SIZE / 2);
        return left.chars().map(i -> i - '0').sum() == right.chars().map(i -> i - '0').sum();
    }
}
