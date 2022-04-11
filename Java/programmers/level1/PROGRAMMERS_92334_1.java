package programmers.level1;

import java.util.*;

/**
 * PROGRAMMERS 92334 신고 결과 받기
 * Level 1
 * 2022 KAKAO BLIND RECRUITMENT
 */

public class PROGRAMMERS_92334_1 {

    public static void main(String[] args) {
        // input
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        // logic
        int[] answer = solution(id_list, report, k);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        Map<String, Set<String>> reportMap = new HashMap<>();
        Arrays.stream(id_list)
                .forEach(id -> reportMap.put(id, new HashSet<>()));

        StringTokenizer st = null;
        for (String str : report) {
            st = new StringTokenizer(str, " ");
            String reporter = st.nextToken();
            String reported = st.nextToken();
            reportMap.get(reporter).add(reported);
        }

        Map<String, Integer> reportedCount = new HashMap<>();
        for (String reporter : reportMap.keySet()) {
            for (String reported : reportMap.get(reporter)) {
                reportedCount.put(reported, reportedCount.getOrDefault(reported, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (String id : id_list) {
            int cnt = 0;
            for (String reported : reportMap.get(id)) {
                if (reportedCount.get(reported) >= k) {
                    ++cnt;
                }
            }

            result.add(cnt);
        }

        answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
