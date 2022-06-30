package boj.gold;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * BOJ 14567 선수과목 (Prerequisite)
 * G5
 * DP, 위상 정렬
 */

public class BOJ_14567_1 {

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

    static List<List<Integer>> edges;

    static int[] inDegrees;


    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }

        inDegrees = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int preSubjectNo = Integer.parseInt(st.nextToken()) - 1;
            int sufSubjectNo = Integer.parseInt(st.nextToken()) - 1;

            edges.get(preSubjectNo).add(sufSubjectNo);
            ++inDegrees[sufSubjectNo];
        }

        int[] semesters = subjectTopologySort();

        String result = Arrays.stream(semesters)
                .mapToObj(i -> i + " ")
                .collect(Collectors.joining());

        // output
        bw.write(result);

        // io close
        bw.close();
        br.close();
    }

    static int[] subjectTopologySort() {
        int[] semesters = new int[N];

        Queue<Subject> subjectQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegrees[i] == 0) {
                subjectQueue.offer(new Subject(i, 1));
            }
        }

        while (!subjectQueue.isEmpty()) {
            Subject subject = subjectQueue.poll();
            int no = subject.getNo();
            int semester = subject.getSemester();

            semesters[no] = semester;

            for (int nextSubjectNo : edges.get(no)) {
                --inDegrees[nextSubjectNo];
                if (inDegrees[nextSubjectNo] == 0) {
                    subjectQueue.offer(new Subject(nextSubjectNo, semester + 1));
                }
            }
        }

        return semesters;
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
