package boj.gold;

import java.io.*;
import java.util.*;
import java.util.function.ToIntFunction;

/**
 * BOJ 1068 트리
 * G5
 * 트리, DFS
 */

public class BOJ_1068_1 {

    /**
     * 트리의 노드의 개수
     * 1 <= N <= 50
     */
    static int N;

    static Map<Integer, List<Integer>> graph;

    static ToIntFunction<String> parseInt = Integer::parseInt;

    static int leafNodesCount;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = parseInt.applyAsInt(br.readLine());

        graph = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int rootNo = 0;
        for (int nodeNo = 0; nodeNo < N; nodeNo++) {
            int parentNo = parseInt.applyAsInt(st.nextToken());

            if (parentNo == -1) {
                rootNo = nodeNo;
                continue;
            }

            if (graph.containsKey(parentNo)) {
                graph.get(parentNo).add(nodeNo);
            } else {
                List<Integer> children = new LinkedList<>();
                children.add(nodeNo);
                graph.put(parentNo, children);
            }
        }

        Integer removeNodeNo = parseInt.applyAsInt(br.readLine());
        if (rootNo != removeNodeNo) {
            graph.remove(removeNodeNo);
            for (int nodeNo : graph.keySet()) {
                List<Integer> children = graph.get(nodeNo);
                if (children.contains(removeNodeNo)) {
                    children.remove(removeNodeNo);
                    break;
                }
            }

            dfs(rootNo);
        }

        // output
        bw.write("" + leafNodesCount);

        // io close
        bw.close();
        br.close();
    }

    private static void dfs(int nodeNo) {
        List<Integer> children = graph.get(nodeNo);
        if (children.isEmpty()) {
            ++leafNodesCount;
            return;
        }

        for (Integer child : children) {
            if (graph.containsKey(child)) {
                dfs(child);
            } else {
                ++leafNodesCount;
            }
        }
    }
}
