package boj.bronze;

import java.io.*;

/**
 * BOJ 10808 알파벳 개수
 * B2
 * 구현, 문자열
 */

public class BOJ_10808_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];

        String S = br.readLine();
        for (int i = 0; i < S.length(); ++i) {
            ++count[S.charAt(i) - 'a'];
        }

        for (int cnt : count) {
            sb.append(cnt + " ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
