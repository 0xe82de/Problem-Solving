package boj.bronze5;
import java.util.Scanner;

public class BOJ_1550 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();

		int sum = 0;
		
		for (int i = 0, len = str.length(); i < len; i++) {
			int res = hexToDec(str.charAt(i));
			
			if (i != len - 1) {
				for (int j = 0; j < len - i - 1; j++) {
					res = res * 16;
				}
			}
			
			sum = sum + res;
		}
		
		System.out.println(sum);
	}
	
	private static int hexToDec (char c) {
		int num = 0;
		
		switch (c) {
			case '1':
				num = 1;
				break;
			case '2':
				num = 2;
				break;
			case '3':
				num = 3;
				break;
			case '4':
				num = 4;
				break;
			case '5':
				num = 5;
				break;
			case '6':
				num = 6;
				break;
			case '7':
				num = 7;
				break;
			case '8':
				num = 8;
				break;
			case '9':
				num = 9;
				break;
			case 'A':
				num = 10;
				break;
			case 'B':
				num = 11;
				break;
			case 'C':
				num = 12;
				break;
			case 'D':
				num = 13;
				break;
			case 'E':
				num = 14;
				break;
			case 'F':
				num = 15;
				break;
		}
		
		return num;
	}

}
