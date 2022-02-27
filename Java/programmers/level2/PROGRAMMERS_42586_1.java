package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42586 기능개발
 * Level 2
 * 큐
 */

public class PROGRAMMERS_42586_1 {

    public static void main(String[] args) {
        // input
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        // logic
        int[] answer = {};

        final int SIZE = progresses.length;

        Queue<Work> works = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            works.offer(new Work(progresses[i], speeds[i]));
        }

        List<Integer> result = new ArrayList<>();
        while (!works.isEmpty()) {
            Work work = works.poll();

            int count = 0;
            while (work != null && work.isFinish()) {
                ++count;
                work = works.poll();
            }
            if (count > 0) {
                result.add(count);
            }

            if (work == null) {
                break;
            }

            int remainWorkCount = works.size();
            work.working();
            works.offer(work);
            while (remainWorkCount-- > 0) {
                work = works.poll();
                work.working();
                works.offer(work);
            }
        }

        answer = result.stream().mapToInt(i -> i).toArray();

        // output
        System.out.println("answer = " + Arrays.toString(answer));
    }

    static class Work {

        private int progress;

        private final int speed;

        private Status status;

        public Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
            this.status = Status.WORKING;
        }

        boolean working() {
            if (progress < 100) {
                progress += speed;
                if (progress >= 100) {
                    progress = 100;
                    this.status = Status.FINISH;
                }
                return true;
            }

            return false;
        }

        boolean isFinish() {
            return this.status == Status.FINISH;
        }

        enum Status {
            WORKING, FINISH
        }
    }
}
