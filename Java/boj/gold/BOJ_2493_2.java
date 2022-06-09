package boj.gold;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 2493 탑
 * G5
 * 자료 구조, 스택
 */

public class BOJ_2493_2 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 탑의 수
         * 1 <= N <= 500,000
         */
        int N = Integer.parseInt(br.readLine());
        int[] receive = new int[N + 1];
        Stack<Top> tops = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int order = 1; order <= N; order++) {
            int height = Integer.parseInt(st.nextToken());
            Top top = new Top(height, order);

            if (!tops.isEmpty()) {
                Top recentTop = tops.peek();
                if (recentTop.getHeight() > height) {
                    receive[order] = recentTop.getOrder();
                }
            }

            tops.push(top);
        }

        Stack<Top> notYetReceiveTops = new Stack<>();
        while (!tops.isEmpty()) {
            Top recentTop = tops.pop();
            int recentTopOrder = recentTop.getOrder();

            if (!notYetReceiveTops.isEmpty()) {
                Top resRecentTop = notYetReceiveTops.peek();
                while (recentTop.getHeight() > resRecentTop.getHeight()) {
                    receive[resRecentTop.getOrder()] = recentTopOrder;
                    notYetReceiveTops.pop();

                    if (notYetReceiveTops.isEmpty()) {
                        break;
                    } else {
                        resRecentTop = notYetReceiveTops.peek();
                    }
                }
            }

            if (tops.isEmpty()) {
                break;
            }

            if (receive[recentTopOrder] == 0) {
                notYetReceiveTops.push(recentTop);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(receive[i]).append(" ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static class Top {

        private final int height;

        private final int order;

        public Top(int height, int order) {
            this.height = height;
            this.order = order;
        }

        public int getHeight() {
            return height;
        }

        public int getOrder() {
            return order;
        }
    }
}
