package solving;

import java.io.*;
import java.util.*;

/**
 * SWEA 5656 벽돌 깨기
 * 모의 SW 역량테스트
 * 구현
 */

public class SWEA_5656_1 {

    // 맵 상수
    static int N, W, H;

    // 맵, 복사할 맵, 중복순열
    static int[][] map, clone;
    static int[] selected;

    // 요소 타입
    static final int EMPTY = 0;

    // 남은 벽돌 최대 값
    static final int INF = Integer.MAX_VALUE;

    // 최소로 계산한 남은 벽돌의 개수
    static int minRemainBrick;

    // 벽돌의 총 개수
    static int cntBrick;

    // 부순 벽돌의 개수
    static int brokenBrick;

    // 방향 델타 상수, 우 하 좌 상
    static int[] DR = {0, 1, 0, -1};
    static int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
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

            map = new int[H][W];
            clone = new int[H][W];
            cntBrick = 0;
            for (int r = 0; r < H; ++r) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < W; ++c) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] != EMPTY) ++cntBrick;
                }
            }

            selected = new int[N];
            minRemainBrick = INF;
            selectCol(0);
            sb.append("#" + tc + " " + minRemainBrick + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void selectCol(int cnt) {
        if (cnt == N) {
            compute();
            return;
        }

        for (int i = 0; i < W; ++i) {
            selected[cnt] = i;
            selectCol(cnt + 1);
        }
    }

    private static void compute() {
        // 맵 복제
        for (int i = 0; i < H; ++i)
            System.arraycopy(map[i], 0, clone[i], 0, W);

        // 벽돌 부수기
        brokenBrick = 0;
        for (int start : selected) smash(start);

        // 남은 벽돌 계산하기
        int tempRemainBrick = cntBrick - brokenBrick;
        if (minRemainBrick > tempRemainBrick)
            minRemainBrick = tempRemainBrick;
    }

    /**
     * 벽돌을 부수고 부순 벽돌의 개수를 저장하고, 빈 공간을 채운다.
     * @param start : 벽돌을 던질 위치 (열)
     */
    private static void smash(int start) {
        int r = 0, c, range;
        int nr, nc, type;
        int[] pos;
        while (r < H && clone[r][start] == EMPTY) ++r;

        // 현재 위치에서 떨어지면 벽돌이랑 만나지 않는다.
        if (r == H) return;

        // 벽돌의 범위가 1이면 그 곳만 부수고 리턴한다.
        if (clone[r][start] == 1) {
            clone[r][start] = EMPTY;
            ++brokenBrick;
            return;
        }

        // 벽돌의 범위가 1보다 크면 주변 벽돌을 부수기 위해 bfs 탐색한다.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, start, clone[r][start]});
        clone[r][start] = EMPTY;
        ++brokenBrick;

        while (!q.isEmpty()) {
            pos = q.poll();
            r = pos[0];
            c = pos[1];
            range = pos[2];

            if (range > 1) {
                for (int dir = 0; dir < 4; ++dir) {
                    nr = r;
                    nc = c;
                    for (int i = 1; i < range; ++i) {
                        nr += DR[dir];
                        nc += DC[dir];

                        // 범위를 벗어나면 그쪽 방향으로는 가지 않는다.
                        if (isOutRange(nr, nc)) break;
                        // 빈 공간이면 continue
                        type = clone[nr][nc];
                        if (type == EMPTY) continue;

                        // 벽돌이 있으면 큐에 넣는다.
                        if (type > 1) q.offer(new int[]{nr, nc, type});
                        clone[nr][nc] = EMPTY;
                        ++brokenBrick;
                    }
                }
            }
        }

        // 빈 공간을 채운다.
        drop();
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
     * clone 맵에서 빈 공간을 채운다.
     */
    private static void drop() {
        Queue<Integer> q =  new LinkedList<>();
        int tr;
        for (int c = 0; c < W; ++c) {
            for (int r = H - 1; r >= 0; --r) {
                if (clone[r][c] != EMPTY) {
                    q.offer(clone[r][c]);
                    clone[r][c] = EMPTY;
                }
            }
            for (int r = H - 1, len = H - q.size(); r >= len; --r) {
                clone[r][c] = q.poll();
            }
        }
    }

    /**
     * 맵 디버깅용
     */
    private static void debug() {
        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                System.out.print(clone[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
