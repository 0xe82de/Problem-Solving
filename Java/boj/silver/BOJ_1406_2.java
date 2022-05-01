package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * BOJ 1406 에디터
 * S2
 * 자료 구조, 스택, 연결 리스트
 */

public class BOJ_1406_2 {

    static List<String> editor;

    static ListIterator<String> iter;

    /**
     * 명령어의 개수
     * 1 <= M <= 500,000
     */
    static int M;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String[] words = br.readLine().split("");
        editor = new LinkedList<>();
        iter = editor.listIterator();

        for (String word : words) {
            iter.add(word);
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if ("L".equals(command)) {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if ("D".equals(command)) {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if ("B".equals(command)) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if ("P".equals(command)) {
                iter.add(st.nextToken());
            } else {
                throw new IllegalStateException();
            }
        }

        String output = editor.stream()
                .collect(Collectors.joining());

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }
}
