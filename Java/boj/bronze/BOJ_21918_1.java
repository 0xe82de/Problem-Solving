package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

/**
 * BOJ 21918 전구
 * B2
 * 구현
 */

public class BOJ_21918_1 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    /**
     * 전구의 개수
     * 1 <= N <= 4,000
     */
    private static int N;

    /**
     * 명령어의 개수
     * 1 <= M <= 4,000
     */
    private static int M;

    private static char[] bulbs;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = parseInt.applyAsInt(st.nextToken());
        M = parseInt.applyAsInt(st.nextToken());

        bulbs = new char[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            bulbs[i] = st.nextToken().charAt(0);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = parseInt.applyAsInt(st.nextToken());

            if (command == 1) {
                int i = parseInt.applyAsInt(st.nextToken()) - 1;
                char x = st.nextToken().charAt(0);

                bulbs[i] = x;
            } else {
                int l = parseInt.applyAsInt(st.nextToken()) - 1;
                int r = parseInt.applyAsInt(st.nextToken()) - 1;

                if (command == 2) {
                    IntStream.rangeClosed(l, r)
                            .forEach(i -> bulbs[i] = bulbs[i] == '1' ? '0' : '1');
                } else {
                    char b = command == 3 ? '0' : '1';
                    IntStream.rangeClosed(l, r)
                            .forEach(i -> bulbs[i] = b);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char bulb : bulbs) {
            sb.append(bulb).append(" ");
        }

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }
}
