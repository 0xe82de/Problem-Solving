package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42583 다리를 지나는 트럭
 * Level 2
 * 큐
 */

public class PROGRAMMERS_42583_1 {

    public static void main(String[] args) {
        // input
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        // logic
        int answer = 0;

        final int SIZE = truck_weights.length;
        int[] distanceOfTruck = new int[SIZE];

        /**
         * 도착한 트럭의 개수
         */
        int arriveCount = 0;

        /**
         * 흐른 시간
         */
        int second = 0;

        /**
         * 다리에 있는 트럭의 인덱스
         */
        int index = 0;

        /**
         * 다리에 오르지 않은 트럭의 인덱스
         */
        int indexOfTruck = 0;
        Queue<Integer> bridge = new LinkedList<>();
        while (arriveCount < SIZE) {
            ++second;

            for (int i = index; i < SIZE; i++) {
                if (distanceOfTruck[i] == 0) break;

                if (isArrive(distanceOfTruck[i], bridge_length)) {
                    bridge.poll();
                    ++arriveCount;
                    ++index;
                } else {
                    ++distanceOfTruck[i];
                }
            }

            if (isRemainTruck(indexOfTruck, SIZE) &&
                    !isFull(bridge.size(), bridge_length) &&
                    !isWeightOver(bridge.stream().mapToInt(i -> i).sum() + truck_weights[indexOfTruck], weight)) {
                bridge.offer(truck_weights[indexOfTruck]);
                distanceOfTruck[indexOfTruck] = 1;
                ++indexOfTruck;
            }
        }
        answer = second;

        // output
        System.out.println("answer = " + answer);
    }

    private static boolean isArrive(int cur, int dst) {
        return cur == dst;
    }

    private static boolean isRemainTruck(int curIndex, int size) {
        return curIndex < size;
    }

    private static boolean isFull(int curSize, int size) {
        return curSize == size;
    }

    private static boolean isWeightOver(int curWeight, int weight) {
        return curWeight > weight;
    }
}
