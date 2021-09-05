package boj.bronze;

import java.util.Scanner;

public class BOJ_10871_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		final int BASE = sc.nextInt();
		
		int[] numbers = new int[N];
		
		for (int i = 0; i < N; ++i) {
			numbers[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; ++i) {
			if (BASE > numbers[i]) System.out.print(numbers[i] + " ");
		}
		
		// io close
		sc.close();
	}
}
