package boj.silver;

import java.io.*;

/**
 * BOJ 2447 별 찍기 - 10
 * S1
 * 분할 정복, 재귀
 */

public class BOJ_2447_1 {

	public static void main(String[] args) throws IOException {
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();

		// logic
		final int N = Integer.parseInt(br.readLine());
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < N; ++c) {
				sb.append(getElement(r, c, N));
			}
			sb.append("\n");
		}

		// output
		bw.write(sb.toString());

		// io close
		bw.close();
		br.close();
	}

	/**
	 * 각각의 위치의 요소를 리터한다.
	 * 1. 행, 열을 n으로 나눈 몫을 3으로 나눈 나머지가 1이면 빈 칸이어야 한다.
	 * 2. 빈 공간이 아닐 때, n이 3으로 나눈 몫이 0이면 별이어야 한다.
	 * 3. 위 두 조건을 만족하지 않으면 분할하여 재귀호출한다.
	 * @param r
	 * @param c
	 * @param n
	 * @return
	 */
	private static char getElement(int r, int c, int n) {
		if ((r / n) % 3 == 1 && (c / n) % 3 == 1)
			return ' ';
		else {
			if (n / 3 == 0)
				return '*';
			else
				return getElement(r, c, n / 3);
		}
	}
}