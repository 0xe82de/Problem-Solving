package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ 1620 나는야 포멧몬 마스터 이다솜
 * S4
 * 자료 구조, 해시를 사용한 집합과 맵
 */

public class BOJ_1620_1 {

    /**
     * N : 포켓몬의 개수
     * M : 내가 맞춰야 하는 문제의 개수
     */
    static int N, M;

    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String number = String.valueOf(i);
            String name = br.readLine();
            map.put(number, name);
            map.put(name, number);
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
