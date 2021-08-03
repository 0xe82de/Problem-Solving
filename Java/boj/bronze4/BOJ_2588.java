package boj.bronze4;

import java.util.Scanner;

public class BOJ_2588 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		String num2 = sc.next();
		sc.close();
		
		System.out.println(num1 * (num2.charAt(num2.length() - 1) - '0'));
		System.out.println(num1 * (num2.charAt(num2.length() - 2) - '0'));
		System.out.println(num1 * (num2.charAt(num2.length() - 3) - '0'));
		System.out.println(num1 * Integer.parseInt(num2));
		
	}

}
