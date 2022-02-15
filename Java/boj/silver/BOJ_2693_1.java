package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 2693 N번째 큰 수
 * S5
 * 정렬
 */

public class BOJ_2693_1 {

    /**
     * 1 <= T <= 1,000
     */
    static int T;

    static final int SIZE = 10;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Integer[] input = new Integer[SIZE];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < SIZE; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input, Comparator.reverseOrder());
            sb.append(input[2]).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
