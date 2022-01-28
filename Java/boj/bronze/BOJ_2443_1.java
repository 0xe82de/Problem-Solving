package boj.bronze;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * BOJ 2443 별 찍기 - 6
 * B3
 * 구현
 */

public class BOJ_2443_1 {

    public static void main(String[] args) throws IOException {
        // io
        Scanner sc = new Scanner(System.in);

        // logic
        // 1 <= N <= 100
        int N = sc.nextInt();

        int spaceCnt = 0;
        do {
            for (int i = 0; i < spaceCnt; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < N * 2 - 1; i++) {
                System.out.print("*");
            }
            System.out.println();

            spaceCnt++;
        } while (--N > 0);

        // io close
        sc.close();
    }

}
