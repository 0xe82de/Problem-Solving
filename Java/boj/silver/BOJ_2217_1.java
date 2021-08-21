package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_2217_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 로프의 개수, 1 <= N <= 100,000
		final int N = Integer.parseInt(br.readLine());
		
		// 로프의 무게를 저장할 배열
		int[] ropeWeight = new int[N];
		
		// 로프의 무게 입력
		for (int i = 0; i < N; ++i) ropeWeight[i] = Integer.parseInt(br.readLine());
		
		// 가장 작은 값부터 로프 무게를 계산하기 위해 정렬
		Arrays.sort(ropeWeight);
		
		int max = 0;
		for (int i = 0; i < N; ++i) {
			// 현재 값부터 가장 큰 값까지 중량을 같이 받았을 때를 계속 비교하면서 가장 큰 값 저장
			max = Math.max(ropeWeight[i] * (N - i), max);
		}
		
		// 출력
		bw.write(String.valueOf(max));
		
		// 입출력 stream close
		bw.close();
		br.close();
	}

}
