package jungol.intermediate_coder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * JUNGOL 1681 해밀턴 순환회로
 * Intermediate_Coder
 * 백트래킹
 */

public class jungol_1681_1 {
	
	static int minCost = 500;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		// 장소의 수
		final int N = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[N][N];
		
		// map setting
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		
		// 첫 번째 장소부터 방문하므로 true로 초기화
		visited[0] = true;
		
		dfs(map, N, 0, 0, 0);
		
		// output
		bw.write(String.valueOf(minCost));

		// io close
		bw.close();
		br.close();
	}
	
	/**
	 * 모든 장소를 방문하면서 최소 비용을 계산하고 minCost에 저장한다.
	 * @param map : 장소 간의 비용
	 * @param N : 사이즈
	 * @param tmpCost : 임시 비용
	 * @param cur : 현재 장소
	 * @param cnt : 장소 카운팅
	 */
	private static void dfs(int[][] map, int N, int tmpCost, int cur, int cnt) {
		if (cnt == N - 1) {
			if (map[cur][0] == 0) return;
			
			tmpCost += map[cur][0];
			if (minCost > tmpCost) minCost = tmpCost;
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			// 이동할 수 없거나 이미 방문했으면
			if (map[cur][i] == 0 || visited[i]) continue;
			
			// 백트래킹
			if (tmpCost + map[cur][i] > minCost) continue;
			
			
			visited[i] = true;
			dfs(map, N, tmpCost + map[cur][i], i, cnt + 1);
			visited[i] = false;
		}
	}
}