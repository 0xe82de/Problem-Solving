package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10953_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 개수
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; ++tc) {
			char[] input = br.readLine().toCharArray();
			
			int num1 = input[0] - '0';
			int num2 = input[2] - '0';
			
			sb.append(num1 + num2);
			sb.append("\n");
		}
		
		// output
		bw.write(sb.toString());
		
		// io close
		br.close();
		bw.close();
	}
}