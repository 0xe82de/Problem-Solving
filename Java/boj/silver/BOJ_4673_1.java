package boj.silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * BOJ 4673 셀프 넘버
 * S5
 * 수학, 구현
 * 단계별로 풀어보기 : 함수
 */

public class BOJ_4673_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		
		// 생성자의 개수를 가지고 있는 배열
		int[] arr = new int[10001];
		
		// 생성자의 개수를 계산
		generate(arr);
		
		for (int i = 1, len = arr.length; i < len; ++i) {
			if (arr[i] == 0) { // 생성자가의 개수가 0인 경우
				sb.append(i + "\n");
			}
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
	}
	
	
	/**
	 * 생성자의 개수를 배열에 저장한다.
	 * @param arr : 생성자의 개수를 저장하는 배열
	 */
	private static void generate(int[] arr) {
		for (int i = 1, len = arr.length; i < len; ++i) {
			// 생성한 숫자
			int res = i;
			
			// 임시 변수
			int temp = i;
			
			// 각 자리수를 더한다.
			while (temp != 0) {
				res += temp % 10;
				temp /= 10;
			}
			
			// 10,000 보다 작거나 같은 값일 경우 배열에서 1 증가시킨다. 배열의 값은  생성자의 개수이다.
			if (res < len) { // len = 10001
				++arr[res];
			}
		}
	}
}