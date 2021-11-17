package boj.silver;

import java.io.*;

/**
 * BOJ 17413 단어 뒤집기 2
 * S3
 * 구현, 문자열
 */

public class BOJ_17413_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder output = new StringBuilder();
        StringBuilder reverse = new StringBuilder();

        boolean isTag = false;
        char ch = ' ';
        char[] input = br.readLine().toCharArray();
        for (int i = 0, SIZE = input.length; i < SIZE; ++i) {
            ch = input[i];
            if (ch == '<' || ch == ' ') {
                output.append(reverse.reverse().toString());
                reverse.setLength(0);
                if (ch == '<') {
                    isTag = true;
                }
                else if (ch == ' ') {
                    output.append(' ');
                    continue;
                }
            }
            else if (ch == '>') {
                output.append(ch);
                isTag = false;
                continue;
            }

            if (isTag) output.append(ch);
            else reverse.append(ch);
        }
        if (reverse.length() > 0) {
            output.append(reverse.reverse().toString());
        }

        // output
        bw.write(output.toString());

        // io close
        bw.close();
        br.close();
    }
}
