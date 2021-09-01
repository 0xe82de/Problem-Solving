package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_8958_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		// 퀴즈의 개수
		final int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; ++i) {
			
			// 퀴즈의 정답 배열
			char[] answer = br.readLine().toCharArray();
			
			// 점수
			int point = 0;
			
			// 합산
			int sum = 0;
			
			for (int j = 0, len = answer.length; j < len; ++j) {
				// 정답이면 point 증가 후 합산한다.
				if (answer[j] == 'O') {
					++point;
					sum += point;
				} else point = 0; // 오답이면 포인트를 초기화한다.
			}
			
			sb.append(sum);
			sb.append("\n");
		}
		
		// output
		System.out.print(sb.toString());
		
		// io close
		br.close();
	}
}
