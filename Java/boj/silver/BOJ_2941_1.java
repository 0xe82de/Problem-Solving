package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOj 2941 크로아티아 알파벳
 * S5
 * 구현, 문자열
 * 단계별로 풀어보기 : 문자열
 */

public class BOJ_2941_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		// output
		bw.write(String.valueOf(getCount(str)));

		// io close
		bw.close();
		br.close();
		
	}
	
	/**
	 * 크로아티아 알파벳의 개수를 리턴한다.
	 * @param str : 단어 
	 * @return 크로아티아 알파벳의 개수
	 */
	private static int getCount(String str) {
		int count = 0;
		
		for (int i = 0, len = str.length(); i < len; ++i) {
			++count;
			if (i == len - 1) break;
			
			// 세 글자 크로아티아 알파벳이므로 i를 2 증가시키고, for문에서도 1 증가시키면 총 3 증가
			if (i < len - 2 && str.substring(i, i + 3).equals("dz=")) i += 2;
			else {
				switch (str.substring(i, i + 2)) {
					case "c=": case "c-": case "d-":
					case "lj": case "nj": case "s=": case "z=":
						++i; // 두 글자 크로아티아 알파벳이므로 i를 1 증가시키고, for문에서도 1 증가시키면 총 2 증가
						break;
				}
			}
		}
		
		return count;
	}
}