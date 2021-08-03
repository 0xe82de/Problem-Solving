package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1204 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] scores = new int[101];
		final int COUNT = 1000;
		int num = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < COUNT; ++i) {
			++scores[Integer.parseInt(br.readLine())];
		}
		br.close();
		
		num = scores[scores.length - 1];
		for (int i = scores.length - 2; i >= 0; --i) {
			if (num < scores[i]) num = scores[i];
		}
		
	}

}
