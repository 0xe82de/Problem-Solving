package programmers.level2;

/**
 * PROGRAMMERS 12985 예상 대진표
 * Level 2
 * 구현
 */

public class PROGRAMMERS_12985_1 {

    public static void main(String[] args) {
        // input
        int n = 8;
        int a = 4;
        int b = 7;

        // logic
        int answer = solution(n, a, b);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int n, int a, int b) {
        int answer = 0;

        answer = getAnswer(n, a, b);

        return answer;
    }

    static int getAnswer(int n, int a, int b) {
        int answer = 1;

        while ((a = nextNumber(a)) != (b = nextNumber(b))) {
            ++answer;
        }

        return answer;
    }

    static int nextNumber(int number) {
        int nextNumber = number / 2;
        if (number % 2 == 1) {
            ++nextNumber;
        }

        return nextNumber;
    }
}
