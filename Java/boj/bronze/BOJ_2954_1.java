package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ 2954 창영이의 일기장
 * B1
 * 구현, 문자열
 */

public class BOJ_2954_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		// logic
		String changed = br.readLine();
		
		// output
		bw.write(getOriginString(changed));
		
		// io close
		bw.close();
		br.close();
	}

	/**
	 * 원본 문자열을 만들어서 리턴한다.
	 * @param changed : 창영이의 문자열
	 * @return 원본 문자열
	 */
	private static String getOriginString(String changed) {
		StringBuilder sb = new StringBuilder();

		char ch;
		for (int i = 0, len = changed.length(); i < len; ++i) {
			ch = changed.charAt(i);
			sb.append(ch);
			switch (ch) {
				case 'a': case'e': case 'i': case 'o': case 'u': i += 2;
			}
		}

		return sb.toString();
	}

}
