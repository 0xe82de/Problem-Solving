package solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 국어 점수가 감소하는 순서로
 * 국어 점수가 같으면 영어 점수가 증가하는 순서로
 * 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 */

public class BOJ_10825 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// io setting
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Stack<String[]> stack = new Stack<>();
		Stack<String[]> tmpStack = new Stack<>();
		
//		String[][] totalGrades;
		
		
		// 1 <= N <= 100,000
		final int TC = Integer.parseInt(br.readLine());
//		totalGrades = new String[TC][];
		
		
		// logic
		final int NAME = 0;
		final int KOREAN = 1;
		final int ENGLISH = 2;
		final int MATH = 3;
		int len;
		String[] current;
		String[] temp;
		int[] compRes = new int[4];
		for (int tc = 0; tc < TC; ++tc) {
			
			st = new StringTokenizer(br.readLine(), " ");
			len = st.countTokens();
			
			current = new String[len];
//			totalGrades[tc] = new String[len];
			for(int i = 0; i < len; ++i) {
				current[i] = st.nextToken();
			}
			
			if (stack.isEmpty()) stack.push(current);
			else {
				
				// 국어 비교
				while (true) {
					temp = stack.peek();
					compRes[KOREAN] = Integer.compare(Integer.parseInt(current[KOREAN]), Integer.parseInt(temp[KOREAN]));
					if (compRes[KOREAN] > 0) {
						// 국어점수가 높으면 먼저 들어감
						// 0 보다 클 경우 스택에 있는 것 빼고 current push
						tmpStack.push(stack.pop());
						
						// 스택이 비었다면, current 푸시하고 tmpStack에 있는거 다 빼서 stack에 푸시
						if (stack.isEmpty()) {
							stack.push(current);
							while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
							break;
						}
					}
					else if (compRes[KOREAN] < 0) {
						// 국어점수가 낮으면 기존 스택은 그대로 둠
						// current는 그대로 stack에 푸시
						stack.push(current);
						while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
						break;
						
					} else {
						// 국어 점수가 같은 경우 영어 점수를 비교해야 함.
						while (true) {
							temp = stack.peek();
							compRes[ENGLISH] = Integer.compare(Integer.parseInt(current[ENGLISH]), Integer.parseInt(temp[ENGLISH]));
							if (compRes[ENGLISH] < 0) {
								// current의 영어 점수가 더 낮으면 스택에 있는거 뺴고 넣는다.
								tmpStack.push(stack.pop());
								
								// 스택이 비었거나, current의 국어 점수가 더 낮ㅇ면 current 푸시하고 tmpStack에 있는거 다 빼서 stack에 푸시
								if (!stack.isEmpty()) temp = stack.peek();
								if (
										stack.isEmpty() ||
										Integer.compare(Integer.parseInt(current[KOREAN]), Integer.parseInt(temp[KOREAN])) < 0
									) {
									stack.push(current);
									while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
									break;
								}
							}
							else if (compRes[ENGLISH] > 0) {
								// currnet의 영어 점수가 더 높으면 스택은 그대로 두고 푸시한다.
								stack.push(current);
								while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
								break;
							} else {
								
								// 국어, 영어 줌사가 같으면 수학 점수를 비교함.
								while (true) {
									temp = stack.peek();
									compRes[MATH] = Integer.compare(Integer.parseInt(current[MATH]), Integer.parseInt(temp[MATH]));
									if (compRes[MATH] > 0) {
										// current의 수학 점수가 더 높으면 스택에 있는거 빼고 넣는다.
										tmpStack.push(stack.pop());
										
										// 스택이 비었거나, current의 영어 점수가 더 높으면 current 푸시하고 tmpStack에 있는거 다 빼서 stack에 푸시
										if (!stack.isEmpty()) temp = stack.peek();
										if (
												stack.isEmpty() ||
												Integer.compare(Integer.parseInt(current[KOREAN]), Integer.parseInt(temp[KOREAN])) < 0 ||
												Integer.compare(Integer.parseInt(current[ENGLISH]), Integer.parseInt(temp[ENGLISH])) > 0
											) {
											stack.push(current);
											while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
											break;
										}
									}
									else if (compRes[MATH] < 0) {
										// current의 수학 점수가 더 낮으면 스택은 그대로 두고 current 푸시한다.
										stack.push(current);
										while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
										break;
									} else {
										// 국어, 영어, 수학 점수가 똑같으면 이름으로 비교한다.
										while (true) {
											temp = stack.peek();
											compRes[NAME] = current[NAME].compareTo(temp[NAME]);
											if (compRes[NAME] < 0) {
												tmpStack.push(stack.pop());
												
												// 스택이 비었거나, current의 수학 점수가 더 낮으면 current 푸시하고 tmpStack에 있는거 다 빼서 stack에 푸시
												if (!stack.isEmpty()) temp = stack.peek();
												if (
														stack.isEmpty() ||
														Integer.compare(Integer.parseInt(current[KOREAN]), Integer.parseInt(temp[KOREAN])) < 0 ||
														Integer.compare(Integer.parseInt(current[ENGLISH]), Integer.parseInt(temp[ENGLISH])) > 0
//														Integer.compare(Integer.parseInt(current[MATH]), Integer.parseInt(temp[MATH])) > 0
													) {
													stack.push(current);
													while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
													break;
												}
											}
											else if (compRes[NAME] > 0) {
												// current의 이름이 사전상 뒤 쪽이면 스택은 그대로 두고 current 푸시한다.
												stack.push(current);
												while (!tmpStack.isEmpty()) stack.push(tmpStack.pop());
												break;
											}
										}
										break;
									}
								}
								break;
								
							}
						}
						
						break;
						
					}
					
				}
			}
		}
		
		for (int tc = 0; tc < TC; ++tc) {
			sb.insert(0, stack.pop()[NAME] + "\n");
		}
		
		
		// output
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
