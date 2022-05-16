package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * PROGRAMMERS 92341 주차 요금 계산
 * Level 2
 * 구현
 */

public class PROGRAMMERS_92341_1 {

    public static void main(String[] args) {
        // input
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        int[] fees = {1, 461, 1, 10};
//        String[] records = {"00:00 1234 IN"};
//        int[] fees = {120, 0, 60, 591};
//        String[] records = {"16:00 0202 IN", "18:00 0202 OUT"};

        // logic
        int[] answer = solution(fees, records);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        answer = getAnswer(fees, records);

        return answer;
    }

    static int[] getAnswer(int[] fees, String[] records) {
        int[] answer = null;
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        StringTokenizer st = null;
        Map<String, Integer> recordMap = new HashMap<>();
        Map<String, Integer> times = new HashMap<>();
        for (String record : records) {
            st = new StringTokenizer(record, " ");
            int time = getTime(st.nextToken());
            String carNumber = st.nextToken();
            String command = st.nextToken();

            if ("IN".equals(command)) {
                recordMap.put(carNumber, time);
            } else {
                int startTime = recordMap.get(carNumber);
                times.put(carNumber, times.getOrDefault(carNumber, 0) + time - startTime);
                recordMap.remove(carNumber);
            }
        }

        if (recordMap.size() > 0) {
            int endTime = getTime("23:59");
            for (String carNumber : recordMap.keySet()) {
                int startTime = recordMap.get(carNumber);
                times.put(carNumber, times.getOrDefault(carNumber, 0 ) + endTime - startTime);
            }
        }

        List<String> carNumbers = times.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        final int SIZE = carNumbers.size();
        answer = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            String carNumber = carNumbers.get(i);
            int time = times.get(carNumber);

            if (time <= defaultTime) {
                answer[i] = defaultFee;
            } else {
                answer[i] += defaultFee;
                int restTime = time - defaultTime;

                if (restTime % unitTime == 0) {
                    answer[i] += restTime / unitTime * unitFee;
                } else {
                    answer[i] += (int) Math.ceil((double) restTime / unitTime) * unitFee;
                }
            }
        }

        return answer;
    }

    static int getTime(String strTime) {
        int time = 0;

        String[] split = strTime.split(":");
        String hour = split[0];
        String minute = split[1];

        time += Integer.parseInt(hour) * 60;
        time += Integer.parseInt(minute);

        return time;
    }
}
