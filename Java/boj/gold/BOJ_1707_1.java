package boj.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * BOJ 1707 이분 그래프
 * G4
 * DFS, BFS
 */

public class BOJ_1707_1 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 테스트 케이스의 개수
         */
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            /**
             * V : 정점의 개수
             * E : 간선의 개수
             */
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            List<List<Integer>> lists = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                lists.add(new ArrayList<>());
            }

            while (E-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;

                lists.get(from).add(to);
                lists.get(to).add(from);
            }

            int[] colors = new int[V];
            boolean bipartiteGraph = true;
            for (int base = 0; base < V; base++) {
                if (colors[base] == 0 && !dfs(lists, base, colors, 1)) {
                    bipartiteGraph = false;
                    break;
                }
            }

            sb.append(bipartiteGraph ? "YES" : "NO");
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static boolean dfs(List<List<Integer>> lists, int base, int[] colors, int color) {
        colors[base] = color;

        for (int next : lists.get(base)) {
            if (colors[next] == color) {
                return false;
            }

            if (colors[next] == 0 && !dfs(lists, next, colors, color * -1)) {
                return false;
            }
        }

        return true;
    }
}