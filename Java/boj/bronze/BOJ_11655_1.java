package boj.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//public class BOJ_11655 {
public class BOJ_11655_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		br.close();
		
		System.out.println(rot13(S));
		
	}
	
	private static String rot13(String p) {

		String c = new String();
		for (int i = 0; i < p.length(); i++) {
			char ascii = p.charAt(i);
			
			boolean isUpper = ascii >= 'A' && ascii <= 'Z' ? true : false;
			boolean isLower = ascii >= 'a' && ascii <= 'z' ? true : false;				
			
			if (isUpper || isLower) {
				ascii = (char) (ascii + 13);
				
				if ((isUpper && ascii > 'Z') || (isLower && ascii > 'z')) {
					ascii = (char) (ascii - 26);
				}
			}
			c = c + ascii;
		}
		
		return c;
	}

}
