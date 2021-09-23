package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 2292 벌집
 * B2
 * 수학
 * 단계별로 풀어보기 : 기본 수학 1
 */

public class BOJ_2292_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int N = Integer.parseInt(br.readLine());
		int count = 1;
		
		int i = 1;
		while (N > count) {
			count += (6 * i);
			++i;
		}
		
		// output
		bw.write(String.valueOf(i));

		// io close
		bw.close();
		br.close();
	}
}