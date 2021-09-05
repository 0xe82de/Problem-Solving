package boj.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10809_1 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		char[] word = sc.next().toCharArray();
		
		int[] posAlphabet = new int[26];
		
		Arrays.fill(posAlphabet, -1);
		
		for (int i = 0, len = word.length; i < len; ++i) {
			if (posAlphabet[word[i] - 'a'] != -1) continue;
			posAlphabet[word[i] - 'a'] = i;
		}
		
		// output
		for (int i = 0, len = posAlphabet.length; i < len; ++i) {
			System.out.print(posAlphabet[i] + " ");
		}
		
		// io close
		sc.close();
	}
}
