package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 11723 집합
 * S5
 * 구현, 비트마스킹
 */

public class BOJ_11723_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int MAX_VALUE = 20;
        /**
         * 연산의 수
         * 1 <= M <= 3,000,000
         */
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] binary = empty(MAX_VALUE + 1);
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if ("all".equals(command)) {
                binary = full(MAX_VALUE + 1);
            } else if ("empty".equals(command)) {
                binary = empty(MAX_VALUE + 1);
            } else {
                int x = Integer.parseInt(st.nextToken());

                if ("add".equals(command)) {
                    binary[x] = true;
                } else if ("remove".equals(command)) {
                    binary[x] = false;
                } else if ("check".equals(command)) {
                    sb.append(binary[x] ? '1' : '0');
                    sb.append("\n");
                } else if ("toggle".equals(command)) {
                    binary[x] = !binary[x];
                }
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static boolean[] empty(int n) {
        return new boolean[n];
    }

    static boolean[] full(int n) {
        boolean[] full = empty(n);
        for (int i = 0; i < n; i++) {
            full[i] = true;
        }

        return full;
    }
}
