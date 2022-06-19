package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 9205 맥주 마시면서 걸어가기
 * S1
 * BFS
 */

public class BOJ_9205_1 {

    /**
     * 테스트 케이스의 개수
     * t <= 50
     */
    static int t;

    /**
     * 맥주를 파는 편의점의 개수
     * 0 <= n <= 100
     */
    static int n;

    static List<Point> points;

    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            points = new ArrayList<>();

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                points.add(new Point(x, y));
            }

            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (manhattanDistance(points.get(i), points.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            sb.append(bfs() ? "happy" : "sad").append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            if (current == n + 1) {
                return true;
            }

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }

        return false;
    }

    static int manhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    static class Point {

        private final int x;

        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
