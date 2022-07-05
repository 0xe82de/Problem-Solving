package boj.silver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 2346 풍선 터뜨리기
 * S3
 * 자료 구조, 덱
 */

public class BOJ_2346_1 {

    /**
     * 풍선의 개수
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logicR=
        N = Integer.parseInt(br.readLine());
        Deque<Balloon> balloonDeque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int no = 1; no <= N; no++) {
            balloonDeque.offer(new Balloon(no, Integer.parseInt(st.nextToken())));
        }

        int[] balloonBurstOrders = burst(balloonDeque);
        String output = Arrays.stream(balloonBurstOrders)
                .mapToObj(i -> i + " ")
                .collect(Collectors.joining())
                .trim();

        // output
        bw.write(output);

        // io close
        bw.close();
        br.close();
    }

    private static int[] burst(Deque<Balloon> balloonDeque) {
        int[] balloonBurstOrders = new int[balloonDeque.size()];

        int index = 0;
        while (!balloonDeque.isEmpty()) {
            Balloon balloon = balloonDeque.poll();
            balloonBurstOrders[index++] = balloon.getNo();

            if (balloonDeque.size() == 0) {
                break;
            }

            int moveCountForNextBalloon = balloon.getMoveCountForNextBalloon();
            if (moveCountForNextBalloon > 0) {
                while (moveCountForNextBalloon-- > 1) {
                    balloonDeque.offer(balloonDeque.poll());
                }
            } else if (moveCountForNextBalloon < 0) {
                while (moveCountForNextBalloon++ < 0) {
                    balloonDeque.offerFirst(balloonDeque.pollLast());
                }
            }
        }

        return balloonBurstOrders;
    }

    private static class Balloon {

        private final int no;

        private final int moveCountForNextBalloon;

        public Balloon(int no, int moveCountForNextBalloon) {
            this.no = no;
            this.moveCountForNextBalloon = moveCountForNextBalloon;
        }

        public int getNo() {
            return no;
        }

        public int getMoveCountForNextBalloon() {
            return moveCountForNextBalloon;
        }
    }
}
