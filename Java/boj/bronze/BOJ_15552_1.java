package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * BOJ 15552 빠른 A+B
 * B2
 * 구현
 */

public class BOJ_15552_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			sb.append(String.valueOf(first + second) + "\n");
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}