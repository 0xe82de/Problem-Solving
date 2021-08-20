package boj.bronze;

import java.util.Scanner;

public class BOJ_2884 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		
		sc.close();
		
		if (M - 45 >= 0) {
			System.out.println(H + " " + (M - 45));
		} else {
			if (H == 0) H = 24;
			System.out.println((H - 1) + " " + (M + 15));
		}
		
	}

}
