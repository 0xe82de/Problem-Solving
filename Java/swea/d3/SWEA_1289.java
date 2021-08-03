package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int T = Integer.parseInt(br.readLine());
		String[] memory = new String[T];
		int[] count = new int[T];
		
		
		for (int i = 0; i < T; ++i) {
			int flag = 1;
			memory[i] = br.readLine();
			
			for (int j = 0; j < memory[i].length(); ++j) {
				if ((memory[i].charAt(j) - '0') == flag) {
					++count[i];
					if (flag == 1) flag = 0;
					else flag = 1;
				}
			}
			
		}
		br.close();
		
		for (int i = 0; i < T; ++i) {
			System.out.println("#" + (i + 1) + " " + count[i]);
		}
	}

}
