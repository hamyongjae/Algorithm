package Algorithm;
import java.util.Scanner;

public class BOJ_15874 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt(); k %=26;
		int s = sc.nextInt();
		sc.nextLine();
		char temp;
		String st=sc.nextLine();
		StringBuilder sb = new StringBuilder();
		

		for (int i = 0; i < s; i++) {
			temp = st.charAt(i);
			
			if (temp == ',' || temp == '.' || temp == ' ') {
				sb.append(temp);
				continue;
			}
			
			
			if ('A' <= temp && temp <= 'Z') {
				temp += k;
				
				if('Z'< temp) 
					temp -=26;	
			} 
			
			else if ('a' <= temp && temp <= 'z') {
				temp += k;
				
				if('z'<temp) 
					temp -=26;
			}
			
			sb.append(temp);
		}
		System.out.println(sb.toString());
	}
}