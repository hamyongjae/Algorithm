package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ_16234
// 인구이동
// BFS

public class BOJ_16234 {

	static int N, L, R, S;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean flag = true;
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		while (flag) {
			cnt++;
			visited = new boolean[N + 1][N + 1];
			flag = false;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (visited[r][c])
						continue;
					Queue<Point_16234> qu = new LinkedList<Point_16234>();
					LinkedList<Point_16234> list = new LinkedList<Point_16234>();

					int sum = map[r][c];
					qu.add(new Point_16234(r, c));
					list.add(new Point_16234(r, c));
					visited[r][c] = true;

					while (!qu.isEmpty()) {
						int x = qu.peek().x;
						int y = qu.peek().y;

						qu.poll();

						for (int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];

							if (nx < 1 || N < nx || ny < 1 || N < ny)
								continue;

							int temp = Math.abs(map[ny][nx] - map[y][x]);
							if (!visited[ny][nx] && L <= temp && temp <= R) {
								flag = true;
								sum += map[ny][nx];
								list.add(new Point_16234(ny, nx));
								qu.add(new Point_16234(ny, nx));
								visited[ny][nx] = true;
							}
						}
					}

					int n = list.size();
					int a = sum / n;
					for (int i = 0; i < n; i++)
						map[list.get(i).y][list.get(i).x] = a;
				}
			}
		}

		System.out.println(cnt - 1);
	}
}

class Point_16234 {
	int x, y;

	public Point_16234(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
