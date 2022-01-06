package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 3036 링
 * S3
 * 수학, 정수론, 유클리드 호제법
 */

public class BOJ_3036_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 3 <= N <= 100
        final int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        final int firstCircleRadius = Integer.parseInt(st.nextToken());
        int A = 0, B = 0;
        int gcd = 0;
        for (int i = 1; i < N; ++i) {
            int nextCircleRadidus = Integer.parseInt(st.nextToken());
            if (firstCircleRadius % nextCircleRadidus == 0) {
                A = firstCircleRadius / nextCircleRadidus;
                B = 1;
            } else {
                gcd = getGcd(firstCircleRadius, nextCircleRadidus);
                A = firstCircleRadius / gcd;
                B = nextCircleRadidus / gcd;
            }
            sb.append(A + "/" + B + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * gcd 계산
     *
     * @param a : 수 1
     * @param b : 수 2
     * @return gcd
     */
    private static int getGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
