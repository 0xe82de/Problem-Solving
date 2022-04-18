package programmers.level2;

/**
 * PROGRAMMERS 60057 문자열 압축
 * Level 2
 * 문자열
 */

public class PROGRAMMERS_60057_1 {

    public static void main(String[] args) {
        // input
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        // logic
        int answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(String s) {
        int answer = 0;

        final int SIZE = s.length();
        answer = SIZE;

        for (int length = 1; length < SIZE; length++) {
            int sum = 0;
            int start = 0;
            int count = 1;

            String origin = s.substring(start, start + length);
            start += length;
            while (start + length <= SIZE) {
                String next = s.substring(start, start + length);

                if (origin.equals(next)) {
                    ++count;
                } else {
                    if (count > 1) {
                        while (count > 0) {
                            ++sum;
                            count /= 10;
                        }
                        count = 1;
                    }

                    sum += length;
                    origin = next;
                }

                start += length;
            }
            if (count > 1) {
                while (count > 0) {
                    ++sum;
                    count /= 10;
                }
            }
            sum += length;
            sum += SIZE - start;

            answer = Math.min(answer, sum);
        }

        return answer;
    }
}
