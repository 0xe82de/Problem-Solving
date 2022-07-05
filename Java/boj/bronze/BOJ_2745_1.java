package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2745 진법 변환
 * B2
 * 수학, 구현, 문자열
 */

public class BOJ_2745_1 {

    /**
     * B진법 수
     */
    static String N;

    /**
     * 진법
     * 2 <= B <= 36
     */
    static int B;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = st.nextToken();
        B = Integer.parseInt(st.nextToken());

        int result = 0;
        final int SIZE = N.length();
        for (int i = SIZE - 1; i >= 0; i--) {
            char number = N.charAt(i);
            result += ('A' <= number && number <= 'Z' ? number - 'A' + 10 : number - '0') * Math.pow(B, SIZE - i - 1);
        }

        // output
        bw.write("" + result);

        // io close
        bw.close();
        br.close();
    }
}
