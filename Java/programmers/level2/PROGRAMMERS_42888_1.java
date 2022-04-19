package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42888 오픈채팅방
 * Level 2
 * 구현
 */

public class PROGRAMMERS_42888_1 {

    public static void main(String[] args) {
        // input
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        // logic
        String[] answer = solution(record);

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static public String[] solution(String[] record) {
        String[] answer = {};

        List<String[]> list = new ArrayList<>();
        Map<String, String> nicknameMap = new HashMap<>();
        for (String log : record) {
            String[] arr = log.split(" ");
            String command = arr[0];
            String id = arr[1];

            if ("Leave".equals(command)) {
                list.add(new String[]{id, "님이 나갔습니다."});
            } else {
                String nickname = arr[2];
                nicknameMap.put(id, nickname);

                if ("Enter".equals(command)) {
                    list.add(new String[]{id, "님이 들어왔습니다."});
                } else if ("Change".equals(command)) {
                    nicknameMap.put(id, nickname);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        final int SIZE = list.size();
        answer = new String[SIZE];
        for (int i = 0; i < SIZE; i++) {
            String[] log = list.get(i);
            answer[i] = nicknameMap.get(log[0]) + log[1];
        }

        return answer;
    }
}
