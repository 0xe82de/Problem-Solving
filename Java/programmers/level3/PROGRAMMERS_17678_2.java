package programmers.level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * PROGRAMMERS 17678 [1차] 셔틀버스
 * Level 3
 * 정렬
 */

public class PROGRAMMERS_17678_2 {

    public static void main(String[] args) {
        // input
        int[] n = {1, 2, 2, 1, 1, 10};
        int[] t = {1, 10, 1, 1, 1, 60};
        int[] m = {5, 2, 2, 5, 1, 45};
        String[][] timetable = {
                {"08:00", "08:01", "08:02", "08:03"},
                {"09:10", "09:09", "08:00"},
                {"09:00", "09:00", "09:00", "09:00"},
                {"00:01", "00:01", "00:01", "00:01", "00:01"},
                {"23:59"},
                {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}
        };
        String[] result = {"09:00", "09:09", "08:59", "00:00", "09:00", "18:00"};

        for (int i = 0; i < 6; i++) {
            // logic
            String answer = solution(n[i], t[i], m[i], timetable[i]);

            // output
            System.out.println(result[i].equals(answer) + "\t answer = " + answer);
        }
    }

    static public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        answer = getAnswer(n, t, m, timetable);

        return answer;
    }

    static String getAnswer(int n, int t, int m, String[] timetable) {
        int cornTime = 0;

        List<Integer> crewTimes = getCrewTimes(timetable);
        int index = 0;
        int departure = toMinute("09:00");
        final int CREW_TIMES_SIZE = crewTimes.size();
        for (int i = 1; i <= n; i++) {
            int seat = m;
            for (int j = index; j < CREW_TIMES_SIZE; j++) {
                if (departure < crewTimes.get(j)) break;

                ++index;
                --seat;
                if (seat == 0) break;
            }

            if (i == n) {
                cornTime = seat == 0 ? crewTimes.get(index - 1) - 1 : departure;
            } else {
                departure += t;
            }
        }

        return toString(cornTime);
    }

    static String toString(int minute) {
        int hour = minute / 60;
        int min = minute % 60;

        return String.format("%02d", hour).concat(":").concat(String.format("%02d", min));
    }

    static List<Integer> getCrewTimes(String[] timetable) {
        List<Integer> crewTimes = new ArrayList<>();
        for (String time : timetable) {
            crewTimes.add(toMinute(time));
        }

        crewTimes.sort(Comparator.naturalOrder());

        return crewTimes;
    }

    static int toMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
