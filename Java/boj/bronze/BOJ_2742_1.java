package boj.bronze;

import java.util.Scanner;

public class BOJ_2742_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		
		for (int i = N; i >= 1; --i) {
			System.out.println(i);
		}
		
		// io close
		sc.close();
	}

}
