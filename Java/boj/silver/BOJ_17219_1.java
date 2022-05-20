package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ 17219 비밀번호 찾기
 * S4
 * 자료 구조, 해시를 사용한 집합과 맵
 */

public class BOJ_17219_1 {

    /**
     * 저장된 사이트 주소의 수
     * 1 <= N <= 100,000
     */
    static int N;

    /**
     * 비밀번호를 찾으려는 사이트 주소의 수
     * 1 <= M <= 100,000
     */
    static int M;

    static Map<String, String> map;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site, password);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
