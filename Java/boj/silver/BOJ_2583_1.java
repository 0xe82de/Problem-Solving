package boj.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * BOJ 2583 영역 구하기
 * S1
 * BFS, DFs
 */

public class BOJ_2583_1 {

    /**
     * 1 <= M, N, K <= 100
     */
    static int M, N, K;

    static boolean[][] paper;

    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        paper = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int secondX = Integer.parseInt(st.nextToken());
            int secondY = Integer.parseInt(st.nextToken());

            for (int x = firstX; x < secondX; x++) {
                for (int y = firstY; y < secondY; y++) {
                    paper[x][y] = true;
                }
            }
        }
//        printPaper();

        List<Integer> counts = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (paper[x][y]) continue;

                counts.add(dfs(x, y, 1));
//                printPaper();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(counts.size()).append("\n")
                .append(counts.stream()
                        .sorted(Comparator.naturalOrder())
                        .map(count -> String.valueOf(count).concat(" "))
                        .collect(Collectors.joining()));

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static int dfs(int x, int y, int count) {
        paper[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + DR[dir];
            int ny = y + DC[dir];

            if (outOfBound(nx, ny) || paper[nx][ny]) continue;

            count = dfs(nx, ny, count + 1);
        }

        return count;
    }

    static boolean outOfBound(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    static void printPaper() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                System.out.print((paper[x][y] ? "1" : "0") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
