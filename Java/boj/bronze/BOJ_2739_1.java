package boj.bronze;

import java.util.Scanner;

public class BOJ_2739_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		
		for (int i = 1; i <= 9; ++i) {
			System.out.printf("%d * %d = %d%n", N, i, N * i);
		}
		
		// io close
		sc.close();
	}
}
