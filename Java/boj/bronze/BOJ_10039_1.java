package boj.bronze;

import java.io.*;

/**
 * BOJ 10039 평균 점수
 * B4
 * 수학
 */

public class BOJ_10039_1 {

    static final int INPUT_COUNT = 5;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int sum = 0;
        for (int i = 0; i < INPUT_COUNT; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input >= 40) {
                sum += input;
            } else {
                sum += 40;
            }
        }

        // output
        bw.write(String.valueOf(sum / INPUT_COUNT));

        // io close
        bw.close();
        br.close();
    }

}
