package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2445_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(br.readLine());
		final int N2 = N * 2;
		
		for (int i = 0; i < N2 - 1; ++i) {
			int space = (i < N ? N - i - 1 : i - N + 1) * 2;
			int star = (N2 - space) / 2;
			
			for (int j = 0; j < star; ++j) sb.append("*");
			for (int j = 0; j < space; ++j) sb.append(" ");
			for (int j = 0; j < star; ++j) sb.append("*");
			sb.append("\n");
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}