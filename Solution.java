package Algorithm;

public class Solution {

	public static void main(String[] args) {

		Solution2 sl = new Solution2();
		System.out.println("test");
		System.out.println(sl.solution(33));

	}

}

class Solution2 {
	public int solution(int num) {
		int answer = 0;
		String temp = null;
		for (int i = 1; i <= num; i++) {
			temp =String.valueOf(i);
			for(int j =0; j<temp.length(); j++) {
				if(temp.charAt(j)=='3' || temp.charAt(j)=='6' || temp.charAt(j)=='9') {
					answer++;
					break;
				}
					
			}
		}
		return answer;
	}
}