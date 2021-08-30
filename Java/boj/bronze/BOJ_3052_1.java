package boj.bronze;

import java.util.Scanner;

public class BOJ_3052_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		final int N = 42;
		int[] arr = new int[N];
		
		for (int i = 0; i < 10; ++i) {
			arr[sc.nextInt() % N] = 1;
		}
		
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			sum += arr[i];
		}
		
		System.out.print(sum);
		
		// io close
		sc.close();
	}

}
