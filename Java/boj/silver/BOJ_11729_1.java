package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729_1 {

	private static int hanoi(int num, int s, int t, int d, StringBuilder sb) {
		int K = 0;
		
		if (num == 1) {
			sb.append(s + " " + d + "\n");
			return ++K;
		} else {
			K = K + hanoi(num - 1, s, d, t, sb);
			sb.append(s + " " + d + "\n");
			++K;
			K = K + hanoi(num - 1, t, s, d, sb);			
		}
		
		return K;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numOfPlate = Integer.parseInt(br.readLine());
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		int K = hanoi(numOfPlate, 1, 2, 3, sb);
		System.out.println(K);
		System.out.println(sb);
		
	}

}
