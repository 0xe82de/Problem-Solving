package programmers.level2;

import java.util.*;

/**
 * PROGRAMMERS 42587 프린터
 * Level 2
 * 큐
 */

public class PROGRAMMERS_42587_1 {

    public static void main(String[] args) {
        // input
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        // logic
        int answer = 0;

        final int SIZE = 9;
        int[] biggerThanMe = new int[SIZE + 1];

        Queue<Document> documents = new LinkedList<>();

        int currentLocation = 0;
        for (int priority : priorities) {
            documents.offer(new Document(currentLocation++, priority));
            for (int i = priority - 1; i > 0; i--) {
                ++biggerThanMe[i];
            }
        }

        int order = 1;
        while (!documents.isEmpty()) {
            Document document = documents.poll();
            int curLocation = document.getLocation();
            int curPriority = document.getPriority();

            if (biggerThanMe[curPriority] == 0) {
                if (curLocation == location) {
                    answer = order;
                    break;
                }

                for (int i = curPriority - 1; i > 0; i--) {
                    if (biggerThanMe[i] > 0) {
                        --biggerThanMe[i];
                    }
                }

                ++order;
            } else {
                documents.offer(document);
            }
        }

        // output
        System.out.println("answer = " + answer);
    }

    static class Document {

        private final int location;

        private final int priority;

        public Document(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

        public int getLocation() {
            return location;
        }

        public int getPriority() {
            return priority;
        }
    }
}
