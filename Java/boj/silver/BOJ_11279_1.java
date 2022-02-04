package boj.silver;

import java.io.*;
import java.util.PriorityQueue;

/**
 * BOJ 11279 최대 힙
 * S2
 * 자료 구조, 우선순위 큐
 */

public class BOJ_11279_1 {

    // 1 <= N <= 100,000
    static int N;

    static PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                pq.offer(x);
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
