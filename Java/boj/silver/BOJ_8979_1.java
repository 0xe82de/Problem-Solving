package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 8979 올림픽
 * S5
 * 구현, 정렬
 */

public class BOJ_8979_1 {

    /**
     * 국가의 수
     * 1 <= N <= 1,000
     */
    static int N;

    /**
     * 등수를 알고 싶은 국가
     * 1 <= K <= N
     */
    static int K;

    static int[][] result;

    static int count = 1;

    static final int ORDER = 0;
    static final int GOLD = 1;
    static final int SILVER = 2;
    static final int BRONZE = 3;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = new int[N + 1][4];
        result[0][GOLD] = 1000000;
        result[0][SILVER] = 1000000;
        result[0][BRONZE] = 1000000;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            result[i][ORDER] = Integer.parseInt(st.nextToken());
            result[i][GOLD] = Integer.parseInt(st.nextToken());
            result[i][SILVER] = Integer.parseInt(st.nextToken());
            result[i][BRONZE] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(result, (int[] o1, int[] o2) -> o1[GOLD] != o2[GOLD] ?
                Integer.compare(o2[GOLD], o1[GOLD]) : o1[SILVER] != o2[SILVER] ?
                Integer.compare(o2[SILVER], o1[SILVER]) : Integer.compare(o2[BRONZE], o1[BRONZE]));

        for (int index = 1; index <= N; index++) {
            if (result[index][ORDER] == K) {
                int compareIndex = index - 1;
                while (compareIndex > 0) {
                    if (isDiff(result[index], result[compareIndex])) {
                        count = compareIndex + 1;
                        break;
                    }
                    --compareIndex;
                }
                break;
            }
        }

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    private static boolean isDiff(int[] result1, int[] result2) {
        return result1[GOLD] != result2[GOLD] || result1[SILVER] != result2[SILVER] || result1[BRONZE] != result2[BRONZE];
    }

}
