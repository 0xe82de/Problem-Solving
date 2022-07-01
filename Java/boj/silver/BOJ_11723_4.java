package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11723 집합
 * S5
 * 구현, 비트마스킹
 */

public class BOJ_11723_4 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 연산의 수
         * 1 <= M <= 3,000,000
         */
        int M = Integer.parseInt(br.readLine());

        int S = 0;
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if ("all".equals(command)) {
                S = (1 << 21) - 1;
            } else if ("empty".equals(command)) {
                S = 0;
            } else {
                int x = Integer.parseInt(st.nextToken());
                if ("add".equals(command)) {
                    S |= 1 << x;
                } else if ("remove".equals(command)) {
                    S &= ~(1 << x);
                } else if ("check".equals(command)) {
                    sb.append(containX(S, x) ? 1 : 0)
                            .append("\n");
                } else if ("toggle".equals(command)) {
                    S ^= 1 << x;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static boolean containX(int s, int x) {
        return (s & (1 << x)) > 0;
    }
}
