package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1049 기타줄
 * S4
 * 수학, 그리디
 */

public class BOJ_1049_2 {

    /**
     * 끊어진 기타줄의 개수
     * 1 <= N <= 100
     */
    static int N;

    /**
     * 기타줄 브랜드 개수
     * 1 <= M <= 50
     */
    static int M;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int priceByBundle = Integer.MAX_VALUE;
        int priceByPiece = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            priceByBundle = Math.min(priceByBundle, Integer.parseInt(st.nextToken()));
            priceByPiece = Math.min(priceByPiece, Integer.parseInt(st.nextToken()));
        }

        int i = N / 6;
        int j = N % 6;
        int price = Math.min(priceByBundle * i + priceByPiece * j, Math.min(priceByBundle * (i + 1), priceByPiece * N));

        // output
        bw.write(String.valueOf(price));

        // io close
        bw.close();
        br.close();
    }
}
