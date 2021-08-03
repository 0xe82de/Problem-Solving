package silver5;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_17478_02 {
	
	private static void whatIsRecursive(int max, int cnt) {
		
		if (max == cnt) {
			System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		}
		
		StringBuilder str = new StringBuilder();
		StringBuilder str1 = new StringBuilder().append("\"재귀함수가 뭔가요?\"");
		StringBuilder str2 = new StringBuilder().append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		StringBuilder str3 = new StringBuilder().append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		StringBuilder str4 = new StringBuilder().append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		StringBuilder str5 = new StringBuilder().append("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		StringBuilder str6 = new StringBuilder().append("라고 답변하였지.");
		
		for (int i = cnt; i < max; ++i) {
			str.insert(0, "____");
		}
		
		System.out.print(str);
		System.out.println(str1);
		
		if (cnt != 0) {
			System.out.print(str);
			System.out.println(str2);
			System.out.print(str);
			System.out.println(str3);
			System.out.print(str);
			System.out.println(str4);
		} else {
			System.out.print(str);
			System.out.println(str5);
			System.out.print(str);
			System.out.println(str6);
			return;
		}
		
		whatIsRecursive(max, --cnt);
		
		str.delete(0, str.length());
		for (int i = cnt + 1; i < max; ++i) {
			str.insert(0, "____");
		}
		System.out.print(str);
		System.out.println(str6);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		sc.close();
		
		whatIsRecursive(cnt, cnt);
		
	}

}
