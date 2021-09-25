package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 10872 팩토리얼
 * B3
 * 수학, 구현
 */

public class BOJ_10872_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int N = Integer.parseInt(br.readLine());

		// output
		bw.write(String.valueOf(fact(N)));

		// io close
		bw.close();
		br.close();
	}
	
	private static int fact(int n) {
		if (n <= 1) return 1;
		else return n * fact(n - 1);
	}
}