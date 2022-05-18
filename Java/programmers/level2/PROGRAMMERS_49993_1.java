package programmers.level2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * PROGRAMMERS 49993 스킬트리
 * Level 2
 * 맵, 큐
 */

public class PROGRAMMERS_49993_1 {

    public static void main(String[] args) {
        // input
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        // logic
        int answer = solution(skill, skill_trees);

        // output
        System.out.println("answer = " + answer);
    }

    static public int solution(String skill, String[] skill_trees) {
        int answer = -1;

        answer = getAnswer(skill, skill_trees);

        return answer;
    }

    static int getAnswer(String skill, String[] skillTrees) {
        int answer = 0;

        Set<Character> set = new HashSet<>();
        for (char c : skill.toCharArray()) {
            set.add(c);
        }

        for (String skillTree : skillTrees) {
            Queue<Character> q = new LinkedList<>();
            for (char c : skill.toCharArray()) {
                q.offer(c);
            }

            boolean possible = true;
            for (char c : skillTree.toCharArray()) {
                if (q.isEmpty()) break;

                if (set.contains(c) && q.poll() != c) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ++answer;
            }
        }


        return answer;
    }
}
