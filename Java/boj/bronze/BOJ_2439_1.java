package boj.bronze;

import java.util.Scanner;

public class BOJ_2439_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		// N, 1 ~ 100
		final int N = sc.nextInt();
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - i - 1; ++j) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; ++j) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// io close
		sc.close();
	}

}
