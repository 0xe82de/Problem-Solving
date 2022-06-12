package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2512 예산
 * S3
 * 이분 탐색
 */

public class BOJ_2512_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 지방의 수
         * 3 <= N <= 10,000
         */
        int N = Integer.parseInt(br.readLine());

        /**
         * 각 지방의 요청 예산
         * 1 <= buget <= 100,000
         */
        int[] requestBudgets = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            requestBudgets[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 총 예산
         * N <= M <= 1,000,000,000
         */
        int M = Integer.parseInt(br.readLine());

        int maxBudget = calc(requestBudgets, M);

        // output
        bw.write("" + maxBudget);

        // io close
        bw.close();
        br.close();
    }

    static int calc(int[] requestBudgets, int totalBudget) {
        final int SIZE = requestBudgets.length;
        Arrays.sort(requestBudgets);

        if (Arrays.stream(requestBudgets).sum() <= totalBudget) {
            return requestBudgets[SIZE - 1];
        }

        int left = 0;
        int right = requestBudgets[SIZE - 1];
        int maxBudget = 0;
        while (left <= right) {
            int limit = (left + right) / 2;

            if (getSum(requestBudgets, limit) > totalBudget) {
                right = limit - 1;
            } else {
                left = limit + 1;
                maxBudget = limit;
            }
        }

        return maxBudget;
    }

    static int getSum(int[] requestBudgets, int limit) {
        return Arrays.stream(requestBudgets)
                .map(requestBudget -> Math.min(requestBudget, limit))
                .sum();
    }
}
