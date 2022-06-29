package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 1238 파티
 * G3
 * 다익스트라
 */

public class BOJ_1238_1 {

    /**
     * 학생의 수
     * 1 <= N <= 1,000
     */
    static int N;

    /**
     * 단방향 도로의 수
     * 1 <= M <= 10,000
     */
    static int M;

    /**
     * 파티 마을
     * 1 <= X <= N
     */
    static int X;

    static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            graph.get(src).add(new Node(dst, cost));
            reverseGraph.get(dst).add(new Node(src, cost));
        }

        int[] xToOthersDistances = dijkstra(graph, X);
        int[] othersToXDistances = dijkstra(reverseGraph, X);
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, xToOthersDistances[i] + othersToXDistances[i]);
        }

        // output
        bw.write("" + result);

        // io close
        bw.close();
        br.close();
    }

    static int[] dijkstra(List<List<Node>> graph, int src) {
        int[] distances = new int[N];
        Arrays.fill(distances, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));
        distances[src] = 0;

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
