package boj.silver;

import java.io.*;

/**
 * BOJ 1543 문서 검색
 * S3
 * 문자열, 그리디, 브루트포스
 */

public class BOJ_1543_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String document = br.readLine();
        String searchKeyword = br.readLine();

        int documentSize = document.length();
        int searchKeywordSize = searchKeyword.length();
        int count = 0;
        for (int i = 0; i + searchKeywordSize <= documentSize; i++) {
            if (document.substring(i, i + searchKeywordSize).equals(searchKeyword)) {
                ++count;
                i += searchKeywordSize - 1;
            }
        }

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }
}
