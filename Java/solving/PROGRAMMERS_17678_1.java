package solving;

import java.time.LocalTime;
import java.util.*;

/**
 * PROGRAMMERS 17678 [1차] 셔틀버스
 * Level 3
 * 정렬
 */

public class PROGRAMMERS_17678_1 {

    public static void main(String[] args) {
        // input
//        int n = 1, t = 1, m = 5;
//        String[] timetable = {"08:00", "08:01", "08:02", "08:03"};
        int n = 2, t = 10, m = 2;
        String[] timetable = {"09:10", "09:09", "08:00"};
//        int n = 2, t = 1, m = 2;
//        String[] timetable = {"09:00", "09:00", "09:00", "09:00"};
//        int n = 1, t = 1, m = 5;
//        String[] timetable = {"00:01", "00:01", "00:01", "00:01", "00:01"};
//        int n = 1, t = 1, m = 1;
//        String[] timetable = {"23:59"};

        // logic
        String answer = solution(n, t, m, timetable);

        // output
        System.out.println("answer = " + answer);
    }

    static public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        answer = getAnswer(n, t, m, timetable);

        return answer;
    }

    static String getAnswer(int n, int t, int m, String[] timetable) {
        String answer = "";

        Arrays.sort(timetable);
        Queue<LocalTime> crewTimes = getLocalTimeQueue(timetable);

        int remainSeatCount = m;
        LocalTime busTime = LocalTime.of(9, 0);
        LocalTime crewTime = null;
        for (int i = 1; i <= n; i++) {
            if (i == n) {
                if (remainSeatCount > 0) {
                    answer = busTime.toString();
                } else {
                    answer = crewTime.minusMinutes(1L).toString();
                }
            } else if (remainSeatCount == 0) {
                remainSeatCount = m;
                busTime = busTime.plusMinutes(t);
            } else {
                crewTime = crewTimes.poll();
                --remainSeatCount;
                if (remainSeatCount == 0) {
                    busTime = busTime.plusMinutes(t);
                }
            }
        }

        return answer;
    }

    static boolean possible(LocalTime crewTime, LocalTime busTime) {
        return crewTime.compareTo(busTime) <= 0;
    }

//    static String getAnswer(int n, int t, int m, String[] timetable) {
//        String answer = "";
//
//        Arrays.sort(timetable);
//        Queue<LocalTime> crewTimes = getLocalTimeQueue(timetable);
//
//        int remainBusCount = n;
//        int remainSeatCount = m;
//        final int SIZE = timetable.length;
//        LocalTime busTime = LocalTime.of(9, 0);
//        while (!crewTimes.isEmpty()) {
//            LocalTime crewTime = crewTimes.peek();
//
//            if (busTime.compareTo(crewTime) <= 0) {
//                --remainBusCount;
//                remainSeatCount = m;
//
//                if (remainBusCount > 0) {
//                    crewTimes.poll();
//                    --remainSeatCount;
//                } else {
//                    answer = crewTimes.poll().minusMinutes(1L).toString();
//                    break;
//                }
//            } else {
//                crewTimes.poll();
//                --remainSeatCount;
//                if (remainSeatCount == 0) {
//                    --remainBusCount;
//                    remainSeatCount = m;
//                    busTime = busTime.plusMinutes(t);
//                }
//            }
//        }
//
//        if (remainBusCount == 0 && "".equals(answer)) {
//            answer = stringToLocalTime(timetable[n * m - 1]).minusMinutes(1L).toString();
//        }
//
//        if ("".equals(answer)) {
//            answer = busTime.toString();
//        }
//
//        return answer;
//    }

    static Queue<LocalTime> getLocalTimeQueue(String[] timetable) {
        Queue<LocalTime> times = new LinkedList<>();
        for (String time : timetable) {
            times.offer(stringToLocalTime(time));
        }

        return times;
    }

    static LocalTime stringToLocalTime(String timeByString) {
        String[] split = timeByString.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return LocalTime.of(hour, minute);
    }
}
