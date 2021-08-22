package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11576_1 {

	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// A, B 세계의 진법
		// 2 <= A, B <= 30
		st = new StringTokenizer(br.readLine(), " ");
		
		// A 세계의 진법
		final int SCALE_A = Integer.parseInt(st.nextToken());
		
		// B 세계의 진법
		final int SCALE_B = Integer.parseInt(st.nextToken());
		
		// 1 <= m <= 25
		int m = Integer.parseInt(br.readLine());
		
		// A 세계의 자리수 별 값 입력
		st = new StringTokenizer(br.readLine(), " ");
		
		// A 세계의 숫자를 10진수로 저장
		int sum = 0;
		for (int i = 0; i < m; ++i) {
			sum += pow(SCALE_A, m - i - 1) * Integer.parseInt(st.nextToken());
		}
		
		do {
			sb.insert(0, sum % SCALE_B + " "); // 나누면서 남은 값을 맨 앞에 붙인다
			sum = sum / SCALE_B; // 몫을 계산
		} while (sum > 0); // 몫이 0이면 끝낸다.
		
		// 출력
		bw.write(sb.toString());
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	
	/**
	 * @param number : 제곱할 값
	 * @param n : 자리수
	 * @return : 결과
	 */
	private static int pow(int number, int n) {
		// 0 제곱 -> 1 리턴
		if (n == 0) return 1;
		
		int res = 1;
		
		do {
			res = res * number;
		} while (--n > 0);
		
		return res;
	}
}
