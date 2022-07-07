package boj.silver;

import java.io.*;
import java.util.function.BiPredicate;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

/**
 * BOJ 14916 거스름돈
 * S5
 * DP
 */

public class BOJ_14916_1 {

    static ToIntFunction<String> parseInt = Integer::parseInt;

    static BiPredicate<Integer, Integer> isDivisor = (i1, i2) -> i1 % i2 == 0;

    static BiPredicate<Integer, Integer> diffGEThanZero = (i1, i2) -> i1 - i2 >= 0;

    static IntPredicate greaterThanZero = i -> i > 0;

    static IntBinaryOperator calcQuotient = (left, right) -> left / right;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        int n = parseInt.applyAsInt(br.readLine());
        int[] dp = new int[n + 1];

        IntStream.of(2, 5)
                .forEach(coin -> {
                    IntStream.rangeClosed(1, n)
                            .forEach(amount -> {
                                if (isDivisor.test(amount, coin)) {
                                    dp[amount] = calcQuotient.applyAsInt(amount, coin);
                                } else if (diffGEThanZero.test(amount, coin) && greaterThanZero.test(dp[amount - coin])) {
                                    dp[amount] = dp[amount - coin] + 1;
                                }
                            });
                });

        // output
        bw.write("" + (dp[n] == 0 ? -1 : dp[n]));

        // io close
        bw.close();
        br.close();
    }
}
