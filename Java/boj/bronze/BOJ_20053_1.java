package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 20053 최소, 최대 2
 * B3
 * 구현
 */

public class BOJ_20053_1 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 테스트 케이스의 개수
         * 1 <= t <= 10
         */
        int T = parseInt.applyAsInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            /**
             * 정수의 개수
             * 1 <= N <= 1,000,000
             */
            int N = parseInt.applyAsInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int min = 1_000_000;
            int max = -1_000_000;
            for (int i = 0; i < N; i++) {
                int number = parseInt.applyAsInt(st.nextToken());
                min = Math.min(min, number);
                max = Math.max(max, number);
            }

            sb.append(min).append(" ").append(max)
                    .append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
