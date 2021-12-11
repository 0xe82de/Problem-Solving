package boj.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1181_1 {

    public static void main(String[] args) throws IOException {
        // io setting
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // logic
        StringBuilder sb = new StringBuilder();

        // 1 <= N <= 20,000
        final int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int n = 0; n < N; ++n) {
            arr[n] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a1, String a2) {
                if (a1.length() != a2.length()) {
                    return Integer.compare(a1.length(), a2.length());
                }
                else {
                    return a1.compareTo(a2);
                }
            }
        });

        String before = null;
        for (int n = 0; n < N; ++n) {
            if (before != null && before.equals(arr[n])) continue;
            sb.append(arr[n] + "\n");
            before = arr[n];
        }

        // output
        bw.write(sb.toString());

        // io close
        bw.close();
        br.close();
    }

}
