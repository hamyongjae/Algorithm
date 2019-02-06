package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_16497
// 대출요청
public class BOJ_16497 {

	static int[] cnt; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from, to;
		int N = Integer.parseInt(st.nextToken());

		cnt = new int[32];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			for (int j = from; j < to; j++){
				cnt[j]++;
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		int result = 1;
		
		for(int i =1; i<32; i++){
			if(K<cnt[i]){
				result=0;
				break;
			}
		}
		System.out.println(result);
	}
}
