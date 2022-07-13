package boj.silver;

import java.io.*;

/**
 * BOJ 21314 민겸 수
 * S2
 * 구현, 그리디
 */

public class BOJ_21314_1 {

    private static final char M = 'M';

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        char[] mks = br.readLine().toCharArray();

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        int mCount = 0;
        for (char mk : mks) {
            if (mk == M) {
                ++mCount;
            } else {
                if (mCount == 0) {
                    max.append(5);
                    min.append(5);
                } else {
                    max.append(5);
                    for (int i = 0; i < mCount; i++) {
                        max.append(0);
                    }

                    min.append(1);
                    for (int i = 1; i < mCount; i++) {
                        min.append(0);
                    }
                    min.append(5);

                    mCount = 0;
                }
            }
        }

        if (mCount > 0) {
            min.append(1);
            for (int i = 1; i < mCount; i++) {
                min.append(0);
            }

            while (mCount-- > 0) {
                max.append(1);
            }
        }

        // output
        bw.write(max + "\n" + min);

        // io close
        bw.close();
        br.close();
    }
}
