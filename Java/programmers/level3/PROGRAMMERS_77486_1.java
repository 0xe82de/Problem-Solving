package programmers.level3;

import java.util.HashMap;
import java.util.Map;

/**
 * PROGRAMMERS 77486 다단계 칫솔 판매
 * Level 3
 * DFS
 */

public class PROGRAMMERS_77486_1 {

    public static void main(String[] args) {
        // input
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        // logic
        int[] answer = solution(enroll, referral, seller, amount);

        // output
        System.out.println("answer = " + answer);
    }

    static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};

        Map<String, String> recommendedMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();

        final int memberCount = enroll.length;
        for (int i = 0; i < memberCount; i++) {
            String memberName = enroll[i];
            recommendedMap.put(memberName, referral[i]);
            profitMap.put(memberName, 0);
        }

        final int SELL_COUNT = seller.length;
        for (int i = 0; i < SELL_COUNT; i++) {
            dfs(recommendedMap, profitMap, seller[i], calcprofit(amount[i]));
        }

        answer = new int[memberCount];
        for (int i = 0; i < memberCount; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }

        return answer;
    }

    private static void dfs(Map<String, String> recommendedMap, Map<String, Integer> profitMap, String seller, int profit) {
        if ("-".equals(seller)) {
            return;
        }

        int tax = calcTax(profit);
        if (tax < 1) {
            profitMap.put(seller, profitMap.get(seller) + profit);
        } else {
            profitMap.put(seller, profitMap.get(seller) + profit - tax);
            dfs(recommendedMap, profitMap, recommendedMap.get(seller), tax);
        }
    }

    private static int calcprofit(int amount) {
        return amount * 100;
    }

    private static int calcTax(int money) {
        return (int)(money * 0.1);
    }
}
