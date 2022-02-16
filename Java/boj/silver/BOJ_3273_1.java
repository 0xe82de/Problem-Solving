package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 3273 두 수의 합
 * S3
 * 정렬, 두 포인터
 */

public class BOJ_3273_1 {

    /**
     * 1 <= n <= 1,000,000
     */
    static int n;

    static int[] sequence;

    /**
     * 1 <= x <= 2,000,000
     */
    static int x;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(br.readLine());

        sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sequence);

        compute();

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    private static void compute() {
        for (int i = 0; i < n; i++) {
            if (sequence[i] >= x) break;
            for (int j = i + 1; j < n; j++) {
                int s1 = sequence[i];
                int s2 = sequence[j];
                if (s1 + s2 > x) break;
                if (s1 + s2 == x) ++count;
            }
        }
    }

}
