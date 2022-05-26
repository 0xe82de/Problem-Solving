package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2167 2차원 배열의 합
 * B1
 * 구현, 누적 합
 */

public class BOJ_2167_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 배열의 크기
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int sum = arr[x][y] - arr[x][j - 1] - arr[i - 1][y] + arr[i - 1][j - 1];
            sb.append(sum);
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
