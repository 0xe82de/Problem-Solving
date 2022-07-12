package boj.silver;

import java.io.*;
import java.util.function.ToIntFunction;

/**
 * BOJ 20365 블로그2
 * S2
 * 문자열, 그리디
 */

public class BOJ_20365_1 {

    private static final ToIntFunction<String> strToInt = Integer::parseInt;

    private static final int BLUE = 0;

    private static final int RED = 1;

    private static final char B = 'B';

    private static final char R = 'R';

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int N = strToInt.applyAsInt(br.readLine());
        char[] words = br.readLine().toCharArray();

        int[] count = new int[2];
        char base = ' ';
        for (char word : words) {
            if (base != word) {
                if (base == B) {
                    ++count[BLUE];
                } else if (base == R) {
                    ++count[RED];
                }

                base = word;
            }
        }

        ++count[words[N - 1] == B ? BLUE : RED];

        int result = Math.min(count[BLUE], count[RED]) + 1;

        // output
        bw.write(result + "");

        // io close
        bw.close();
        br.close();
    }
}
