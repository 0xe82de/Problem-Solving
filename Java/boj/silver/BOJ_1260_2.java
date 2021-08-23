package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_2 {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		// 정점의 개수 N, 1 <= N <= 1000
		// 간선의 개수 M, 1 <= M <= 10000
		// 루트 노트 V
		st = new StringTokenizer(br.readLine(), " ");
		
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		final int V = Integer.parseInt(st.nextToken());
		
		// 인접행렬
		boolean[][] adjMatrix = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			// 인접 행렬 값 저장
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}
		
		// dfs
		dfs(adjMatrix, N, V, new boolean[N + 1]);
		
		sb.append("\n");
		
		// bfs
		bfs(adjMatrix, N, V);
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	/**
	 * @param adjMatrix : 인접행렬
	 * @param N : 행렬 사이즈
	 * @param current : 현재 노드
	 * @param isVisit : 방문 체크용
	 */
	private static void dfs(boolean[][] adjMatrix, int N, int current, boolean[] isVisit) {
		
		// 현재 방문한 노드 기억
		isVisit[current] = true;
		
		// 출력 저장
		sb.append(current);
		sb.append(" ");
		
		for (int i = 1; i <= N; ++i) {
			// 인접행렬이 true이고, 아직 방문하지 않았다면
			if (adjMatrix[current][i] && !isVisit[i]) {
				// 다음 방문할 노드인 i를 매개변수로 보낸다.
				dfs(adjMatrix, N, i, isVisit);
			}
		}
	}
	
	/**
	 * @param adjMatrix : 인접행렬
	 * @param N : 행렬 사이즈
	 * @param root : 시작 노드
	 */
	private static void bfs(boolean[][] adjMatrix, int N, int root) {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] isVisit = new boolean[N + 1];
		
		// 루트 노드 큐에 삽입
		queue.offer(root);
		isVisit[root] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll(); // 현재 노드 확인
			sb.append(current);
			sb.append(" ");
			
			for (int i = 1; i < N + 1; ++i) {
				// 인접행렬이 true이고, 아직 방문하지 않았다면
				if (adjMatrix[current][i] && !isVisit[i]) {
					// 방문할 노드를 큐에 삽입
					queue.offer(i);
					// 방문 체크
					isVisit[i] = true;
				}
			}
		}
	}
}
