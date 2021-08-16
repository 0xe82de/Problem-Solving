package boj.silver1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	
	private static int bfs(int o, int y, int max) {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[max + 1];
		
		int node = 0;
		int count = 0;
		
		queue.offer(o);
		int size;
		while (true) {
			size = queue.size();
			
			for (int i = 0; i < size; ++i) {
				node = queue.poll();
				visit[node] = true;
				
				if (y == node) return count;
				else {
					if (node - 1 >= 0 && !visit[node - 1]) {
						queue.offer(node - 1);
						visit[node - 1] = true;
					}
					if (node + 1 <= max && !visit[node + 1]) {
						queue.offer(node + 1);
						visit[node + 1] = true;
					}
					if (node * 2 <= max && !visit[node * 2]) {
						queue.offer(node * 2);
						visit[node * 2] = true;
					}
				}
			}
			++count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		final int MAX = 100000;
		int old = Integer.parseInt(st.nextToken());
		int young = Integer.parseInt(st.nextToken());
		
		// logic
		if (old == young) bw.write(String.valueOf(0));
		else bw.write(String.valueOf(bfs(old, young, MAX)));
		
		bw.close();
		br.close();
		
	}

}
