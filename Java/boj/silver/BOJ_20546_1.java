package boj.silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 20546 🐜 기적의 매매법 🐜
 * S5
 * 구현
 */

public class BOJ_20546_1 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        final int cash = parseInt.applyAsInt(br.readLine());

        int[] stockPrices = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 14; i++) {
            stockPrices[i] = parseInt.applyAsInt(st.nextToken());
        }

        int bnp = bnp(cash, stockPrices);
        int timing = timing(cash, stockPrices);

        // output
        bw.write(bnp > timing ? "BNP" : bnp == timing ? "SAMESAME" : "TIMING");

        // io close
        bw.close();
        br.close();
    }

    private static int bnp(int cash, int[] stockPrices) {
        final int STOCK_COUNT = stockPrices.length;
        int stocks = 0;

        for (int stockPrice : stockPrices) {
            if (cash >= stockPrice) {
                int buyStockCount = cash / stockPrice;
                stocks += buyStockCount;
                cash -= buyStockCount * stockPrice;
            }
        }

        return stocks * stockPrices[STOCK_COUNT - 1] + cash;
    }

    private static int timing(int cash, int[] stockPrices) {
        final int STOCK_COUNT = stockPrices.length;
        int stocks = 0;

        int upCount = 0;
        int downCount = 0;
        int beforePrice = stockPrices[0];
        for (int i = 1; i < STOCK_COUNT; i++) {
            int currentPrice = stockPrices[i];

            if (beforePrice < currentPrice) {
                // 주가 상승
                downCount = 0;
                ++upCount;
                if (upCount >= 3 && stocks > 0) {
                    cash += stocks * currentPrice;
                    stocks = 0;
                }
            } else if (beforePrice > currentPrice) {
                // 주가 하락
                upCount = 0;
                ++downCount;
                if (downCount >= 3 && cash > currentPrice) {
                    int buyStockCount = cash / currentPrice;
                    stocks += buyStockCount;
                    cash -= buyStockCount * currentPrice;
                }
            }

            beforePrice = currentPrice;
        }

        return stocks * stockPrices[STOCK_COUNT - 1] + cash;
    }
}
