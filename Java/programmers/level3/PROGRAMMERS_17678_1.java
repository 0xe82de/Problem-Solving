package programmers.level3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * PROGRAMMERS 17678 [1차] 셔틀버스
 * Level 3
 * 정렬
 */

public class PROGRAMMERS_17678_1 {

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
        String[] answer = {
                "09:00",
                "09:09",
                "08:59",
                "00:00",
                "09:00",
                "18:00"
        };

        for (int i = 0; i < 6; i++) {
            // logic
            String result = solution(n[i], t[i], m[i], timetable[i]);

            // output
            if (answer[i].equals(result)) {
                System.out.println(true + "\t" + result);
            } else {
                System.out.println(false + "\t" + result);
            }
        }
    }

    static public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        answer = getAnswer(n, t, m, timetable);

        return answer;
    }

    static String getAnswer(int n, int t, int m, String[] timetable) {
        String answer = "";

        List<Integer> crewTimes = translateTime(timetable);
        crewTimes.sort(Comparator.naturalOrder());

        int departure = toMinute("09:00");
        int index = 0;
        int cornTime = 0;
        final int CREW_TIMES_SIZE = crewTimes.size();
        for (int i = 1; i <= n; i++) {
            int crew = 0;
            for (int j = index; j < CREW_TIMES_SIZE; j++) {
                if (crewTimes.get(j) > departure) break;

                ++crew;
                ++index;
                if (crew == m) {
                    break;
                }
            }

            if (i == n) {
                cornTime = crew == m ? crewTimes.get(index - 1) - 1 : departure;
            } else {
                departure += t;
            }
        }

        answer = ""
                .concat(String.format("%02d", cornTime / 60))
                .concat(":")
                .concat(String.format("%02d", cornTime % 60));

        return answer;
    }

    static List<Integer> translateTime(String[] timetable) {
        List<Integer> crewTimes = new ArrayList<>();
        for (String time : timetable) {
            crewTimes.add(toMinute(time));
        }

        return crewTimes;
    }

    static int toMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
