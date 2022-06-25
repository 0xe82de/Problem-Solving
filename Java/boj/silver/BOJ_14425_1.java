package boj.silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ 14425 문자열 집합
 * S3
 * 자료 구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 */

public class BOJ_14425_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            set.add(br.readLine());
        }

        int count = 0;
        while (M-- > 0) {
            if (set.contains(br.readLine())) {
                ++count;
            }
        }

        // output
        bw.write("" + count);

        // io close
        bw.close();
        br.close();
    }
}
