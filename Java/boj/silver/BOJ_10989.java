package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_10989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		final int T = Integer.parseInt(br.readLine());
		int[] intArr = new int[T];
		
		for (int t = 0; t < T; ++t) intArr[t] = Integer.parseInt(br.readLine());
		br.close();
		
		Arrays.sort(intArr);
		for (int t = 0; t < T; ++t) {
			bw.write(String.valueOf(intArr[t]));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		
	}

}
