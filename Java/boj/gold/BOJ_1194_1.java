package boj.gold;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1194 달이 차오른다, 가자.
 * G1
 * BFS, 비트마스킹
 *
 * 접근 방식
 * 1. bfs 탐색하면서 출구를 찾는다.
 * 2. 잠긴 문이 있으면 열쇠가 있는지 확인하고, 없으면 다시 큐에 넣는다.
 */

public class BOJ_1194_1 {
    
    // 맵 사이즈
    static int N, M;
    
    // 맵
    static char[][] map;

    // 출발지
    static int srcRow, srcCol;

    // 맵 요소 상수
    static final char WALL = '#';
    static final char SRC = '0';
    static final char DST = '1';

    // 방향 델타 상수
    static int[] DR = { 0, 1, 0, -1 };
    static int[] DC = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 <= N, M <= 50
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 2][M + 2];

        // 맵 패딩
        for (int r = 0; r < N + 2; ++r) {
            Arrays.fill(map[r], WALL);
        }

        // 맵 초기화
        for (int r = 1; r <= N; ++r) {
            char[] temp = br.readLine().toCharArray();
            for (int c = 1; c <= M; ++c) {
                map[r][c] = temp[c - 1];

                if (map[r][c] == SRC) {
                    srcRow = r;
                    srcCol = c;
                }
            }
        }

        // output
        bw.write(String.valueOf(bfs()));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 최소 거리를 계산해서 리턴한다.
     * @return 탈출 할 수 있으면 최소거리를 리턴하고, 탈출하지 못하면 -1을 리턴한다.
     */
    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N + 2][M + 2][1 << 6];

        int result = Integer.MAX_VALUE;

        // r, c, key, 거리
        q.offer(new int[] { srcRow, srcCol, 0, 0 });
        visited[srcRow][srcCol][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int k = cur[2];
            int d = cur[3];
            
            // 출구이면
            if (map[r][c] == DST && result > d) {
                result = d;
                continue;
            }

            for (int dir = 0; dir < 4; ++dir) {
                int nr = r + DR[dir];
                int nc = c + DC[dir];
                int nk = k;

                // 방문했거나 벽이면 continue
                if (visited[nr][nc][nk] || map[nr][nc] == WALL) continue;

                // 문이면
                if ('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
                    int door = map[nr][nc] - 'A';

                    // 열쇠가 없으면 continue
                    if ((nk & 1 << door) == 0) continue;
                }

                // 열쇠이면
                else if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
                    nk |= (1 << (map[nr][nc] - 'a'));
                }

                // 방문체크
                visited[nr][nc][nk] = true;
                q.offer(new int[] { nr, nc, nk, d + 1 });
            }
        }
        
        // result가 갱신되지 않았으면 -1 리턴
        if (result == Integer.MAX_VALUE) return -1;
        else return result;
    }

    /**
     * 맵 디버깅용
     */
    private static void debug() {
        for (int r = 0; r < N + 2; ++r) {
            for (int c = 0; c < M + 2; ++c) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
