package Bronze5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2475 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = br.read() - '0';
		br.read();
		int n2 = br.read() - '0';
		br.read();
		int n3 = br.read() - '0';
		br.read();
		int n4 = br.read() - '0';
		br.read();
		int n5 = br.read() - '0';
		br.close();
		
		int res = ((n1 * n1) + (n2 * n2) + (n3 * n3) + (n4 * n4) + (n5 * n5)) % 10;
		System.out.println(res);
		
	}

}
