package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 1316 그룹 단어 체커
 * S5
 * 구현, 문자열
 * 단계별로 풀어보기 : 문자열
 */

public class BOJ_1316_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int TC = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int tc = 1; tc <= TC; ++tc) {
			if (isValid(br.readLine())) ++count;
		}
		
		// output
		bw.write(String.valueOf(count));

		// io close
		bw.close();
		br.close();
		
	}
	
	/**
	 * 그룹 단어 유무를 반환한다.
	 * @param str : 단어
	 * @return 그룹 단어의 유무. 그룹 단어이면 true, 아니면 false
	 */
	private static boolean isValid(String str) {
		boolean[] checked = new boolean[26];
		
		char temp = ' ';
		for (int i = 0, len = str.length(); i < len; ++i) {
			char current = str.charAt(i); // 현재 알파벳
			if (current == temp) continue; // 직전에 나온 알파벳과 같으면 continue
			
			// 현재 알파벳 체크용 인덱스
			int index = current - 'a';
			
			// 직전에 나온 알파벳과 다른데, 이미 체크되어 있으면 예전에 한 번 나온 알파벳이다.
			// 따라서 그룹 단어가 아니다.
			if (checked[index]) return false;
			
			// 처음 나온 알파벳이므로 체크한다.
			checked[index] = true;
			
			// 다음 알파벳과 비교하기 위하여 메모한다.
			temp = current;
		}
		
		return true;
	}
}