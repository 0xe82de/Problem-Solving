package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ 1707 이분 그래프
 * G4
 * DFS, BFS
 */

public class BOJ_1707_1 {
	
	static int V, E;
	static int[] parents;
	static Edge[] edgeList;
	static int[] checked;
	
	// 이분 그래프 영역 구분용
	static int RED = 1;
	static int BLUE = 2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		// 테스트 케이스 개수
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			// 1 <= V <= 20,000
			// 1 <= E <= 200,000
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수
			
			checked = new int[V + 1];
			
//			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
//					else return Integer.compare(o1[1], o2[1]);
//				}
//			});
			PriorityQueue<int[]> pq = new PriorityQueue<>(
					(int[] o1, int[] o2) -> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])
			);
			
			// 간선을 저장할 배열 초기화
			edgeList = new Edge[E];
			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int src = Integer.parseInt(st.nextToken());
				int dst = Integer.parseInt(st.nextToken());
				
				// 간선리스트에 간선 추가
				pq.offer(new int[] {src, dst});
			}
			
			String result = null;
			if (isBipartiteGraph(pq)) result = "YES";
			else result = "NO";
			
			// 출력 문자열 합치기
			sb.append(result + "\n");
			
//			// 부모 초기화
//			make();
//			
//			// 출발지 기준으로 정렬
//			Arrays.sort(edgeList);
//			
//			// 결과 문자열 변수
//			String result = "YES";
//			for (Edge edge : edgeList) {
//				// 부모를 합칠 수 있으면 continue
//				if (union(edge.src, edge.dst)) continue;
//				
//				// 부모가 같으면 이분 그래프가 아니다.
//				result = "NO";
//			}
//			
//			// 출력 문자열 합치기
//			sb.append(result + "\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// io close
		bw.close();
		br.close();
	}
	
	private static boolean isBipartiteGraph(PriorityQueue<int[]> pq) {
		
		int flag = RED;
		int[] now = pq.poll();
		int base = now[0];
		checked[base] = 1;
		checked[now[1]] = 2;
		while (!pq.isEmpty()) {
			now = pq.poll();
			if (base != now[0]) {
//				if (checked[base] != 0 || checked[now[1]])
				if (flag == 1) {
					checked[base] = 2;
					checked[now[1]] = 1;
				} else {
					checked[base] = 1;
					checked[now[1]] = 2;
				}
			} else {
				if (flag == 1) {
					checked[base] = 1;
					checked[now[1]] = 2;
				} else {
					checked[base] = 2;
					checked[now[1]] = 1;
				}
			}
		}
		return false;
	}
	
	// 간선 클래스
	static class Edge implements Comparable<Edge> {
		int src, dst;
		
		public Edge(int src, int dst) {
			this.src = src;
			this.dst = dst;
		}

		@Override
		public int compareTo(Edge o) {
			if (this.src != o.src) return Integer.compare(this.src, o.src);
			else return Integer.compare(this.dst, o.dst);
		}
	}
	
	/**
	 * 부모를 자기 자신으로 초기화한다.
	 */
	private static void make() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; ++i) {
			parents[i] = i;
		}
	}
	
	/**
	 * 합칠 수 있는지 여부를 리턴한다.
	 * @param a : 출발지
	 * @param b : 도착지
	 * @return 합치면 true, 아니면 false
	 */
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	/**
	 * 부모를 찾아서 리턴한다.
	 * @param a : 정점
	 * @return 정점의 부모
	 */
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
}