package boj.gold;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 5014 스타트링크
 * ??
 * BFS
 */

public class BOJ_5014_1 {

    /**
     * 총 F층
     * 강호가 지금 있는 곳은 S층
     * G층으로 이동해야 한다.
     * 1 <= S, G <= F <= 1,000,000
     */
    static int F;
    static int S;
    static int G;

    /**
     * U층씩 올라갈 수 있다.
     * D층씩 내려갈 수 있다.
     * 0 <= U, D <= 1000000
     */
    static int U;
    static int D;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int count = bfs();
        String result = count >= 0 ? String.valueOf(count) : "use the stairs";

        // output
        bw.write(result);

        // io close
        bw.close();
        br.close();
    }

    static int bfs() {
        int result = -1;
        boolean[] visited = new boolean[F + 1];

        Queue<MoveInfo> moveInfoQueue = new LinkedList<>();
        moveInfoQueue.offer(new MoveInfo(S, 0));
        while (!moveInfoQueue.isEmpty()) {
            MoveInfo moveInfo = moveInfoQueue.poll();
            int floor = moveInfo.getFloor();

            if (floor == G) {
                result = moveInfo.getCount();
                break;
            }

            int count = moveInfo.getCount();

            int upper = floor + U;
            if (upper <= F && !visited[upper]) {
                moveInfoQueue.offer(new MoveInfo(upper, count + 1));
                visited[upper] = true;
            }

            int lower = floor - D;
            if (lower > 0 && !visited[lower]) {
                moveInfoQueue.offer(new MoveInfo(floor - D, count + 1));
                visited[lower] = true;
            }
        }

        return result;
    }

    static class MoveInfo {

        private final int floor;

        private final int count;

        public MoveInfo(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }

        public int getFloor() {
            return floor;
        }

        public int getCount() {
            return count;
        }
    }
}
