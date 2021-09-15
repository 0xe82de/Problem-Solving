package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_1 {
	
	static int[] drHorse = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dcHorse = {-2, -1, 1, 2, -2, -1, 1, 2};
	
	static int[] drMonkey = {0, 1, 0, -1};
	static int[] dcMonkey = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		final int W = Integer.parseInt(st.nextToken());
		final int H = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H][W];
		for (int r = 0; r < H; ++r) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < W; c++) {
 				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// output
		bw.write(String.valueOf(getMin(map, K)));

		// io close
		bw.close();
		br.close();
	}
	
	private static int getMin(int[][] map, int k) {
		
		Queue<int[]> q = new LinkedList<>();
		final int R = map.length; 
		final int C = map[0].length;
		boolean[][][] isVisitByK = new boolean[k + 1][R][C];
		
		q.offer(new int[] {0, 0, k, 0});
		isVisitByK[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] curPos = q.poll();
			
			int cr = curPos[0];
			int cc = curPos[1];
			int ck = curPos[2];
			int ccnt = curPos[3]; 
			
			// 계산된 최소값보다 현재 움직인 카운트가 크면 continue
//			if (ccnt >= minCount) continue;
			
			// 도착 시 리턴
			if (cr == R - 1 && cc == C - 1) {
				return ccnt;
			}
			
			// 말로 갈 수 있는 위치
			if (ck > 0) {
//			if (ck < k) { 0 -> k 테스트
				int[][] nextPos = getPosByHorse(map, cr, cc);
				
				for (int i = 0, len = nextPos.length; i < len; ++i) {
					int nr = nextPos[i][0];
					int nc = nextPos[i][1];
					
					// k -> 0
					if (!isVisitByK[ck - 1][nr][nc]) {
						q.offer(new int[] {nr, nc, ck - 1, ccnt + 1});
						isVisitByK[ck - 1][nr][nc] = true;
					}
					// 0 -> k 테스트
//					if (!isVisitByK[ck + 1][nr][nc]) {
//						q.offer(new int[] {nr, nc, ck + 1, ccnt + 1});
//						isVisitByK[ck + 1][nr][nc] = true;
//					}
				}
			}
			
			// 원숭이로 갈 수 있는 위치
			int[][] nextPos = getPosByMonkey(map, cr, cc);
			for (int i = 0, len = nextPos.length; i < len; ++i) {
				int nr = nextPos[i][0];
				int nc = nextPos[i][1];
				
				// k -> 0 테스트
				if (!isVisitByK[ck][nr][nc]) {
					q.offer(new int[] {nr, nc, ck, ccnt + 1});
					isVisitByK[ck][nr][nc] = true;
				}
				// 0 -> k 테스트
//				if (!isVisitByK[ck][nr][nc]) {
//					q.offer(new int[] {nr, nc, ck, ccnt + 1});
//					isVisitByK[ck][nr][nc] = true;
//				}
			}
		}
		
		return -1;
	}
	
	private static int[][] getPosByHorse(int[][] map, int cr, int cc) {
		
		List<int[]> list = new ArrayList<>();
		
		final int R = map.length;
		final int C = map[0].length;
		
		for (int dir = 0; dir < 8; ++dir) {
			int nr = cr + drHorse[dir];
			int nc = cc + dcHorse[dir];
			
			if (
					nr >= 0 && nr < R &&
					nc >= 0 && nc < C &&
					map[nr][nc] != 1 // 다음 위치가 범위 내에 있고 장애물이 아니면
					) {
				list.add(new int[] {nr, nc});
			}
		}
		
		return list.toArray(new int[list.size()][2]);
	}
	
	private static int[][] getPosByMonkey(int[][] map, int cr, int cc) {
		
		List<int[]> list = new ArrayList<>();
		
		final int R = map.length;
		final int C = map[0].length;
		
		for (int dir = 0; dir < 4; ++dir) {
			int nr = cr + drMonkey[dir];
			int nc = cc + dcMonkey[dir];
			
			if (
					nr >= 0 && nr < R &&
					nc >= 0 && nc < C &&
					map[nr][nc] != 1 // 다음 위치가 범위 내에 있고 장애물이 아니면
					) {
				list.add(new int[] {nr, nc});
			}
		}
		
		return list.toArray(new int[list.size()][2]);
	}
}