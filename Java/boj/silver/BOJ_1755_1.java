package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ 1755 숫자놀이
 * S4
 * 수학, 문자열, 정렬
 */

public class BOJ_1755_1 {
	
	// 숫자 매칭 문자열
	static String[] numberToString = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	
	// 숫자, 문자열을 담을 배열
	static Set[] setList;
	
	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		final int M = Integer.parseInt(st.nextToken());
		final int N = Integer.parseInt(st.nextToken());
		final int LEN = N - M + 1;
		
		// 숫자, 숫자를 문자열로 바꾼 것을 저장할 배열
		setList = new Set[LEN];
		
		// 숫자를 문자열로 변환하고 배열에 추가한다.
		for (int i = 0; i < LEN; ++i) {
			String str = getString(i + M);
			setList[i] = new Set(i + M, str);
		}
		
		// 사전순 정렬
		Arrays.sort(setList);
		
		// 출력용 문자열 만들기
		for (int i = 0; i < LEN; ++i) {
			// 정렬된 배열에서 숫자를 가져와서 붙이고 공백을 추가한다.
			sb.append(setList[i].num + " ");
			
			// 10개씩 끊어서 출력하도록 한다.
			if ((i + 1) % 10 == 0) sb.append("\n");
		}
		
		// 출력
		bw.write(sb.toString());
		
		// io close
		bw.close();
		br.close();
	}
	
	// 숫자와 그에 해당하는 문자열을 담을 클래스
	static class Set implements Comparable<Set> {
		int num;
		String str;
		
		// 생성자
		public Set(int num, String str) {
			this.num = num;
			this.str = str;
		}

		@Override
		public int compareTo(Set o) {
			return this.str.compareTo(o.str); // 문자열 str 기준으로 정렬할 수 있도록 한다.
		}
	}
	
	/**
	 * 숫자에 해당하는 문자열을 만들어서 리턴한다.
	 * @param i : 숫자
	 * @return 숫자에 해당하는 문자열
	 */
	private static String getString(int i) {
		// 문자열 병합용
		StringBuilder sb = new StringBuilder();
		
		// i가 0이 되면 그만둔다.
		while (i != 0) {
			// 10으로 나눈 나머지를 저장한다.
			int temp = i % 10;
			
			// i를 10으로 나눈다.
			i /= 10;
			
			// 문자열의 맨 앞에 숫자에 해당하는 문자열과 공백을 추가한다.
			sb.insert(0, numberToString[temp] + " ");
		}
		
		// 만들어진 문자열을 리턴(뒤쪽 공백 제거)
		return sb.toString().trim();
	}
}
