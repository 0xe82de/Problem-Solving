package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1463_2 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int N = Integer.parseInt(br.readLine());
		
		// output
		bw.write(String.valueOf(getMin(N)));

		// io close
		bw.close();
		br.close();
	}
	
	private static int getMin(int n) {
		
		// 연산회수
		int[] memo = new int[n + 1];
		
		for (int i = 2; i <= n; i++) {
			// 직전 값에서 +1을 했을 때 연산회수 1을 더한다.
			memo[i] = memo[i - 1] + 1;
			
			// +1 연산을 했을 때와 2로 나누었을 때의 연산회수를 비교하고 작은 값을 memo[i]에 넣는다.
			if (i % 2 == 0) memo[i] = Math.min(memo[i], memo[i / 2] + 1);
			
			// 위 if 문에서 초기화된 연산회수와 3으로 나누었을 때의 연산회수를 비교하고 작은 값을 memo[i]에 넣는다.
			if (i % 3 == 0) memo[i] = Math.min(memo[i], memo[i / 3] + 1);
		}
		
		return memo[n];
	}
}