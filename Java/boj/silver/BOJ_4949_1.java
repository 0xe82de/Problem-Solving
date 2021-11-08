package boj.silver;

import java.io.*;
import java.util.Stack;

/**
 * BOJ 4949 균형잡힌 세상
 * S4
 * 자료 구조, 문자열, 스택
 */

public class BOJ_4949_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        // logic
        String input;
        while (!(
                (input = br.readLine()).length() == 1 &&
                        input.equals("."))) {
            if (isBalance(input)) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

    /**
     * 문자열이 균형이 잘 잡혀있는지 검사하고 결과를 리턴한다.
     * 
     * @param input : 문자열
     * @return 균형이 잡혀있으면 {@Code true}를 아니면, {@Code false}를 리턴한다.
     */
    private static boolean isBalance(String input) {
        Stack<Character> stack = new Stack<Character>();
        char c, tmp;
        for (int i = 0, LEN = input.length(); i < LEN; ++i) {
            c = input.charAt(i);
            if (c != '[' && c != ']' && c != '(' && c != ')') continue;

            if (stack.size() == 0) stack.push(c);
            else {
                switch (c) {
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                    default:
                        stack.push(c);
                        break;
                }
            }
        }
        if (stack.size() == 0) return true;
        else return false;
    }
}
