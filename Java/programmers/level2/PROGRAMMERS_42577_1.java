package programmers.level2;

import java.io.*;
import java.util.*;

/**
 * PROGRAMMERS 42577 전화번호 목록
 * Level 2
 * 해시
 */

public class PROGRAMMERS_42577_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        String[] phone_book = {"123","123456","789"};
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();
        for (String phone : phone_book) {
            map.put(phone, null);
        }

        for (int i = 0, I_SIZE = phone_book.length; i < I_SIZE; i++) {
            for (int j = 0, J_SIZE = phone_book[i].length(); j < J_SIZE; j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
//                    return answer;
                }
            }
        }

        // output
        bw.write(String.valueOf(answer));

        // io close
        bw.close();
        br.close();
    }

}
