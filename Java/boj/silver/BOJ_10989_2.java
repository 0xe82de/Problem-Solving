package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 10989 수 정렬하기 3
 * S5
 * 정렬
 */

public class BOJ_10989_2 {

    /**
     * 1 <= N <= 10,000,000
     */
    static int N;

    static Map<Integer, Integer> map;

    static final int MAX = 10000;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int number = 1; number <= MAX; number++) {
            if (map.containsKey(number)) {
                Integer count = map.get(number);
                while (count-- > 0) {
                    sb.append(number).append("\n");
                }
            }
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
