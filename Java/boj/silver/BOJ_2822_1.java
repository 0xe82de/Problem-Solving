package boj.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BOJ 2822 점수 계산
 * S5
 * 정렬
 */

public class BOJ_2822_1 {

    static int COUNT = 8;

    static int TOP_COUNT= 5;

    /**
     * 0 <= point <= 150
     */
    static int[][] points = new int[COUNT][2];
    static final int POINT = 0;
    static final int ORDER = 1;

    static int sum;

    static List<Integer> orders = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < COUNT; i++) {
            points[i][POINT] = Integer.parseInt(br.readLine());
            points[i][ORDER] = i + 1;
        }

        Arrays.sort(points, (int[] p1, int[] p2) -> Integer.compare(p2[POINT], p1[POINT]));
        for (int i = 0; i < TOP_COUNT; i++) {
            orders.add(points[i][ORDER]);
            sum += points[i][POINT];
        }
        orders.sort(Integer::compare);

        sb.append(sum).append("\n");
        orders.forEach(order -> sb.append(order).append(" "));

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    private static void compute() {

    }

}
