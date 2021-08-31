package boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2920_1 {

	public static void main(String[] args) throws IOException {
		
		// io
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int first = Integer.parseInt(st.nextToken());
		
		boolean isPrint = false;
		if (first == 1) {
			while (st.hasMoreTokens()) {
				if (++first == Integer.parseInt(st.nextToken())) continue;
				else {
					System.out.println("mixed");
					isPrint = true;
					break;
				}
			}
			if (!isPrint) System.out.println("ascending");
		}
		else if (first == 8) {
			while (st.hasMoreTokens()) {
				if (--first == Integer.parseInt(st.nextToken())) continue;
				else {
					System.out.println("mixed");
					isPrint = true;
					break;
				}
			}
			if (!isPrint) System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		
		// io close
		br.close();
	}
}
