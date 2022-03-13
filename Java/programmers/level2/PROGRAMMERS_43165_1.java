package programmers.level2;

/**
 * PROGRAMMERS 43165 타겟 넘버
 * Level 2
 * DFS, BFS
 */

public class PROGRAMMERS_43165_1 {

    static int SIZE;

    public static void main(String[] args) {
        // input
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        // logic
        int answer = solution(numbers, target);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(int[] numbers, int target) {
        int answer = 0;

        SIZE = numbers.length;
        answer = dfs(numbers, 0, target, 0);

        return answer;
    }

    static int dfs(int[] numbers, int sum, int target, int cnt) {
        if (cnt == SIZE) {
            if (sum == target) {
                return 1;
            }

            return 0;
        }

        return dfs(numbers, sum + numbers[cnt], target, cnt + 1) +
                dfs(numbers, sum - numbers[cnt], target, cnt + 1);
    }
}
