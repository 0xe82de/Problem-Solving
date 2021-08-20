package boj.silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728 {

	public static void main(String[] args) throws IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		// logic
		st = new StringTokenizer(br.readLine(), " ");
		
		// (1 ≤ N, M ≤ 1,000,000)
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + M];
		
		// 배열 값 입력받기
		int index = 0;
		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) arr[index++] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) arr[index++] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		// output
		for (int i = 0; i < N + M; ++i) sb.append(arr[i] + " ");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
