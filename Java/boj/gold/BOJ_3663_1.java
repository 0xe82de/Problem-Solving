package boj.gold;

import java.io.*;

/**
 * BOJ 3663 고득점
 * G4
 * 문자열, 그리디, 브루트포스
 */

public class BOJ_3663_1 {

    static final char TARGET = 'A';

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String name = br.readLine();

            int answer = 0;

            int SIZE = name.length();
            int move = SIZE - 1;

            int index = 0;

            for (int i = 0; i < SIZE; i++) {
                answer += Math.min(name.charAt(i) - TARGET, 'Z' - name.charAt(i) + 1);

                index = i + 1;
                while (index < SIZE && name.charAt(index) == TARGET) {
                    index++;
                }

                move = Math.min(move, i * 2 + SIZE - index);
                move = Math.min(move, (SIZE - index) * 2 + i);
            }

            answer += move;

            sb.append(answer).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
