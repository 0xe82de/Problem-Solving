package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2805 나무 자르기
 * S3
 * 이분 탐색, 매개 변수 탐색
 */

public class BOJ_2805_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int maxValue = getMaxValue(trees, M);

        // output
        bw.write(String.valueOf(maxValue));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 
     * @param trees : 나무의 높이를 가지는 배열
     * @param m : 가져갈 나무의 개수
     * @return
     */
    private static int getMaxValue(int[] trees, int m) {
        int maxH = getMaxHeight(trees);
        int minH = 0;
        int maxValue = 0;
        long cnt = 0;

        while (minH < maxH) {
            maxValue = (maxH + minH) / 2;
            
            cnt = cutAndCounting(trees, maxValue);

            if (cnt < m) {
                maxH = maxValue;
            } else {
                minH = maxValue + 1;
            }
        }

        return minH - 1;
    }

    private static int getMaxHeight(int[] input) {
        int max = 0;

        final int SIZE = input.length;
        for (int i = 0; i < SIZE; i++) {
            if (max < input[i]) max = input[i];
        }

        return max;
    }

    private static long cutAndCounting(int[] trees, int height) {
        long sumHeight = 0;

        final int SIZE = trees.length;
        for (int i = 0; i < SIZE; i++) {
            int result = trees[i] - height;
            if (result > 0) sumHeight += result;
        }

        return sumHeight;
    }

}
