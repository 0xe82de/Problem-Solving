package boj.bronze;

import java.util.HashSet;
import java.util.Scanner;

public class BOJ_3052_2 {

	public static void main(String[] args) {
		
		// io
		Scanner sc = new Scanner(System.in);
		
		final int N = 42;
		
		HashSet<Integer> hashSet = new HashSet<>();
		
		for (int i = 0; i < 10; ++i) {
			hashSet.add(sc.nextInt() % N);
		}
		
		// output
		System.out.print(hashSet.size());
		
		// io close
		sc.close();
	}

}
