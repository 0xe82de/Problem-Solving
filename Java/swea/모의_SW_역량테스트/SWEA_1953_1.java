package swea.모의_SW_역량테스트;

import java.io.*;
import java.util.*;

/**
 * SWEA 1953 탈주범 검거
 * 모의 SW 역량테스트
 * BFS
 */

public class SWEA_1953_1 {

    // 맵 상수
    static final int EMPTY = 0;
    static final int DEL = -1;

    // 방향 상수
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;

    // 방향 델타 상수, 상 우 하 좌
    static final int[] DR = { -1, 0, 1, 0 };
    static final int[] DC = { 0, 1, 0, -1 };

    // 터널 타입에 따라 확인해야할 방향 범위
    static final int[] SRC_TUNNEL = { 0, UP,    UP,     RIGHT,  UP,     RIGHT,  DOWN,   UP };
    static final int[] DST_TUNNEL = { 0, LEFT,  DOWN,   LEFT,   RIGHT,  DOWN,   LEFT,   LEFT };

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; ++tc) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            for (int r = 0; r < N; ++r) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < M; ++c) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + tc + " " + getCount(map, R, C, L) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * bfs 탐색을 하면서 주어진 시간 내에 도달할 수 있는 곳을 카운팅하고 리턴한다.
     * @param map : 맵
     * @param srcRow : 출발 위치 (행)
     * @param srcCol : 출발 위치 (열)
     * @param maxTime : 주어진 시간
     * @return 도달할 수 있는 곳의 개수
     */
    private static int getCount(int[][] map, int srcRow, int srcCol, int maxTime) {
        int count = 0;

        int n = map.length;
        int m = map[0].length;

        // bfs
        Queue<int[]> pq = new LinkedList<>();

        // 출발지, 목적지, 걸린 시간
        pq.offer(new int[] { srcRow, srcCol, map[srcRow][srcCol], 1 });
        map[srcRow][srcCol] = DEL;
        ++count;

        int cr, cc, cTime, cType;
        int nr, nc, nType;
        int srcDir, dstDir;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            cr = cur[0];
            cc = cur[1];
            cType = cur[2];
            cTime = cur[3];

            // 현재까지 오는데 걸린 시간이 최대 시간과 동일하면 continue
            if (cTime == maxTime) continue;

            // 타입이 1 또는 4 ~ 7일 경우
            srcDir = SRC_TUNNEL[cType];
            dstDir = DST_TUNNEL[cType];
            for (int dir = srcDir; dir <= dstDir; ++dir) {
                nr = cr + DR[dir];
                nc = cc + DC[dir];
                try {
                    // 범위를 초과하거나 터널이 없으면
                    if (isOutRange(nr, nc, n, m) || map[nr][nc] == EMPTY || map[nr][nc] == DEL) continue;

                    // 다음 터널로 갈 수 있는지 확인한다.
                    nType = map[nr][nc];
                    if (dir == UP || dir == DOWN) {
                        if (nType == 3) continue;
                        if (dir == UP && (nType == 4 || nType == 7)) continue;
                        else if (dir == DOWN && (nType == 5 || nType == 6)) continue;
                    } else {
                        if (nType == 2) continue;
                        if (dir == RIGHT && (nType == 4 || nType == 5)) continue;
                        else if (dir == LEFT && (nType == 6 || nType == 7)) continue;
                    }

                    // 큐에 넣고 카운트를 증가시킨다.
                    pq.offer(new int[] { nr, nc, nType, cTime + 1 });
                    map[nr][nc] = DEL; // 방문체크
                    ++count;
                } finally {
                    // 타입이 2 또는 3일 때는 방향 변수를 1 증가시킨다.
                    if (2 <= cType && cType <= 3) ++dir;
                    if (cType == 7) dir += 2;
                }
            }
        }

        return count;
    }

    /**
     * 맵 초과 여부 확인
     * @param r : 현재 행 위치
     * @param c : 현재 열 위치
     * @param n : 행 크기
     * @param m : 열 크기
     * @return 초과 여부
     */
    private static boolean isOutRange(int r, int c, int n, int m) {
        if (r < 0 || r >= n || c < 0 || c >= m) return true;
        else return false;
    }

    /**
     * 맵 디버깅용
     * @param map : 맵
     */
    private static void debug(int[][] map) {
        for (int r = 0, n = map.length; r < n; ++r) {
            for (int c = 0, m = map[r].length; c < m; ++c) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
