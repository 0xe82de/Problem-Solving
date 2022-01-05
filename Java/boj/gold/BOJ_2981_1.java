package boj.gold;

import java.io.*;

/**
 * BOJ 2981 검문
 * G5
 * 수학, 정수론, 유클리드 호제법
 */

public class BOJ_2981_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        // 2 <= N <= 100
        final int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            // 1 <= input <= 1000000000 10억
            input[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 6 / M + r
         * 34 / M + r
         * 38 / M + r
         * r은 모두 같다.
         * 따라서,
         * (6 - 34) / M과 (34 - 38) / M, 두 식에서 M은 같다.
         * M은 (6 - 34), (34 - 38)의 공약수다.
         * 모든 M을 구하기 위해서는 (6 - 34), (34 - 38)의 최대공약수를 구하고,
         * 구한 최대공약수의 약수를 구하면 된다.
         */

        int gcd = Math.abs(input[1] - input[0]);
        for (int i = 2; i < N; ++i) {
            // 최대공약수
            gcd = getGcd(gcd, Math.abs(input[i] - input[i - 1]));
        }

        for (int i = 2, SIZE = gcd / 2; i <= SIZE; ++i) {
            // 약수
            if (gcd % i == 0) {
                sb.append(i +" ");
            }
        }
        sb.append(gcd);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 최대공약수
     * 
     * @param a : 숫자 1
     * @param b : 숫자 2
     * @return 최대공약수
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
