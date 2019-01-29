package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1025 {
	static boolean map[][];
	static boolean visited[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int M, N, K, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추 심어져 있는 위치 개수

			map = new boolean[N + 1][M + 1];
			visited = new boolean[N + 1][M + 1];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				map[Y][X] = true;
			}
			cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] && !visited[i][j]) {
						cnt++;
						visited[i][j] = true;
						DFS(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void DFS(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (ny < 0 || N <= ny || nx < 0 || M <= nx)
				continue;

			if (!visited[ny][nx] && map[ny][nx]) {
				visited[ny][nx] = true;
				DFS(ny, nx);
			}
		}
	}
}
