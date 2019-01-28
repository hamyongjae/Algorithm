package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2293번 동전 1
public class BOJ_2293 {

	static int[] C = new int[101]; 
	static int[] DP = new int[10001];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 동전의 개수
		int k = Integer.parseInt(st.nextToken()); // 동전 가치의 합
		
		for(int i=1; i<=n; i++)
			C[i]=Integer.parseInt(br.readLine());
		
		DP[0]=1;
		
		for(int i =0; i<=n; i++){
			for(int j=1; j<=k; j++){
				if(j>=C[i]) {
					DP[j]=DP[j] +DP[j-C[i]];					
				}
			}
		}
		System.out.println(DP[k]);
	}

}
