package boj.silver;

import java.io.*;
import java.util.*;

/**
 * BOJ 1764 듣보잡
 * S4
 * 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵
 */

public class BOJ_1764_1 {

    // 1 <= N, M <= 500,000
    static int N, M;

    static PriorityQueue<String> pq = new PriorityQueue<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String input = "";
        while (N-- > 0) {
            input = br.readLine();
            set.add(input);
        }

        while (M-- > 0) {
            input = br.readLine();
            if (!set.add(input)) {
                pq.offer(input);
            }
        }

        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
