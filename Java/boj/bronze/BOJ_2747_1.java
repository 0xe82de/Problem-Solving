package boj.bronze;

import java.io.*;

/**
 * BOJ 2747
 * B3
 * 수학, 구현
 */

public class BOJ_2747_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int n = Integer.parseInt(br.readLine());

        // output
        bw.write(String.valueOf(fibonacci(n)));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 피보나치 수를 계산해서 리턴한다.
     *
     * @param n : n번째 피보나치 수를 계산하기 위해 주어지는 n
     * @return n번째 피보나치 수
     */
    private static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        int[] computed = new int[n + 1];
        computed[0] = 0;
        computed[1] = 1;
        for (int i = 2; i <= n; ++i) {
            computed[i] = computed[i - 1] + computed[i - 2];
        }

        return computed[n];
    }
}
