package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ_1309
//동물원
//DP
public class BOJ_1309 {

	static int N;
	static int DP[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		int[][] DP = new int[N + 1][3];

		DP[1][0] = 1;
		DP[1][1] = 1;
		DP[1][2] = 1;

		for (int i = 2; i <= N; i++) {
			DP[i][0] = (DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2]) % 9901;
			DP[i][1] = (DP[i - 1][0] + DP[i - 1][2]) % 9901;
			DP[i][2] = (DP[i - 1][0] + DP[i - 1][1]) % 9901;
		}
		System.out.println((DP[N][0] + DP[N][1] + DP[N][2]) % 9901);
	}
}