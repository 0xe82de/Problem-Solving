package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2954 {

	public static void main(String[] args) throws IOException {
		
		// io setting
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 원본 문자열을 저장하기 위해 StringBuilder 사용
		StringBuilder sb = new StringBuilder();
		
		// 변형된 문자열을  toCharArray() 메서드로 char[] 배열에 저장.
		char[] changed = br.readLine().toCharArray();
		
		// 변형된 문자열을 1개씩 확인한다.
		for (int i = 0; i < changed.length; ++i) {
			
			// i가 0보다 크고 문자가 'p'일 떄
			if (i > 0 && changed[i] == 'p' && i < changed.length - 1) {
				
				// 테스트 케이스
				// 원본 문자열 : pineapple
				// 변형 문자열 : pipinepeapapplepe
				
				// 변형 문자열 : pipinepeapapplepe
				
				// 앞뒤로 a e i o u가 있는지 확인
				if (changed[i - 1] == changed[i + 1]) {
					if (
							changed[i - 1] == 'a' ||
							changed[i - 1] == 'e' ||
							changed[i - 1] == 'i' ||
							changed[i - 1] == 'o' ||
							changed[i - 1] == 'u'
						) {
						++i;
					}
				} else {
					// 문자가 p이지만 앞뒤로 모음이 없으면 원본 문자열로 저장한다.
					sb.append(changed[i]);
				}
			}
			else {
				// 문자가 p가 아니면 원본 문자열에 저장한다.
				sb.append(changed[i]);
			}
		}
		
		// 문자열 출력
		bw.write(sb.toString());
		
		// io close
		bw.close();
		br.close();
	}

}
