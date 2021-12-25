package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 5430 AC
 * G5
 * 구현, 자료 구조, 문자열, 파싱, 덱
 */

public class BOJ_5430_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        final int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; ++tc) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[,]");

            Deque<Integer> dq = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            boolean direction = true;
            boolean isError = false;
            for (char function: p) {
                switch (function) {
                    case 'R':
                        direction = !direction;
                        break;
                    case 'D':
                        try {
                            if (dq.size() == 0)
                                throw new NoSuchElementException();
                            if (direction)
                                dq.poll();
                            else
                                dq.pollLast();
                        } catch (NoSuchElementException e) {
                            isError = true;
                            break;
                        }
                        break;
                }
            }

            if (!isError) {
                int size = dq.size();

                sb.append("[");
                if (size > 0) {
                    while (size-- > 0) {
                        if (direction) {
                            sb.append(dq.poll());
                        } else {
                            sb.append(dq.pollLast());
                        }
                        sb.append(",");
                    }
                    sb.setLength(sb.length() - 1);
                }
                sb.append("]");
            }
            else {
                sb.append("error");
            }

            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
