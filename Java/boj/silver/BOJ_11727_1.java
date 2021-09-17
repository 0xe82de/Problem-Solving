package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 11727 2xn 타일링 2
 */

public class BOJ_11727_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i = 2; i <= N; ++i) {
			arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
		}

		// output
		bw.write(String.valueOf(arr[N]));

		// io close
		bw.close();
		br.close();
	}
}