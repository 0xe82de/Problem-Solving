package boj.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * BOJ 5622 다이얼
 * B2
 * 구현
 * 단계별로 풀어보기 : 문자열
 */

public class BOJ_5622_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int minSecond = 0;
		
		for (int i = 0, len = str.length(); i < len; ++i) {
			minSecond += getTime(str.charAt(i));
		}
		minSecond += str.length();

		// output
		bw.write(String.valueOf(minSecond));

		// io close
		bw.close();
		br.close();
	}
	
	/**
	 * 문자에 해당하는 시간을 계산해서 리턴한다.
	 * @param ch : 문자
	 * @return : 걸린 시간
	 */
	private static int getTime(char ch) {
		int second = 0;
		switch (ch) {
			case 'W': case 'X': case 'Y': case 'Z': ++second;
			case 'T': case 'U': case 'V': ++second;
			case 'P': case 'Q': case 'R': case 'S': ++second;
			case 'M': case 'N': case 'O': ++second;
			case 'J': case 'K': case 'L': ++second;
			case 'G': case 'H': case 'I': ++second;
			case 'D': case 'E': case 'F': ++second;
			case 'A': case 'B': case 'C': ++second;
		}
		++second;
		
		return second;
	}
}