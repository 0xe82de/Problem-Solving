package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 1065 한수
 * S4
 * 브루트포스
 * 단계별로 풀어보기 : 함수
 */

public class BOJ_1065_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int N = Integer.parseInt(br.readLine());
		
		// output
		bw.write(String.valueOf(getCount(N)));

		// io close
		bw.close();
		br.close();
	}
	
	/**
	 * 매개변수 N까지 한수의 개수를 리턴한다.
	 * @param N : 주어진 자연수의 범위. 1 <= N <= 1,000
	 * @return 한수의 개수
	 */
	private static int getCount(int N) {
		if (N < 100) return N;
		
		int count = 0;
		int temp = 0, diff = 0;
		for (int i = 100; i <= N; ++i) {
			temp = i;
			// 1의 자리수 값
			int first = temp % 10;
			temp /= 10;
			
			// 10의 자리수 값
			int second = temp % 10;
			temp /= 10;
			
			// 기준 등차 값
			diff = first - second;
			while (temp != 0) {
				// 다음 자리수 계산을 위해 second -> first 초기화
				first = second;
				
				// 다음 자리수 값
				second = temp % 10;
				temp /= 10;
				
				// 기준 등차 값과 현재 등차 값이 다르면 등차 수열이 아니므로 break
				if (diff != first - second) break;
				// tenp가 0이고 -> 모든 자리수 확인
				// 기준 등차 값과 현재 등차 값이 같으면 등차수열이므로 count 1 증가
				else if (diff == first - second && temp == 0) ++count;
			}
		}
		
		// N이 100 이상일 경우 99를 더해준다. 위 for문에서 100부터 시작하였음.
		return count + 99;
	}
}