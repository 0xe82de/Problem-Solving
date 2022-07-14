package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 10816 숫자 카드 2
 * S4
 * 자료 구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵
 */

public class BOJ_10816_4 {

    private static int N;

    private static int M;

    private static int[] cards;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = strToInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = strToInt(st.nextToken());
        }
        Arrays.sort(cards);

        M = strToInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int card = strToInt(st.nextToken());
            sb.append(upperBound(card) - lowerBound(card)).append(" ");
        }

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }

    private static int upperBound(int card) {
        int lower = 0;
        int upper = N;

        while (lower < upper) {
            int mid = (lower + upper) / 2;

            if (card >= cards[mid]) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        return lower;
    }

    private static int lowerBound(int card) {
        int lower = 0;
        int upper = N;

        while (lower < upper) {
            int mid = (lower + upper) / 2;

            if (card > cards[mid]) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        return lower;
    }

    private static int strToInt(String str) {
        return Integer.parseInt(str);
    }
}
