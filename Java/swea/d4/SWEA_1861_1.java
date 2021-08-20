package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1861_1 {
	
	private static int finalRoomNumber = 0;
	private static int finalMoveCount = 0;
	private static int currentRoomNumber = 0;
	private static int currentMoveCount = 0;
	
	private static boolean[][] isVisit;
	
	// 추가할 것. 이미 방문한 방은 방문할 필요 없음.
	// => 코드리뷰하면서 추가 완료. main에서 isVisit으로 해결
	private static void recur(int[][] map, int lenMap, int r, int c) {
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int NONE = 4;
		
		// 기준 값보댜 1 큰 값의 방향으로 설정
		int dir = 0;
		
		// 0: 상
		// 1: 하
		// 2: 좌
		// 3: 우
		for (; dir < NONE; ++dir) {
			if (
					r + dr[dir] >= 0 && r + dr[dir] < lenMap &&
					c + dc[dir] >= 0 && c + dc[dir] < lenMap &&
					(map[r + dr[dir]][c + dc[dir]] == map[r][c] + 1)
				) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				isVisit[nr][nc] = true;
				
				++currentMoveCount;
				recur(map, lenMap, nr, nc);
				
				return;
			}
		}
		
		// 방향이 없다면 재귀 끝
		if (dir == NONE){
			if (finalMoveCount < currentMoveCount) {
				finalMoveCount = currentMoveCount;
				finalRoomNumber = currentRoomNumber;
			} else if (finalMoveCount == currentMoveCount && finalRoomNumber > currentRoomNumber) {
				finalRoomNumber = currentRoomNumber;
			}
			
			return;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		final int TC = Integer.parseInt(br.readLine());
		
		int N;
		int[][] map;
		for (int tc = 0; tc < TC; ++tc) {
			
			// 1 <= N <= 10^3
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			isVisit = new boolean[N][N];
			
			// N이 1000이라면 1000 x 1000 => 1백만.. TC가 100개라면 1억
			for (int r = 0; r < N; ++r) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; ++c) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#" + (tc + 1) + " ");
			for (int r = 0; r < N; ++r) {
				for (int c = 0; c < N; ++c) {
					if (isVisit[r][c] == true) continue;
					isVisit[r][c] = true;
					
					currentRoomNumber = map[r][c];
					currentMoveCount = 1;
					
					recur(map, N, r, c);
				}
			}
			sb.append(finalRoomNumber + " " + finalMoveCount + "\n");
			finalRoomNumber = 0;
			finalMoveCount = 0;
		}
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
