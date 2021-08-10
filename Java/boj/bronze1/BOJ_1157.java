package boj.bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chars = br.readLine().toCharArray();
		int[] alphabet = new int[26];
		boolean isDupl = false;
		int max = 0;
		int ch = 0;
		
		for (int i = 0; i < chars.length; ++i) {
			++alphabet[Character.toLowerCase(chars[i]) - 'a'];
		}
		
		for (int i = 0; i < 26; ++i) {
			if (max == alphabet[i]) isDupl = true;
			else if (max < alphabet[i]) {
				isDupl = false;
				max = alphabet[i];
				ch = i;
			}
		}
		
		if (isDupl) System.out.println("?");
		else System.out.println((char)(ch + 'A'));
		
		br.close();
	}

}
