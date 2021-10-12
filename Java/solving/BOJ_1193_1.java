package solving;

import java.io.*;

/**
 * BOJ 1193 분수찾기
 * B1
 * 수학, 구현
 */

public class BOJ_1193_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        final int X = Integer.parseInt(br.readLine());
        int i = 1;
        int sum = 0;
        while (sum + i < X) sum += i++;
        int top = X - sum;
        int bot = i - top + 1;

        // 짝수, 아래쪽 방향
        if (i % 2 == 0) sb.append(top + "/" + bot);
        // 홀수, 위쪽 방향
        else sb.append(bot + "/" + top);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
