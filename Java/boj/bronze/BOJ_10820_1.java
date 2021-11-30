package boj.bronze;

import java.io.*;

/**
 * BOJ 10820 문자열 분석
 * B2
 * 구현, 문자열
 */

public class BOJ_10820_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        /**
         * 0 : 소문자 개수
         * 1 : 대문자 개수
         * 2 : 숫자 개수
         * 3 : 공백 개수
         */
        int[] count = new int[4];
        String N = null;
        while ((N = br.readLine()) != null) {
            clear(count);
            for (char c : N.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    ++count[0];
                } else if ('A' <= c && c <= 'Z') {
                    ++count[1];
                } else if ('0' <= c && c <= '9') {
                    ++count[2];
                } else if (' ' == c) {
                    ++count[3];
                }
            }
            sb.append(count[0] + " " + count[1] + " " + count[2] + " " + count[3] + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void clear(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = 0;
        }
    }

}
