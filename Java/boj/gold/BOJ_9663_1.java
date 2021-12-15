package boj.gold;

import java.io.*;

/**
 * BOJ 9663 N-Queen
 * G5
 * 브루트포스, 백트래킹
 */

public class BOJ_9663_1 {

    static int count = 0;
    static int N;
    static int[] rowVisited;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        N = Integer.parseInt(br.readLine());
        rowVisited = new int[N];

        compute(0);

        // output
        bw.write(String.valueOf(count));

        // io close
        bw.close();
        br.close();
    }

    /**
     * 정답 계산
     * 
     * @param row : 행 위치
     */
    private static void compute(int row) {
        if (row == N) {
            ++count;
            return;
        }

        for (int col = 0; col < N; ++col) {
            // 현재 행에서 어느 열 값을 선택했는지 저장
            rowVisited[row] = col;
            
            // 현재 선택한 열이 다른 퀸에게 공격받지 않으면 다음 행으로 이동
            if (isValid(row)) {
                compute(row + 1);
            }
        }
    }

    /**
     * 공격받지 않는 위치인지 확인
     * 
     * @param row : 행 위치
     * @return 공격 여부
     */
    private static boolean isValid(int row) {
        for (int i = 0; i < row; ++i) {
            // 같은 열이거나
            if (rowVisited[row] == rowVisited[i]) {
                return false;
            }
            // 대각선에 위치하면
            else if (Math.abs(row - i) == Math.abs(rowVisited[row] - rowVisited[i])) {
                return false;
            }
        }
        return true;
    }

}
