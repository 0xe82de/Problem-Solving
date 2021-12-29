package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2740 행렬 곱셈
 * B1
 * 수학, 구현, 선형대수학
 */

public class BOJ_2740_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // N * M 행렬
        st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j) {
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // M * K 행렬
        st = new StringTokenizer(br.readLine(), " ");
        st.nextToken(); // M
        final int K = Integer.parseInt(st.nextToken());
        int[][] matrixB = new int[M][K];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < K; ++j) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 결과 행렬
        int[][] matrixResult = new int[N][K];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < K; ++j) {
                for (int k = 0; k < M; ++k) {
                    matrixResult[i][j] += (matrixA[i][k] * matrixB[k][j]);
                }
                sb.append(matrixResult[i][j] + " ");
            }
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
