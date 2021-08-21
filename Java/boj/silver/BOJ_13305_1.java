package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13305_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		// 도시의 개수
		// 2 <= N <= 100,000
		final int N = Integer.parseInt(br.readLine());
		
		// 도로 개수
		final int numRoad = N - 1;
		
		// 도시 사이의 거리 변수
		int[] distances = new int[numRoad];
		// 도시의 기름값
		int[] priceOfOil = new int[N];
		
		// 도시 사이의 거리 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < numRoad; ++i) distances[i] = Integer.parseInt(st.nextToken());
		
		// 도시의 기름값 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; ++i) priceOfOil[i] = Integer.parseInt(st.nextToken());
		
		// 최대 값
		// 도시의 최대 개수 * 도시 사이의 최장 도로 * 최고 기름값
		// 10만 * 10억 * 10억
		// 최대값 int로 계산 못하므로 long 선언
		long price = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < N - 1; ++i) {
			// 더 작은 기름값이 나오면 최소 기름값 갱신
			if (priceOfOil[i] < minPrice) minPrice = priceOfOil[i];
			
			// 현재 최소 기름값 * 거리
			// price 변수가 long 이므로 long 형변환
			price += distances[i] * (long)minPrice;
		}
		
		// 출력
		bw.write(String.valueOf(price));
		
		// 입출력 stream close
		bw.close();
		br.close();
	}

}
