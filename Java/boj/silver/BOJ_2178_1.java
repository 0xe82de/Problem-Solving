package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * BOJ 2178 미로탐색
 * S1
 * DFS
 */

public class BOJ_2178_1 {
	
	// 결과 변수
	static int sum;
	
	// 맵 사이즈
	static int N, M;
	
	// 맵
	static char[][] map;
	
	// 방향 델타 상수, 우 하 좌 상
	static final int[] DR = {0, 1, 0, -1}; 
	static final int[] DC = {1, 0, -1, 0};
	
	// 상수
	static char WALL = '0';
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 맵 초기화
		map = new char[N][M];
		for (int r = 0; r < N; ++r) map[r] = br.readLine().toCharArray();
		
		// 최대값
		sum = N * M;
		
		bfs();
		
		// output
		bw.write(String.valueOf(sum));
		
		// io close
		bw.close();
		br.close();
	}
	
	/**
	 * 맵을 bfs 탐색하면서 최소 이동 칸수 계산하여 저장한다.
	 */
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 0});
		
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int cr = temp[0];
			int cc = temp[1];
			int cSum = temp[2];
			
			// 목적지에 도달하면 기존에 계산된 sum과 비교하여 더 작은 값을 저장한다.
			if (cr == N - 1 && cc == M - 1) {
				if (sum > cSum + 1) sum = cSum + 1;
				continue;
			}
			
			// 사방 탐색
			for (int dir = 0; dir < 4; ++dir) {
				int nr = cr + DR[dir];
				int nc = cc + DC[dir];
				
				// 범위 초과 or 벽 or 기존의 sum보다 크면 continue
				if (isOutRange(nr, nc) || map[nr][nc] == WALL || sum < cSum + 1) continue;
				
				// 다음 위치를 벽으로 만들어서 더 이상 방문하지 않도록 한다.
				map[nr][nc] = WALL;
				
				// 큐에 저장한다.
				q.offer(new int[] {nr, nc, cSum + 1});
			}
		}
	}
	
	/**
	 * 맵의 범위를 초과하는지 확인하고 결과를 리턴한다.
	 * @param r : 현재 위치 r
	 * @param c : 현재 위치 c
	 * @return 범위를 초과하면 true, 아니면 false
	 */
	private static boolean isOutRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) return true;
		return false;
	}
}