package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 9934 완전 이진 트리
 * S1
 * 트리, 재귀
 */

public class BOJ_9934_1 {

    static ToIntFunction<String> parseInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 깊이
         * 1 <= K <= 10
         */
        final int K = parseInt.applyAsInt(br.readLine());
        final int SIZE = (int)Math.pow(2, K) - 1;
        int[] tree = new int[SIZE + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> orders = new LinkedList<>();
        while (st.hasMoreTokens()) {
            orders.offer(parseInt.applyAsInt(st.nextToken()));
        }

        inorder(1, SIZE, tree, orders);

        StringBuilder sb = new StringBuilder();
        int level = 1;
        for (int i = 1; i <= SIZE; i++) {
            sb.append(tree[i]);
            if (Math.pow(2, level) - 1 == i) {
                ++level;
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }

    private static void inorder(int order, int size, int[] tree, Queue<Integer> orders) {
        if (order * 2 <= size) {
            inorder(order * 2, size, tree, orders);
        }

        tree[order] = orders.poll();

        if (order * 2 + 1 <= size) {
            inorder(order * 2 + 1, size, tree, orders);
        }
    }
}
