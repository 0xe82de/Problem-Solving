package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 1780 종이의 개수
 * S2
 * 분할 정복, 재귀
 */

public class BOJ_1780_1 {

    // 카운팅 결과를 저장할 배열
    static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // logic
        // 1 <= N <= 3^7, 2,187
        final int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int r = 0; r < N; ++r) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        compute(map, 0, 0, N);

        sb.append(result[0] + "\n");
        sb.append(result[1] + "\n");
        sb.append(result[2] + "\n");

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 기준값과 같은 영역에 있는 값들을 비교한다. 다르면 9분할하여 재귀함수 호출
     * @param map : 맵
     * @param srcR : 현재 영역 시작 행 위치
     * @param srcC : 현재 영역 시작 열 위치
     * @param size : 영역 크기
     */
    private static void compute(int[][] map, int srcR, int srcC, int size) {
        if (size == 1) {
            ++result[map[srcR][srcC] + 1];
            return;
        }

        int base = map[srcR][srcC];
        int lenR = srcR + size;
        int lenC = srcC + size;
        for (int r = srcR; r < lenR; ++r) {
            for (int c = srcC; c < lenC; ++c) {
                // 기준 값과 같으면 continue
                if (base == map[r][c]) continue;
                
                // 9분할
                for (int i = 0; i < 3; ++i) {
                    for (int j = 0; j < 3; ++j) {
                        compute(
                                map,
                                srcR + i * (size / 3),
                                srcC + j * (size / 3),
                                size / 3
                        );
                    }
                }

                return;
            }
        }
        ++result[base + 1];
    }

}