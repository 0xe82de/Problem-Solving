package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 10816 숫자 카드 2
 * S4
 * 자료 구조, 정렬, 이분 탐색, 해시르 사용한 집합과 맵
 */

public class BOJ_10816_3 {

    private static final ToIntFunction<String> strToInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        Map<String, Integer> count = new HashMap<>();

        final int N = strToInt.applyAsInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            String numberCard = st.nextToken();
            count.put(numberCard, count.getOrDefault(numberCard, 0) + 1);
        }


        final int M = strToInt.applyAsInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            sb.append(count.getOrDefault(st.nextToken(), 0)).append(" ");
        }

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }
}
