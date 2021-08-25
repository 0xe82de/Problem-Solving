package boj.gold;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 정점의 개수가 최대 20,000개이므로 인접행렬로 처리할 수 없다. N^2 -> 4억개
 */

/*
 * 접근방식
 * 
 * 인접리스트
 * 우선순위큐
 */

public class BOJ_1753_1 {
	
	static class Node {
		int vertex; // 인접 정점 값
		int weight; // 인접 정점으로 가는 가중치
		Node link; // 인접 노드
		
		public Node(int vertex, int weight, Node link) {
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}

	static class Vertex implements Comparable<Vertex>{
		int no; // 정점 값
		int distance; // 시작점에서 현재까지 거리

		public Vertex(int no, int distance) {
			super();
			this.no = no;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.distance, o.distance);
		}
	}

	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// 정점의 개수 V, 1 ~ 20,000
		final int V = Integer.parseInt(st.nextToken());
		
		// 간선의 개수 E, 1 ~ 300,000
		final int E = Integer.parseInt(st.nextToken());
		
		// 시작 정점의 번호 K
		final int K = Integer.parseInt(br.readLine());
		
		// 방문 체크용 배열
		boolean[] isVisit = new boolean[V + 1];
		
		// 1 <= V <= 20,000
		Node[] adjList = new Node[V + 1];
		
		// 거리 배열
		int[] distance = new int[V + 1];
		
		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 인접리스트
			adjList[from] = new Node(to, w, adjList[from]);
		}
		
		// 모든 거리를 MAX 값으로 저장
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// 시작점 K
		int start = K;
		
		// 시작점 ~ 시작점 거리를 0으로 저장
		distance[start] = 0;
		
		// 우선순위큐 생성
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		// 시작점을 pq에 삽입한다.
		pq.offer(new Vertex(start, distance[start]));
		
		// 계산용 Vertex
		Vertex current = null;
		while (!pq.isEmpty()) {
			
			// 1단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			current = pq.poll();
			
			// 방문 체크
			isVisit[current.no]= true;
			
			// 2단계 : current 정점을 경유지로 하여 갈 수 있는 다른 방문하지 않은 정점들에 대한 처리
			for (Node temp = adjList[current.no]; temp != null; temp = temp.link) {
				if (
						!isVisit[temp.vertex] && // 인접리스트에서 다음 정점을 방문하지 않았고
						distance[temp.vertex] > current.distance + temp.weight
						// 기존에 저장되어 있던 거리가 현재 계산된 거리보다 크면
					) {
					// 새로운 거리 저장
					distance[temp.vertex] = current.distance + temp.weight;
					// 우선순위 큐에 삽입한다.
					// 가중치가 낮은 것이 앞쪽으로 간다.
					pq.offer(new Vertex(temp.vertex, distance[temp.vertex]));
				}
			}
		}
		
		// 출력 문자열 만들기
		for (int i = 1; i <= V; ++i) {
			if (distance[i] != Integer.MAX_VALUE) {
				sb.append(distance[i]);
			} else {
				sb.append("INF");
			}
			sb.append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
}
