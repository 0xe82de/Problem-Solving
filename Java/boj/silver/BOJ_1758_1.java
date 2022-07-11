package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.function.ToIntFunction;

/**
 * BOJ 1758 알바생 강호
 * ??
 * 그리디, 정렬
 */

public class BOJ_1758_1 {

    private static final ToIntFunction<String> strToInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = strToInt.applyAsInt(br.readLine());
        int[] tips = new int[N];

        for (int i = 0; i < N; i++) {
            tips[i] = strToInt.applyAsInt(br.readLine());
        }

        Arrays.sort(tips);

        long result = 0;
        for (int i = N - 1; i >= 0; i--) {
            int rank = N - i;
            int tip = tips[i] - (rank - 1);
            if (tip <= 0) {
                continue;
            }

            result += tip;
        }

        // output
        bw.write("" + result);

        // io close
        bw.close();
        br.close();
    }
}
