package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 2239 스도쿠
 * G4
 * 구현, 백트래킹
 */

public class BOJ_2239_1 {

    // 스도쿠 사이즈
    static final int SIZE = 9;

    // 상수
    static final int EMPTY = 0;

    public static void main(String[] args) throws IOException {

        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        int[][] sudoku = new int[SIZE][SIZE];
        ArrayList<int[]> posList = new ArrayList<>();
        for (int r = 0; r < SIZE; ++r) {
            char[] temp = br.readLine().toCharArray();
            for (int c = 0; c < SIZE; ++c) {
                sudoku[r][c] = temp[c] - '0';
                if (sudoku[r][c] == EMPTY) posList.add(new int[]{r, c});
            }
        }

        play(sudoku, posList, 0, posList.size());

        for (int r = 0; r < SIZE; ++r) {
            for (int c = 0; c < SIZE; ++c) {
                sb.append(sudoku[r][c]);
            }
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 스도쿠를 완성시킨다.
     * 숫자를 1부터 넣기 때문에 첫 번째로 완성되는 스도쿠가 사전순으로 가장 빠른 스도쿠다.
     * @param sudoku    : 스도쿠
     * @param posList   : 빈 칸 위치가 담긴 리스트
     * @param index     : 빈 칸의 인덱스
     * @return 스도쿠를 완성시키면 true, 아니면 false를 리턴한다.
     */
    private static boolean play(int[][] sudoku, ArrayList<int[]> posList, int index, int max) {
        // 스도쿠가 완성되면 true 리턴
        if (index == max) return true;

        int[] pos = posList.get(index);
        int r = pos[0], c = pos[1];
        for (int number = 1; number <= 9; ++number) {
            // 현재 위치에 number를 놓을 수 없으면 continue
            if (!isValid(sudoku, r, c, number)) continue;
            // 현재 위치에 number를 놓는다.
            sudoku[r][c] = number;
            // 다음 위치로
            if (play(sudoku, posList, index + 1, max)) return true;
        }
        // 현재 위치에 숫자를 놓은 뒤에 다음 위치를 진행했는데, 불가능해서 돌아온 경우
        // 현재 위치를 비워두고 이전 위치로 돌아가야 한다.
        // 그래서 EMPTY로 초기화한다.
        sudoku[r][c] = EMPTY;
        return false;
    }

    /**
     * 스도쿠에 숫자를 입력할 수 있는지 체크해서 리턴한다.
     * @param sudoku    : 스도쿠
     * @param curR      : 현재 행 위치
     * @param curC      : 현재 열 위치
     * @param number    : 넣을 수사
     * @return 입력 여부
     */
    private static boolean isValid(int[][] sudoku, int curR, int curC, int number) {
        // 가로 확인
        for (int c = 0; c < SIZE; ++c)
            if (curC != c && sudoku[curR][c] == number)
                return false;
        // 세로 확인
        for (int r = 0; r < SIZE; ++r)
            if (curR != r && sudoku[r][curC] == number)
                return false;
        // 영역 확인
        int tr = curR / 3 * 3;
        int tc = curC / 3 * 3;
        for (int r = tr, lenR = tr + 3; r < lenR; ++r) {
            for (int c = tc, lenC = tc + 3; c < lenC; ++c) {
                if (curR == r && curC == c) continue;
                if (sudoku[r][c] == number) return false;
            }
        }
        return true;
    }

    /**
     * 스도쿠 디버깅용
     * @param sudoku    : 스도쿠
     */
    private static void debug(int[][] sudoku) {
        for (int r = 0; r < SIZE; ++r) {
            for (int c = 0; c < SIZE; ++c) {
                System.out.print(sudoku[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
