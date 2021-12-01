package boj.bronze;

import java.io.*;

/**
 * BOJ 2743 단어 길이 재기
 * B2
 * 구현, 문자열
 */

public class BOJ_2743_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        // output
        bw.write(String.valueOf(br.readLine().length()));

        // io close
        bw.close();
        br.close();
    }
}
