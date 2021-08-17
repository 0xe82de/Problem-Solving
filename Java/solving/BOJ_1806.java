package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1806 {
	
	static int N;
	static int S;
	
	static int[] input, numbers;
	static boolean[] isSelected;
	
	static int len = Integer.MAX_VALUE;
	
	private static void generateSubset(int cnt) {
		
		if (cnt == N) {
			// 부분집합 완성
			
			int sum = 0;
			int count = 0;
			
			for (int i = 0; i < N; ++i) {
				if (isSelected[i]) {
					sum += input[i];
					++count;
				}
			}
			
			if (sum > S) {
				if (len > count) len = count;
			}
			
			return;
		}
		
		// 현재 원소를 부분집합에 포함
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		
		// 현재 원소를 부분집합에 미포함
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		// 10 <= N <= 10,000
		N = Integer.parseInt(st.nextToken());
		input = new int[N];
		numbers = new int[N];
		isSelected = new boolean[N];
		
		// 0 <= S <= 100,000,000 1억
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; ++i) input[i] = Integer.parseInt(st.nextToken());
		
		// logic
		generateSubset(0);
		
		// output
		bw.write(String.valueOf(len));
		bw.close();
		br.close();
	}

}
