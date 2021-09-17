package swea.SW_Test_샘플문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * SWEA 1767
 * SW Test 샘플문제
 */

public class SWEA_1767_1 {
	
	// 상수
	static final int EMPTY = 0;
	static final int CORE = 1;
	static final int WIRE = 2;
	static final int NONE = -1;
	
	// 방향 델타, 순서 : 우 하 좌 상
	static final int[] DR = {0, 1, 0, -1};
	static final int[] DC = {1, 0, -1, 0};
	
	// 맵 사이즈
	static int N;
	
	// 코어 리스트
	static ArrayList<int[]> listOfCores = new ArrayList<>();
	
	// 코어 리스트 사이즈
	static int listSize;
	
	// 전선 길이
	static int minLength = Integer.MAX_VALUE;
	
	// 코어 개수 보관
	static int maxCountCore = 0;
	
	// 현재 계산된 코어 개수
	static int countCore = 0;

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			minLength = Integer.MAX_VALUE;
			maxCountCore = 0;
			countCore = 0;
			listOfCores.clear();
			
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) { 
					map[i][j] = Integer.parseInt(st.nextToken());
					
					// 빈 공간이면 continue
					if (map[i][j] == EMPTY) continue;
					
					// 코어이지만, 위치가 가장자리에 있으면 continue
					if (i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
					
					// 코어이고, 가장자리에 없으면 list에 추가
					if (map[i][j] == CORE) listOfCores.add(new int[] {i, j});
				}
			}
			
			listSize = listOfCores.size();
			if (listSize == 0 || listSize == (N * N)) minLength = 0;
			else setMinLenOfWire(map);
			
			sb.append("#" + tc + " " + minLength + "\n");
		}

		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
	
	/**
	 * 최소 전선 길이를 초기화하기 위해 dfs를 처음 호출하는 메서드
	 * @param map : 맵
	 */
	private static void setMinLenOfWire(int[][] map) {
		int[] posCore = listOfCores.get(0);
		++countCore;
		dfs(map, 0, posCore[0], posCore[1], NONE);
	}
	
	/**
	 * 모든 코어를 탐색하면서 전선을 설치한다.
	 * 전선을 설치한 후에 최소 전선 길이 계산을 위한 메서드 compareLenOfWire()를 호출한다.
	 * @param map : 맵
	 * @param index : 리스트 상의 코어 index
	 * @param r : 현재 코어의 위치 r
	 * @param c : 현재 코어의 위치 c
	 * @param dir : 방향
	 */
	private static void dfs(int[][] map, int index, int r, int c, int dir) {
		
		int nr, nc;
		int[] posCore;
		if (dir == NONE) { // 방향이 정해지지 않은 경우 현재 위치는 안쪽 코어의 위치이다.
			for (dir = 0; dir < 4; ++dir) {
				nr = r + DR[dir];
				nc = c + DC[dir];
				
				// 현재 위치가 안쪽 코어의 위치이므로, 다음 위치는 무조건 범위 내에 있다.
				// 따라서, 범위 체크를 할 필요 없고  빈 공간이 있을 경우에만 dfs를 재귀적으로 호출하면 된다.
				if (map[nr][nc] == EMPTY) {
					map[nr][nc] = WIRE;
					dfs(map, index, nr, nc, dir); // 이 때 전달하는 dir 값으로 인해 다음 dfs부터는 방향이 정해지게 된다.
					map[nr][nc] = EMPTY;
				}
			}
			
			// 현재 코어의 사방을 모두 탐색하고 현재 코어를 사용하지 않고 나머지 코어를 사용하는 경우
			// 현재 코어를 사용하지 않으므로 countCore는 증가시키지 않는다.
			if (index < listSize - 1) { // 나머지 코어가 존재하는 경우
				posCore = listOfCores.get(index + 1);
				dfs(map, index + 1, posCore[0], posCore[1], NONE);
			} else { // 현재 코어가 마지막 코어인 경우 마지막 코어를 제외하고 전선길이를 계산한다.
				--countCore;
				compareLenOfWire(map);
			}
		} else { // 방향이 정해진 경우 다음 위치가 빈 공간이면 직진한다.
			nr = r + DR[dir];
			nc = c + DC[dir];
			
			// 전선이 연결된 경우
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				// 남은 코어가 있을 경우
				if (index < listSize - 1) {
					posCore = listOfCores.get(index + 1);
					++countCore;
					dfs(map, index + 1, posCore[0], posCore[1], NONE);
				} else { // 모든 코어를 탐색하고 마지막 코어가 전선에 연결된 경우
					compareLenOfWire(map);
				}
			} else if (map[nr][nc] == EMPTY) { // 다음 위치가 빈 공간이면 직진한다.
				map[nr][nc] = WIRE;
				dfs(map, index, nr, nc, dir);
				map[nr][nc] = EMPTY;
			}
		}
	}
	
	/**
	 * 전선길이를 계산하고, 이전에 계산된 전선길이와 비교하여 짧은 전선길이로 초기화한다.
	 * @param map
	 */
	private static void compareLenOfWire(int[][] map) {
		// 현재 맵에 깔린 전선의 길이 계산
		int tempLength = 0;
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				if (map[r][c] == WIRE) {
					++tempLength;
				}
			}
		}
		
		// 기존에 사용한 코어 개수보다 현재 계산한 코어의 개수가 더 크면 maxCountCore와 minLength를 현재 값으로 초기화한다.
		if (maxCountCore < countCore) {
			maxCountCore = countCore;
			minLength = tempLength;
		} else if (maxCountCore == countCore) { // 계산된 코어 개수가 같을 경우 전선 길이가 짧은 쪽으로 초기화한다.
			if (minLength > tempLength) minLength = tempLength;
		}
	}
	
	/**
	 * 맵 디버깅용
	 * @param map : 맵
	 */
//	private static void debugMap(int[][] map) {
//		for (int r = 0; r < N; ++r) {
//			for (int c = 0; c < N; ++c) {
//				System.out.print(map[r][c] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}