package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1251_1 {
	
	static final int X = 0;
	static final int Y = 1;

	static class Vertex implements Comparable<Vertex> {
		
		int no;
		double distance;
		
		public Vertex(int no, double distance) {
			super();
			this.no = no;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.distance, o.distance);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 테스트 케이스 개수
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			// 섬의 개수 N, 1 ~ 1,000
			int N = Integer.parseInt(br.readLine());
			int[][] posIsland = new int[N][2];
			
			// 섬들의 X 좌표들
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; ++i) posIsland[i][X] = Integer.parseInt(st.nextToken());
			
			// 섬들의 Y 좌표들
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; ++i) posIsland[i][Y] = Integer.parseInt(st.nextToken());
			
			// 세율
			double E = Double.parseDouble(br.readLine());
			
			// 환경부담금
			double tax = E * getMinLengthOfTunnel(posIsland);
			
			// 출력 문자열 합치기
			sb.append("#").append(tc);
			sb.append(" ").append(Math.round(tax)); // 소수점 1의 자리에서 반올림하여 정수 출력
			sb.append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	/**
	 * 최소신장트리의 합을 리턴한다.
	 * @param posIsland : 섬의 XY 좌표
	 * @return 최소신장트리의 합
	 */
	private static double getMinLengthOfTunnel(int[][] posIsland) {
		
		// 인접행렬
		double[][] adjMatrix = getAdjMatrix(posIsland);
		
		// 사이즈
		int n = adjMatrix.length;
		
		// 방문 체크
		boolean[] isVisit = new boolean[n];
		
		// 거리 비교용
		double[] distance = new double[n];
		Arrays.fill(distance, Double.MAX_VALUE);
		
		// 최소신장트리 비용
		double result = 0;
		
		// 임의의 시작점 0
		int start = 0;
		
		// 시작점의 거리를 0으로 설정
		distance[start] = 0;
		
		// 우선순위큐
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		
		// 시작점 offer
		pq.offer(new Vertex(start, distance[start]));
		
		// 비교 인접점
		Vertex current = null;
		while (!pq.isEmpty()) {
			// 가중치가 가장 작은 섬을 꺼낸다.
			current = pq.poll();
			
			// 방문 체크
			if(isVisit[current.no]) continue;
			isVisit[current.no] = true;
			
			// 거리 누적
			result += current.distance;
			
			for (int c = 0; c < n; ++c) {
				if (
						!isVisit[c] && // 방문하지 않았고
						adjMatrix[current.no][c] != 0 && // 거리가 0이 아니고
						distance[c] > adjMatrix[current.no][c] // 가장 짧은 거리로 계산
					) {
					// pq에 거리 저장
					// 거리가 가장 짧은 순서대로 들어감
					distance[c] = adjMatrix[current.no][c];
					pq.offer(new Vertex(c, distance[c]));
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 인접행렬을 리턴한다.
	 * @param posIsland : 섬의 XY 좌표
	 * @return 인접행렬
	 */
	private static double[][] getAdjMatrix(int[][] posIsland) {
		
		int n = posIsland.length;
		double[][] adjMatrix = new double[n][n];
		
		for (int i = 0; i < n; ++i) {
			adjMatrix[i][i] = 0;
			for (int j = i; j < n; ++j) {
				 adjMatrix[i][j] = adjMatrix[j][i] = getDistanceXY(posIsland[i], posIsland[j]);
			}
		}
		
		return adjMatrix;
	}
	
	/**
	 * 두 섬 사이의 거리를 리턴한다.
	 * 거리 계산 : (|a.x - b.x|)^2 + (|a.y - b.y|)^2
	 * @param a : a 섬
	 * @param b : b 섬
	 * @return 두 섬 사이의 거리
	 */
	private static double getDistanceXY(int[] a, int[] b) {
		return Math.pow(a[X] - b[X], 2) + Math.pow(a[Y] - b[Y], 2); // Math.pow return -> Double
	}

}
