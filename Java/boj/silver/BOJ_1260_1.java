package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_1 {
	
	static boolean[] visit;
	
	private static void bfs(int[][] treeInfo, int V) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(V);
		visit[V] = true;
		while (!queue.isEmpty()) {
 			int data = queue.poll();
 			System.out.print(data + " ");
			
  			for (int i = 1; i < treeInfo.length; ++i) {
  				if (!visit[i] && treeInfo[data][i] == 1) {
  					queue.offer(i);
  					visit[i] = true;
  				}
			}
		}
		
	}
	
	private static void dfs(int[][] treeInfo, int V) {
		
		visit[V] = true;
		System.out.print(V + " ");
		
		for (int i = 1; i < treeInfo.length; ++i) {
			if (!visit[i] && treeInfo[V][i] == 1) {
				dfs(treeInfo, i);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		//  N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 10,000)
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		final int V = Integer.parseInt(st.nextToken());
		
		int[][] treeInfo = new int[N + 1][N + 1];
		
		// logic
		int a, b;
		for (int i = 0; i < M; ++i) {
			
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			treeInfo[a][b] = 1;
			treeInfo[b][a] = 1;
			
		}
		
		visit = new boolean[N + 1];
		
		dfs(treeInfo, V);
		Arrays.fill(visit, false);
		System.out.println("");
		bfs(treeInfo, V);
		
		br.close();
		
	}

}
