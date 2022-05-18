package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 72411 메뉴 리뉴얼
 * Level 2
 * 구현
 */

public class PROGRAMMERS_72411_2 {

    public static void main(String[] args) {
        // input
        String[][] orders = {
                {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                {"XYZ", "XWY", "WXA"}
        };
        int[][] course = {
                {2, 3, 4},
                {2, 3, 5},
                {2, 3, 4}
        };
        String[][] result = {
                {"AC", "ACDE", "BCFG", "CDE"},
                {"ACD", "AD", "ADE", "CD", "XYZ"},
                {"WX", "XY"}
        };

        for (int i = 0; i < 3; i++) {
            // logic
            String[] answer = solution(orders[i], course[i]);

            // output
            boolean flag = true;
            for (int j = 0; j < answer.length; j++) {
                if (!answer[j].equals(result[i][j])) {
                    flag = false;
                    break;
                }
            }

            System.out.println(flag + "\t, answer = " + Arrays.toString(answer));
        }
    }

    static public String[] solution(String[] orders, int[] course) {
        String[] answer ={};

        answer = getAnswer(orders, course);

        return answer;
    }

    static String[] getAnswer(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        for (int i = 0, SIZE = orders.length; i < SIZE; i++) {
            orders[i] = sort(orders[i]);
        }

        for (int size : course) {
            Map<String, Integer> orderMap = new HashMap<>();
            for (String order : orders) {
                int orderSize = order.length();
                if (orderSize < size) continue;
                else if (orderSize == size) {
                    orderMap.put(order, orderMap.getOrDefault(order, 0) + 1);
                } else {
                    comb(orderMap, 0, 0, size, orderSize, order.toCharArray(), new char[size]);
                }
            }

            list.addAll(getNewOrders(orderMap));
        }

        list.sort(Comparator.naturalOrder());

        return list.toArray(new String[0]);
    }

    static List<String> getNewOrders(Map<String, Integer> orderMap) {
        int newOrderCount = 0;
        List<String> newOrders = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : orderMap.entrySet()) {
            if (entry.getValue() < 2) continue;

            if (newOrders.isEmpty()) {
                newOrders.add(entry.getKey());
                newOrderCount = entry.getValue();
            } else {
                int nextOrderCount = entry.getValue();
                if (newOrderCount > nextOrderCount) continue;
                else if (newOrderCount == nextOrderCount) {
                    newOrders.add(entry.getKey());
                } else {
                    newOrderCount = nextOrderCount;

                    newOrders.clear();
                    newOrders.add(entry.getKey());
                }
            }
        }

        return newOrders;
    }

    static void comb(Map<String, Integer> orderMap, int cnt, int src, int newOrderSize, int max, char[] menus, char[] selected) {
        if (cnt == newOrderSize) {
            String newOrder = String.valueOf(selected);
            orderMap.put(newOrder, orderMap.getOrDefault(newOrder, 0) + 1);

            return;
        }

        for (int i = src; i < max; i++) {
            selected[cnt] = menus[i];
            comb(orderMap, cnt + 1, i + 1, newOrderSize, max, menus, selected);
        }
    }

    static String sort(String order) {
        char[] temp = order.toCharArray();
        Arrays.sort(temp);

        return String.valueOf(temp);
    }
}
