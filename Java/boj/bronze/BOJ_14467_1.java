package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

/**
 * BOJ 14467 소가 길을 건너간 이유 1
 * B1
 * 구현
 */

public class BOJ_14467_1 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    /**
     * 관찰 횟수
     */
    private static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 관찰 횟수
         * 1 <= N <= 100
         */
        final int N = parseInt.applyAsInt(br.readLine());

        int[] cowPositions = IntStream.rangeClosed(0, 11)
                .map(i -> -1)
                .toArray();

        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cow = parseInt.applyAsInt(st.nextToken());
            int position = parseInt.applyAsInt(st.nextToken());

            if (cowPositions[cow] != -1 && cowPositions[cow] != position) {
                ++count;
            }

            cowPositions[cow] = position;
        }

        // output
        bw.write(count + "");

        // io close
        bw.close();
        br.close();
    }
}
