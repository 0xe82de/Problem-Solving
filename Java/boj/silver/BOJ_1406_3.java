package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * BOJ 1406 에디터
 * S3
 * 자료 구조, 스택, 연결 리스트
 */

public class BOJ_1406_3 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String str = br.readLine();
        List<String> editor = new LinkedList<>();
        ListIterator<String> iterator = editor.listIterator();
        for (String word : str.split("")) {
            iterator.add(word);
        }

        /**
         * 입력할 명령어의 개수
         * 1 <= M <= 500,000
         */
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if ("L".equals(command)) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                }
            } else if ("D".equals(command)) {
                if (iterator.hasNext()) {
                    iterator.next();
                }
            } else if ("B".equals(command)) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            } else if ("P".equals(command)) {
                iterator.add(st.nextToken());
            }
        }

        String output = String.join("", editor);

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }
}
