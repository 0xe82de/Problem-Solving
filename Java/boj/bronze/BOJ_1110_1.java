package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 1110 더하기 사이클
 * B1
 * 구현
 */

public class BOJ_1110_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 0 <= N <= 99
		final int N = Integer.parseInt(br.readLine());
		int count = 0;
		int temp = N;
		
		do {
			// 26 -> N -> temp
			// (temp % 10) * 10 => 60
			// (((temp / 10) + (temp % 10)) % 10) => 8
			temp = (temp % 10) * 10 + (((temp / 10) + (temp % 10)) % 10);
			++count;
		} while (N != temp);
		
		
		// output
		bw.write(String.valueOf(count));

		// io close
		bw.close();
		br.close();
	}
}