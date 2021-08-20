package boj.bronze;

import java.util.Scanner;

public class BOJ_2845 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int N = 5;
		int[] peaples = new int[N];
		
		int L = sc.nextInt();
		int P = sc.nextInt();
		
		for (int i = 0; i < N; ++i) {
			peaples[i] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < N; ++i) {
			System.out.print(peaples[i] - (L * P) + " ");
		}
		
	}

}
