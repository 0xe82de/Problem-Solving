package boj.gold;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 4485 녹색 옷 입은 애가 젤다지?
 * G4
 * BFS, 다익스트라
 */

public class BOJ_4485_1 {

    // 방향 델타 상수
    static final int[] DR = { 0, 1, 0, -1 };
    static final int[] DC = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        // 2 ≤ N ≤ 125
        int N = 0;

        int tc = 0;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] map = new int[N][N];
            for (int r = 0; r < N; ++r) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < N; ++c) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem " + (++tc) + ": " + getMinDistance(map) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 최소 거리를 계산해서 리턴한다.
     * @param map
     * @return
     */
    private static int getMinDistance(int[][] map) {
        return bfs(map, map.length, map[0].length);
    }

    /**
     * 우선순위큐로 가중치 오름차순으로 bfs 탐색을 하면서 최소 거리를 계산해서 리턴한다.
     * @param map : 맵
     * @param n : 행 사이즈
     * @param m : 열 사이즈
     * @return 최소 거리
     */
    private static int bfs(int[][] map, int n, int m) {
        int result = 0;

        // 가중치(깊이) 순으로 오름차순으로 정렬한다.
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        // 방문 체크용
        boolean[][] visited = new boolean[n][m];

        // 출발지 offer
        visited[0][0] = true;
        q.offer(new int[] { 0, 0, map[0][0]});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cw = cur[2];

            // 우선순위큐로 정렬하기 때문에
            // 처음으로 목적지에 도착했을 대가 가장 거리가 짧을 때이다.
            if (cr == n - 1 && cc == m - 1) {
                result = cw;
                continue;
            }

            for (int dir = 0; dir < 4; ++dir) {
                int nr = cr + DR[dir];
                int nc = cc + DC[dir];

                // 범위를 초과하거나 방문했으면
                if (isOutRange(nr, nc, n, n) || visited[nr][nc]) continue;

                int nw = cw + map[nr][nc];

                visited[nr][nc] = true;
                q.offer(new int[] { nr, nc, nw });
            }
        }

        return result;
    }

    /**
     * 범위를 초과하는지 확인하고 초과여부를 리턴한다.
     * @param r : 현재 행 위치
     * @param c : 현재 열 위치
     * @param n : 행 사이즈
     * @param m : 열 사이즈
     * @return 초과여부
     */
    private static boolean isOutRange(int r, int c, int n, int m) {
        if (r < 0 || r >= n || c < 0 || c >= m) return true;
        return false;
    }

}
