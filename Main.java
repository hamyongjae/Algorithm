import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] s = new String[3];
		StringBuilder result = new StringBuilder();

		boolean flag[] = new boolean[3];
		HashSet<Character> set = new HashSet<Character>();

		//int testcase = sc.nextInt();
		//sc.nextLine();

		for (int j = 0; j < 3; j++)
			s[j] = sc.nextLine();

		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < s[j].length(); k++)
				set.add(s[j].charAt(k));
		}
		
		

		Iterator it = set.iterator();
		


		while (it.hasNext()) {
			char temp = (char) it.next();

			for (int i = 0; i < 3; i++) {
				flag[i] = false;
				for (int j = 0; j < s[i].length(); j++) {
					if (s[i].charAt(j) == temp) {
						System.out.println("s[i]~~ =" +s[i].charAt(j));
						System.out.println("temp="+temp+", i="+i+", j="+j+" 이거일때 "+flag[i]+"엿던 flag["+i+"]"+ "를 true로 바꾼다!");
						flag[i] = true;
						//break
					}
				}
			}

			if (flag[0] && flag[1] && flag[2]) {
				System.out.println(temp);
				//System.out.println(set.remove(temp));
			}

		}

		//System.out.println(result.length());

	}
	
}