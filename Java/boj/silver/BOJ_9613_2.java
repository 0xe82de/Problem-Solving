package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 9613 GCD 합
 * S3
 * 수학, 정수론, 유클리드 호제법
 */

public class BOJ_9613_2 {

    /**
     * 테스트 케이스의 개수
     * 1 <= t <= 100
     */
    static int t;

    /**
     * 테스트 케이스 별 수의 개수
     * 1 < n < = 100
     */
    static int n;

    /**
     * 1 <= number <= 1,000,000
     */
    static int number;

    static int[] numbers;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                number = Integer.parseInt(st.nextToken());
                numbers[i] = number;
            }

            sb.append(getGcdSum()).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static long getGcdSum() {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum += getGcd(numbers[i], numbers[j]);
            }
        }

        return sum;
    }

    private static int getGcd(int n1, int n2) {
        int gcd = Math.min(n1, n2);

        while (n1 % gcd != 0 || n2 % gcd != 0) {
            --gcd;
        }

        return gcd;
    }

}
