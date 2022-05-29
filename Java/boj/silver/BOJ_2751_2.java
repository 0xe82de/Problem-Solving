package boj.silver;

import java.io.*;

/**
 * BOJ 2751 수 정렬하기 2
 * S5
 * 정렬
 */

public class BOJ_2751_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 수의 개수
         * 1 <= N <= 1,000,000
         */
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        heapSort(arr);

        StringBuilder sb = new StringBuilder();
        for (int number : arr) {
            sb.append(number).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static void heapSort(int[] arr) {
        heapSort(arr, arr.length);
    }

    static void heapSort(int[] arr, int size) {
        if (size < 2) {
            return;
        }

        int parentIndex = getParent(size - 1);

        for (int i = parentIndex; i >= 0; i--) {
            heapify(arr, i, size - 1);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i - 1);
        }
    }

    static int getParent(int child) {
        return (child - 1) / 2;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void heapify(int[] arr, int parentIndex, int lastIndex) {
        int leftChildIndex = 0;
        int rightChildIndex = 0;
        int largestIndex = 0;

        while ((parentIndex * 2) + 1 <= lastIndex) {
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
            largestIndex = parentIndex;

            if (arr[leftChildIndex] > arr[largestIndex]) {
                largestIndex = leftChildIndex;
            }

            if (rightChildIndex <= lastIndex && arr[rightChildIndex] > arr[largestIndex]) {
                largestIndex = rightChildIndex;
            }

            if (largestIndex != parentIndex) {
                swap(arr, parentIndex, largestIndex);
                parentIndex = largestIndex;
            } else {
                break;
            }
        }
    }
}
