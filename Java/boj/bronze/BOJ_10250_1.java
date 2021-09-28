package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * BOJ 10250 ACM 호텔
 * B3
 * 수학, 구현, 사칙연산
 */

public class BOJ_10250_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		final int TC = Integer.parseInt(br.readLine());
		
		int floor = 0;
		double roomNumber = 0.0;
		for (int tc = 1; tc <= TC; ++tc) {
			// 1 ≤ H, W ≤ 99, 1 ≤ N ≤ H × W 
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			// 나머지가 0이면 최고층이다.
			floor = N % H != 0 ? N % H : H;
			roomNumber = (double)N / H;
			
			// 소수점 숫자가 있으면 ++해준다.
			if (roomNumber - (int)roomNumber > 0) ++roomNumber;
			
			sb.append(floor);
			sb.append(String.format("%02d", (int)roomNumber));
			sb.append("\n");
		}

		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}