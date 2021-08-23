package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2331_1 {

	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int number = Integer.parseInt(st.nextToken());
		final int P = Integer.parseInt(st.nextToken());
		int count = 0;
		
		// 10으로 나누면서 몫을 p번 곱한다.
		// 해시맵에 넣으면서 이미 들어가있으면 끝낸다.
		
		// value, index
		Map<Integer, Integer> map = new HashMap<>();
		
		int sum = number;
		while (true) {
			
			// map에 현재 value가 없으면 추가한다.
			if (map.get(sum) == null) {
				map.put(sum, ++count);
			} else {
				// value가 있으면 중복되었으므로 break
				break;
			}
			
			number = sum;
			sum = 0;
			while (!(number == 0)) {
				sum += pow(number % 10, P);
				number /= 10;
			}
		}
		
		// 출력
		bw.write(String.valueOf(map.get(sum) - 1)); // index - 1 출력
		
		// 입출력 stream close
		bw.close();
		br.close();
	}
	
	/**
	 * @param number : 제곱할 값
	 * @param n : n 제곱
	 * @return
	 */
	private static int pow(int number, int n) {
		
		int result = 1;
		
		do {
			result *= number;
		} while (--n > 0);
		
		return result;
	}
}
