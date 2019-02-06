package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_2169
// 로봇 조종하기
// 다이나믹 프로그래밍
public class BOJ_2169 {

	static int[][] map;
	static int[][] DP;
	static int[][][] temp;
	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		DP = new int[N + 1][M + 1];
		temp = new int[2][N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		DP[1][1] = map[1][1];

		for (int j = 2; j <= M; j++)
			DP[1][j] += DP[1][j - 1] + map[1][j];

		for (int i = 2; i <= N; i++) {

			temp[0][i][1] = DP[i - 1][1] + map[i][1];

			for (int j = 2; j <= M; j++)
				temp[0][i][j] = Math.max(DP[i - 1][j], temp[0][i][j - 1]) + map[i][j];

			temp[1][i][M] = DP[i - 1][M] + map[i][M];

			for (int j = M - 1; j >= 1; j--)
				temp[1][i][j] = Math.max(DP[i - 1][j], temp[1][i][j + 1]) + map[i][j];

			for (int j = 1; j <= M; j++)
				DP[i][j] = Math.max(temp[0][i][j], temp[1][i][j]);

		}
		System.out.println(DP[N][M]);
	}
}
