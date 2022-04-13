package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 10816 숫자 카드 2
 * S4
 * 자료 구조, 정렬, 이분 탐색
 */

public class BOJ_10816_2 {

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
        System.setIn(new FileInputStream("input.txt"));
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
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(target) - lowerBound(target)).append(" ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static int upperBound(int target) {
        int lower = 0;
        int upper = N;

        while (lower < upper) {
            int mid = (lower + upper) / 2;
            if (target >= cards[mid]) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        return lower;
    }

    static int lowerBound(int target) {
        int lower = 0;
        int upper = N;

        while (lower < upper) {
            int mid = (lower + upper) / 2;
            if (target > cards[mid]) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        return lower;
    }
}
