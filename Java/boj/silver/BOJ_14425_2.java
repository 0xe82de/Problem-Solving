package boj.silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

/**
 * BOJ 14425 문자열 집합
 * S3
 * 자료 구조, 문자열, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 */

public class BOJ_14425_2 {

    private static final ToIntFunction<String> parseInt = Integer::parseInt;

    /**
     * 집합 S에 포함되어 있는 문자열의 개수
     * 1 <= N <= 10,000
     */
    private static int N;

    /**
     * 검사해야 하는 문자열의 개수
     * 1 <= M <= 10,000
     */
    private static int M;

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = parseInt.applyAsInt(st.nextToken());
        M = parseInt.applyAsInt(st.nextToken());

        Set<String> set = new HashSet<>();
        while (N-- > 0) {
            set.add(br.readLine());
        }

        int result = 0;
        while (M-- > 0) {
            if (set.contains(br.readLine())) {
                ++result;
            }
        }

        // output
        bw.write(result + "");

        // io close
        bw.close();
        br.close();
    }
}
