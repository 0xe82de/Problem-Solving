package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 72411 메뉴 리뉴얼
 * Level 1
 * 구현
 */

public class PROGRAMMERS_72411_1 {

    public static void main(String[] args) {
        // input
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2, 3, 4};
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2, 3, 5};
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        // logic
        String[] answer = solution(orders, course);

        // output
        System.out.println(Arrays.toString(answer));
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        answer = getAnswer(orders, course);

        return answer;
    }

    static String[] getAnswer(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        final int SIZE = orders.length;
        char[][] menus = new char[SIZE][];
        for (int i = 0; i < SIZE; i++) {
            menus[i] = orders[i].toCharArray();
            Arrays.sort(menus[i]);
        }

        for (int i : course) {
            Map<String, Integer> orderCountMap = new HashMap<>();
            for (char[] menu : menus) {
                if (i <= menu.length) {
                    comb(orderCountMap, menu, 0, 0, i, new char[i]);
                }
            }

            int max = 1;
            for (Map.Entry<String, Integer> entry : orderCountMap.entrySet()) {
                max = Math.max(max, entry.getValue());
            }

            if (max == 1) continue;
            for (Map.Entry<String, Integer> entry : orderCountMap.entrySet()) {
                if (entry.getValue() == max) {
                    list.add(entry.getKey());
                }
            }
        }

        list.sort(Comparator.naturalOrder());
        return list.toArray(new String[0]);
    }

    static void comb(Map<String, Integer> orderCountMap, char[] order, int current, int src, int max, char[] menus) {
        if (current == max) {
            String newMenu = String.valueOf(menus);
            orderCountMap.put(newMenu, orderCountMap.getOrDefault(newMenu, 0) + 1);

            return;
        }

        for (int i = src, SIZE = order.length; i < SIZE; i++) {
            menus[current] = order[i];
            comb(orderCountMap, order, current + 1, i + 1, max, menus);
        }
    }
}
