package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1011 Fly me to the Alpha Centauri
 * G5
 * 수학
 */

public class BOJ_1011_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        int x, y;
        for (int tc = 1; tc <= TC; ++tc) {
            // 0 <= x < y < 2^31, 2^31 = 2147483648
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(getMinMoveCount(x, y) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 최소 이동 회수를 계산해서 반환한다.
     * @param src : 출발지 위치
     * @param dst : 목적지 위치
     * @return 최소 이동 회수
     */
    private static int getMinMoveCount(int src, int dst) {
        int distance = dst - src;
        int count = 1;
        long max = 0;

        /**
         * 거리에 따른 최소 이동 회수가 아래와 같은 규칙을 가진다.
         * 1 -> 1
         * 2 -> 1 => (1, 2) 2개
         * 3, 4 -> 2
         * 5, 6 -> 2 => (3, 4, 5, 6) 4개
         * 7, 8, 9 -> 3
         * 10, 11, 12 -> 3 => (7, 8, 9, 10, 11, 12) 6개
         * 이동 거리의 개수가 2의 배수로 증가한다.
         *
         * 이동 거리(max)에 2의 배수(count * 2)를 더한 값이 전체 거리(distance)보다 작으면
         * 이동 거리에 2의 배수(max += count * 2)를 더하고, 2의 배수(++count)를 증가시킨다. 
         */
        while (distance > max + count * 2) {
            max += count * 2;
            ++count;
        }

        // 현재까지의 이동 거리에 2의 배수를 더한 값이 전체 거리보다 크거나 같으면
        if (max + count >= distance) return 2 * count - 1;
        // 작으면
        else return 2 * count;
    }
}
