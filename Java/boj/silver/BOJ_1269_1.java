package boj.silver;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * BOJ 1269 대칭 차집합
 * S3
 * 자료 구조, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵
 */

public class BOJ_1269_1 {

    public static void main(String[] args) throws IOException {
        // io
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        Set<String> aSet = new HashSet<>();
        Set<String> aSet2 = new HashSet<>();
        Set<String> bSet = new HashSet<>();

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            String number = st.nextToken();
            aSet.add(number);
            aSet2.add(number);
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            bSet.add(st.nextToken());
        }

        aSet.removeAll(bSet);
        bSet.removeAll(aSet2);

        int count = aSet.size() + bSet.size();

        // output
        bw.write("" + count);

        // io close
        bw.close();
        br.close();
    }
}
