package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 17406 배열 돌리기 4
 * G4
 * 구현, 브루트포스, 백트래킹
 */

public class BOJ_17406_2 {

    static int[][] arr;

    static int minSum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        List<RotateOperator> rotateOperators = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            rotateOperators.add(new RotateOperator(r, c, s));
        }

        perm(rotateOperators, new RotateOperator[K], new boolean[K], 0);

        // output
        bw.write("" + minSum);

        // io close
        bw.close();
        br.close();
    }

    static void perm(List<RotateOperator> rotateOperators, RotateOperator[] selected, boolean[] checked, int cnt) {
        if (cnt == rotateOperators.size()) {
            int[][] copy = copyArray(arr);
            for (RotateOperator rotateOperator : selected) {
                rotateArray(copy, rotateOperator.getSrcRow(), rotateOperator.getSrcCol(), rotateOperator.getRowSize(), rotateOperator.getColSize());
            }

            minSum = Math.min(minSum, calcSum(copy));
            return;
        }

        for (int i = 0; i < rotateOperators.size(); i++) {
            if (checked[i]) {
                continue;
            }

            selected[cnt] = rotateOperators.get(i);
            checked[i] = true;
            perm(rotateOperators, selected, checked, cnt + 1);
            checked[i] = false;
        }
    }

    static int calcSum(int[][] arr) {
        int tempSum = Integer.MAX_VALUE;
        for (int[] line : arr) {
            tempSum = Math.min(tempSum, calcArrSum(line));
        }

        return tempSum;
    }

    static int calcArrSum(int[] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }

        return sum;
    }

    static int[][] copyArray(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        int[][] newArr = new int[rowSize][colSize];
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                newArr[r][c] = arr[r][c];
            }
        }

        return newArr;
    }

    static void rotateArray(int[][] arr, int sr, int sc, int rowSize, int colSize) {
        if (rowSize <= 1 || colSize <= 1) {
            return;
        }

        int backup = arr[sr][sc];
        int dr = sr + rowSize - 1;
        int dc = sc + colSize - 1;

        // left ↑
        for (int r = sr; r < dr; r++) {
            arr[r][sc] = arr[r + 1][sc];
        }

        // bottom ←
        for (int c = sc; c < dc; c++) {
            arr[dr][c] = arr[dr][c + 1];
        }

        // right ↓
        for (int r = dr; r > sr; r--) {
            arr[r][dc] = arr[r - 1][dc];
        }

        // top →
        for (int c = dc; c > sc; c--) {
            arr[sr][c] = arr[sr][c - 1];
        }

        arr[sr][sc + 1] = backup;

        rotateArray(arr, sr + 1, sc + 1, rowSize - 2, colSize - 2);
    }

    static class RotateOperator {

        private final int r;

        private final int c;

        private final int s;

        public RotateOperator(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }

        public int getSrcRow() {
            return r - s - 1;
        }

        public int getSrcCol() {
            return c - s - 1;
        }

        public int getDstRow() {
            return r + s - 1;
        }

        public int getDstCol() {
            return c + s - 1;
        }

        public int getRowSize() {
            return getDstRow() - getSrcRow() + 1;
        }

        public int getColSize() {
            return getDstCol() - getSrcCol() + 1;
        }

        @Override
        public String toString() {
            return "RotateOperator{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    '}';
        }
    }
}
