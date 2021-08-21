package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1439_1 {

	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 문자열 입력
		char[] str = br.readLine().toCharArray();
		
		// 기준 값
		char base = str[0];
		
		// 0, 1 카운트
		int countZero = 0;
		int countOne = 0;
		
		if (base == '0') ++countZero;
		else ++countOne;
		
		for (int i = 1, len = str.length; i < len; ++i) {
			// base 값과 다르면 count 증가
			if (base != str[i]) {
				if (str[i] == '0') ++countZero;
				else ++countOne;
				base = str[i];
			}
		}
		
		// 출력
		// 0의 모임과 1의 모임 중 작은 값을 출력한다.
		bw.write(String.valueOf(countZero < countOne ? countZero : countOne));
		
		// 입출력 stream close
		bw.close();
		br.close();
	}

}
