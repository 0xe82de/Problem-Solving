package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * BOJ 9375 패션왕 신해빈
 * S3
 * 수학, 자료 구조, 조합론, 해시를 사용한 집합과 맵
 */

public class BOJ_9375_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        final int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; ++tc) {
            // 0 <= n <= 30
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                sb.append("0\n");
                continue;
            }

            Map<String, Integer> closet = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken(); // clothes
                String kind = st.nextToken();

                if (closet.containsKey(kind)) {
                    closet.put(kind, closet.get(kind) + 1);
                } else {
                    closet.put(kind, 1);
                }
            }

            int result = 1;
            for (int count : closet.values()) {
                result *= (count + 1);
            }

            --result;
            sb.append(result + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
