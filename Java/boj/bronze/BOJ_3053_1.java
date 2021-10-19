package boj.bronze;

import java.io.*;

/**
 * BOJ 택시 기하학
 * B3
 * 수학, 기하학
 */

public class BOJ_3053_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        final double R = Double.parseDouble(br.readLine());
        sb.append(String.format("%.6f", Math.PI * R * R ) + "\n");
        sb.append(String.format("%.6f", R * R * 2));

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
