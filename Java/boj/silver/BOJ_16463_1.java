package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 16463 13일의 금요일
 * S4
 * 구현, 브루트포스
 */

public class BOJ_16463_1 {

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        final int N = Integer.parseInt(br.readLine());

        // 1월 ~ 12월, 첫 번째 값은 사용하지 않는다.
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int total = 0, count = 0;
        for (int year = 2019; year <= N; ++year) {
            // 윤년
            if (year % 400 == 0) days[2] = 29;
            // 윤년 X
            else if (year % 100 == 0) days[2] = 28;
            // 윤년
            else if (year % 4 == 0) days[2] = 29;
            // 윤년 X
            else days[2] = 28;

            for (int m = 1; m <= 12; ++m) {
                for (int d = 1; d <= days[m]; ++d) {
                    ++total; // 매일매일 1 증가한다.

                    // 일주일 단위로 짜른다.
                    if (total > 7) total = 1;

                    // 13일이고 total을 4로 나눈 나머지가 0이면 금요일이다.
                    // 시작이 화요일이므로 화요일을 1로 잡으면 금요일은 4이다.
                    if (d == 13 && total % 4 == 0) ++count;
                }
            }
        }

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

}
