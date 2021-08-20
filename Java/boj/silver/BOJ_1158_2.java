package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_2 {

	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		final int N = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		// logic
		for (int i = 1; i <= N; ++i) {
			queue.offer(i);
		}
		
		int count = 1;
		sb.append("<");
		while (!queue.isEmpty()) {
			if (count % K == 0) sb.append(queue.poll() + ", ");
			else queue.offer(queue.poll());
			++count;
		}
		
		// output
		sb.setLength(sb.length() - 2);
		sb.append(">");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
		 
	}

}
