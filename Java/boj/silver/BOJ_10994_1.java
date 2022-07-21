package boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 10994 별 찍기 - 19
 * S4
 * 구현, 재귀
 */

public class BOJ_10994_1 {

    /**
     * 1 <= N <= 100
     */
    private static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // logic
        N = Integer.parseInt(br.readLine());

        int start = 1 + (N - 1) * 4;
        upper(start, start);
        mid();
        lower(start, 5);

        // io close
        br.close();
    }

    private static void lower(int size, int n) {
        if (n > size) {
            return;
        }

        int count = (size - (n - 4)) / 4;
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }

        for (int i = 0; i < n - 4; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < count; i++) {
            System.out.print(" *");
        }
        System.out.println();

        count = (size - n) / 4;
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }

        for (int i = 0; i < count; i++) {
            System.out.print(" *");
        }
        System.out.println();

        lower(size, n + 4);
    }

    private static void mid() {
        int count = N - 1;
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
        System.out.print("*");

        for (int i = 0; i < count; i++) {
            System.out.print(" *");
        }
        System.out.println();
    }

    private static void upper(int size, int n) {
        if (n == 1) {
            return;
        }

        int count = (size - n) / 4;
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }

        for (int i = 0; i < count; i++) {
            System.out.print(" *");
        }
        System.out.println();

        count = (size - (n - 4)) / 4;
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }

        for (int i = 0; i < n - 4; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < count; i++) {
            System.out.print(" *");
        }
        System.out.println();

        upper(size, n - 4);
    }
}
