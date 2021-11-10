package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * BOJ 1406 에디터
 * S3
 * 자료 구조, 스택, 연결 리스트
 */

public class BOJ_1406_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        String input = br.readLine();

        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();

        int SIZE = input.length();
        for (int i = 0; i < SIZE; ++i) {
            iter.add(input.charAt(i));;
        }

        // 명령어 개수
        int M = Integer.parseInt(br.readLine());

        char[] command;
        int cursor = SIZE;
        for (int m = 0; m < M; ++m) {
            command = br.readLine().toCharArray();

            switch (command[0]) {
                case 'L':
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(command[2]);
                    break;
            }
        }

        for (char c : list) {
            sb.append(c);
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}