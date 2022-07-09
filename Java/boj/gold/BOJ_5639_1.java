package boj.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * BOJ 5639 이진 검색 트리
 * G5
 * 트리, 재귀
 */

public class BOJ_5639_1 {

    private static ToIntFunction<String> parseInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        List<Integer> preorder = new ArrayList<>();

        String input = "";
        while ((input = br.readLine()) != null) {
            preorder.add(parseInt.applyAsInt(input));
        }


        StringBuilder sb = new StringBuilder();
        computePreToPost(preorder, 0, preorder.size(), sb);

        // output
        bw.write(sb.toString().trim());

        // io close
        bw.close();
        br.close();
    }

    private static void computePreToPost(List<Integer> preorder, int src, int dst, StringBuilder sb) {
        if (src >= dst) {
            return;
        }

        int root = preorder.get(src);
        int rightChildIndex = src + 1;
        for (; rightChildIndex < dst; rightChildIndex++) {
            if (preorder.get(rightChildIndex) > root) {
                break;
            }
        }

        computePreToPost(preorder, src + 1, rightChildIndex, sb);
        computePreToPost(preorder, rightChildIndex, dst, sb);
        sb.append(root).append("\n");
    }
}
