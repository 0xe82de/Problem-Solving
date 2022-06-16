package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 6603 로또
 * S2
 * 수학, 조합론, 백트래킹, 재귀
 */

public class BOJ_6603_1 {

    static int k;

    static int[] S;

    static int[] selected = new int[6];

    static int MAX_COUNT = 6;

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            result.append("\n");
        }

        // output
        bw.write(result.toString());

        // io close
        bw.close();
        br.close();
    }

    static void comb(int cnt, int src) {
        if (cnt == MAX_COUNT) {
            for (int number : selected) {
                result.append(number).append(" ");
            }
            result.append("\n");

            return;
        }

        for (int i = src; i < k; i++) {
            selected[cnt] = S[i];
            comb(cnt + 1, i + 1);
        }
    }
}
