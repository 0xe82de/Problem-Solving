package boj.silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * BOJ 11478 서로 다른 부분 문자열의 개수
 * S3
 * 자료 구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 */

public class BOJ_11478_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String S = br.readLine();

        Set<String> set = new HashSet<>();
        for (int length = 1, size = S.length(); length <= size; length++) {
            for (int i = 0; i + length <= size; i++) {
                set.add(S.substring(i, i + length));
            }
        }

        // output
        bw.write("" + set.size());

        // io close
        bw.close();
        br.close();
    }
}
