package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 3009 네 번째 점
 * B3
 * 구현, 기하학
 */

public class BOJ_3009_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        int[][] pos = new int[2][2];
        int[] third = new int[2];
        for (int i = 0; i < 2; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2; ++i) {
            third[i] = Integer.parseInt(st.nextToken());
            if (pos[0][i] == third[i]) sb.append(pos[1][i]);
            else if (pos[1][i] == third[i]) sb.append(pos[0][i]);
            else sb.append(third[i]);
            sb.append(" ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
