package boj.gold4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1806 {
	
	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// 10 <= N <= 10,000
		final int N = Integer.parseInt(st.nextToken());
		
		// 0 <= S <= 100,000,000 1억
		final int S = Integer.parseInt(st.nextToken());
		
		
		int[] input = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) input[i] = Integer.parseInt(st.nextToken());
		
		// logic
		// two pointer
		int len = Integer.MAX_VALUE;
		int src = 0;
		int dst = 0;
		int sum = 0;
		while (dst <= N && src <= N) {
			if (sum >= S && len > dst - src) {
				len = dst - src;
			} // sum이 S보다 클 때 길이를 비교해서 가장 짧은 길이 저장
			
			// 맨 앞부터 포인터 2개로 sum 계산
			// sum이 S보다 작으면 계속 더한다.
			// sum이 S보다 크면 맨 앞부터 뺀다.
			if (sum < S) {
				sum += input[dst++];
			} else {
				sum -= input[src++];
			}
		}
		
		// output
		bw.write(String.valueOf(len == Integer.MAX_VALUE ? 0 : len));
		bw.close();
		br.close();
	}

}
