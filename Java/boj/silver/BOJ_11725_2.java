package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 11725 트리의 부모 찾기
 * S2
 * 트리, BFS, DFS
 */

public class BOJ_11725_2 {

    /**
     * 노드의 개수
     * 2 <= N <= 100,000
     */
    static int N;

    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;

            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }

        int[] parents = bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            sb.append(parents[i] + 1)
                    .append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static int[] bfs() {
        int[] parents = new int[N];
        boolean[] visited = new boolean[N];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int parent = q.poll();

            for (int child : graph.get(parent)) {
                if (visited[child]) {
                    continue;
                }

                q.offer(child);
                parents[child] = parent;
                visited[child] = true;
            }
        }

        return parents;
    }
}
