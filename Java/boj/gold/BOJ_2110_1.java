package boj.gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2100 공유기 설치
 * G5
 * 이분 탐색, 매개 변수 탐색
 */

public class BOJ_2110_1 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 2 <= N <= 200,000
        final int N = Integer.parseInt(st.nextToken());
        // 2 <= C <= N
        final int C = Integer.parseInt(st.nextToken());

        int[] locationOfHouses = new int[N];
        for (int i = 0; i < N; i++) {
            locationOfHouses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(locationOfHouses);

        int minDistance = 1;
        int maxDistance = locationOfHouses[N - 1] - locationOfHouses[0] + 1;
        int distance = 0;
        while (minDistance < maxDistance) {
            distance = (minDistance + maxDistance) / 2;

            if (canInstall(locationOfHouses, distance) < C) {
                maxDistance = distance;
            } else {
                minDistance = distance + 1;
            }
        }

        // output
        bw.write(String.valueOf(minDistance - 1));

        // io close
        bw.close();
        br.close();
    }

    private static int canInstall(int[] locationOfHouses, int distance) {
        int cnt = 1;
        int lastInstallLocation = locationOfHouses[0];
        final int SIZE = locationOfHouses.length;

        for (int i = 1; i < SIZE; i++) {
            int location = locationOfHouses[i];

            if (location - lastInstallLocation >= distance) {
                ++cnt;
                lastInstallLocation = location;
            }
        }

        return cnt;
    }

}
