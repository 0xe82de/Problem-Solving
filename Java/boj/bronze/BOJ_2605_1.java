package boj.bronze;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2605_1 {

	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		// 변수 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 학생들의 수
		final int N = Integer.parseInt(br.readLine());
		
		int[] line = new int[N];
		for (int i = 0; i < N; ++i) line[i] = i + 1; 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; ++i) {
			int count = Integer.parseInt(st.nextToken());
			
			int index = i;
			while (count-- > 0) {
				swap(line, index - 1, index--);
			}
		}
		
		// 출력
		for (int i : line) {
			System.out.print(i + " ");
		}
		
		// 입력 stream close
		br.close();
	}
	
	private static void swap(int[] line, int i, int j) {
		int temp = line[i];
		line[i] =  line[j];
		line[j] =  temp;
	}
}