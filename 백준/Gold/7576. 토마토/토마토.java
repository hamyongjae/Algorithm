import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int M, N;
	static int map[][];
	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static int cnt1 = 0, cnt2 = 0, day = 0;
	static Queue<int[]> qu = new LinkedList<int[]>();

	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로

		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1)
					qu.add(new int[] { i, j });
				else if (map[i][j] == -1)
					cnt1++;
			}
		}

		BFS();

		Loop1: for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				day = Math.max(day, map[i][j]);

				if (map[i][j] == 0) {
					day = -1;
					break Loop1;
				}
			}
		}
		if (day != -1)
			System.out.println(day - 1);
		else
			System.out.println(day);
	}

	static void BFS() {

		while (!qu.isEmpty()) {
			int curY = qu.peek()[0];
			int curX = qu.peek()[1];

			qu.poll();

			for (int i = 0; i < 4; i++) {
				int ny = curY + dy[i];
				int nx = curX + dx[i];

				if (ny <= 0 || nx <= 0 || ny > N || nx > M)
					continue;

				if (map[ny][nx] != 0)
					continue;

				qu.add(new int[] { ny, nx });

				map[ny][nx] = map[curY][curX] + 1;

			}
		}

	}
}