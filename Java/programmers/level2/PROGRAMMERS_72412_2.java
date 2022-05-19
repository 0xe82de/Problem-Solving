package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 72412 순위 검색
 * Level 2
 * 이분 탐색
 */

public class PROGRAMMERS_72412_2 {

    public static void main(String[] args) {
        // input
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] result = {1, 1, 1, 1, 2, 4};

        // logic
        int[] answer = solution(info, query);

        // output
        boolean flag = true;
        for (int i = 0; i < 6; i++) {
            if (result[i] != answer[i]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag + "\t answer = " + Arrays.toString(answer));
    }

    static public int[] solution(String[] info, String[] query) {
        int[] answer = {};


        answer = getAnswer(info, query);

        return answer;
    }

    static int[] getAnswer(String[] info, String[] query) {
        int[] answer = {};

        Map<String, List<Integer>> infoMap = getInfoMap(info);
        sortValue(infoMap);
        answer = getResult(query, infoMap);

        return answer;
    }

    static void sortValue(Map<String, List<Integer>> infoMap) {
        for (Map.Entry<String, List<Integer>> entry : infoMap.entrySet()) {
            List<Integer> values = entry.getValue();
            values.sort(Comparator.naturalOrder());
        }
    }

    static int[] getResult(String[] query, Map<String, List<Integer>> infoMap) {
        final int QUERY_SIZE = query.length;
        int[] result = new int[QUERY_SIZE];

        for (int i = 0; i < QUERY_SIZE; i++) {
            String[] split = query[i].replaceAll(" and ", "").split(" ");
            String builder = split[0];
            int point = Integer.parseInt(split[1]);

            result[i] = search(infoMap, builder, point);
        }

        return result;
    }

    static int search(Map<String, List<Integer>> infoMap, String builder, int point) {
        if (!infoMap.containsKey(builder)) {
            return 0;
        }

        List<Integer> points = infoMap.get(builder);
        int left = 0;
        int right = points.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (points.get(mid) < point) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return points.size() - left;
    }

    static Map<String, List<Integer>> getInfoMap(String[] info) {
        Map<String, List<Integer>> infoMap = new HashMap<>();
        for (String i : info) {
            dfs(infoMap, "", i.split(" "), 0);
        }

        return infoMap;
    }

    static void dfs(Map<String, List<Integer>> infoMap, String builder, String[] resume, int cnt) {
        if (cnt == 4) {
            int point = Integer.parseInt(resume[cnt]);
            if (infoMap.containsKey(builder)) {
                infoMap.get(builder).add(point);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(point);
                ;
                infoMap.put(builder, list);
            }

            return;
        }

        dfs(infoMap, builder + "-", resume, cnt + 1);
        dfs(infoMap, builder + resume[cnt], resume, cnt + 1);
    }
}
