package boj.silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * BOJ 2004 조합 0의 개수
 * S2
 * 수학, 정수론
 */

public class BOJ_2004_1 {

	public static void main(String[] args) throws IOException {
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// logic
		int cntZero;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int cnt2 = getPower(n, 2) - getPower(n - m, 2) - getPower(m, 2);
		int cnt5 = getPower(n, 5) - getPower(n - m, 5) - getPower(m, 5);

		cntZero = Math.min(cnt2, cnt5);

		// output
		bw.write(String.valueOf(cntZero));

		// io close
		bw.close();
		br.close();
	}

	/**
	 * divide의 승수를 리턴
	 * 
	 * @param number : 주어진 수
	 * @param divide : 제수
	 * @return divide의 승수
	 */
	private static int getPower(int number, int divide) {
		int count = 0;

		while (number >= divide) {
			count += number / divide;
			number /= divide;
		}

		return count;
	}

}
