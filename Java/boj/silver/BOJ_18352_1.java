package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 18352 특정 거리의 도시 찾기
 * S2
 * BFS, 다익스트라
 */

public class BOJ_18352_1 {

    /**
     * 도시의 개수
     * 2 <= N <= 300,000
     */
    static int N;

    /**
     * 도로의 개수
     * 1 <= M <= 1,000,000
     */
    static int M;

    /**
     * 거리 정보
     * 1 <= K <= 300,000
     */
    static int K;

    /**
     * 출발 도시의 번호
     * 1 <= X <= N
     */
    static int X;

    static final int DISTANCE = 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;

            graph.get(src).add(new Node(dst, DISTANCE));
        }

        int[] distances = dijkstra(graph, X);

        StringBuilder sb = new StringBuilder();
        for (int cityIndex = 0; cityIndex < N; cityIndex++) {
            if (distances[cityIndex] == K) {
                sb.append(cityIndex + 1).append("\n");
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static int[] dijkstra(List<List<Node>> graph, int src) {
        final int INF = (int) 1e9;

        int[] distances = new int[N];
        Arrays.fill(distances, INF);
        distances[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIndex = current.getIndex();

            if (distances[currentIndex] < current.getDistance()) {
                continue;
            }

            for (Node currentToNext : graph.get(currentIndex)) {
                int transferDistance = distances[currentIndex] + currentToNext.getDistance();
                int nextIndex = currentToNext.getIndex();

                if (transferDistance < distances[nextIndex]) {
                    distances[nextIndex] = transferDistance;
                    pq.offer(new Node(nextIndex, transferDistance));
                }
            }
        }

        return distances;
    }

    static class Node implements Comparable<Node> {

        private final int index;

        private final int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getDistance(), o.getDistance());
        }
    }
}
