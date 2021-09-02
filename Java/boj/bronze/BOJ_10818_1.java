package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818_1 {

	public static void main(String[] args) throws IOException {

		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정수의 개수, 1 ~ 1,000,000
		final int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = -1000000;
		int min = 1000000;
		for (int i = 0; i < N; ++i) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp > max) max = temp;
			if (temp < min) min = temp;
		}
		
		// output
		System.out.print(min + " " + max);
		
		// io close
		br.close();
	}
}
