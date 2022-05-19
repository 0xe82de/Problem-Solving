package programmers.level3;

/**
 * PROGRAMMERS 43162 네트워크
 * Level 3
 * DFS
 */

public class PROGRAMMERS_43162_2 {

    public static void main(String[] args) {
        // input
        int[] n = {3, 3};
        int[][][] computers = {
                {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}},
                {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}
        };
        int[] result = {2, 1};

        for (int i = 0; i < 2; i++) {
            // logic
            int answer = solution(n[i], computers[i]);

            // output
            System.out.println((result[i] == answer) + "\t answer = " + answer);
        }
    }

    static public int solution(int n, int[][] computers) {
        int answer = 0;

        answer = getAnswer(n, computers);

        return answer;
    }

    static int getAnswer(int n, int[][] computers) {
        int count = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(n, i, computers, visited);
            ++count;
        }

        return count;
    }

    static void dfs(int n, int node, int[][] computers, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (visited[i] || computers[node][i] == 0) continue;
            visited[i] = true;
            dfs(n, i, computers, visited);
        }
    }
}
