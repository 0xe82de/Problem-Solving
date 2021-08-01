package solving;

public class Test {

	public static void main(String[] args) {
		
		String s = "0123456789";
		
		int i = 5;
		
		s = s.substring(0, i) + 'D' + s.substring(i + 1);
		
		System.out.println(s);
		
		
	}

}
