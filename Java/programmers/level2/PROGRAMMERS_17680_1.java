package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 17680 [1차] 캐시
 * Level 2
 * 큐
 */

public class PROGRAMMERS_17680_1 {

    public static void main(String[] args) {
        // input
        int cacheSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};

        // logic
        int answer = solution(cacheSize, cities);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        answer = getRunningTime(cacheSize, cities);

        return answer;
    }

    static int getRunningTime(int cacheSize, String[] cities) {
        int runningTime = 0;

        Queue<String> q = new LinkedList<>();

        for (String city : cities) {
            city = city.toUpperCase();
            if (q.contains(city)) {
                q.remove(city);
                q.offer(city);

                ++runningTime;
            } else {
                q.offer(city);
                if (q.size() > cacheSize) {
                    q.poll();
                }

                runningTime += 5;
            }
        }

        return runningTime;
    }
}
