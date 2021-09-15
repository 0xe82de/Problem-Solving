package swea.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124_1 {
	
	static int V, E;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			Edge[] edgeList = new Edge[E];
			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int src = Integer.parseInt(st.nextToken()); 
				int dst = Integer.parseInt(st.nextToken()); 
				int w = Integer.parseInt(st.nextToken());
				
				edgeList[i] = new Edge(src, dst, w);
			}
			
			Arrays.sort(edgeList);
			
			make();
			
			int cnt = 0;
			long result = 0;
			for (Edge edge : edgeList) {
				if (union(edge.src, edge.dst)) {
					result += edge.w;
					if (++cnt == V - 1) break;
				}
			}
			
			sb.append("#" + tc + " " + result + "\n");
		}

		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
		
	}

	static class Edge implements Comparable<Edge> {
		
		int src, dst, w;
		
		public Edge(int src, int dst, int w) {
			super();
			this.src = src;
			this.dst = dst;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	private static void make() {
		parents = new int[V + 1];
		
		for (int i = 1; i <= V; ++i) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
