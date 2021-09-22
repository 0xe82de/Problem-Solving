package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * BOJ 4344 평균은 넘겠지
 * B1
 * 수학, 사칙연산
 * 단계별로 풀어보기 : 1차원 배열
 */

public class BOJ_4344_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		// 테스트 케이스 개수
		final int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; ++tc) {
			int N = 0; // 학생들의 수
			int[] arr; // point 배열
			int sum = 0; // point 합계
			double avg = 0.0; // point 평균
			int count = 0; // 평균을 넘는 학생들의 수
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// 1 <= N <= 1,000
			N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			for (int i = 0; i < N; ++i) {
				// point => arr[i], 0 <= point <= 100
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			avg = (double)sum / N;
			
			for (int i = 0; i < N; ++i) {
				if (arr[i] > avg) ++count;
			}
			
			sb.append(String.format("%.3f", ((double)count / N) * 100));
			sb.append("%\n");
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}