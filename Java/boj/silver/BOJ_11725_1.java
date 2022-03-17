package boj.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 11725 트리의 부모 찾기
 * S2
 * 트리, BFS, DFS
 */

public class BOJ_11725_1 {

    /**
     * 2 <= N <= 100,000
     */
    static int N;

    static List<Integer>[] adjList;

    static int[] parents;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        adjList = new ArrayList [N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = null;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        parents = new int[N + 1];
        dfs(1, 0);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(parents).filter(parent -> parent > 0).forEach(parent -> sb.append(parent).append("\n"));

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static void dfs(int child, int parent) {
        parents[child] = parent;
        for (int p : adjList[child]) {
            if (p != parent) {
                dfs(p, child);
            }
        }
    }
}
