package boj.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * BOJ 1197 최소 스패닝 트리
 * G4
 * 최소 스패닝 트리
 */

public class BOJ_1197_2 {

    /**
     * 정점의 개수
     * 1 <= v <= 10,000
     */
    static int V;

    /**
     * 간선의 개수
     * 1 <= E <= 100,000
     */
    static int E;

    static int[] parents;

    static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        edges = new ArrayList<>(E);
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(src, dst, cost));
        }
        edges.sort(null);

        parents = createParents(V);
        long output = 0L;
        for (Edge edge : edges) {
            int src = edge.getSrc();
            int dst = edge.getDst();

            if (isUnion(src, dst)) {
                continue;
            }

            union(src, dst);
            output += edge.getCost();
        }

        // output
        bw.write("" + output);

        // io close
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    static boolean isUnion(int a, int b) {
        return find(a) == find(b);
    }

    static int find(int child) {
        if (child == parents[child]) {
            return child;
        } else {
            return parents[child] = find(parents[child]);
        }
    }

    static int[] createParents(int i) {
        return IntStream.range(0, i + 1)
                .toArray();
    }

    static class Edge implements Comparable<Edge> {

        private final int src;

        private final int dst;

        private final long cost;

        public Edge(int src, int dst, long cost) {
            this.src = src;
            this.dst = dst;
            this.cost = cost;
        }

        public int getSrc() {
            return src;
        }

        public int getDst() {
            return dst;
        }

        public long getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.getCost(), o.getCost());
        }
    }
}
