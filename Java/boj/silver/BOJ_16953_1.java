package boj.silver;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 16953 A → B
 * S1
 * 그리디, BFS
 */

public class BOJ_16953_1 {

    static final int VALUE = 0;
    static final int COUNT = 1;

    static long minCount = -1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 1 <= A < B <= 10^9
        final long A = Integer.parseInt(st.nextToken());
        final long B = Integer.parseInt(st.nextToken());

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[COUNT], o2[COUNT]));

        long[] current = null;
        if (A * 2 <= B) {
            pq.offer(new long[]{A * 2, 1});
            pq.offer(new long[]{A * 10 + 1, 1});

            while (!pq.isEmpty()) {
                current = pq.poll();
                long value = current[VALUE];
                long count = current[COUNT];

                if (value == B) {
                    minCount = count + 1;
                    break;
                }

                if (value * 2 <= B) {
                    pq.offer(new long[] {value * 2, count + 1});

                    if (value * 10 + 1 <= B) {
                        pq.offer(new long[] {value * 10 + 1, count + 1});
                    }
                }
            }
        }

        // output
        bw.write(String.valueOf(minCount));

        // io close
        bw.close();
        br.close();
    }

}
