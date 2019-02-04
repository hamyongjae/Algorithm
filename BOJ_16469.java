package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BOJ_16469
//소년 점프
public class BOJ_16469 {

	static int R, C;
	static boolean visited[][];
	static int map[][];
	static int temp[][];
	static int max[][];
	static int cnt[][];

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1];
		max = new int[R + 1][C + 1];
		cnt = new int[R + 1][C + 1];

		int min=Integer.MAX_VALUE;
		
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < C; j++)
				map[i][j + 1] = str.charAt(j) - '0';
		}

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			BFS(new Point(x, y));

			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					max[j][k] = Math.max(max[j][k], temp[j][k]);
				}
			}
		}

		for (int j = 1; j <= R; j++) {
			for (int k = 1; k <= C; k++) {
				if(max[j][k] <min&& map[j][k]==0 && cnt[j][k]==3)
					min = max[j][k];
			}
		}
		
		if(min!=Integer.MAX_VALUE) {
			System.out.println(min);
			int c=0;
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					if(min==max[j][k])
					{
						c++;
					}
				}
			}
			System.out.println(c);
		}
		else
			System.out.println(-1);
	}

	public static void BFS(Point p) {
		Queue<Point> Q = new LinkedList<>();
		visited = new boolean[R + 1][C + 1];
		temp = new int[R + 1][C + 1];
		visited[p.y][p.x] = true;
		temp[p.y][p.x] = 0;
		cnt[p.y][p.x] += 1;
		Q.add(p);

		while (!Q.isEmpty()) {

			int x = Q.peek().x;
			int y = Q.peek().y;

			Q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 1 || C < nx || ny < 1 || R < ny)
					continue;

				if (!visited[ny][nx] && map[ny][nx] == 0) {
					Q.add(new Point(nx, ny));
					temp[ny][nx] = temp[y][x] + 1;
					visited[ny][nx] = true;
					cnt[ny][nx]++;
				}
			}
		}
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
