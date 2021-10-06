package swea.모의_SW_역량테스트;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SWEA 4014 활주로 건설
 * 모의 SW 역량테스트
 * 구현
 */

public class SWEA_4014_1 {

    // 절벽 사이즈, 경사로 길이
    static int N, X;

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        final int TC = Integer.parseInt(br.readLine());

        int[][] map;
        for (int tc = 1; tc <= TC; ++tc) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int r = 0; r < N; ++r) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int c = 0; c < N; ++c) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#" + tc + " " + getNumOfCase(map) + "\n");
        }

        // output
        bw.write(sb.toString());

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
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                heightGaro[c] = map[r][c];
                heightSero[c] = map[c][r];
            }

            if (isValid(heightGaro)) ++cntCase;
            if (isValid(heightSero)) ++cntCase;
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

            // 다음 위치가 1 높은 경우
            if (base < height[i]) {
                // 평지 길이가 X보다 작으면
                // 경사로를 세울 수 없다.
                if (platLen < X) return false;
                // 평지 길이가 X보다 크거나 같으면 경사로를 세울 수 있다.
                else {
                    // 기준 높이를 다음 위치의 높이로 갱신한다.
                    base = height[i];
                    // 평지 길이도 1로 초기화한다.
                    platLen = 1;
                }
            }
            // 다음 위치와 높이가 같을 경우 평지 길이를 1 증가시킨다.
            else if (base == height[i]) ++platLen;
            // 다음 위치의 높이가 1 낮을 경우
            else {
                // i + X 위치가 활주로 크기를 벗어나면 경사로를 세울 수 없다.
                if (i + X > N) return false;
                // 경사로를 세우려면 다음 위치(i)부터 X 만큼의 높이가 딱 1만큼 작아야 한다.
                int src = i;
                int dst = i + X;
                for (; src < dst; ++src) {
                    // 높이가 맞지 않으면  경사로를 세울 수 없다.
                    if (base - 1 != height[src]) return false;
                }
                // 경사로를 세웠기 때문에 평지 길이를 0으로 초기화한다.
                platLen = 0;
                // 기준 위치를 경사로를 세운 바닥의 높이로 초기화한다.
                base = height[src - 1];
                // 인덱스 값도 경사로를 세운 바닥의 인덱스로 초기화한다.
                i = src - 1;
            }
        }
        return true;
    }
}
