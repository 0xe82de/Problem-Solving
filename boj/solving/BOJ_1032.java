package solving;

import java.util.Scanner;

public class BOJ_1032 {

	public static void main(String[] args) {
		int fileLen = 0;
		String pattern = new String();
		String firstFileName = new String();
		String[] fileNames;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		fileNames = new String[N];
		
		for (int i = 0; i < N; ++i) {
			fileNames[i] = sc.next();
		}
		sc.close();
		
		fileLen = fileNames[0].length();
		pattern = fileNames[0];
		firstFileName = fileNames[0];
		
		for (int i = 1; i < N; ++i) {
			for (int j = 0; j < fileLen; ++j) {
				if (firstFileName.charAt(j) != fileNames[i].charAt(j)) {
					pattern = pattern.substring(0, j) + "?" + pattern.substring(j + 1);
				}
			}
		}
		
		System.out.println(pattern);
	}

}
