package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2167 2차원 배열의 합
 * B1
 * 구현, 누적합
 */

public class BOJ_2167_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 배열의 크기
         * 1 <= N, M <= 300
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 합을 구할 부분의 개수
         */
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            int sum = 0;
            for (int k = i; k <= x; k++) {
                for (int l = j; l <= y; l++) {
                    sum += arr[k][l];
                }
            }

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
