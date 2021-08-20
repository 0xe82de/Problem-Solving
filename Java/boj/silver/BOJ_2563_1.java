package boj.silver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_2563_1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		// init
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		final int TC = sc.nextInt();
		
		int[] posX = new int[TC];
		int[] posY = new int[TC];
		int maxX = 0, maxY = 0;
		int[][] map;
		int count = 0;
		
		for (int tc = 0; tc < TC; ++tc) {
			posX[tc] = sc.nextInt();
			posY[tc] = sc.nextInt();
		}
		
		// logic
		for (int x : posX) maxX = Math.max(maxX, x);
		for (int y : posY) maxY = Math.max(maxY, y);
		map = new int[maxX + 10][maxY + 10];
		
		for (int tc = 0; tc < TC; ++tc) {
			for (int r = posX[tc]; r < posX[tc] + 10; ++r) {
				for (int c = posY[tc]; c < posY[tc] + 10; ++c) {
					map[r][c] = 1;
				}
			}
		}
		
		for (int r = 0; r < maxX + 10; ++r) {
			for (int c = 0; c < maxY + 10; ++c) {
				if (map[r][c] == 1) ++count;
			}
		}
		
		// output
		System.out.println(count);
		
		sc.close();
	}

}
