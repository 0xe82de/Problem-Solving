package boj.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BOJ_9613_1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int t = Integer.parseInt(br.readLine());
		
		long[] sumOfGCDs = new long[t];
		for (int i = 0; i < t; ++i) {
			String[] nums = br.readLine().split(" ");
			long sum = 0;
			
			// j: 가장 왼쪽 숫자, k: j를 제외한 오른쪽 숫자들
			for (int j = 1; j < nums.length - 1; ++j) {
				for (int k = j + 1; k < nums.length; ++k) {
					
					int gcd = getGCD(
							Integer.parseInt(nums[j]),
							Integer.parseInt(nums[k])
					);
					
					sum = sum + gcd;
				}
			}
			
			sumOfGCDs[i] = sum;
		}
		br.close();
		
		for (long sumOfGCD : sumOfGCDs) {
			bw.write(Long.toString(sumOfGCD) + "\n");
			bw.flush();
		}
		bw.close();
		
	}
	
	private static int getGCD(int x, int y) {
		return BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue();
	}

}
