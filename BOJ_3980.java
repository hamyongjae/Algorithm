package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3980 {
	static int[][] arr;
	static boolean[] check; // 초기값 false
	static int sum = 0, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());

		for (int t = 0; t < test_case; t++) {
			arr = new int[12][12];
			check = new boolean[12];
			answer = 0;
			for (int i = 1; i < 12; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < 12; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 1; i < 12; i++) {

				// 0 이면 패스
				if (arr[1][i] == 0)
					continue;
				
				check[i] = true;
				dfs(1, arr[1][i]); //첫번쨰 선수부터 시작
				check[i] = false;

			}
			System.out.println(answer);
		}

		br.close();
	}

	public static void dfs(int player, int sum) {
		// 마지막 선수까지오면 
		if (player == 11) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = 1; i < 12; i++) {
			if (arr[player + 1][i] == 0 || check[i] == true)
				continue;

			check[i] = true;
			dfs(player + 1, sum + arr[player+1][i]);
			check[i] = false;
		}
	}
}
