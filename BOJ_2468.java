package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_2468 안전 영역

// DFS 몇번의 뭉탱이로 돌아가는지 높이마다 카운트
public class BOJ_2468 {

	static int N, max = 0, height_min = 101, height_max = -1;
	static int map[][];
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		int cnt = 0;

		int input;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				input = Integer.parseInt(st.nextToken());

				height_max = Math.max(input, height_max);
				map[i][j] = input;
			}
		}

		for (int h = 0; h <= height_max; h++) {

			visited = new boolean[N + 1][N + 1];
			cnt = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] > h && !visited[i][j]) {
						visited[i][j] = true;
						cnt++;
						DFS(i, j, h);
					}
				}
			}
			max = Math.max(cnt, max);
		}
		System.out.println(max);

	}

	public static void DFS(int y, int x, int h) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 1 || N < nx || ny < 1 || N < ny)
				continue;

			if (map[ny][nx] > h && !visited[ny][nx]) {
				visited[ny][nx] = true;
				DFS(ny, nx, h);
			}
		}
	}
}
