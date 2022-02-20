package boj.silver;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 7562 나이트의 이동
 * S2
 * BFS
 */

public class BOJ_7562_1 {

    /**
     * 테스트 케이스의 개수
     */
    static int TC;

    /**
     * 체스판의 한 변의 길이
     */
    static int l;

    static int[][] map;
    static boolean[][] visited;

    static int srcRow, srcCol;

    static final int KNIGHT = 1;
    static final int DEST = 2;

    static final int ROW = 0;
    static final int COL = 1;
    static final int MOVE = 2;

    static final int[] DR = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] DC = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine(), " ");
            srcRow = Integer.parseInt(st.nextToken());
            srcCol = Integer.parseInt(st.nextToken());
            map[srcRow][srcCol] = KNIGHT;

            st = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = DEST;

            sb.append(bfs() + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static int bfs() {
        int move = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[MOVE], o2[MOVE]));
        pq.offer(new int[] {srcRow, srcCol, 0});
        visited[srcRow][srcCol] = true;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cr = current[ROW];
            int cc = current[COL];
            int cm = current[MOVE];

            if (map[cr][cc] == DEST) {
                move = cm;
                break;
            }

            for (int dir = 0; dir < 8; dir++) {
                int nr = cr + DR[dir];
                int nc = cc + DC[dir];

                if (isOutRange(nr, nc) || visited[nr][nc]) continue;

                int nm = cm + 1;
                pq.offer(new int[] {nr, nc, nm});
                visited[nr][nc] = true;
            }
        }

        return move;
    }

    private static boolean isOutRange(int r, int c) {
        return r < 0 || r >= l || c < 0 || c >= l;
    }
}
