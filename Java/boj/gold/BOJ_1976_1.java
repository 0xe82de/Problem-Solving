package boj.gold;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * BOJ 1976 여행 가자
 * G4
 * 자료 구조, 분리 집합
 */

public class BOJ_1976_1 {

    /**
     * 도시의 수
     * N <= 200
     */
    static int N;

    /**
     * 여행 계획에 속한 도시들의 수
     * M <= 1,000
     */
    static int M;

    static int[][] matrix;

    static int[] parents;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = createParents(N);

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());

                if (i != j && matrix[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int parent = find(Integer.parseInt(st.nextToken()) - 1);
        boolean correct = true;
        while (st.hasMoreTokens() && (correct = parent == find(Integer.parseInt(st.nextToken()) - 1))) {}

        // output
        bw.write(correct ? "YES" : "NO");

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

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }

    static int[] createParents(int n) {
        return IntStream.range(0, n + 1)
                .toArray();
    }
}
