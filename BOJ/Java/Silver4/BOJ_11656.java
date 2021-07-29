import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.Arrays;

public class BOJ_11656 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String t = br.readLine();
		br.close();
		
		final int LEN = t.length();
		
		String[] strings = new String[LEN];
		String[] sorted = new String[LEN];
		
		for (int s = 0; s < LEN; ++s) {
			strings[s] = t.substring(s);
		}
//		Arrays.sort(strings);
		
		sorted = stringSort(strings);
		
		for (int s = 0; s < LEN; ++s) {
			bw.write(strings[s] + "\n");
			bw.flush();
		}
		bw.close();
		
	}
	
	private static String[] stringSort(String[] strings) {
		boolean flag;
		final int LEN = strings.length;
		String temp = new String();
		
		do {
			flag = true;
			
			for (int s = 0; s < LEN - 1; ++s) {
				if (strings[s].compareTo(strings[s + 1]) > 0) {
					temp = strings[s];
					strings[s] = strings[s + 1];
					strings[s + 1] = temp;
					
					flag = false;
				}
			}
		} while (!flag);
		
		return strings;
	}

}
