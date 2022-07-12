package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

/**
 * BOJ 20115 에너지 드링크
 * S3
 * 그리디
 */

public class BOJ_20115_1 {

    private static final ToIntFunction<String> strToInt = Integer::parseInt;

    private static final ToDoubleFunction<String> strToDouble = Double::parseDouble;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = strToInt.applyAsInt(br.readLine());
        double[] drinkAmounts = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            drinkAmounts[i] = strToDouble.applyAsDouble(st.nextToken());
        }

        Arrays.sort(drinkAmounts);

        double result = drinkAmounts[N - 1];
        for (int i = 0; i < N - 1; i++) {
            result += drinkAmounts[i] / 2;
        }

        // output
        bw.write(result + "");

        // io close
        bw.close();
        br.close();
    }
}
