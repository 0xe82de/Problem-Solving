package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 1699 제곱수의 합
 * S3
 * DP
 */

public class BOJ_1699_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		final int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N + 1];
		
		int base = 1;
		for (int i = 1; i <= N; ++i) {
			if (i - square(base + 1) == 0) {
				DP[i] = 1;
				++base;
				continue;
			}
			DP[i] = i;
			for (int j = 1; j <= base; ++j) {
				DP[i] = Math.min(DP[i], DP[i - square(j)] + 1);
			}
		}
		
		// output
		bw.write(String.valueOf(DP[N]));

		// io close
		bw.close();
		br.close();
	}
	
	private static int square(int num) {
		return num * num;
	}
}