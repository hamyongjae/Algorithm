package Algorithm;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_2504 {

	public static void main(String[] args) {
		
		int temp=1,sum=0;
		Stack<Character> stack = new Stack<>();
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();

		for(int i=0; i<s.length(); i++){
			
			if(s.charAt(i)=='(') {
				stack.push('(');
				temp*=2;
				if(s.charAt(i+1)==')')
					sum+=temp;
			}
			else if(s.charAt(i)=='[') {
				stack.push('[');
				temp*=3;
				if(s.charAt(i+1)==']')
					sum+=temp;
			}
			else if(s.charAt(i)==')') {
				temp/=2;
				if(stack.isEmpty() || stack.peek()!='(') {
					sum=0;
					break;
				}
				stack.pop();
			}
			else if(s.charAt(i)==']' ) {
				temp/=3;
				if(stack.isEmpty() || stack.peek()!='[') {
					sum=0;
					break;
				}
				stack.pop();
			}
		}
		
		if(!stack.isEmpty())
			sum=0;
		System.out.println(sum);
	}
}