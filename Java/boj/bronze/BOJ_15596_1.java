package boj.bronze;

/*
 * BOJ 15596 정수 N개의 합
 * B2
 * 수학, 구현, 사칙연산
 * 단계별로 풀어보기 : 함수
 */

class Test {
    long sum(int[] a) {
        long ans = 0;
        for (int i = 0, len = a.length; i < len; ++i) {
            ans += a[i];
        }
        return ans;
    }
}

public class BOJ_15596_1 {

	public static void main(String[] args) {
		
	}
}