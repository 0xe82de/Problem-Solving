package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_3 {
	
	static class Node {
		int vertex; // 인접 정점 인덱스
		Node link;
		
		public Node() {};
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
	}
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 정점의 개수
		final int N = Integer.parseInt(st.nextToken());
		
		// 간선의 개수
		final int M = Integer.parseInt(st.nextToken());
		
		// 루트 노드
		final int V = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[N + 1];
		
		for (int i = 0; i < M; ++i) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		// dfs
		dfs(adjList, V, new boolean[N + 1]);
		
		sb.append("\n");
		
		// bfs
		bfs(adjList, V, new boolean[N + 1]);
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	/**
	 * @param adjList : 인접리스트
	 * @param current : 현재 방문한 노드
	 * @param isVisit : 방문 체크
	 */
	private static void dfs(Node[] adjList, int current, boolean[] isVisit) {
		
		isVisit[current] = true;
		sb.append(current);
		sb.append(" ");
		
		for (Node node = adjList[current]; node != null; node = node.link) {
			if (!isVisit[node.vertex]) {
				isVisit[node.vertex] = true;
				dfs(adjList, node.vertex, isVisit);
			}
		}
	}
	
	/**
	 * @param adjList : 인접리스트
	 * @param current : 현재 방문한 노드
	 * @param isVisit : 방문 체크
	 */
	private static void bfs(Node[] adjList, int current, boolean[] isVisit) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(current);
		isVisit[current] = true;
		
		while (!queue.isEmpty()) {
			
			current = queue.poll();
			sb.append(current);
			sb.append(" ");
			
			for (Node node = adjList[current]; node != null; node = node.link) {
				if (!isVisit[node.vertex]) {
					queue.offer(node.vertex);
					isVisit[node.vertex] = true;
				}
			}
			
		}
		
		
	}
}
