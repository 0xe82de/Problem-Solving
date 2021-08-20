package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_1 {

	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Queue<Integer> result = new LinkedList<>();
		
		final int N = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		
		int[] input = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		
		// logic
		for (int i = 1; i <= N; ++i) {
			input[i] = i;
		}
		
		int i = 1;
		int count = 0;
		int fullCount = 0;
		while (true) {		
			
			++count;
			
			while (visit[i] == true) {
				if (++i == N + 1) i = 1;
			}
			
			if (count % K == 0) {
				result.offer(input[i]);
				visit[i] = true;
				++fullCount;
				count = 0;
			}
			
			if (fullCount == N) break;
			if (count == K) count = 0;
			if (++i > N) i = 1;
		}
		
		// output
		sb.append("<");
		for (int n = 0; n < N; ++n) {
			sb.append(result.poll() + ", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		 
	}

}
