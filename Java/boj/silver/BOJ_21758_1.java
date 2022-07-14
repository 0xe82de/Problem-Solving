package boj.silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 21758 꿀 따기
 * S1
 * 그리디, 누적 합, 많은 조건 분기
 */

public class BOJ_21758_1 {

    private static final ToIntFunction<String> strToInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = strToInt.applyAsInt(br.readLine());
        int[] honeyAmounts = new int[N];
        long[] cumulativeSum = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        honeyAmounts[0] = strToInt.applyAsInt(st.nextToken());
        cumulativeSum[0] = honeyAmounts[0];

        for (int i = 1; i < N; i++) {
            honeyAmounts[i] = strToInt.applyAsInt(st.nextToken());
            cumulativeSum[i] = cumulativeSum[i - 1] + honeyAmounts[i];
        }

        long maxHoneyAmount = 0L;

        /**
         * 1번 벌 : 0
         * 2번 벌 : 1 ~ N - 2
         * 벌통 : N - 1
         */
        for (int secondBeeIndex = 1; secondBeeIndex < N - 1; secondBeeIndex++) {
            long firstBee = cumulativeSum[N - 1] - honeyAmounts[secondBeeIndex] - honeyAmounts[0];
            long secondBee = cumulativeSum[N - 1] - cumulativeSum[secondBeeIndex];
            maxHoneyAmount = Math.max(maxHoneyAmount, firstBee + secondBee);
        }

        /**
         * 벌통 : 0
         * 1번 벌 : 1 ~ N - 2
         * 2번 벌 : N - 1
         */
        for (int firstBeeIndex = 1; firstBeeIndex < N - 1; firstBeeIndex++) {
            long firstBee = cumulativeSum[firstBeeIndex - 1];
            long secondBee = cumulativeSum[N - 1] - honeyAmounts[N - 1] - honeyAmounts[firstBeeIndex];
            maxHoneyAmount = Math.max(maxHoneyAmount, firstBee + secondBee);
        }

        /**
         * 1번 벌 : 0
         * 벌통 : 1 ~ N - 2
         * 2번 벌 : N - 1
         */
        for (int hiveIndex = 1; hiveIndex < N - 1; hiveIndex++) {
            long firstBee = cumulativeSum[hiveIndex] - honeyAmounts[0];
            long secondBee = cumulativeSum[N - 1] - cumulativeSum[hiveIndex - 1] - honeyAmounts[N - 1];
            maxHoneyAmount = Math.max(maxHoneyAmount, firstBee + secondBee);
        }

        // output
        bw.write(maxHoneyAmount + "");

        // io close
        bw.close();
        br.close();
    }
}
