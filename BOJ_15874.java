package Algorithm;


import java.util.Scanner;

public class BOJ_15874 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		k %=26;
		int s_length = sc.nextInt();
		char temp;
		String s_result = "";
		sc.nextLine();
		String s=sc.nextLine();
		
		for(int i =0; i<s_length; i++) {
			
			temp = s.charAt(i);
			if('A'<=temp&&temp<='Z') {
				if((temp+k)<='Z')
					s_result+=(char)(temp+k);
				else if('Z'<(temp+k))
					s_result+=(char)(temp+k-26);
			}
			else if('a'<=temp && temp<='z') {
				if((temp+k)<='z')
					s_result+=(char)(temp+k);
				else if('z'<(temp+k))
					s_result+=(char)(temp+k-26);
			}
			else if(temp==',' || temp=='.' ||  temp==' ')
				s_result +=temp;
		}
		System.out.println(s_result);
	}

}
