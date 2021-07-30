package silver4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1978 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int N = Integer.parseInt(br.readLine());
		String[] nums = br.readLine().split(" ");
		br.close();
		
		int count = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (isPrime(Integer.parseInt(nums[i]))) ++count;
		}
		
		System.out.println(count);
	}
	
	private static boolean isPrime(int num) throws IOException {
		if (num > 3) {
			for (int i = 2; i <= num / 2; ++i) {
				if (num % i == 0) return false;
			}
		}
		else if (num > 1) return true;
		else return false;
		
		return true;
	}

}
