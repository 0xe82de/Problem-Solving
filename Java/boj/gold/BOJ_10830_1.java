package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 10830 행렬 제곱
 * G4
 * 수학, 분할 정복, 분할 정복을 이용한 거듭제곱, 선형대수학
 */

public class BOJ_10830_1 {

    static int N;
    static final int MOD = 1000;

    static int[][] origin;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        final long B = Long.parseLong(st.nextToken());

        origin = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                origin[i][j] = Integer.parseInt(st.nextToken());
                origin[i][j] %= MOD;
            }
        }

        int[][] result = pow(origin, B);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 행렬 제곱
     * 
     * @param matrix : 제곱할 행렬
     * @param B : 지수
     * @return 연산 결과
     */
    private static int[][] pow(int[][] matrix, long B) {
        if (B == 1L) {
            return matrix;
        }

        int[][] result = pow(matrix, B / 2);
        result = multiply(result, result);
        if (B % 2 == 1L) {
            result = multiply(result, origin);
        }

        return result;
    }

    /**
     * 행렬 곱셈
     * 
     * @param A : 행렬 A
     * @param B : 행렬 B
     * @return 연산 결과
     */
    private static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    result[i][j] += (A[i][k] * B[k][j]);
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }

}
