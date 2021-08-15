package boj.bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8320 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// init
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int len = Integer.parseInt(br.readLine());
		int count = 0;
		
		// logic
		for (int i = 1; i <= len; ++i) {
			for (int j = i; i * j <= len; ++j) {
				// 가로를 고정시키고 세로로 1씩 증가시키면서 정사각형의 총 개수보다 작으면 counting
				// 첫 시작은 정사각형부터 시작한다.
				// 1. X
				// 2. X X
				//    X X
				// 3. X X X
				//    X X X
				//    X X X
				++count;
			}
		}
		
		// output
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
		
	}

}
