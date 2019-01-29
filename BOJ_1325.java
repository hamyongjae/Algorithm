package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// BOJ_1325 효율적인 해킹
public class BOJ_1325 {

	static int N;
	static int M;
	//static int cnt;
	static ArrayList<Integer> ad[];
	static boolean[] check;
	static int[] cnt_arr = new int[10001];;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // vertex
		M = Integer.parseInt(st.nextToken()); // edge

		ad = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++)
			ad[i] = new ArrayList<Integer>(); // 1 2 3 4 5

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ad[from].add(to);
		}

		for (int i = 1; i <= N; i++) {
			check = new boolean[N + 1];
			//cnt = 0;
			DFS(i);
			//cnt_arr[i] = cnt;
		}
		
		int max=0;
		for(int i =1; i<= N; i++){
			if(cnt_arr[i]>max)
				max=cnt_arr[i];
		}
		
		for(int i =1; i<= N; i++){
			if(max==cnt_arr[i])
				System.out.print(i+" ");
		}
	}
    
	public static void DFS(int v) {
		check[v] = true;
		

		for (int i : ad[v]) { // 배열 null check
			if (!check[i]) {
				DFS(i);
				cnt_arr[i]++;
			}
		}
	}
}
