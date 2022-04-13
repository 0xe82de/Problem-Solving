package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 10815 숫자 카드
 * S4
 * 정렬, 이분 탐색
 */

public class BOJ_10815_2 {

    /**
     * 숫자 카드의 개수
     * 1 <= N <= 500,000
     */
    static int N;

    /**
     * -10,000,000 <= card <= 10,000,000
     */
    static int[] cards;

    /**
     * 확인할 카드의 개수
     * 1 <= M <= 500,000
     */
    static int M;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int output = binarySearch(0, N - 1, target) == -1 ? 0 : 1;
            sb.append(output).append(" ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static int binarySearch(int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (target == cards[mid]) {
            return mid;
        } else if (target < cards[mid]) {
            return binarySearch(start, mid - 1, target);
        } else {
            return binarySearch(mid + 1, end, target);
        }
    }
}
