package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2798 블랙잭
 * B2
 * 브루트포스
 */

public class BOJ_2798_2 {

    /**
     * 카드의 개수
     * 3 <= N <= 100
     */
    static int N;

    /**
     * 10 <= M <= 300,000
     */
    static int M;

    static int[] cards;

    static boolean[] checked;

    static final int COUNT = 3;

    static int result;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];
        checked = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        compute(0, 0);

        // output
        bw.write(String.valueOf(result));

        // io close
        bw.close();
        br.close();
    }

    static void compute(int cnt, int sum) {
        if (cnt == COUNT) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (checked[i] || sum + cards[i] > M) continue;
            checked[i] = true;
            compute(cnt + 1, sum + cards[i]);
            checked[i] = false;
        }
    }
}
