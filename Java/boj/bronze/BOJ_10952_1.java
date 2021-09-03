package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10952_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = null;
		
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			// 마지막 숫자들
			if (num1 == num2 && num1 == 0) break;
			
			int sum = num1 + num2;
			sb.append(sum + "\n");
		}
		
		// output
		System.out.println(sb.toString());
		
		// io close
		br.close();
	}

}
