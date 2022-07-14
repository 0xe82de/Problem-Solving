package boj.silver;

import java.io.*;
import java.util.function.ToIntFunction;

/**
 * BOJ 2485 가로수
 * S4
 * 수학, 정수론, 유클리드 호제법
 */

public class BOJ_2485_2 {

    private static final ToIntFunction<String> strToInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 이미 심어져 있는 가로수의 수
         * 3 <= N <= 100,000
         */
        final int N = strToInt(br.readLine());

        int[] treePositions = new int[N];

        treePositions[0] = strToInt(br.readLine());
        treePositions[1] = strToInt(br.readLine());
        treePositions[2] = strToInt(br.readLine());

        int gcd = gcd(treePositions[1] - treePositions[0], treePositions[2] - treePositions[1]);

        for (int i = 3; i < N; i++) {
            treePositions[i] = strToInt(br.readLine());
            gcd = gcd(gcd, treePositions[i] - treePositions[i - 1]);
        }

        int result = (treePositions[N - 1] - treePositions[0]) / gcd - (N - 2) - 1;

        // output
        bw.write("" + result);

        // io close
        bw.close();
        br.close();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int strToInt(String str) {
        return strToInt.applyAsInt(str);
    }
}
