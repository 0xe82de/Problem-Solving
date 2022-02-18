package boj.silver;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 1697 숨바꼭질
 * S1
 * BFS
 */

public class BOJ_1697_2 {

    /**
     * N : 수빈이의 위치
     * K : 동생의 위치
     * 0 <= N, K <= 100,000
     */
    static int N, K;

    static int result;

    static final int MIN_SIZE = 0;
    static final int MAX_SIZE = 100000;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX_SIZE + 1];
        bfs();

        // output
        bw.write(String.valueOf(result));

        // io close
        bw.close();
        br.close();
    }

    private static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
        pq.offer(new int[] {N, 0});
        visited[N] = true;

        while (!pq.isEmpty()) {
            int[] res = pq.poll();
            int pos = res[0];
            int time = res[1];

            if (pos == K) {
                result = time;
                break;
            }

            if (pos - 1 >= MIN_SIZE && !visited[pos - 1]) {
                pq.offer(new int[] {pos - 1, time + 1});
                visited[pos - 1] = true;
            }

            if (pos + 1 <= MAX_SIZE && !visited[pos + 1]) {
                pq.offer(new int[] {pos + 1, time + 1});
                visited[pos + 1] = true;
            }

            if (pos * 2 <= MAX_SIZE && !visited[pos * 2]) {
                pq.offer(new int[] {pos * 2, time + 1});
                visited[pos * 2] = true;
            }
        }
    }

}
