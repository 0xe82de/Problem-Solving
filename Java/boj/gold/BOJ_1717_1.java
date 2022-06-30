package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1717 집합의 표현
 * G4
 * 자료 구조, 분리 집합
 */

public class BOJ_1717_1 {

    /**
     * 노드의 개수
     * 1 <= n <= 1,000,000
     */
    static int n;

    /**
     * 연산의 개수
     * 1 <= m <= 100,000
     */
    static int m;

    static int[] parents;

    static final int UNION = 0;

    static final int FIND = 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        clearParents(n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == UNION) {
                union(a, b);
            } else if (command == FIND) {
                sb.append(isUnion(a, b) ? "YES" : "NO").append("\n");
            } else {
                throw new IllegalStateException();
            }
        }


        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static boolean isUnion(int a, int b) {
        return find(a) == find(b);
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

    static int find(int child) {
        if (child == parents[child]) {
            return parents[child];
        } else {
            return parents[child] = find(parents[child]);
        }
    }

    static void clearParents(int n) {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }
}
