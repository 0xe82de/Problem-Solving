package boj.gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 암호는 서로 다른 L개의 알파벳 소문자들로 구성되며
 * 최소 한 개의 모음(a, e, i, o, u)과
 * 최소 두 개의 자음으로 구성되어 있다고 알려져 있다. 
 * 
 * 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다
 * 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
 * 
 */

public class BOJ_1759_1 {
	
	static int L;
	static int C;
	
	static char[] chars;
	static char[] cipher;
	
	static boolean[] isSelected;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		// variable setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		// 순열 다 만들고, 모음 1개, 자음 2개 들어가 있는지 확인
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cipher = new char[L];
		chars = new char[C];

		// 문자 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; ++i) chars[i] = st.nextToken().charAt(0);

		// 문자 정렬
		Arrays.sort(chars);
		
		isSelected = new boolean[C + 1];
		comb(0, 0);
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	
	private static void comb(int cnt, int start) throws IOException {
		
		if (cnt == L) {
			
			// 모음 1개, 자음 2개 이상 포함하는지 확인
			int countVow = 0; // 모음
			int countCon = 0; // 자음
			
			for (int i = 0; i < L; ++i) {
				char temp = cipher[i];
				if (
						temp == 'a' || temp == 'e' ||
						temp == 'i' || temp == 'o' || temp == 'u'
					) {
					++countVow;
				} else {
					++countCon;
				}
			}
			
			if (countVow >= 1 && countCon >= 2) {
				sb.append(String.valueOf(cipher) + "\n");
			}
			
			return;
			
		}
		
		for (int i = start; i < C; ++i) {
			cipher[cnt] = chars[i];
			comb(cnt + 1, i + 1);
		}
	}
}
