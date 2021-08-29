package boj.silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2635_1 {

	public static void main(String[] args) throws IOException {
		
		// 변수 설정
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 출력 문자열  병합용
		StringBuilder sb = new StringBuilder();
		
		// 첫 번째 숫자
		final int FIRST = sc.nextInt();
		
		// 최종 수열
		Queue<Integer> queue = getNumbers(FIRST);
		
		// 출력 문자열 합치기
		sb.append(queue.size() + "\n");
		for (Object number : queue.toArray()) sb.append(number + " ");
		
		// 출력
		bw.write(sb.toString());
		
		// I/O close
		bw.close();
		sc.close();
	}
	
	/**
	 * 최대 크기의 수열을 생성해서 큐로 반환한다.
	 * @param first : 첫 번째 값
	 * @return 최대 크기의 수열(큐)
	 */
	private static Queue<Integer> getNumbers(int first) {
		// 임시 수열, 최종 수열
		Queue<Integer> tempQueue = new LinkedList<>();
		Queue<Integer> finalQueue = new LinkedList<>();
		
		// 두 번째 숫자 초기화
		int second = first % 2 == 0 ? first / 2 : first / 2 + 1;
		int temp;
		int left = 0;
		int right = 0;
		while (true) {
			// 큐에 첫 번째, 두 번째 숫자 입력
			if (tempQueue.size() == 0) {
				tempQueue.offer(first);
				tempQueue.offer(second);
				right = first - second;
				left = second++; // 다음 수열에서 사용할 두 번째 숫자를 위해 ++연산자 사용
			}
			
			/*
			 * 다음 숫자가 음수이면 이전까지 만들어둔 수열의 최대 크기를 비교하고
			 * 새로 만든 수열의 크기가 작아지면 break
			 * 크다면 최대 크기의 수열 갱신
			 */
			if (right < 0) {
				if (finalQueue.size() > tempQueue.size()) break;
				finalQueue.clear();
				while (!tempQueue.isEmpty()) finalQueue.offer(tempQueue.poll());
				continue;
			}
			
			// 임시 수열에 숫자 추가
			tempQueue.offer(right);
			
			// 다음 숫자 계산
			temp = right;
			right = left - right;
			left = temp;
		}
		
		return finalQueue;
	}
}
