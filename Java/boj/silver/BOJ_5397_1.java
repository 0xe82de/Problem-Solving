package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * BOJ 5397 키로거
 * S3
 * 자료 구조, 스택, 연결 리스트
 */

public class BOJ_5397_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; ++tc) {
            sb.append(getPass(br.readLine()) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 패스워드를 리턴한다.
     * 
     * @param input : 입력 키들
     * @return 패스워드
     */
    private static String getPass(String input) {
        LinkedList<String> list = new LinkedList<>();
        ListIterator<String> iter = list.listIterator();

        // 1 <= L <= 1,000,000
        final int L = input.length();

        String c;
        for (int i = 0; i < L; ++i) {
            c = input.substring(i, i + 1);

            switch (c) {
                case "<":
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case ">":
                    if (iter.hasNext()) iter.next();
                    break;
                case "-":
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                default:
                    iter.add(c);
                    break;
            }
        }

        StringBuilder password = new StringBuilder();
        for (String s : list) {
            password.append(s);
        }

        return password.toString();
    }

}
