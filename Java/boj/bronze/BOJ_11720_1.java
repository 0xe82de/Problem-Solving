package boj.bronze;

import java.util.Scanner;

public class BOJ_11720_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		sc.next();
		char[] numbers = sc.next().toCharArray();
		
		int sum = 0;
		for (int i = 0, len = numbers.length; i < len; ++i) sum += numbers[i] - '0';
		
		// output
		System.out.println(sum);
		
		// io close
		sc.close();
	}
}
