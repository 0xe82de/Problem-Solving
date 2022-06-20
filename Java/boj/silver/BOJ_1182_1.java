package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1182 부분수열의 합
 * S2
 * 브루트포스, 백트래킹
 */

public class BOJ_1182_1 {

    /**
     * 정수의 개수
     * 1 <= N <= 20
     */
    static int N;

    /**
     * 비교할 정수
     * |S| <= 1,000,000
     */
    static int S;

    static int[] numbers;

    static int count;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            --count;
        }

        // output
        bw.write("" + count);

        // io close
        bw.close();
        br.close();
    }

    static void dfs(int current, int sum) {
        if (current == N) {
            if (sum == S) {
                ++count;
            }

            return;
        }

        dfs(current + 1, sum + numbers[current]);
        dfs(current + 1, sum);
    }
}
