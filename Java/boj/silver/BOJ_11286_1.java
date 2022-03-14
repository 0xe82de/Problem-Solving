package boj.silver;

import java.io.*;
import java.util.PriorityQueue;

/**
 * BOJ 11286 절댓값 힙
 * S1
 * 자료 구조, 우선순위 큐
 */

public class BOJ_11286_1 {

    static int N;

    static int ORIGIN = 0;

    static int ABS = 1;

    static int PRINT = 0;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[ABS] == o2[ABS]) {
                return Integer.compare(o1[ORIGIN], o2[ORIGIN]);
            } else {
                return Integer.compare(o1[ABS], o2[ABS]);
            }
        });

        int x = 0;
        while (N-- > 0) {
            x = Integer.parseInt(br.readLine());

            if (x == PRINT) {
                if (pq.isEmpty()) {
                    sb.append("0");
                } else {
                    sb.append(pq.poll()[ORIGIN]);
                }
                sb.append("\n");
            } else {
                pq.offer(new int[] {x, Math.abs(x)});
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
