package boj.bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1085 직사각형에서 탈출
 * B3
 * 수학, 기하학
 */

public class BOJ_1085_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        // logic
        int minValue = 0;
        int[] pos = new int[2];
        int[] len = new int[2];
        st = new StringTokenizer(br.readLine());
        pos[0] = Integer.parseInt(st.nextToken());
        pos[1] = Integer.parseInt(st.nextToken());
        len[0] = Integer.parseInt(st.nextToken());
        len[1] = Integer.parseInt(st.nextToken());

        minValue = pos[0];
        if (minValue > len[0] - pos[0]) minValue = len[0] - pos[0];
        if (minValue > pos[1]) minValue = pos[1];
        if (minValue > len[1] - pos[1]) minValue = len[1] - pos[1];

        // output
        bw.write(String.valueOf(minValue));

        // io close
        bw.close();
        br.close();
    }
}
