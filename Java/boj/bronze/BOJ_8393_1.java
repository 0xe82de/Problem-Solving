package boj.bronze;

import java.util.Scanner;

public class BOJ_8393_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		int max = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i <= max; ++i) sum += i;

		// output
		System.out.println(sum);
		
		// io close
		sc.close();
	}
}