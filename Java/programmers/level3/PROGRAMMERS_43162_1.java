package programmers.level3;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * PROGRAMMERS 43162 네트워크
 * Level 3
 * DFS, BFS
 */

public class PROGRAMMERS_43162_1 {

    public static void main(String[] args) {
        // input
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        // logic
        int answer = solution(n, computers);

        // output
        System.out.println("answer = " + answer);
    }

    static int[] networks;

    static public int solution(int n, int[][] computers) {
        int answer = 0;

        make(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        answer = (int) Arrays.stream(networks)
                .map(network -> networks[network])
                .distinct()
                .count();

        return answer;
    }

    static void make(int n ) {
        networks = IntStream.range(0, n).toArray();
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            networks[y] = x;
        } else {
            networks[x] = y;
        }
    }

    static int find(int x) {
        if (networks[x] == x) return x;
        return networks[x] = find(networks[x]);
    }
}
