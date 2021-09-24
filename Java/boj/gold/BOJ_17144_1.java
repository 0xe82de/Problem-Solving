package boj.gold;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * BOJ 17144 미세먼지 안녕!
 * G4
 * 구현
 */

public class BOJ_17144_1 {
	
	// 방향 델타
	enum Direction {
		RIGHT(0, 1), DOWN(1, 0), LEFT(0, -1), UP(-1, 0);
		private final int row, col;
		Direction(int row, int col) {
			this.row = row;
			this.col = col;
		}
		int getRow() { return row; }
		int getCol() { return col; }
	}
	
	// 공기청정기 상수
	static final int AC = -1;
	static final int TOP = 0;
	static final int BOT = 1;
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		// 6 <= R, C <= 50, 1 <= T <= 1,000
		st = new StringTokenizer(br.readLine(), " ");
		final int R = Integer.parseInt(st.nextToken());
		final int C = Integer.parseInt(st.nextToken());
		final int T = Integer.parseInt(st.nextToken());
		
		// 방 초기화
		int[][] room = new int[R][C];
		
		// 공기청정기 위치를 저장할 배열
		int[] rowAC = new int[2];
		for (int r = 0; r < R; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; ++c) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if (room[r][c] == AC && rowAC[TOP] == 0) {
					rowAC[TOP] = r;
					rowAC[BOT] = r + 1;
				}
			}
		}
		
		// 주어진 T초만큼 미세먼지를 확산시키고 공기청정기를 돌린다.
		goodbyeDust(room, R, C, T, rowAC);
		
		// 방에 남은 미세먼지의 양을 리턴받는다.
		int amountDust = getAmountDust(room, R, C);
		
		// output
		bw.write(String.valueOf(amountDust));

		// io close
		bw.close();
		br.close();
	}
	
	/**
	 * 주어진 T만큼 미세먼지를 확산시키고, 공기청정기를 돌린다.
	 * @param room : 방
	 * @param R : 방의 세로 길이
	 * @param C : 방의 가로 길이
	 * @param T : 시간(초)
	 * @param rowAC : 공기청정기 위치(행)
	 */
	private static void goodbyeDust(int[][] room, int R, int C, int T, int[] rowAC) {
		for (int t = 0; t < T; ++t) {
			spreadDust(room, R, C); // 미세먼지 확산
			workAC(room, R, C, rowAC); // 공기청정기 돌리기
		}
	}
	
	/**
	 * 미세먼지를 확산시킨다.
	 * @param room : 방
	 * @param R : 방의 세로 길이
	 * @param C : 방의 가로 길이
	 */
	private static void spreadDust(int[][] room, int R, int C) {
		// 미세먼지가 확산되면서 증감되는 수치들을 저장할 2차원 배열
		int[][] res = new int[R][C];
		
		int nr, nc, amount;
		for (int r = 0; r < R; ++r) {
			for (int c = 0; c < C; ++c) {
				if (room[r][c] > 0) { // 공기청정기 : -1
					amount = room[r][c] / 5; // 확산될 미세먼지의 양
					for (Direction dir : Direction.values()) {
						// 확산될 위치
						nr = r + dir.getRow();
						nc = c + dir.getCol();
						
						// 범위 초과
						if (isOutRange(nr, nc, R, C) || room[nr][nc] == AC) continue;
						
						// 확산될 위치에 미세먼지를 확산시킨다.
						res[nr][nc] += amount;
						
						// 현재 위치에서 확산된 미세먼지만큼 뺀다.
						res[r][c] -= amount;
					}
				}
			}
		}
		
		// 확산된 결과를 합친다.
		for (int r = 0; r < R; ++r) {
			for (int c = 0; c < C; ++c) {
				room[r][c] += res[r][c];
			}
		}
	}
	
	/**
	 * 배열 범위를 초과하는지 확인한다.
	 * @param nr : 행
	 * @param nc : 열
	 * @param R : 최대 nr 값
	 * @param C : 최대 nc 값
	 * @return 초과하면 true, 아니면 false
	 */
	private static boolean isOutRange(int nr, int nc, int R, int C) {
		if (nr < 0 || nr >= R || nc < 0 || nc >= C) return true;
		return false;
	}
	
	/**
	 * 공기청정기를 돌려서 미세먼지를 이동시킨다.
	 * @param room : 방
	 * @param R : 방의 세로 길이
	 * @param C : 방의 가로 길이
	 * @param rowAC : 공기청정기의 행 위치 값
	 */
	private static void workAC(int[][] room, int R, int C, int[] rowAC) {
		int top = rowAC[TOP];
		int bot = rowAC[BOT];
		
		int r, c;
		
		// 상단 공기청정기 작동
		r = top - 1;
		c = 0;
		while (r > 0) room[r][c] = room[--r][c]; // LEFT
		while (c < C - 1) room[r][c] = room[r][++c]; // TOP
		while (r < top) room[r][c] = room[++r][c]; // RIGHT
		while (c > 1) room[r][c] = room[r][--c]; // BOT
		room[top][c] = 0; // 마지막 미세먼지는 0으로
		
		// 하단 공기청정기 작동
		r = bot + 1;
		c = 0;
		while (r < R - 1) room[r][c] = room[++r][c]; // LEFT
		while (c < C - 1) room[r][c] = room[r][++c]; // BOT
		while (r > bot) room[r][c] = room[--r][c]; // RIGHT
		while (c > 1) room[r][c] = room[r][--c]; // TOP
		room[bot][c] = 0; // 마지막 미세먼지는 0으로
	}
	
	/**
	 * 방에 남은 미세먼지의 양을 합산해서 리턴한다.
	 * @param room : 방
	 * @param R : 방의 세로 길이
	 * @param C : 방의 가로 길이
	 * @return 방에 남은 미세먼지의 양을 합산한 결과
	 */
	private static int getAmountDust(int[][] room, int R, int C) {
		int amount = 0;
		for (int r = 0; r < R; ++r) {
			for (int c = 0; c < C; ++c) {
				if (room[r][c] > 0) amount += room[r][c];
			}
		}
		return amount;
	}
	
	/**
	 * 방 디버깅용
	 * @param room : 방
	 */
	private static void debug(int[][] room) {
		for (int r = 0, R = room.length; r < R; ++r) {
			for (int c = 0, C = room[r].length; c < C; ++c) {
				System.out.print(room[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}