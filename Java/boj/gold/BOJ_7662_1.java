package boj.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 7662 이중 우선순위 큐
 * G4
 * 자료 구조, 트리를 사용한 집합과 맵, 우선순위 큐
 */

public class BOJ_7662_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        /**
         * 테스트 케이스 개수
         */
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            /**
             * 1 <= k <= 1,000,000
             */
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            Map<Integer, Integer> map = new HashMap<>();

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int data = Integer.parseInt(st.nextToken());

                if ("I".equals(command)) {
                    max.offer(data);
                    min.offer(data);
                    map.put(data, map.getOrDefault(data, 0) + 1);
                } else if ("D".equals(command)) {
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (data == 1) {
                        remove(max, map);
                    } else if (data == -1) {
                        remove(min, map);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY");
            } else {
                int maxValue = remove(max, map);
                int minValue = map.size() > 0 ? remove(min, map) : maxValue;
                
                sb.append(maxValue);
                sb.append(" ");
                sb.append(minValue);
            }

            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    static int remove(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        int data = 0;
        while (true) {
            data = pq.poll();
            int count = map.getOrDefault(data, 0);

            if (count == 0) {
                continue;
            } else if (count == 1) {
                map.remove(data);
            } else {
                map.put(data, count - 1);
            }

            break;
        }

        return data;
    }
}
