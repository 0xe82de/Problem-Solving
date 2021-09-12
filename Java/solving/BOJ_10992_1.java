package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10992_1 {

	public static void main(String[] args) throws IOException {
		
//		System.setIn(new FileInputStream("input.txt"));
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			int space = i < N ? (N - i) - 1 : (i - N) + 1;
			int star = N - space;
			
			for (int j = 0; j < space; ++j) {
				sb.append(" ");
			}
			
			if (N < 3) {
				for (int j = 0; j < star; ++j) sb.append("*");
				if (i == 1) sb.append("*");
			} else {
				if (i < N - 2) {
					for (int j = 0; j < star; ++j) {
						sb.append("*");
						sb.append(" ");
					}
				} else if (i == N - 2) {
					sb.append("*");
					for (int j = 0; j < N * 2 - 5; ++j) {
						sb.append(" ");
					}
					sb.append("*");
				} else {
					for (int j = 0; j < N * 2 - 1; ++j) {
						sb.append("*");
					}
				}
			}
			
//			System.out.println("");
			sb.append("\n");
		}
//		sb.delete(sb.length() - 2, sb.length() - 1);
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}