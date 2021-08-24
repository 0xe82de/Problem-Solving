package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2798_1 {
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		
		// 카드를 담을 배열 초기화
		int[] cards = new int[N];
		int[] selected = new int[3];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// 카드 입력
		for (int i = 0; i < N; ++i) cards[i] = Integer.parseInt(st.nextToken());
		
		// 카드 조합을 생성
		comb(cards, selected, N, M, 0, 0);
		
		System.out.println(result);
		
		// 입력 stream close
		br.close();
	}
	
	/**
	 * 카드를 조합해서 합을 구하고, M에 가까운 결과를 저장한다.
	 * @param cards : 카드(숫자) 배열
	 * @param selected : 선택된 카드 조합
	 * @param N : 카드의 개수
	 * @param M : 최대 값
	 * @param cnt : selected 배열의 인덱스
	 * @param start : 선택한 카드의 인덱스
	 */
	private static void comb(int[] cards, int[] selected, int N, int M, int cnt, int start) {
		
		if (cnt == selected.length) {
			int temp = 0;
			for (int i = 0; i < cnt; ++i) {
				// 현재 조합의 카드를 더한다.
				temp += selected[i];
				
				// 더한 값이 M보다 크면 현재 조합을 버린다.
				if (temp > M) return;
			}
			
			// 현재 조합의 카드 합이 기존의 합보다 클 때
			if (temp > result) result = temp;
			return;
		}
		
		// 카드 조합
		for (int i = start; i < N; ++i) {
			selected[cnt] = cards[i];
			// 다음 카드
			comb(cards, selected, N, M, cnt + 1, i + 1);
		}
	}
}
