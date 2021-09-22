package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * BOJ 1712 손익분기점
 * B4
 * 수학, 사칙연산
 * 단계별로 풀어보기 : 기본 수학 1
 */

public class BOJ_1712_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		final int A = Integer.parseInt(st.nextToken());
		final int B = Integer.parseInt(st.nextToken());
		final int C = Integer.parseInt(st.nextToken());
		
		// 가변 비용이 가격보다 크거나 같을 때 절대 이익을 볼 수 없다.
		if (B >= C) sb.append(-1);
		else sb.append((int)Math.ceil((A / (C - B) + 1)));
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}