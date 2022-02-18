package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_3 {

	/**
	 * 정점의 개수
	 * 1 <= N <= 1,000
	 */
	static int N;

	/**
	 * 간선의 개수
	 * 1 <= M <= 10,000
	 */
	static int M;

	/**
	 * 탐색을 시작할 정점
	 */
	static int V;

	/**
	 * 인접행렬
	 */
	static boolean[][] adjMatrix;

	/**
	 * 출력 문자열 빌더
	 */
	static StringBuilder sb = new StringBuilder();

	/**
	 * 방문 체크
	 */
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// logic
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adjMatrix = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			adjMatrix[src][dst] = true;
			adjMatrix[dst][src] = true;
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		bfs();

		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}

	private static void dfs(int v) {
		sb.append(v).append(" ");
		visited[v] = true;

		for (int node = 1; node <= N; node++) {
			if (visited[node] || !adjMatrix[v][node]) continue;

			dfs(node);
		}
	}

	private static void bfs() {
		visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		visited[V] = true;

		while (!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append(" ");

			for (int node = 1; node <= N; node++) {
				if (visited[node] || !adjMatrix[v][node]) continue;

				q.offer(node);
				visited[node] = true;
			}
		}
	}

}
