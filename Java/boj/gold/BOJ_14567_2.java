package boj.gold;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 14567 선수과목 (Prerequisite)
 * G5
 * DP, 위상 정렬
 */

public class BOJ_14567_2 {

    /**
     * 과목의 수
     * 1 <= N <= 1,000
     */
    static int N;

    /**
     * 선수 조건의 수
     * 0 <= M <= 500,000
     */
    static int M;

    static final int START_SEMESTER = 1;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = createGraph(N);
        int[] inDegrees = new int[N];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int pre = Integer.parseInt(st.nextToken()) - 1;
            int suf = Integer.parseInt(st.nextToken()) - 1;

            graph.get(pre).add(suf);
            ++inDegrees[suf];
        }

        int[] semesters = topologySort(graph, inDegrees);

        // output
        bw.write(output(semesters));

        // io close
        bw.close();
        br.close();
    }

    private static int[] topologySort(List<List<Integer>> graph, int[] inDegrees) {
        Queue<Subject> subjectQueue = createSubjectQueue(inDegrees);

        int[] semesters = new int[graph.size()];
        while (!subjectQueue.isEmpty()) {
            Subject subject = subjectQueue.poll();
            int subjectNo = subject.getNo();
            int semester = subject.getSemester();

            semesters[subjectNo] = semester;

            for (int nextSubjectNo : graph.get(subjectNo)) {
                --inDegrees[nextSubjectNo];
                if (inDegrees[nextSubjectNo] == 0) {
                    subjectQueue.offer(new Subject(nextSubjectNo, semester + 1));
                }
            }
        }

        return semesters;
    }

    private static Queue<Subject> createSubjectQueue(int[] inDegrees) {
        final int SIZE = inDegrees.length;

        Queue<Subject> subjectQueue = new LinkedList<>();
        for (int subjectNo = 0; subjectNo < SIZE; subjectNo++) {
            if (inDegrees[subjectNo] == 0) {
                subjectQueue.offer(new Subject(subjectNo, START_SEMESTER));
            }
        }

        return subjectQueue;
    }

    private static String output(int[] inDegrees) {
        return Arrays.stream(inDegrees)
                .mapToObj(i -> i + " ")
                .collect(Collectors.joining());
    }

    private static List<List<Integer>> createGraph(int size) {
        List<List<Integer>> graph = new ArrayList<>(size);

        while (size-- > 0) {
            graph.add(new ArrayList<>());
        }

        return graph;
    }

    static class Subject {

        private final int no;

        private final int semester;

        public Subject(int no, int semester) {
            this.no = no;
            this.semester = semester;
        }

        public int getNo() {
            return no;
        }

        public int getSemester() {
            return semester;
        }
    }
}
