package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2512 예산
 * S3
 * 이분 탐색, 매개 변수 탐색
 */

public class BOJ_2512_1 {

    /**
     * 3 <= N <= 10,000
     */
    static int N;

    /**
     * 1 <= number <= 100,000
     */
    static int[] numbers;

    /**
     * N <= M <= 1,000,000,000
     */
    static int M;

    static int sum;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
        }

        M = Integer.parseInt(br.readLine());

        int maxLimit = getMaxLimit();

        // output
        bw.write(String.valueOf(maxLimit));

        // io close
        bw.close();
        br.close();
    }

    static int getMaxLimit() {
        Arrays.sort(numbers);
        if (sum <= M) {
            return numbers[N - 1];
        }

        int lower = 0;
        int upper = numbers[N - 1];
        int limit = 0;
        int maxLimit = 0;
        while (lower <= upper) {
            limit = (lower + upper) / 2;

            if (getValue(limit) > M) {
                upper = limit - 1;
            } else {
                lower = limit + 1;
                maxLimit = limit;
            }
        }

        return maxLimit;
    }

    static int getValue(int limit) {
        return Arrays.stream(numbers).map(number -> Math.min(limit, number)).sum();
    }
}
