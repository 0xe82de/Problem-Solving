package boj.bronze;

import java.util.Scanner;

public class BOJ_2908_1 {
	
	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		final int N = 3;
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int temp1 = 0;
		int temp2 = 0;
		
		for (int i = 0; i < N; ++i) {
			temp1 += (num1 % 10) * Math.pow(10, N - i - 1);
			temp2 += (num2 % 10) * Math.pow(10, N - i - 1);
			num1 /= 10;
			num2 /= 10;
		}
		
		// output
		if (temp1 > temp2) System.out.print(temp1);
		else System.out.print(temp2);
		
		// io close
		sc.close();
	}
}
