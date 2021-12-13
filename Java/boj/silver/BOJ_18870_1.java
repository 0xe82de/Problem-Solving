package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 18870 좌표 압축
 * S2
 * 정렬, 값 / 좌표 압축
 */

public class BOJ_18870_1 {

    static final int VALUE = 0;
    static final int INPUT_ORDER = 1;
    static final int COMP_ORDER = 2;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        int[][] coordinateInfo = new int[N][3];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            coordinateInfo[i][VALUE] = Integer.parseInt(st.nextToken());
            coordinateInfo[i][INPUT_ORDER] = i;
        }

        Arrays.sort(coordinateInfo, (o1, o2) -> Integer.compare(o1[VALUE], o2[VALUE]));

        int j = 0;
        int k = 0;
        while (++j < N) {
            coordinateInfo[j][COMP_ORDER] =
                    coordinateInfo[j][VALUE] == coordinateInfo[j - 1][VALUE] ? coordinateInfo[j - 1][COMP_ORDER] : ++k;
        }

        Arrays.sort(coordinateInfo, (o1, o2) -> Integer.compare(o1[INPUT_ORDER], o2[INPUT_ORDER]));

        for (int i = 0; i < N; ++i) {
            sb.append(coordinateInfo[i][COMP_ORDER] + " ");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }
}
