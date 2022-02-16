package boj.silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * BOJ 1302 베스트셀러
 * S4
 * 자료 구조, 문자열, 정렬, 해시를 사용한 집합과 맵
 */

public class BOJ_1302_1 {

    /**
     * 1 <= N <= 1,000
     */
    static int N;

    static Map<String, Integer> countByTitle = new HashMap<>();

    static String resTitle = "";
    static int resCount = 0;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String input = br.readLine();
            countByTitle.merge(input, 1, Integer::sum);

            int count = countByTitle.get(input);
            if (resCount < count || resCount == count && resTitle.compareTo(input) > 0) {
                resTitle = input;
                resCount = count;
            }
        }

        // output
        bw.write(resTitle);

        // io close
        bw.close();
        br.close();
    }

}
