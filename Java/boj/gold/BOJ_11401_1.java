package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11401 이항 계수 3
 * G1
 * 수학, 정수론, 분할정복을 이용한 거듭제곱, 페르마의 소정리, 모듈로 곱셈 역원
 */

public class BOJ_11401_1 {

    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1 <= N <= 4,000,000
        final int N = Integer.parseInt(st.nextToken());
        // 0 <= K <= N
        final int K = Integer.parseInt(st.nextToken());

        long result = 0;
        if (N == K || K == 0) {
            result = 1;
        }
        else {
            long numer = factorial(N);
            long denom = factorial(K) * factorial(N - K) % MOD;
            result = numer * pow(denom, MOD - 2) % MOD;
        }

        // output
        bw.write(String.valueOf(result));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 팩토리얼
     * 
     * @param n : 수
     * @return 계산된 값
     */
    private static long factorial(int n) {
        long result = 1L;

        while (n > 1) {
            result = (result * n--) % MOD;
        }

        return result;
    }

    /**
     * 역원 구하기
     * 
     * @param base : 밑수
     * @param expo : 지수
     * @return 역원
     */
    private static long pow(long base, long expo) {
        long result = 1L;

        while (expo > 0) {
            if (expo % 2 == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            expo /= 2;
        }

        return result;
    }

}
