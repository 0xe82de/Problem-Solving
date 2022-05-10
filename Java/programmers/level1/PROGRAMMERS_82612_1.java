package programmers.level1;

/**
 * PROGRAMMERS 82612 부족한 금액 계산하기
 * Level 1
 * 구현
 */

public class PROGRAMMERS_82612_1 {

    public static void main(String[] args) {
        // input
        int price = 3;
        int money = 20;
        int count = 4;

        // logic
        long answer = solution(price, money, count);

        // output
        System.out.println("answer = " + answer);
    }

    static public long solution(int price, int money, int count) {
        long answer = -1;

        answer = 0;
        for (long i = 1L; i <= count; i++) {
            answer += price * i;
        }

        answer -= money;

        if (answer < 0) {
            answer = 0;
        }

        return answer;
    }
}
