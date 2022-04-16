package programmers.level1;

/**
 * PROGRAMMERS 81301 숫자 문자열과 영단어
 * Level 1
 * 문자열
 */

public class PROGRAMMERS_81301_1 {

    public static void main(String[] args) {
        // input
        String s = "one4seveneight";

        // logic
        int answer = solution(s);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(String s) {
        int answer = 0;

        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(words[i], numbers[i]);
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
