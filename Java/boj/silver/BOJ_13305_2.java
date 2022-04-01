package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 13305 주유소
 * S4
 * 그리디
 */

public class BOJ_13305_2 {

    /**
     * 도시의 개수
     * 2 <= N <= 100,000
     */
    static int N;

    /**
     * N-1개
     */
    static int[] distances;

    /**
     * N개
     */
    static int[] oilPrices;

    static final int MAX_OIL_PRICE = 1000000000;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        distances = new int[N - 1];
        oilPrices = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0, SIZE = N - 1; i < SIZE; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            oilPrices[i] = Integer.parseInt(st.nextToken());
        }

        long minPrice = go();

        // output
        bw.write(String.valueOf(minPrice));

        // io close
        bw.close();
        br.close();
    }

    static long go() {
        int minOilPrice = MAX_OIL_PRICE;
        long minPrice = 0L;

        for (int i = 0, SIZE = N - 1; i < SIZE; i++) {
            minOilPrice = Math.min(minOilPrice, oilPrices[i]);
            minPrice += (long) minOilPrice * distances[i];
        }

        return minPrice;
    }
}
