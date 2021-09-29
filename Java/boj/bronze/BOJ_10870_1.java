package boj.bronze;

import java.util.Scanner;

/**
 * BOJ 10870 피보나치 수 5
 * B2
 * 수학, 구현, DP
 */

public class BOJ_10870_1 {

    public static void main(String[] args) {

        // io
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 0) System.out.println(0);
        else System.out.println(fibo(n - 1));

        // io close
        sc.close();
    }

    private static int fibo(int n) {
        if (n <= 1) return 1;
        return fibo(n - 2) + fibo(n - 1);
    }

}
