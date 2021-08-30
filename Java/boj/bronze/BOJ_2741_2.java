package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2741_2 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; ++i) {
			sb.append(i + "\n");
		}
		
		// output
		bw.write(sb.toString());
		
		// io close
		bw.close();
		br.close();
	}

}
