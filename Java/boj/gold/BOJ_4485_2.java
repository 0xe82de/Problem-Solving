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
 * 
 * 접근 방식
 * 1. 다익스트라
 */

public class BOJ_4485_2 {

    // 방향 델타 상수
    static final int[] DR = { 0, 1, 0, -1 };
    static final int[] DC = { 1, 0, -1, 0 };

    // 맵 상수
    static final int INF = Integer.MAX_VALUE;

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

            sb.append("Problem " + (++tc) + ": " + dijkstra(map, 0, 0) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 다익스트라에 우선순위큐를 적용하고 탐색하면서 최소 거리를 리턴한다.
     * @param map : 맵
     * @param srcRow : 행 사이즈
     * @param srcCol : 열 사이즈
     * @return 최소 거리
     */
    private static int dijkstra(int[][] map, int srcRow, int srcCol) {
        int n = map.length;
        int m = map[0].length;

        // 방문 체크용
        boolean[][] visited = new boolean[n][m];

        // 거리 계산
        int[][] minTime = new int[n][m];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(minTime[i], INF);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2]; // 가중치가 양수이기 때문에 이렇게 해도 된다.
            }
        });

        // 출발지
        minTime[srcRow][srcCol] = map[srcRow][srcCol];
        pq.offer(new int[] { srcRow, srcCol, minTime[srcRow][srcCol] });

        int r = 0, c = 0;
        int minCost = 0;
        int nr, nc;
        while (true) {
            int[] cur = pq.poll();
            r = cur[0];
            c = cur[1];
            minCost =  cur[2];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            // 도착하면 리턴한다.
            // 우선순위큐를 사용하므로 가장 빨리 나오는 값이 최소값이다.
            if (r == n - 1 && c == m - 1) return minCost;

            // 사방탐색하면서 새롭게 계산된 거리가 기존의 거리보다 작으면 갱신하고 pq에 넣는다.
            for (int dir = 0; dir < 4; ++dir) {
                nr = r + DR[dir];
                nc = c + DC[dir];

                if (
                        !isOutRange(nr, nc, n, m) &&
                                !visited[nr][nc] &&
                                minTime[nr][nc] > minCost + map[nr][nc]
                ) {
                    minTime[nr][nc] = minCost + map[nr][nc];
                    pq.offer(new int[] { nr, nc, minTime[nr][nc] });
                }
            }
        }

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
