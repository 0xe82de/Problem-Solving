package boj.bronze;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * BOJ 10757 큰 수 A+B
 * B5
 * 수학, 구현, 사칙연산, 임의 정밀도 / 큰 수 연산
 */

public class BOJ_10757_1 {

    public static void main(String[] args) throws IOException {
        // io
        Scanner sc = new Scanner(System.in);

        BigInteger b1 = new BigInteger(sc.next());
        BigInteger b2 = new BigInteger(sc.next());

        // logic
        System.out.println(b1.add(b2));

        // io close
        sc.close();
    }

}
