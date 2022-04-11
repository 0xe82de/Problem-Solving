package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1072 게임
 * S3
 * 수학, 이분 탐색
 */

public class BOJ_1072_1 {

    /**
     * 1 <= X <= 1e9
     */
    static long X;

    /**
     * 0 <= Y <= X
     */
    static long Y;

    static long Z;

    static long minCount = -1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        Z = Y * 100 / X;

        binarySearch(1, (long) 1e9);

        // output
        bw.write(String.valueOf(minCount));

        // io close
        bw.close();
        br.close();
    }

    static void binarySearch(long start, long end) {
        if (start > end) {
            return;
        }

        long mid = (start + end) / 2;
        long newZ = getNewZ(mid);
        if (Z < newZ) {
            minCount = mid;
            binarySearch(start, mid - 1);
        } else if (Z == newZ) {
            binarySearch(mid + 1, end);
        }
    }

    static long getNewZ(long count) {
        return (Y + count) * 100 / (X + count);
    }
}
