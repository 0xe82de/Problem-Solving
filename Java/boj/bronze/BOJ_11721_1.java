package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11721_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		
		for (int i = 0, len = s.length(); i < len; ++i) {
			sb.append(s.charAt(i));
			if ((i + 1) % 10 == 0) sb.append("\n");
		}

		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}