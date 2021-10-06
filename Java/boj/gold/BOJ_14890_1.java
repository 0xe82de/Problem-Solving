package boj.gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 14890 경사로
 * G3
 * 구현
 */

public class BOJ_14890_1 {

    // 절벽 사이즈, 경사로 길이
    static int N, X;

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        // logic
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // output
        bw.write(String.valueOf(getNumOfCase(map)));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 경사로를 세울 수 있는 경우의 수를 합산해서 리턴한다.
     * @param map : 절벽의 높이를 저장한 2차원 배열
     * @return 경사로를 세울 수 있는 경우의 수
     */
    private static int getNumOfCase(int[][] map) {
        int cntCase = 0;

        int[] heightGaro = new int[N];
        int[] heightSero = new int[N];
        boolean flatGaro, flatSero;
        boolean flag = X * 2 <= N;
        for (int r = 0; r < N; ++r) {
            flatGaro = true;
            flatSero = true;
            for (int c = 0; c < N; ++c) {
                heightGaro[c] = map[r][c];
                heightSero[c] = map[c][r];

                if (heightGaro[0] != heightGaro[c]) flatGaro = false;
                if (heightSero[0] != heightSero[c]) flatSero = false;
            }

            if (flag && flatGaro) ++cntCase;
            else if (isValid(heightGaro)) ++cntCase;

            if (flag && flatSero) ++cntCase;
            else if (isValid(heightSero)) ++cntCase;
        }

        return cntCase;
    }

    /**
     * 경사로를 세울 수 있는지 여부를 체크하고 리턴한다.
     * @param height : 절벽 높이
     * @return 경사로 건설 여부
     */
    private static boolean isValid(int[] height) {
        // 기준 높이
        int base = height[0];
        // 현재 위치까지의 평지 길이
        int platLen = 1;
        for (int i = 1; i < N; ++i) {
            if (Math.abs(base - height[i]) > 1) return false;

            // 다음 위치와 높이가 같을 경우 평지 길이를 1 증가시킨다.
            if (base == height[i]) ++platLen;
            // 다음 위치가 1 높은 경우
            else if (base < height[i]) {
                // 평지 길이가 X보다 작으면
                // 경사로를 세울 수 없ㄴ다.
                if (platLen < X) return false;
                // 평지 길이가 X보다 크거나 같으면 경사로를 세울 수 있다.
                else {
                    // 기준 높이를 다음 위치의 높이로 갱신한다.
                    base = height[i];
                    // 평지 길이도 1로 초기화한다.
                    platLen = 1;
                }
            }
            // 다음 위치의 높이가 1 낮을 경우
            else {
                // i + X 위치가 활주로 크기를 벗어나면 경사로를 세울 수 없다.
                if (i + X > N) return false;
                // 높이가 1만큼 작지 않으면  경사로를 세울 수 없다.
                for (int dst = i + X; i < dst; ++i) {
                    if (base - 1 != height[i]) return false;
                }
                // 인덱스 값을 경사로의 끝 인덱스로 초기화하고,
                // 기준 위치를 경사로를 세운 바닥의 높이로 초기화한다.
                base = height[--i];
                // 경사로를 세웠기 때문에 평지 길이를 0으로 초기화한다.
                platLen = 0;
            }
        }
        return true;
    }
}
