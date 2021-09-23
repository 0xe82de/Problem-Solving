package boj.platinum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/*
 * BOJ 1786 찾기
 * P5
 * 문자열, KMP
 */

public class BOJ_1786_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final char[] T = br.readLine().toCharArray();
		final char[] P = br.readLine().toCharArray();
		final int tLength = T.length;
		final int pLength = P.length;
		
		// 실패함수 pi 만들기
		int[] pi = new int[pLength];
		
		// i : 접미사 포인터
		// j : 접두사 포인터
		for (int i = 1, j = 0; i < pLength; ++i) {
			// 접두사 포인터가 0보다 크고 접미사 포인터의 값과 다르면 중복이 아니므로 j를  초기화해야 한다.
			// 이 때, j 값이 0이거나 접미사 포인터의 값과 같을 때까지 반복한다.
			while (j > 0 && P[i] != P[j]) {
				j = pi[j - 1];
			}
			
			// 중복되는 부분이 있으면 j를 증가시킨다.
			if (P[i] == P[j]) pi[i] = ++j;
		}
		
		// 패턴과 매칭되는 인덱스 list에 추가
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0, j = 0; i < tLength; ++i) {
			// ㄴ
			while (j > 0 && T[i] != P[j]) {
				j = pi[j - 1];
			}
			
			// 주어진 문자열과 패턴의 문자가 일치할 경우
			if (T[i] == P[j]) {
				// 현재 접두사 포인터가 패턴 길이일 경우(모든 문자, 패턴이 일치할 경우)
				if (j == pLength - 1) {
					// 리스트에 인덱스를 추가한다.
					// 인덱스는 1부터 시작하므로 +2 - pLength를 해주면 매칭되는 패턴의 시작 문자 인덱스가 들어간다.
					list.add(i + 2 - pLength);
					j = pi[j];
				} else {
					// 접두사 포인터가 패턴 길이보다 작을 경우
					++j;
				}
			}
		}

		sb.append(list.size() + "\n");
		for (int i = 0, len = list.size(); i < len; ++i) {
			sb.append(list.get(i) + " ");
		}
		
		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}
}