package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.function.ToIntFunction;

/**
 * BOJ 11508 2+1 세일
 * S4
 * 그리디, 정렬
 */

public class BOJ_11508_1 {

    private static final ToIntFunction<String> strToInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 유제품의 수
         * 1 <= N <= 100,000
         */
        final int N = strToInt.applyAsInt(br.readLine());

        int[] costs = new int[N];
        for (int i = 0; i < N; i++) {
            costs[i] = strToInt.applyAsInt(br.readLine());
        }

        Arrays.sort(costs);

        long minCost = 0L;
        int count = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (count % 3 == 0) {
                count = 1;
                continue;
            }

            minCost += costs[i];
            ++count;
        }

        // output
        bw.write(minCost + "");

        // io close
        bw.close();
        br.close();
    }
}
