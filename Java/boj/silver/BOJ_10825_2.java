package boj.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * BOJ 10825 국영수
 * S4
 * 정렬
 */

public class BOJ_10825_2 {

    /**
     * 학생의 수
     * 1 <= N <= 100,000
     */
    static int N;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        List<Student> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(name, korean, english, math));
        }

        String names = list.stream().sorted().map(student -> student.getName().concat("\n")).collect(Collectors.joining());

        // output
        bw.write(names);

        // io close
        bw.close();
        br.close();
    }

    static class Student implements Comparable<Student> {

        private String name;

        private Integer korean;

        private Integer english;

        private Integer math;

        public Student(String name, Integer korean, Integer english, Integer math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public Integer getKorean() {
            return korean;
        }

        public Integer getEnglish() {
            return english;
        }

        public Integer getMath() {
            return math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.getKorean().equals(o.getKorean())) {
                if (this.getEnglish().equals(o.getEnglish())) {
                    if (this.getMath().equals(o.getMath())) {
                        return this.getName().compareTo(o.getName());
                    }
                    return this.getMath().compareTo(o.getMath()) * -1;
                }
                return this.getEnglish().compareTo(o.getEnglish());
            }
            return this.getKorean().compareTo(o.getKorean()) * -1;
        }
    }
}
