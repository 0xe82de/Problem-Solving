package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1932 정수 삼각형
 * S1
 * DP
 */

public class BOJ_1932_1 {

    /**
     * 1 <= N <= 500
     */
    static int n;

    static int SIZE;

    /**
     * 0 <= node <= 9999
     */
    static int[][] node;

    static int[] dp;

    static final int DATA = 0;

    static final int FLOOR = 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        n = Integer.parseInt(br.readLine());
        SIZE = n * (n + 1) / 2;

        node = new int[SIZE + 1][2];
        dp = new int[SIZE + 1];

        StringTokenizer st = null;
        int index = 1;
        for (int floor = 1; floor <= n; floor++) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                node[index][DATA] = Integer.parseInt(st.nextToken());
                node[index][FLOOR] = floor;
                index++;
            }
        }

        int maxSum = compute();

        // output
        bw.write(String.valueOf(maxSum));

        // io close
        bw.close();
        br.close();
    }

    static int compute() {
        dp[1] = node[1][DATA];
        if (n == 1) return dp[1];

        int leftParentIndex = 0, rightParentIndex = 0;
        int leftParent = 0, rightParent = 0;
        int currentFloor = 0;
        for (int childIndex = 2; childIndex <= SIZE; childIndex++) {
            leftParent = rightParent = 0;
            currentFloor = node[childIndex][FLOOR];

            leftParentIndex = childIndex - currentFloor;
            if (node[leftParentIndex][FLOOR] + 1 == currentFloor) {
                leftParent = dp[leftParentIndex];
            }

            rightParentIndex = leftParentIndex + 1;
            if (node[rightParentIndex][FLOOR] + 1 == currentFloor) {
                rightParent = dp[rightParentIndex];
            }

            dp[childIndex] = node[childIndex][DATA] + Math.max(leftParent, rightParent);
        }

        int maxSum = 0;
        for (int i = SIZE; i > SIZE - n; i--) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
