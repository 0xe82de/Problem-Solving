package swea.모의_SW_역량테스트;

import java.io.*;
import java.util.*;

/**
 * SWEA 5656 벽돌 깨기
 * 모의 SW 역량테스트
 * 구현, BFS
 */

public class SWEA_5656_1 {

    // 맵 상수
    static int N, W, H;

    // 요소 타입
    static final int EMPTY = 0;

    // 남은 벽돌 최대 값
    static final int INF = Integer.MAX_VALUE;

    // 최소로 계산한 남은 벽돌의 개수
    static int minRemainBrick;

    // 방향 델타 상수, 우 하 좌 상
    static int[] DR = {0, 1, 0, -1};
    static int[] DC = {1, 0, -1, 0};

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
            // 1 <= N <= 4
            N = Integer.parseInt(st.nextToken());
            // 2 <= W <= 12
            W = Integer.parseInt(st.nextToken());
            // 2 <= H <= 15
            H = Integer.parseInt(st.nextToken());

            int[][] map = new int[H][W];
            for (int r = 0; r < H; ++r) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < W; ++c) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            minRemainBrick = INF;
            selectCol(map, 0);
            sb.append("#" + tc + " " + minRemainBrick + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 벽돌을 떨어뜨릴 위치(열)를 정하고 계산한다.
     * @param map : 현재까지 벽돌을 떨어뜨려본 맵
     * @param cnt : 벽돌을 떨어뜨린 회수
     */
    private static void selectCol(int[][] map, int cnt) {
        // 벽돌을 모두 떨어뜨리면
        if (cnt == N) {
            minRemainBrick = Math.min(minRemainBrick, getCntRemainBrick(map));
            return;
        }

        for (int i = 0; i < W; ++i) {
            // 맵을 복사한다.
            int[][] clone = copyMap(map);

            // 복사한 맵으로 벽돌을 떨어뜨리고 빈 공간을 채운다.
            compute(clone, i);

            // 시뮬레이션 돌린 맵으로 다음 벽돌을 떨어뜨린다.
            selectCol(clone, cnt + 1);
        }
    }

    /**
     * 맵을 복사해서 리턴한다.
     * @param map : 현재 맵
     * @return 복사된 맵
     */
    private static int[][] copyMap(int[][] map) {
        int[][] clone = new int[H][W];
        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                clone[r][c] = map[r][c];
            }
        }
        return clone;
    }

    /**
     * 벽돌을 부수고 빈 공간을 채운다.
     * @param map
     * @param start
     */
    private static void compute(int[][] map, int start) {
        // 벽돌 부수기
        smash(map, start);

        // 빈 공간 채우기
        drop(map);
    }

    /**
     * 벽돌을 부수고 부순 벽돌의 개수를 저장하고, 빈 공간을 채운다.
     * @param start : 벽돌을 던질 위치 (열)
     */
    private static void smash(int[][] map, int start) {
        int r = 0;
        while (r < H && map[r][start] == EMPTY) ++r;
        // 현재 위치에서 떨어지면 벽돌이랑 만나지 않는다.
        if (r == H) return;

        int c, range;
        int nr, nc, type;
        int[] pos;

        // 벽돌의 범위가 1이면 그 곳만 부수고 리턴한다.
        if (map[r][start] == 1) {
            map[r][start] = EMPTY;
            return;
        }

        // 벽돌의 범위가 1보다 크면 주변 벽돌을 부수기 위해 bfs 탐색한다.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, start, map[r][start]});
        map[r][start] = EMPTY;

        while (!q.isEmpty()) {
            pos = q.poll();
            r = pos[0];
            c = pos[1];
            range = pos[2];

            for (int dir = 0; dir < 4; ++dir) {
                nr = r;
                nc = c;
                for (int i = 1; i < range; ++i) {
                    nr += DR[dir];
                    nc += DC[dir];

                    // 범위를 벗어나면 그쪽 방향으로는 가지 않는다.
                    if (isOutRange(nr, nc)) break;
                    // 빈 공간이면 continue
                    type = map[nr][nc];
                    if (type == EMPTY) continue;

                    // 벽돌이 있으면 큐에 넣는다.
                    if (type > 1) q.offer(new int[]{nr, nc, type});
                    map[nr][nc] = EMPTY;
                }
            }
        }
    }

    /**
     * 범위를 초과하는지 확인하고 결과를 리턴한다.
     * @param r : 현재 행 위치
     * @param c : 현재 열 위치
     * @return 초과 여부
     */
    private static boolean isOutRange(int r, int c) {
        return r < 0 || r >= H || c < 0 || c >= W;
    }

    /**
     * 맵에서 빈 공간을 채운다.
     */
    private static void drop(int[][] map) {
        Queue<Integer> q =  new LinkedList<>();
        int tr;
        for (int c = 0; c < W; ++c) {
            for (int r = H - 1; r >= 0; --r) {
                if (map[r][c] != EMPTY) {
                    q.offer(map[r][c]);
                    map[r][c] = EMPTY;
                }
            }
            for (int r = H - 1, len = H - q.size(); r >= len; --r) {
                map[r][c] = q.poll();
            }
        }
    }

    /**
     * 맵에서 남은 벽돌의 개수를 리턴한다.
     * @param map : 현재 맵
     * @return 벽돌의 개수
     */
    private static int getCntRemainBrick(int[][] map) {
        int cnt = 0;
        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                if (map[r][c] != EMPTY) ++cnt;
            }
        }
        return cnt;
    }

    /**
     * 맵 디버깅용
     */
    private static void debug(int[][] map) {
        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
