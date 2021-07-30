package Silver4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9012 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int T = Integer.parseInt(br.readLine());
		String[] strings = new String[T];
		
		for (int i = 0; i < strings.length; ++i) {
			strings[i] = br.readLine();
		}
		br.close();
		
		for (int i = 0; i < strings.length; ++i) {
			if (isVPS(strings[i])) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
			bw.flush();
		}
		bw.close();
		
	}
	
	private static boolean isVPS(String str) {
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) == '(') {
				++left;
			} else {
				++right;
			}
			
			if (right > left) return false;
		}
		
		if (left == right) return true;
		else return false;
	}

}
