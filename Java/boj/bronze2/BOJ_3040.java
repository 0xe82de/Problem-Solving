package boj.bronze2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3040 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int TC = 9;
		int[] fakeDwarfNum = new int[TC];
		
		for (int tc = 0; tc < TC; ++tc) {
			fakeDwarfNum[tc] = Integer.parseInt(br.readLine());
		}
		final int N = fakeDwarfNum.length;
		int[] combDwarf = new int[N];
		final int R = 7;
		
		// logic
		int cnt = 0;
		while (++cnt <= R) combDwarf[N - cnt] = 1;
		
		int sum = 0;
		do {
			sum = 0;
			for (int i = 0; i < N; ++i) {
				if (combDwarf[i] == 1) sum += fakeDwarfNum[i];
			}
			
			if (sum == 100) {
				for (int i = 0; i < N; ++i) {
					if (combDwarf[i] == 1) {
						// output
						bw.write(String.valueOf(fakeDwarfNum[i]) + "\n");
						bw.flush();
					}
				}
				break;
			}
		} while (nextPermutation(combDwarf));
		
		bw.close();
		br.close();
		
	}
	
	private static boolean nextPermutation(int[] combDwarf) {
		
		int N = combDwarf.length;
		
		int i = N - 1;
		while (i > 0 && combDwarf[i - 1] >= combDwarf[i]) --i;
		
		if (i == 0) return false;
		
		int j = N - 1;
		while (combDwarf[i - 1] >= combDwarf[j]) --j;
		
		swap(combDwarf, i - 1, j);
		
		int k = N - 1;
		while (i < k) {
			swap(combDwarf, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
