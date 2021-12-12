package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * BOJ 10814
 * S5
 * 정렬
 */

public class BOJ_10814_1 {

    static final int AGE = 0;
    static final int NAME = 1;
    static final int REG_ORDER = 2;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        Object[][] users = new Object[N][3];
        for (int n = 0; n < N; ++n) {
            st = new StringTokenizer(br.readLine(), " ");
            users[n][AGE] = Integer.parseInt(st.nextToken());
            users[n][NAME] = st.nextToken();
            users[n][REG_ORDER] = n + 1;
        }

        Arrays.sort(users, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                if (o1[AGE] != o2[AGE]) {
                    return Integer.compare((int)o1[AGE], (int)o2[AGE]);
                }
                else {
                    return Integer.compare((int)o1[REG_ORDER], (int)o2[REG_ORDER]);
                }
            }
        });

        for (int n = 0; n < N; ++n) {
            sb
                    .append(users[n][AGE]).append(" ")
                    .append(users[n][NAME]).append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
