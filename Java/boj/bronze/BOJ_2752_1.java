package boj.bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2752 세수정렬
 * B4
 * 정렬
 */

public class BOJ_2752_1 {
    
    static int SIZE = 3;
    
    static int[] numbers = new int[SIZE];

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(numbers);
        Arrays.stream(numbers).forEach(number -> sb.append(number).append(" "));

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
