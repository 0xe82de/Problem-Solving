package boj.bronze5;

import java.util.Scanner;

public class BOJ_2914 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int I = sc.nextInt();
		sc.close();
		
		System.out.println(A * (I - 1) + 1);
		
	}

}
