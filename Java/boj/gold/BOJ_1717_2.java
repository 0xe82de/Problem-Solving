package boj.gold;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * BOJ 1717 집합의 표현
 * G4
 * 자료 구조, 분리 집합
 */

public class BOJ_1717_2 {

    /**
     * 집합의 개수
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

    static final int UNION_CHECK = 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = createParents(n);

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command) {
                case UNION:
                    union(a, b);
                    break;
                case UNION_CHECK:
                    sb.append(isUnion(a, b) ? "YES" : "NO")
                            .append("\n");
                    break;
                default:
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
            return child;
        } else {
            return parents[child] = find(parents[child]);
        }
    }

    private static int[] createParents(int n) {
        return IntStream.range(0, n + 1)
                .toArray();
    }
}
