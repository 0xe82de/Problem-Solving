package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 2193 이진수
 * S3
 * DP
 */

public class BOJ_2193_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int N = Integer.parseInt(br.readLine());
		long[] DP = new long[N + 1];
		
		DP[1] = 1;
		if (N > 1) {
			DP[2] = 1;
			for (int i = 3; i <= N; ++i) {
				DP[i] = DP[i - 1] + DP[i - 2];
			}
		}
			
		// output
		bw.write(String.valueOf(DP[N]));

		// io close
		bw.close();
		br.close();	
	}
}