package boj.silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * BOJ 10867 중복 빼고 정렬하기
 * S5
 * 정렬
 */

public class BOJ_10867_1 {

    /**
     * 1 <= N <= 100,000
     */
    static int N;

    static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer integer : set) {
            sb.append(integer).append(" ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
