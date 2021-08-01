package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10951 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] sum = new int[2];
		int i = 0;
		while (true) {
			String AB = br.readLine();
			
			sum[i] = (AB.charAt(0) - '0') + (AB.charAt(2) - '0');
			i++;
			if (i == sum.length) {
				sum = new int[i * 2];
			}
			if (i == 32) {
				break;
			}
		}
//		br.close();
		
		for (i = 0; i < sum.length; i++) {
			System.out.println(sum[i]);
		}
		
	}
	
}
