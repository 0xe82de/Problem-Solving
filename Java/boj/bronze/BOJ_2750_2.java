package boj.bronze;

import java.io.*;

/**
 * BOJ 2750 수 정렬하기
 * B1
 * 구현, 정렬
 */

public class BOJ_2750_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        final int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(arr);

        for (int i = 0; i < N; ++i) {
            sb.append(arr[i] + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 거품 정렬
     * @param arr : 정렬할 배열
     */
    private static void bubbleSort(int[] arr) {
        final int SIZE = arr.length - 1;
        int temp;
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
