package boj.bronze;

import java.util.Scanner;

public class BOJ_2562_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		final int N = 9;
		int[] numbers = new int[N];
		
		for (int i = 0; i < N; ++i) numbers[i] = sc.nextInt();
		
		int maxValue = 0;
		int maxIndex = 0;
		
		for (int i = 0; i < N; ++i) {
			if (numbers[i] > maxValue) {
				maxValue = numbers[i];
				maxIndex = i + 1;
			}
		}
		
		// output
		System.out.println(maxValue);
		System.out.println(maxIndex);
		
		// io close
		sc.close();
	}

}
