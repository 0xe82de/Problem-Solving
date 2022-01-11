package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 10816 숫자 카드 2
 * S4
 * 자료 구조, 정렬, 이분 탐색
 */

public class BOJ_10816_1 {

    static int N;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 1 <= N <= 500,000
        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(cards);

        // 1 <= M <= 500,000
        br.readLine();
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(target) - lowerBound(target)).append(" ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static int upperBound(int target) {
        int left = 0;
        int right = N;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (target < cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int lowerBound(int target) {
        int left = 0;
        int right = N;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (target <= cards[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


}
