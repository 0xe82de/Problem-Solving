package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * BOJ 2667 단지번호붙이기
 * S1
 * BFS, DFS
 */

public class BOJ_2667_1 {

    static final char EMPTY = '0';

    static final int ROW = 0;
    static final int COL = 1;

    static final int[] DR = { 0, 1, 0, -1 };
    static final int[] DC = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == EMPTY) continue;

                q.offer(new int[] {r, c});
                map[r][c] = EMPTY;
                int count = 1;

                while (!q.isEmpty()) {
                    int[] cHouse = q.poll();
                    int cr = cHouse[ROW];
                    int cc = cHouse[COL];

                    for (int dir = 0; dir < 4; dir++) {
                        int nr = cr + DR[dir];
                        int nc = cc + DC[dir];

                        if (isOutRange(nr, nc, N) || map[nr][nc] == EMPTY) continue;

                        q.offer(new int[] {nr, nc});
                        map[nr][nc] = EMPTY;
                        ++count;
                    }
                }

                pq.offer(count);
            }
        }

        sb.append(pq.size()).append("\n");
        Stream.generate(pq::poll)
                .limit(pq.size())
                .forEach(count -> sb.append(count).append("\n"));

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static boolean isOutRange(int nr, int nc, int n) {
        return nr < 0 || nr >= n || nc < 0 || nc >= n;
    }

}
