package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1120 문자열
 * S4
 * 구현, 문자열, 브루트포스
 */

public class BOJ_1120_1 {

    /**
     * 1 <= A <= B <= 50
     */
    static char[] A, B;

    static int diffCount = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = st.nextToken().toCharArray();
        B = st.nextToken().toCharArray();

        final int SIZE_A = A.length;
        final int SIZE_B = B.length;

        for (int i = 0, SIZE = SIZE_B - SIZE_A; i <= SIZE; i++) {
            int d = 0;
            for (int index = 0; index < SIZE_A; index++) {
                if (A[index] != B[index + i]) {
                    ++d;
                }
            }
            diffCount = Math.min(diffCount, d);
            if (diffCount == 0) {
                break;
            }
        }

        // output
        bw.write(String.valueOf(diffCount));

        // io close
        bw.close();
        br.close();
    }
}
