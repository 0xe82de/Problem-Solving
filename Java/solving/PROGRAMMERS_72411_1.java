package solving;

/*
 * 접근 방식
 * 1. 손님 별로 주문한 단품메뉴에서 조합을 뽑아낸다.
 * 2. 주어진 course 값 -> 조합할 단품메뉴의 개수
 * 3. HashMap으로 중복메뉴 관리, value로 카운팅.
 * 4. value가 2 이상인 key를 list에 추가하고, 마지막에 정렬
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

public class PROGRAMMERS_72411_1 {

	public static void main(String[] args) {
		
		String[] orders = {
				"ABCFG",
				"AC",
				"CDE",
				"ACDE",
				"BCFG",
				"ACDEH"
		};
		
		int[] course = { 2, 3, 4 };
		
		String[] answer = solution(orders, course);
		System.out.println(Arrays.toString(answer));
	}
	
	public static String[] solution(String[] orders, int[] course) {
//    public String[] solution(String[] orders, int[] course) {
        
        final int SIZE_ORDERS = orders.length;
        final int SIZE_COURSE = course.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < SIZE_ORDERS; ++i) {
        	for (int j = 0; j < SIZE_COURSE; ++j) {
        		// 단품메뉴의 개수가 조합할 메뉴의 개수보다 작으면 break
        		// 만들 수 없음
        		if (orders[i].length() < course[j]) break;
        		
        		comb(orders[i], course[j], 0, 0, map, new String());
        	}
        }
        
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < SIZE_ORDERS; ++i) {
        	
        	int count = 1;
        	String temp = new String();
        	
        	for (String menu : map.keySet()) {
//				if (orders[i].contains(menu) && count < map.get(menu)) {
        		if (orders[i].matches(menu)) {
//        		if (orders[i].contains(menu)) {
        			if (count < map.get(menu)) {
        				count = map.get(menu);
        				temp = menu;
        			}
				}
			}
        	
        	if (!temp.equals("")) list.add(temp);
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
	
	private static void comb(String menus, int R, int cnt, int start, HashMap<String, Integer> map, String cook) {
		
		if (cnt == R) {
			String temp = cook.toString();
			if (map.get(temp) == null) map.put(temp, 1);
			else map.put(temp, map.get(temp) + 1);
		}
		
		for (int i = start, len = menus.length(); i < len; ++i) {
//			cook.append(menus.charAt(i));
			comb(menus, R, cnt + 1, i + 1, map, cook + menus.charAt(i));
		}
	}

}
