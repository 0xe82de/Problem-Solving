package boj.silver;

import java.io.*;

/**
 * BOJ 17478 재귀함수가 뭔가요?
 * S5
 * 구현, 재귀
 */

public class BOJ_17478_3 {

    /**
     * 재귀 횟수
     * 1 <= N <= 50
     */
    static int N;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        recur(0);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static void recur(int cnt) {
        printUnderBar(cnt);
        sb.append("\"재귀함수가 뭔가요?\"").append("\n");

        if (cnt == N) {
            printUnderBar(cnt);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");

            printUnderBar(cnt);
            printClose();

            return;
        }

        printUnderBar(cnt);
        sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");

        printUnderBar(cnt);
        sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");

        printUnderBar(cnt);
        sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");

        recur(cnt + 1);

        printUnderBar(cnt);
        printClose();
    }

    static void printUnderBar(int cnt) {
        for (int i = 0; i < cnt; i++) {
            sb.append("____");
        }
    }

    static void printClose() {
        sb.append("라고 답변하였지.").append("\n");
    }
}
