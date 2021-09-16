package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ 2636 치즈
 * G5
 * 접근 방식
 * 1. 치즈를 지우는 턴마다 구멍을 새로 세팅한다.
 * 2. 공기층과 닿아 있는 빈 공간이 있으면 방문체크를 하고, 이웃들도 모두 방문체크한다.
 * 3. 방문체크 되지 않은 빈 공간은 구멍으로 본다.
 * 4. 치즈의 사방에 한 개라도 구멍이 아닌 빈 공간이 있으면 이번턴에 녹는다.
 */

public class BOJ_2636_1 {
	
	static final int EMPTY = 0;
	static final int CHEESE = 1;
	static final int MELT = 2;
	static final int HOLE = 3;
	
	static int R, C;
	
	// 상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static boolean[][] isVisit;
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		isVisit = new boolean[R][C];
		
		for (int r = 0; r < R; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < C; ++c) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] result = getResMeltCheese(map);
		
		// output
		bw.write(result[0] + "\n" + result[1]);

		// io close
		bw.close();
		br.close();
	}
	
	private static int[] getResMeltCheese(int[][] map) {
		int finalCount = 0;
		int count = 0;
		int time = 0;
		
		// 구멍을 찾아서 세팅한다.
		init(map);
		while (true) {
			count = 0;
			for (int r = 1; r < R - 1; ++r) {
				for (int c = 1; c < C - 1; ++c) {
					
					// 치즈이고 이번 턴에 녹아야 하면 개수를 센다.
					if (map[r][c] == CHEESE && isMelt(map, r, c)) {
						++count;
					}
				}
			}
			// 녹은 치즈가 없으면 끝낸다.
			if (count == 0) break;
			
			// 치즈를 녹인다.
			meltCheese(map);
			
			// 치즈가 녹았으니, 새로운 구멍을 세팅한다.
			init(map);
			
			// 마지막 치즈 카운팅 계산
			finalCount = count;
			
			// 시간 증가
			++time;
		}
		
		return new int[] {time, finalCount};
	}
	
	private static void init(int[][] map) {
		
		// 치즈가 아닌 부분은 모두 빈 공간으로 채운다.
		for (int r = 1; r < R - 1; ++r) {
			for (int c = 1; c < C - 1; ++c) {
				if (map[r][c] != CHEESE) map[r][c] = EMPTY; 
			}
		}
		
		// 방문 체크용 배열을 초기화한다.
		for (int r = 0; r < R - 1; ++r) {
			Arrays.fill(isVisit[r], false);
		}
		
		// 구멍을 세팅한다.
		setHole(map);
	}
	
	private static void setHole(int[][] map) {
		for (int r = 1; r < R - 1; r++) {
			for (int c = 0; c < C - 1; c++) {
				// 빈 공간이고, 방문하지 않았으면 탐색한다.
				if (map[r][c] == EMPTY && !isVisit[r][c]) {
					dfs(map, r, c, true);
				}
			}
		}
		
		for (int r = 1; r < R - 1; r++) {
			for (int c = 0; c < C - 1; c++) {
				// 빈 공간이고 방문하지 않았으면 구멍으로 초기화한다.
				if (map[r][c] == EMPTY && !isVisit[r][c]) {
					map[r][c] = HOLE;
				}
			}
		}
	}
	
	private static void dfs(int[][] map, int r, int c, boolean isHole) {
		// 방문 체크
		isVisit[r][c] = true;
		
		for (int dir = 0; dir < 4; ++dir) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			// 공기층과 닿아 있으면
			if (nr <= 0 || nr >= R - 1 || nc <= 0 || nc >= C - 1) {
				// 최초에 true로 세팅되어 있으므로 공기층과 닿아있으면 isHole = false로 초기화
				if (isHole) {
					isHole = false;
					// 공기층과 닿아있는 방향이 있으므로 사방을 다시 탐색하기 위해 dir = -1로 초기화
					dir = -1;
				}
				continue;
			}
			
			// 치즈의 경우 건너뛴다.
			if (map[nr][nc] == CHEESE) continue;
			
			// 구멍이 아니고(공기층과 닿아있거나, 내 이웃이 공기층과 닿아있는 경우), 방문하지 않았으면
			if (!isHole && !isVisit[nr][nc]) {
				// 탐색한다. 이 때는 isHole이 false
				dfs(map, nr, nc, isHole);
			}
		}
		
		// 사방을 탐색했는데 공기층과 닿아있는 부분이 없으면 방문 체크한 것을 되돌린다.
		// 이 값으로 구멍인지 공기층과 닿아 있는 빈 공간인지 체크한다.
		if (isHole) isVisit[r][c] = false;
	}

	private static boolean isMelt(int[][] map, int r, int c) {
		for (int dir = 0; dir < 4; ++dir) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 구멍이 아니고 빈 공간이면 치즈를 녹여야 하므로 MELT로 초기화한다.
			if (map[nr][nc] == EMPTY) {
				map[r][c] = MELT;
				return true;
			}
		}
		return false;
	}
	
	private static void meltCheese(int[][] map) {
		for (int r = 1; r < R - 1; ++r) {
			for (int c = 1; c < C - 1; ++c) {
				// 녹아야할 치즈이면 빈 공간으로 초기화한다.
				if (map[r][c] == MELT) map[r][c] = EMPTY;
			}
		}
	}
}