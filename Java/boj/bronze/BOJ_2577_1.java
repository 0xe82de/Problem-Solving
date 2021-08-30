package boj.bronze;

import java.util.Scanner;

public class BOJ_2577_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		final int A = sc.nextInt();
		final int B = sc.nextInt();
		final int C = sc.nextInt();
		
		// 곱셈 결과를 String 객체로 변환
		String str = String.valueOf(A * B * C);
		
		// 0 ~ 9 카운팅할 배열
		int[] arr = new int[10];
		
		// String 객체에서 charAt() 메서드로 문자를 뽑아내고
		// - '0' 연산으로 숫자로 변환한다.
		for (int i = 0, len = str.length(); i < len; ++i) {
			++arr[str.charAt(i) - '0'];
		}
		
		// output
		for (int count : arr) {
			System.out.println(count);
		}
		
		// io close
		sc.close();
	}

}
