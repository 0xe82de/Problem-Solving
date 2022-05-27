package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 11723 집합
 * S5
 * 구현, 비트마스킹
 */

public class BOJ_11723_3 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 연산의 수
         */
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int S = 0;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if ("all".equals(command)) {
                S = all();
            } else if ("empty".equals(command)) {
                S = empty();
            } else {
                int x = Integer.parseInt(st.nextToken());

                if ("add".equals(command)) {
                    S |= (1 << x);
                } else if ("remove".equals(command)) {
                    S &= ~(1 << x);
                } else if ("check".equals(command)) {
                    sb.append((S & (1 << x)) == 0 ? 0 : 1).append("\n");
                } else if ("toggle".equals(command)) {
                    S ^= (1 << x);
                }
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static int all() {
        return (1 << 21) - 1;
    }

    static int empty() {
        return 0;
    }
}
