package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 72412 순위 검색
 * Level 2
 * 이분 탐색
 */

public class PROGRAMMERS_72412_1 {

    public static void main(String[] args) {
        // input
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        // logic
        int[] answer = solution(info, query);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static Map<String, List<Integer>> allInfo;

    static List<Integer> in;

    static public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        answer = getAnswer(info, query);

        return answer;
    }

    static int[] getAnswer(String[] info, String[] query) {
        final int QUERY_SIZE = query.length;
        int[] answer = new int[QUERY_SIZE];
        allInfo = new HashMap<>();

        for (String i : info) {
            dfs("", 0, i.split(" "));
        }

        for (String key : allInfo.keySet()) {
            List<Integer> scoreList = allInfo.get(key);
            Collections.sort(scoreList);
        }

        for (int i = 0; i < QUERY_SIZE; i++) {
            String[] str = query[i].replaceAll(" and ", "").split(" ");
            int score = Integer.parseInt(str[1]);

            answer[i] = search(str[0], score);
        }

        return answer;
    }

    static int search(String str, int score) {
        if (!allInfo.containsKey(str)) {
            return 0;
        }

        List<Integer> scoreList = allInfo.get(str);
        int start = 0;
        int end = scoreList.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (scoreList.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scoreList.size() - start;
    }

    static void dfs(String pos, int depth, String[] info) {
        if (depth == 4) {
            if (!allInfo.containsKey(pos)) {
                in = new ArrayList<>();
                in.add(Integer.parseInt(info[4]));
                allInfo.put(pos, in);
            } else {
                allInfo.get(pos).add(Integer.parseInt(info[4]));
            }

            return;
        }

        dfs(pos + "-", depth + 1, info);
        dfs(pos + info[depth], depth + 1, info);
    }
}
