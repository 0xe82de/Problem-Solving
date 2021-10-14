package solving;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1011 Fly me to the Alpha Centauri
 * G5
 * 수학
 */

public class BOJ_1011_1 {

    private static Queue<int[]> q = new LinkedList<int[]>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        int x, y;
        for (int tc = 1; tc <= TC; ++tc) {
            // 0 <= x < y < 2^31, 2^31 = 2,147,483,648
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(getMinMoveCount(x, y) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
