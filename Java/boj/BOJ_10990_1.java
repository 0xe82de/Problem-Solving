package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10990_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			
			for (int j = i; j < N - 1; ++j) sb.append(" ");
			sb.append("*");
			
			if (i > 0) {
				for (int j = 0, count = 2 * i - 1; j < count; ++j) sb.append(" ");
				sb.append("*");
			}
			sb.append("\n");
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}