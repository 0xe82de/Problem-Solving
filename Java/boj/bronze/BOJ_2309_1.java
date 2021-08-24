package boj.bronze;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2309_1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		// 변수 설정
		Scanner sc = new Scanner(System.in);
		
		final int N = 9;
		
		int[] dwarf = new int[N];
		int[] selected = new int[7];
		
		for (int i = 0; i < N; ++i) {
			dwarf[i] = sc.nextInt();
		}
		
		Arrays.sort(dwarf);
		
		comb(dwarf, selected, N, 7, 0, 0);
		
		// 입력 stream close
		sc.close();
	}
	
	private static boolean comb(int[] dwarf, int[] selected, int N, int R, int cnt, int start) {
		
		if (cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; ++i) {
				sum += selected[i];
			}
			
			if (sum == 100) {
				for (int i = 0; i < R; ++i) {
					System.out.println(selected[i]);
				}
				return true;
			}
			return false;
		}
		
		for (int i = start; i < N; ++i) {
			
			selected[cnt] = dwarf[i];
			if (comb(dwarf, selected, N, R, cnt + 1, start + 1)) return true;
		}
		
		return false;
	}
}
