package boj.silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 9613 GCD 합
 * S3
 * 수학, 브루트포스, 정수론, 유클리드 호제법
 */

public class BOJ_9613_3 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    /**
     * 테스트 케이스의 개수
     * 1 <= t <= 100
     */
    private static int t;

    /**
     * 수의 개수
     * 1 < n <= 100
     * 각 수는 1,000,000을 넘지 않는다.
     */
    private static int n;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        t = parseInt.applyAsInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = parseInt.applyAsInt(st.nextToken());

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = parseInt.applyAsInt(st.nextToken());
            }

            long sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int a = numbers[i];
                    int b = numbers[j];

                    sum += gcd(Math.max(a, b), Math.min(a, b));
                }
            }

            sb.append(sum)
                    .append("\n");
        }

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
