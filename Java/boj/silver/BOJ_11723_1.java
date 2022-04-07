package boj.silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ 집합
 * S5
 * 구현, 비트마스킹
 */

public class BOJ_11723_1 {

    /**
     * 연산의 수
     * 1 <= M <= 3,000,000
     */
    static int M;

    static Set<Integer> allSet = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("all")) {
                set = allSet;
            } else if (command.equals("empty")) {
                set.clear();
            } else {
                int data = Integer.parseInt(st.nextToken());
                if (command.equals("add")) {
                    set.add(data);
                } else if (command.equals("remove")) {
                    set.remove(data);
                } else if (command.equals("check")) {
                    if (set.contains(data)) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");
                } else if (command.equals("toggle")) {
                    if (set.contains(data)) {
                        set.remove(data);
                    } else {
                        set.add(data);
                    }
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
