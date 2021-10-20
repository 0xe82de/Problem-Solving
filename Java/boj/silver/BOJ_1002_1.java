package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1002 터렛
 * S4
 * 수학, 기하학
 */

public class BOJ_1002_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());
        int x1, y1, r1, x2, y2, r2;
        for (int tc = 1; tc <= TC; ++tc) {
            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            sb.append(getCount(x1, y1, r1, x2, y2, r2) + "\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 위치의 개수를 구해서 리턴한다.
     * @param x1 : 조규현의 x 좌표
     * @param y1 : 조규현의 y 좌표
     * @param r1 : 조규현과 류재명과의 거리
     * @param x2 : 백승환의 x 좌표
     * @param y2 : 백승환의 y 좌표
     * @param r2 : 백승환과 류재명과의 거리
     * @return 위치의 개수
     */
    private static int getCount(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 좌표가 같고, 반지름이 같으면 위치의 개수는 무한
        if (x1 == x2 && y1 == y2 && r1 == r2)
            return -1;

        // 두 좌표의 거리
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

        // 반지름의 합
        int sumRad = r1 + r2;

        // 작은 반지름
        int smallRad = Math.min(r1, r2);

        // 큰 반지름
        int bigRad = sumRad - smallRad;

        // 거리 + 작은 반지름
        double x = distance + smallRad;

        // 거리가 두 반지름보다 크거나 x가 큰 반지름보다 작으면
        if (distance > sumRad || x < bigRad)
            return 0;
        // 거리가 두 반지름과 같거나 x가 큰 반지름과 같으면
        else if (distance == sumRad || x == bigRad)
            return 1;
        // 거리가 두 반지름보다 작으면
        else
            return 2;
    }
}
