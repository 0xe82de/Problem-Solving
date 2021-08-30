package boj.bronze;

import java.util.Scanner;

public class BOJ_2675_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		// output string
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 개수
		final int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; ++tc) {
			
			int count = sc.nextInt();
			char[] chars = sc.nextLine().toCharArray();
			
			// 공백 제거 -> i = 1
			for (int i = 1; i < chars.length; ++i) {
				for (int j = 0; j < count; ++j) {
					sb.append(chars[i]);
				}
			}
			sb.append("\n");
		}
		
		// output
		System.out.print(sb.toString());
		
		// io close
		sc.close();
	}
}
