package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * BOJ 14502 연구소
 * G5
 * 
 * 접근 방식
 * 1. 주어진 범위가 작으므로 브루트포스로 벽을 세울 수 있는 경우의 수만큼 벽을 세우고 max값을 찾는다.
 */

/* 테스트 케이스
[#1 input]
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
[#1 output]
27

[#2 input]
3 3
0 0 0
0 0 0
0 0 2
[#2 output]
5
 */

public class BOJ_14502_1 {
	
	// 상수
	static final int EMPTY = 0;
	static final int WALL = 1;
	static final int VIRUS = 2;
	static final int INFECT = 3;
	
	// 맵 사이즈
	static int N, M;
	
	// 방향 델타, 순서 : 우 하 좌 상
	static final int[] DR = {0, 1, 0, -1};
	static final int[] DC = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int n = 0; n < N; ++n) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; ++m) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 안전 영역 최대 크기
		int sizeSafetyZone = getMaxSizeSafetyZone(map); 
		
		// output
		bw.write(String.valueOf(sizeSafetyZone));

		// io close
		bw.close();
		br.close();
	}
	
	/**
	 * 안전 영역의 최대 크기를 반환한다.
	 * @param map : 맵
	 * @return 안전 영역의 최대 크기
	 */
	private static int getMaxSizeSafetyZone(int[][] map) {
		int max = 0;
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == WALL || map[i][j] == VIRUS) continue;
				// 첫 번째 벽
				map[i][j] = WALL;
				
				for (int k = i; k < N; ++k) {
					int l;
					if (k == i) l = j + 1; // k, i 값이 같으면 같은 행이므로 컬럼 l을 1 증가시킨다. 
					else l = 0; // k가 i보다 크므로 컬럼 l을 0부터 시작한다.
					
					for (; l < M; ++l) {
						if (map[k][l] == WALL || map[k][l] == VIRUS) continue;
						// 두 번째 벽
						map[k][l] = WALL;
						
						for (int x = k; x < N; ++x) {
							int y;
							if (x == k) y = l + 1; // x, k 값이 같으면 같은 행이므로 컬럼 l을 1 증가시킨다. 
							else y = 0; // x가 k보다 크므로 컬럼 y를 0부터 시작한다.
							for (; y < M; ++y) {
								if (map[x][y] == WALL || map[x][y] == VIRUS) continue;
								// 세 번째 벽
								map[x][y] = WALL;
								
								// 임시 크기를 가져와서 max 값과 비교한다.
								int tempSize = getSizeSafetyZone(map);
								if (max < tempSize) max = tempSize;
								
								// 세 번째 벽을 빈 공간으로 초기화
								map[x][y] = EMPTY;
							}
						}
						// 두 번째 벽을 빈 공간으로 초기화
						map[k][l] = EMPTY;
					}
				}
				// 첫 번째 벽을 빈 공간으로 초기화
				map[i][j] = EMPTY;
			}
		}
		
		return max;
	}
	
	/**
	 * 현재 맵에서 안전 영역의 크기를 반환한다.
	 * @param map : 맵
	 * @return 현재 맵에서의 안전 영역의 크기
	 */
	private static int getSizeSafetyZone(int[][] map) {
		// 바이러스가 있으면 주위의 빈 공간을 모두 감염시킨다.
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < M; ++c) {
				if (map[r][c] == VIRUS) dfs(map, r, c);
			}
		}
		
		// 안전 영역 크기
		int sizeSafetyZone = 0;
		
		// 감염되지 않는 빈 공간이 있으면 안전 영역 크기를 증가시킨다.
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < M; ++c) {
				if (map[r][c] == EMPTY) ++sizeSafetyZone;
			}
		}
		// 맵 디버깅용
//		debugMap(map);
//		System.out.println();
		
		// 맵 초기화
		initMap(map);
		
		return sizeSafetyZone;
	}
	
	/**
	 * 감염된 공간을 빈 공간으로 초기화한다.
	 * @param map : 맵
	 */
	private static void initMap(int[][] map) {
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < M; ++c) {
				if (map[r][c] == INFECT) map[r][c] = EMPTY;
			}
		}
	}
	
	/**
	 * 바이러스가 있을 때 dfs 메서드를 호출하게 되는데, 사방에 빈 공간이 있으면 감염시킨다(INFECT로 초기화한다.).
	 * @param map : 맵
	 * @param r : 현재 위치 r
	 * @param c : 현재 위치 c
	 */
	private static void dfs(int[][] map, int r, int c) {
		for (int dir = 0; dir < 4; ++dir) {
			int nr = r + DR[dir];
			int nc = c + DC[dir];
			
			// 범위 밖으로 벗어나는 경우 continue
			if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			// 다음 위치가 빈 공간일 경우 해당 위치를 감염시키고 재귀적으로 호출
			if (map[nr][nc] == EMPTY) {
				map[nr][nc] = INFECT;
				dfs(map, nr, nc);
			}
		}
	}
	
	/**
	 * map 디버깅용
	 * @param map : 맵
	 */
//	private static void debugMap(int[][] map) {
//		for (int r = 0; r < N; ++r) {
//			for (int c = 0; c < M; ++c) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}
//	}
}