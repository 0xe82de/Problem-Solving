package boj.gold;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 2075 N번째 큰 수
 * G5
 * 자료 구조, 정렬, 우선순위 큐
 */

public class BOJ_2075_1 {

    /**
     * 1 <= n <= 1,500
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        while (N-- > 1) {
            pq.poll();
        }

        // output
        bw.write(String.valueOf(pq.poll()));

        // io close
        bw.close();
        br.close();
    }
}
