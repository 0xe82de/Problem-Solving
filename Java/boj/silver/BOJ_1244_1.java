package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1244_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// I/O
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// output string
		StringBuilder sb = new StringBuilder();
		
		// input split
		StringTokenizer st = null;
		
		// 스위치의 개수, 1 ~ 100
		final int SIZE = Integer.parseInt(br.readLine());
		
		// 스위치
		int[] sw = new int[SIZE + 1];
		
		// 스위치 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= SIZE; ++i) sw[i] = Integer.parseInt(st.nextToken());
		
		// 학생 수
		final int numStudent = Integer.parseInt(br.readLine());
		
		// 학생들이 받은 수를 저장할 배열
		final int M = 1;
		final int F = 2;
		
		for (int i = 0; i < numStudent; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			
			// 성별
			int gender = Integer.parseInt(st.nextToken());
			
			// 반전시킬 스위치의 번호
			int number = Integer.parseInt(st.nextToken());
			
			switch (gender) {
				case M: // 남자의 경우 주어진 인덱스부터 범위 내의 배수를 모두 반전시킨다.
					for (int j = 1; number * j <= SIZE; ++j) {
						reverseValue(sw, number * j);
					}
					break;
				case F: // 여자의 경우 주어진 인덱스부터 범위 내에서 좌우로 전진하면서 서로 같은 값일 때까지 찾고 그 구간을 모두 반전시킨다.
					// 반전시킬 구간 찾기
					int count = 1;
					while (
							number - count >= 1 && number + count <= SIZE &&
							sw[number - count] == sw[number + count]
							) {
						++count;
					}
					--count;
					
					// 구간 반전
					reverseValue(sw, number);
					if (count > 0) {
						do {
							reverseValue(sw, number + count);
							reverseValue(sw, number - count);
							--count;
						} while (count > 0);
					}
					
					break;
			}
		}
		
		// 출력 문자열 합치기
		for (int i = 1; i <= SIZE; ++i) {
			sb.append(sw[i]);
			sb.append(" ");
			if (i % 20 == 0) sb.append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// I/O close
		bw.close();
		br.close();
	}
	
	/**
	 * 스위치 값을 반전시킨다.
	 * @param sw : 스위치
	 * @param index : 인덱스
	 */
	private static void reverseValue(int[] sw, int index) {
		if (sw[index] == 1) sw[index] = 0;
		else sw[index] = 1;
	}
}
