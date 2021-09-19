package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 9095 1, 2, 3 더하기
 * S3
 */

public class BOJ_9095_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		final int TC = Integer.parseInt(br.readLine());
		
		int[] input = new int[TC];
		
		for (int tc = 0; tc < TC; ++tc) {
			input[tc] = Integer.parseInt(br.readLine());
		}
		
		int max = getMax(input);
		
		int[] DP = new int[max + 1];
		int len = DP.length;
		
		DP[0] = 1;
		DP[1] = 1;
		DP[2] = 2;
		for (int i = 3; i < len; ++i) {
			DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3];
		}
		
		for (int i = 0; i < TC; ++i) {
			sb.append(DP[input[i]] + "\n");
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
	
	private static int getMax(int[] input) {
		int temp = 0;
		for (int i = 0, len = input.length; i < len; ++i) {
			if (temp < input[i]) temp = input[i];
		}
		return temp;
	}
}