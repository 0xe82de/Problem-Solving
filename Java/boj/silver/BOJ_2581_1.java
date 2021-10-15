package boj.silver;

import java.io.*;

/**
 * BOJ 2581 소수
 * S5
 * 수학, 정수론, 소수 판정
 */

public class BOJ_2581_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int M = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());

        // sum, min
        int[] res = getResult(M, N);

        // output
        if (res[1] == 0) bw.write("-1");
        else bw.write(String.valueOf(res[0]) + "\n" + String.valueOf(res[1]));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 소수들의 합과 최소 소수를 리턴한다.
     * @param m : 숫자 범위에서 가장 작은 숫자
     * @param n : 숫자 범위에서 사장 큰 숫자
     * @return
     */
    private static int[] getResult(int m, int n) {
        int[] res = new int[2];
        for (int number = n; number >= m; --number) {
            if (isPrime(number)) {
                res[0] += number;
                res[1] = number;
            }
        }

        return res;
    }

    /**
     * 전달받은 number가 소수인지 검증하여 소수 여부를 반환한다.
     * @param number : 검증할 숫자
     * @return 소수 여부
     */
    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
