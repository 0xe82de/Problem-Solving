package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * BOJ 20300 서강근육맨
 * S3
 * 그리디, 정렬
 */

public class BOJ_20300_1 {

    private static final ToIntFunction<String> strToInt = Integer::parseInt;

    private static final ToLongFunction<String> strToLong = Long::parseLong;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = strToInt.applyAsInt(br.readLine());
        long[] muscleLossAmounts = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            muscleLossAmounts[i] = strToLong.applyAsLong(st.nextToken());
        }

        Arrays.sort(muscleLossAmounts);

        long muscleLossAmount = N % 2 == 0 ? 0L : muscleLossAmounts[N - 1];
        int pairIndex = N % 2 == 0 ? 1 : 2;

        for (int i = 0; i < N / 2; i++) {
            muscleLossAmount = Math.max(muscleLossAmount, muscleLossAmounts[i] + muscleLossAmounts[N - i - pairIndex]);
        }

        // output
        bw.write(muscleLossAmount + "");

        // io close
        bw.close();
        br.close();
    }
}
