package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1920 수 찾기
 * S4 
 * 이분 탐색
 */

public class BOJ_1920_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        br.readLine();
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            sb.append(isExist(numbers, Integer.parseInt(st.nextToken())) ? "1" : "0").append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static boolean isExist(int[] numbers, int target) {
        return binarySearch(numbers, target, 0, (numbers.length - 1) / 2, numbers.length - 1);
    }

    private static boolean binarySearch(int[] numbers, int target, int left, int mid, int right) {
        if (left > right) {
            return false;
        }

        int midNumber = numbers[mid];
        if (target == midNumber) {
            return true;
        }
        else if (target < midNumber) {
            return binarySearch(numbers, target, left, (left + mid - 1) / 2, mid - 1);
        }
        else {
            return binarySearch(numbers, target, mid + 1, (mid + 1 + right) / 2, right);
        }
    }

}
