package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2615 오목
 * S3
 * 구현, 브루트포스
 */

public class BOJ_2615_1 {

	// 오목판 상수
	static final int EMPTY = 0;
	static final int BLACK = 1;
	static final int WHITE = 2;

	// 오목판 사이즈
	static final int N = 19;
	static final int M = 19;

	/**
	 * 방향 델타 상수
	 * 3 4 5
	 * 2   7
	 * 1 9 8
	 * 순서대로 돌아간다.
	 */
	static final int[] DR = { 1, 0, -1, -1, -1, 0, 1, 1 };
	static final int[] DC = { -1, -1, -1, 0, 1, 1, 1, 0 };

	public static void main(String[] args) throws IOException {

		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// logic
		int[][] map = new int[N][M];
		for (int r = 0; r < N; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; ++c) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int[] result = getResult(map);

		sb.append(result[0] + "\n");
		if (result[0] != 0) sb.append(result[1] + " " + result[2]);

		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}

	/**
	 * 오목을 찾고 오목인 돌의 위치값을 리턴한다.
	 * @param map : 오목판
	 * @return 승부가 나지 않으면 0으로 초기화된 2차원 2배열을 리턴하고, 승부가 나면 이긴 돌의 위치를 리턴한다.
	 */
	private static int[] getResult(int[][] map) {
		// 각 돌이 이기면 위치 값을 저장할 배열
		int[][] resMatch = new int[2][2];

		// 임시 돌 변수
		int tempStone, cnt1, cnt2;

		// 돌이 5개 연속 이어질 때 가장 왼쪽 상단의 돌을 찾기 위한 변수
		int nr, nc;

		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < M; ++c) {
				if (map[r][c] != EMPTY) {
					// 임시 돌 초기화
					tempStone = map[r][c];
					for (int dir = 0; dir < 4; ++dir) {
						// 현재 방향, 반대 방향으로 같은 돌이 딱 4개 있으면 오목이다.
						cnt1 = dfs(map, tempStone, r, c, dir, 0);
						cnt2 = dfs(map, tempStone, r, c, (dir + 4) % 8, 0);
						if (cnt1 + cnt2 == 4) {
							// 가장 왼쪽 상단의 돌을 찾기 위해 임시 위치 변수를 초기화한다.
							nr = r;
							nc = c;

							for (int i = 0; i < cnt1; ++i) {
								nr += DR[dir];
								nc += DC[dir];
							}

							resMatch[tempStone - 1][0] = nr + 1;
							resMatch[tempStone - 1][1] = nc + 1;
						}
					}
				}
			}
		}

		int win = WHITE;
		// 둘다 이기지 못한 경우
		if (resMatch[BLACK - 1][0] == 0 && resMatch[WHITE - 1][0] == 0) return new int[] { 0, 0, 0 };
		// 검은돌이 이겼으면 win을 검은돌로 바꾼다.
		else if (resMatch[BLACK - 1][0] != 0) win = BLACK;

		return new int[] { win, resMatch[win - 1][0], resMatch[win - 1][1] };
	}

	/**
	 * 오목판을 벗어나는지 검사해서 결과를 리턴한다.
	 * @param r : 현재 행 위치
	 * @param c : 현재 열 위치
	 * @return 검사 결과
	 */
	private static boolean isOutRange(int r, int c) {
		return r < 0 || r >= N || c < 0 || c >= M;
	}

	/**
	 * 주어진 방향으로 다른돌이 나올 때까지 직진하고 수행 회수(cnt)를 리턴한다.
	 * @param map : 오목판
	 * @param tempStone : 주어진 돌
	 * @param r : 현재 행 위치
	 * @param c : 현재 열 위치
	 * @param dir : 방향
	 * @param cnt : 수행 회수
	 * @return 수행 회수 cnt
	 */
	private static int dfs(int[][] map, int tempStone, int r, int c, int dir, int cnt) {
		int nr = r + DR[dir];
		int nc = c + DC[dir];

		if (isOutRange(nr, nc) || map[nr][nc] != tempStone) return cnt;
		else return dfs(map, tempStone, nr, nc, dir, cnt + 1);
	}

}
