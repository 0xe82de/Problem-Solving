package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1037 약수
 * S5
 * 수학, 정수론
 */

public class BOJ_1037_1 {

    static int N;
    static int MAX = 0;
    static int MIN = 1000001;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // 1 <= N <= 50
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            int input = Integer.parseInt(st.nextToken());
            if (MAX < input) {
                MAX = input;
            }
            if (MIN > input) {
                MIN = input;
            }
        }

        sb.append(MAX * MIN);

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
