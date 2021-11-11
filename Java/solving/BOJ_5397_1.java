package test;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ
 * G5
 * ???
 */

public class template {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // logic


        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
