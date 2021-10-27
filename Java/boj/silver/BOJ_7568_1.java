package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 7568 덫치
 * S5
 * 구현, 브루트포스
 */

public class BOJ_7568_1 {

    static final int W = 0;
    static final int H = 1;
    static final int RANK = 2;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // logic
        final int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[n][W] = Integer.parseInt(st.nextToken());
            arr[n][H] = Integer.parseInt(st.nextToken());
        }

        // 랭크 세팅
        setRank(arr);

        for (int n = 0; n < N; ++n)
            sb.append(arr[n][RANK] + " ");

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 랭크를 세팅한다.
     * @param arr : 사람들
     */
    private static void setRank(int[][] arr) {
        final int size = arr.length;
        int curW, curH, curR;
        for (int i = 0; i < size; ++i) {
            // 현재 사람의 몸무게, 키, 랭크
            curW = arr[i][W];
            curH = arr[i][H];
            curR = 0;

            // 자신을 제외하고 나머지 사람들과 비교해서
            // 자신보다 몸무게, 키가 크면 curR 증가
            for (int j = 0; j < size; ++j) {
                if (i == j) continue;
                if (curW < arr[j][W] && curH < arr[j][H])
                    ++curR;
            }
            
            // curR + 1만큼 랭크를 세팅
            arr[i][RANK] = curR + 1;
        }
    }
}
