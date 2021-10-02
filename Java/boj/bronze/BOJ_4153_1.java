package boj.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 4153 직각삼각형
 * B3
 * 수학, 기하학
 */

public class BOJ_4153_1 {

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        int[] numbers = new int[3];
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            numbers[0] = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
            if (numbers[0] == 0) break;
            numbers[1] = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
            numbers[2] = (int)Math.pow(Integer.parseInt(st.nextToken()), 2);

            Arrays.sort(numbers);
            if (numbers[0] + numbers[1] == numbers[2]) sb.append("right");
            else sb.append("wrong");
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
